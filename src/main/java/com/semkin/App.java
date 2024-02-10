package com.semkin;

import com.semkin.repository.PhraseRepository;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        PhraseRepository phraseRepository = new PhraseRepository();
        phraseRepository.fillHashMap();
        phraseRepository.addPhrase("I'm star");
        System.out.println(phraseRepository.getRandomPhrase());
    }
}
