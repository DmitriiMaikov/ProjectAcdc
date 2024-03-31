package com.javarush.maikov;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

@WebServlet(name = "logic-servlet", value = "/logic-servlet")
public class LogicServlet extends HttpServlet {
    public MemoryRepository memoryRepository = MemoryRepository.getInstance();
    private final Map<String, String> correctAnswersMap = memoryRepository.getCorrectAnswersMap();
    private final Map<Integer, String> questionMap = memoryRepository.getQuestionMap();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String answer = req.getParameter("answer");
        for (Map.Entry<String, String> entry : correctAnswersMap.entrySet()) {
            if (entry.getValue().equals(answer)) {
                String currentQuestion = entry.getKey();
                int key = getKeyForCurrentQuestion(questionMap, currentQuestion);
                if (key == correctAnswersMap.size()) {
                    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/wonGame.jsp");
                    requestDispatcher.forward(req, resp);
                }
                String nextQuestion = memoryRepository.getQuestion(key + 1);
                req.setAttribute("question", nextQuestion);
                req.setAttribute("answer1", memoryRepository.getWrongAnswer(nextQuestion));
                req.setAttribute("answer2", memoryRepository.getCorrectAnswer(nextQuestion));
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/game.jsp");
                requestDispatcher.forward(req, resp);
            }
        }
    }
    private static Integer getKeyForCurrentQuestion(Map<Integer, String> questionMap, String currentQuestion) {
        return questionMap.entrySet()
                .stream()
                .filter(entryQuestion -> entryQuestion.getValue().equals(currentQuestion))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElseThrow();
    }
}
