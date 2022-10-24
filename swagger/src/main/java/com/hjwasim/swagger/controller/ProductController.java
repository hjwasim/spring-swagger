package com.hjwasim.swagger.controller;

import com.hjwasim.swagger.model.Product;
import com.hjwasim.swagger.service.ProductService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@Api(tags = "Product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping(value = "/add", consumes = "application/json")
    @ApiOperation(value = "Add a product")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Return 201, If successful"),
            @ApiResponse(code = 404, message = "Return 404, If unsuccessful"),
            @ApiResponse(code = 200, message = "Return OK")

    })
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product savedProduct = productService.addProduct(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @GetMapping("/get")
    @ApiOperation(value = "Get all available products")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Return 201, If successful"),
            @ApiResponse(code = 404, message = "Return 404, If unsuccessful"),
            @ApiResponse(code = 200, message = "Return OK")

    })
    public ResponseEntity<List<Product>> getAllProduct() {
        List<Product> allProducts = productService.getAllProduct();
        return new ResponseEntity<>(allProducts, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    @ApiOperation(value = "Get a particular product")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Return 201, If successful"),
            @ApiResponse(code = 404, message = "Return 404, If unsuccessful"),
            @ApiResponse(code = 200, message = "Return OK")

    })
    public ResponseEntity<Product> getProductById(@PathVariable("id") int product_id) {
        Product product = productService.getProductById(product_id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}", consumes = "application/json")
    @ApiOperation(value = "Update a particular product")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Return 201, If successful"),
            @ApiResponse(code = 404, message = "Return 404, If unsuccessful"),
            @ApiResponse(code = 200, message = "Return OK")

    })
    public ResponseEntity<Product> updateProductById(@RequestBody Product product, @PathVariable("id") int product_id) {
        Product updated_product = productService.updateProductById(product_id, product);
        return new ResponseEntity<>(updated_product, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Delete a particular product")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Return 201, If successful"),
            @ApiResponse(code = 404, message = "Return 404, If unsuccessful"),
            @ApiResponse(code = 200, message = "Return OK")

    })
    public ResponseEntity<String> deleteProductById(@PathVariable("id") int product_id) {
        String response = productService.deleteProductById(product_id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
