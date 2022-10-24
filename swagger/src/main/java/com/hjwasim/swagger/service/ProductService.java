package com.hjwasim.swagger.service;

import com.hjwasim.swagger.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private static List<Product> PRODUCT_LIST = new ArrayList<>();
    private static int counter = 1;

    public Product addProduct(Product product) {
        product.setId(counter++);
        PRODUCT_LIST.add(product);
        return product;
    }

    public List<Product> getAllProduct() {
        return PRODUCT_LIST;
    }

    public Product getProductById(int product_id) {
        for (Product p : PRODUCT_LIST) {
            if (p.getId() == product_id)
                return p;
        }
        return null;
    }

    public Product updateProductById(int product_id, Product product) {

        for (Product p : PRODUCT_LIST) {
            if (p.getId() == product_id) {
                p.setProduct_name(product.getProduct_name());
                p.setProduct_price(product.getProduct_price());
                return p;
            }
        }
        return null;
    }

    public String deleteProductById(int product_id) {
        for (Product p : PRODUCT_LIST) {
            if (p.getId() == product_id)
                PRODUCT_LIST.remove(p);
                return "Product Deleted Succesfully.";
        }
        return "Error in Deleting.";
    }
}
