package ru.netology.manager;

import ru.netology.exceptions.NotFoundException;
import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    private ProductRepository thingsManager;

    public ProductManager(ProductRepository thingsManager) {
        this.thingsManager = thingsManager;
    }

    public void add(Product product) {
        thingsManager.addProduct(product);
    }

    public void removeById(int id) throws NotFoundException {
        thingsManager.removeThing(id);
    }


    public Product[] searchBy(String text) {
        int length = 0;
        Product[] result = new Product[0];
        for (Product product : thingsManager.showThings()) {
            if (matches(product, text)) {
                length++;
                Product[] tmpsearch = new Product[length];
                System.arraycopy(result, 0, tmpsearch, 0, result.length);
                int lastIndex = length - 1;
                tmpsearch[lastIndex] = product;
                result = tmpsearch;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        return product.matches(search);
    }

}
