package com.semkin;

import com.semkin.controller.PhraseRestControllerV1;
import com.semkin.repository.PhraseRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PhraseTest {

    @Mock
    HttpServletRequest req;
    @Mock
    HttpServletResponse resp;
    @Mock
    PhraseRepository phraseRepository;


    @InjectMocks
    PhraseRestControllerV1 servlet;
    String test = "test";


    @BeforeAll
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void doGet() throws InterruptedException {
        doReturn(test).when(this.phraseRepository.getRandomPhrase());

        this.servlet.doGet(req, resp);

        assertEquals(test, new StringWriter().toString());
    }

    @Test
    void doPost() {
        doReturn(resp).when((phraseRepository).addPhrase(test).toString());
    }
}
