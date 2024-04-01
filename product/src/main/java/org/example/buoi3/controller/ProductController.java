package org.example.buoi3.controller;

import org.example.buoi3.base.ResponseUtil;
import org.example.buoi3.inputs.product.GetListProductDataInput;
import org.example.buoi3.inputs.product.ProductDataInput;
import org.example.buoi3.outputs.product.ProductDataOutput;
import org.example.buoi3.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<?> getDetailProduct(Long id){
        ProductDataOutput productDataOutput = productService.getProductDetail(id);
        return ResponseUtil.restSuccess(productDataOutput);
    }

    @GetMapping("/getList")
    public ResponseEntity<?> getListProduct(GetListProductDataInput input){
        List<ProductDataOutput> outputs = productService.getListProduct(input);
        return ResponseUtil.restSuccess(outputs);
    }

    @PutMapping
    public ResponseEntity<?> editProduct(ProductDataInput input, Long id){
        ProductDataOutput output = productService.editProduct(input, id);
        return ResponseUtil.restSuccess(output);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteProduct(Long id){
        ProductDataOutput output = productService.deleteProduct(id);
        return ResponseUtil.restSuccess(output);
    }
}
