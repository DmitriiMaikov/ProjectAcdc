package com.javarush.maikov;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Map;

import static org.mockito.Mockito.*;

class ControllerServletTest {
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private RequestDispatcher requestDispatcher;
    @Mock
    private MemoryRepository memoryRepository;
    private ControllerServlet controllerServlet;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        controllerServlet = new ControllerServlet();
        controllerServlet.memoryRepository = memoryRepository;
        when(request.getRequestDispatcher("/WEB-INF/correctAnswer.jsp")).thenReturn(requestDispatcher);
        when(request.getRequestDispatcher("/WEB-INF/loseGame.jsp")).thenReturn(requestDispatcher);
    }

    @Test
    public void testCorrectAnswer() throws Exception {
        when(request.getParameter("answer")).thenReturn("Correct Answer");
        when(memoryRepository.getCorrectAnswersMap()).thenReturn(Map.of("Question 1", "Correct Answer"));
        controllerServlet.doPost(request, response);
        verify(request).setAttribute("answer", "Correct Answer");
    }

    @Test
    public void testIncorrectAnswer() throws Exception {
        when(request.getParameter("answer")).thenReturn("Incorrect Answer");
        when(memoryRepository.getCorrectAnswersMap()).thenReturn(Map.of("Question 1", "Correct Answer"));
        controllerServlet.doPost(request, response);
        verify(requestDispatcher).forward(request, response);
    }
}
