package ru.netology.manager;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.*;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductManagerTest {
    static ProductRepository repository = new ProductRepository();
    static ProductManager mng = new ProductManager(repository);
    static Book uno = new Book(1, "Book", 1000, "Jiovan");
    static Smartphone duo = new Smartphone(2, "smartphone", 1000, "China");
    static Book tre = new Book(3, "Book", 1000, "Jiovan");
    static Smartphone cuatro = new Smartphone(4, "smartphone", 1000, "China");

    @BeforeAll
    static void setUp() {
        mng.add(uno);
        mng.add(duo);
        mng.add(tre);
        mng.add(cuatro);
    }

    @Test
    @Order(1)
    void add() {
        Product[] actual = {uno, duo, tre, cuatro};
        Product[] excpected = repository.showThings();
        assertArrayEquals(excpected, actual);
    }

    @Test
    @Order(2)
    void removeById() {
        Product[] actual = {uno, duo, tre};
        mng.removeById(4);
        Product[] excpected = repository.showThings();
        assertArrayEquals(excpected, actual);
        mng.add(cuatro);
    }

    @Test
    @Order(3)
    void searchForBook() {
        Product[] actual = {uno, tre};
        Product[] excpected = mng.searchBy("Book");
        assertArrayEquals(excpected, actual);
    }

    @Test
    @Order(4)
    void searchForSmartphone() {
        Product[] actual = {duo, cuatro};
        Product[] excpected = mng.searchBy("smartphone");
        assertArrayEquals(excpected, actual);
    }

    @Test
    @Order(5)
    void searchForNone() {
        Product[] actual = {};
        Product[] excpected = mng.searchBy("z");
        assertArrayEquals(excpected, actual);
    }

    @Test
    @Order(6)
    void searchForJiovan() {
        Product[] actual = {uno, tre};
        Product[] excpected = mng.searchBy("Jiovan");
        assertArrayEquals(excpected, actual);
    }

    @Test
    @Order(7)
    void searchForChina() {
        Product[] actual = {duo, cuatro};
        Product[] excpected = mng.searchBy("China");
        assertArrayEquals(excpected, actual);
    }

    @Test
    @Order(8)
    void matchesPositiveBook() {
        assertTrue(mng.matches(uno, "Book"));
    }

    @Test
    @Order(9)
    void matchesPositiveChina() {
        assertTrue(mng.matches(duo, "China"));
    }

    @Test
    @Order(10)
    void matchesPositiveJiovan() {
        assertTrue(mng.matches(uno, "Jiovan"));
    }

    @Test
    @Order(11)
    void matchesPositiveSmartphone() {
        assertTrue(mng.matches(duo, "smartphone"));
    }

    @Test
    @Order(12)
    void matchesNegativeBook() {
        assertFalse(mng.matches(duo, "Book"));
    }

    @Test
    @Order(13)
    void matchesNegativeJiovan() {
        assertFalse(mng.matches(duo, "Jiovan"));
    }

    @Test
    @Order(14)
    void matchesNegativeChina() {
        assertFalse(mng.matches(uno, "China"));
    }

    @Test
    @Order(15)
    void matchesNegativeSmartphone() {
        assertFalse(mng.matches(uno, "smartphone"));
    }

}
