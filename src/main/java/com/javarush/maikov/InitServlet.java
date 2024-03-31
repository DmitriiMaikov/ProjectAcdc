package com.javarush.maikov;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "Init-servlet", value = "/start")
public class InitServlet extends HttpServlet {
    public MemoryRepository memoryRepository = MemoryRepository.getInstance();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name") == null
                ? "default Name"
                : req.getParameter("name");
        HttpSession session = req.getSession();
        session.setAttribute("name", name);
        String question = memoryRepository.getQuestion(1);
        req.setAttribute("question", question);
        req.setAttribute("answer1", memoryRepository.getWrongAnswer(question));
        req.setAttribute("answer2", memoryRepository.getCorrectAnswer(question));
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/game.jsp");
        requestDispatcher.forward(req, resp);
    }
}
