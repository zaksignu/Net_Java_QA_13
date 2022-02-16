package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
static Product prod = new Product(1, "Cliff",3000);


    @Test
    void positiveMatch() {
            assertTrue(prod.matches("Cliff"));
    }
    @Test
    void negativeMatch() {
            assertFalse(prod.matches("Goat"));
    }
}