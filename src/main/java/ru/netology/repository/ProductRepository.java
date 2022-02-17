package ru.netology.repository;

import ru.netology.Exceptions.NotFoundException;
import ru.netology.domain.Product;

public class ProductRepository {

    private Product[] things = new Product[0];

    public void addProduct(Product thing) {
        int length = things.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(things, 0, tmp, 0, things.length);
        tmp[tmp.length - 1] = thing;
        things = tmp;

    }

    public Product[] showThings() {
        return things;
    }

    public void removeThing(int id) throws NotFoundException {
        int length;
        int p = 0;
        if (findById(id)==null){
            throw new NotFoundException("there is nothing at "+id);
        }
        length = things.length - 1;
        Product[] tmp = new Product[length];
        for (int i = 0; i < length; i++) {
            if (id != things[i].getId()) {
                tmp[p] = things[i];
                p++;
            }
        }
        things = tmp;
    }

    public Product findById(int id) {
        for (int i = 0; i < things.length; i++) {
            if (id == things[i].getId()) {
                return things[i];
            }
        }
        return null;
    }


}

