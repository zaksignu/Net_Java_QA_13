package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    static Book uno = new Book(1, "Cliff", 1000, "Jiovan");
    @Test
    void positiveMatch() {
        assertTrue(uno.matches("Cliff"));
    }
    @Test
    void negativeMatch() {
        assertFalse(uno.matches("Goat"));
    }
}