package com.semkin.controller;

import com.semkin.repository.PhraseRepository;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class PhraseRestControllerV1 extends HttpServlet {

    private PhraseRepository phraseRepository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            phraseRepository.fillHashMap();
            resp.setContentType("text/plain");
            PrintWriter writer = resp.getWriter();
            writer.println(phraseRepository.getRandomPhrase());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            resp.setContentType("text/plain");
            resp.getWriter().append(phraseRepository.addPhrase(req.getParameter("Ты справишься")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
