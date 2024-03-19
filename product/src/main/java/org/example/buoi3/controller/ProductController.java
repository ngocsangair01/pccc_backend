package org.example.buoi3.controller;

import org.example.buoi3.base.ResponseUtil;
import org.example.buoi3.inputs.product.ProductDataInput;
import org.example.buoi3.outputs.product.ProductDataOutput;
import org.example.buoi3.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<?> createProduct(ProductDataInput input){
        ProductDataOutput productDataOutput = productService.createProduct(input);
        return ResponseUtil.restSuccess(productDataOutput);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createImagesProduct(ProductDataInput input){
        ProductDataOutput productDataOutput = productService.createImagesProduct(input);
        return ResponseUtil.restSuccess(productDataOutput);
    }
}
