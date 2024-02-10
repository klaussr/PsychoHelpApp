package com.semkin.repository;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class PhraseRepository {
    public Map<UUID, String> phrases = new ConcurrentHashMap<>();

    public void fillHashMap() {
        phrases.put(UUID.randomUUID(), "У тебя все получится");
        phrases.put(UUID.randomUUID(), "Ты классный");
        phrases.put(UUID.randomUUID(), "Все преодолеешь");
        phrases.put(UUID.randomUUID(), "Все временно");
    }

    public String getRandomPhrase() throws InterruptedException {
        String phrase = "";
        for (UUID u : phrases.keySet()) {
            Thread.sleep(50);
            phrase = phrases.get(u);
        }
        return phrase;
    }

    public CharSequence addPhrase(String phrase) {
        phrases.put(UUID.randomUUID(), phrase);
        return phrase;
    }
}
