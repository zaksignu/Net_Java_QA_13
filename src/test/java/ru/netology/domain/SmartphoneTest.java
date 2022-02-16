package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    static Smartphone duo = new Smartphone(2, "Cliff", 1000, "China");


    @Test
    void positiveMatch() {
        assertTrue(duo.matches("Cliff"));
    }

    @Test
    void negativeMatch() {
        assertFalse(duo.matches("Goat"));
    }
}