package com.javarush.maikov;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class MemoryRepository {
    private static MemoryRepository memoryRepository;
    private final Map<Integer, String> questions = new HashMap<>();
    private final Map<String, String> correctAnswers = new HashMap<>();
    private final Map<String, String> wrongAnswers = new HashMap<>();

    private MemoryRepository() {
        createQuestionsAndAnswers();
    }

    public static MemoryRepository getInstance() {
        if (memoryRepository == null) {
            synchronized (MemoryRepository.class) {
                memoryRepository = new MemoryRepository();
            }
        }
        return memoryRepository;
    }

    public String getQuestion(int key) {
        return questions.get(key);
    }

    public String getCorrectAnswer(String key) {
        return correctAnswers.get(key);
    }

    public String getWrongAnswer(String key) {
        return wrongAnswers.get(key);
    }

    public Map<Integer, String> getQuestionMap() {
        return Collections.unmodifiableMap(questions);
    }

    public Map<String, String> getCorrectAnswersMap() {
        return Collections.unmodifiableMap(correctAnswers);
    }


    private void createQuestionsAndAnswers() {
        questions.put(1, "Какая структура данных используется для хранения пар ключ-значение?");
        questions.put(2, "Какой модификатор доступа делает метод доступным только для подклассов?");
        questions.put(3, "Какая аннотация используется для указания того, что метод не должен переопределяться в подклассах?");
        questions.put(4, "Какая библиотека Java используется для работы с многопоточностью?");
        questions.put(5, "Какой тип аннотации используется для указания того, что класс является потокобезопасным?");
        questions.put(6, "Какая функция лямбда-выражения используется для возврата значения?");
        questions.put(7, "Какая библиотека Java используется для работы с регулярными выражениями?");
        questions.put(8, "Какой класс представляет исключение, возникающее из-за нехватки памяти?");
        questions.put(9, "Какая функция лямбда-выражения используется для передачи параметра в родительскую область видимости?");
        questions.put(10, "Какой класс представляет исключение, возникающее при попытке получить доступ " +
                "к элементу массива за пределами его границ?");
        correctAnswers.put("Какая структура данных используется для хранения пар ключ-значение?",
                "Map");
        wrongAnswers.put("Какая структура данных используется для хранения пар ключ-значение?",
                "List");
        correctAnswers.put("Какой модификатор доступа делает метод доступным только для подклассов?", "protected");
        wrongAnswers.put("Какой модификатор доступа делает метод доступным только для подклассов?", "private");
        correctAnswers.put("Какая аннотация используется для указания того, что метод не должен переопределяться в подклассах?",
                "@Final");
        wrongAnswers.put("Какая аннотация используется для указания того, что метод не должен переопределяться в подклассах?",
                "@NoOverride");
        correctAnswers.put("Какая библиотека Java используется для работы с многопоточностью?", "Concurrency");
        wrongAnswers.put("Какая библиотека Java используется для работы с многопоточностью?", "Thread");
        correctAnswers.put("Какой тип аннотации используется для указания того, что класс является потокобезопасным?",
                "@ThreadSafe");
        wrongAnswers.put("Какой тип аннотации используется для указания того, что класс является потокобезопасным?",
                "@Synchronized");
        correctAnswers.put("Какая функция лямбда-выражения используется для возврата значения?", ":");
        wrongAnswers.put("Какая функция лямбда-выражения используется для возврата значения?", "->");
        correctAnswers.put("Какая библиотека Java используется для работы с регулярными выражениями?", "Pattern");
        wrongAnswers.put("Какая библиотека Java используется для работы с регулярными выражениями?", "Regex");
        correctAnswers.put("Какой класс представляет исключение, возникающее из-за нехватки памяти?", "OutOfMemoryError");
        wrongAnswers.put("Какой класс представляет исключение, возникающее из-за нехватки памяти?", "MemoryException");
        correctAnswers.put("Какая функция лямбда-выражения используется для передачи параметра в родительскую область видимости?",
                "::");
        wrongAnswers.put("Какая функция лямбда-выражения используется для передачи параметра в родительскую область видимости?",
                "->&");
        correctAnswers.put("Какой класс представляет исключение, возникающее при попытке получить доступ к элементу массива за" +
                " пределами его границ?", "ArrayIndexOutOfBoundsException");
        wrongAnswers.put("Какой класс представляет исключение, возникающее при попытке получить доступ к элементу массива за" +
                " пределами его границ?", "IndexOutOfBoundsException");
    }

}
