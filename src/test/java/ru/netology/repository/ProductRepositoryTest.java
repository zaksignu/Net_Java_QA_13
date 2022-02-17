package ru.netology.repository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;


import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
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
    }

    @Test
    void showThings() {
        Product[] actual = {uno, duo, tre};
        Product[] excpected = repository.showThings();
        assertArrayEquals(excpected, actual);
    }

    @Test
    void removeThing() {
        repository.removeThing(tre.getId());
        Product[] actual = {uno, duo};
        Product[] excpected = repository.showThings();
        assertArrayEquals(excpected, actual);
        mng.add(tre);
    }

    @Test
    void addProduct() {
        mng.add(cuatro);
        Product[] actual = {uno, duo, tre, cuatro};
        Product[] excpected = repository.showThings();
        assertArrayEquals(excpected, actual);
    }

}