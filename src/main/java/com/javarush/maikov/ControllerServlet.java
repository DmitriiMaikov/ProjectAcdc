package com.javarush.maikov;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/controller")
public class ControllerServlet extends HttpServlet {
    MemoryRepository memoryRepository = MemoryRepository.getInstance();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String answer = req.getParameter("answer");
        if(memoryRepository.getCorrectAnswersMap().containsValue(answer)){
            req.setAttribute("answer", answer);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/correctAnswer.jsp");
            requestDispatcher.forward(req, resp);
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/loseGame.jsp");
        requestDispatcher.forward(req, resp);
    }
}
