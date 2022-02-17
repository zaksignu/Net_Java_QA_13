package ru.netology.repository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Order;
import ru.netology.domain.Book;
import ru.netology.exceptions.NotFoundException;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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

    //Жесткий порядок тестов необходим для их корректного прохождения
    @Test
    @Order(1)
    void showThings() {
        Product[] actual = {uno, duo, tre};
        Product[] excpected = repository.showThings();
        assertArrayEquals(excpected, actual);
    }

    @Test
    @Order(2)
    void removeThing() {
        repository.removeThing(tre.getId());
        Product[] actual = {uno, duo};
        Product[] excpected = repository.showThings();
        assertArrayEquals(excpected, actual);
        mng.add(tre);
    }

    @Test
    @Order(3)
    void addProduct() {
        mng.add(cuatro);
        Product[] actual = {uno, duo, tre, cuatro};
        Product[] excpected = repository.showThings();
        assertArrayEquals(excpected, actual);
    }

    @Test
    @Order(4)
    void showId() {
        Product actual = tre;
        Product excpected = repository.findById(3);
        assertEquals(excpected, actual);
    }

    @Test
    @Order(5)
    void removeThingNegative() {
        assertThrows(NotFoundException.class, () -> mng.removeById(5));
    }

    @Test
    @Order(6)
    void removeThingTre() {
        repository.removeThing(cuatro.getId());
        Product[] actual = {uno, duo, tre};
        Product[] excpected = repository.showThings();
        assertArrayEquals(excpected, actual);
    }

    @Test
    @Order(7)
    void removeThingTreSecondTime() {
        assertThrows(NotFoundException.class, () -> mng.removeById(4));
    }

    @Test
    @Order(8)
    void removeThingTre1() {
        repository.removeThing(duo.getId());
        Product[] actual = {uno, tre};
        Product[] excpected = repository.showThings();
        assertArrayEquals(excpected, actual);
    }
}