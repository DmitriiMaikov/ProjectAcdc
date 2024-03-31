package com.javarush.maikov;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;


class InitServletIT {
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private RequestDispatcher requestDispatcher;
    @Mock
    private HttpSession session;
    @Mock
    private MemoryRepository memoryRepository;
    private InitServlet initServlet;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        initServlet = new InitServlet();
        initServlet.memoryRepository = memoryRepository;
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher("/WEB-INF/game.jsp")).thenReturn(requestDispatcher);
    }

    @Test
    public void testInitServlet() throws Exception {
        when(request.getParameter("name")).thenReturn("Test Name");
        when(request.getRemoteAddr()).thenReturn("127.0.0.1");
        when(memoryRepository.getQuestion(1)).thenReturn("Question 1");
        when(memoryRepository.getWrongAnswer("Question 1")).thenReturn("Wrong Answer");
        when(memoryRepository.getCorrectAnswer("Question 1")).thenReturn("Correct Answer");
        initServlet.doPost(request, response);
        verify(session).setAttribute("name", "Test Name");
        verify(session).setAttribute("ipAddress", "127.0.0.1");
        verify(request).setAttribute("question", "Question 1");
        verify(request).setAttribute("answer1", "Wrong Answer");
        verify(request).setAttribute("answer2", "Correct Answer");
        verify(requestDispatcher).forward(request, response);
    }
}