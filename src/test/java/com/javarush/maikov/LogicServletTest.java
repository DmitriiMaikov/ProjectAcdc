package com.javarush.maikov;


import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Map;

import static org.mockito.Mockito.*;

class LogicServletTest {
    @Mock
    private HttpServletRequest request;
    @Mock
    private MemoryRepository memoryRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        LogicServlet logicServlet = new LogicServlet();
        logicServlet.memoryRepository = MemoryRepository.getInstance();
    }
    @Test
    public void testLastQuestionCorrectAnswer() {
        Map<String, String> correctAnswersMap = Map.of("Question 1", "Correct Answer 1", "Question 2", "Correct Answer 2");
        Map<Integer, String> questionMap = Map.of(1, "Question 1", 2, "Question 2");
        when(memoryRepository.getCorrectAnswersMap()).thenReturn(correctAnswersMap);
        when(memoryRepository.getQuestionMap()).thenReturn(questionMap);
        when(request.getParameter("answer")).thenReturn("Correct Answer 2");
    }
    }