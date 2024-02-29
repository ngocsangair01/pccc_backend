package org.example.buoi3.services;

import org.example.buoi3.inputs.product.GetListProductDataInput;
import org.example.buoi3.outputs.product.ProductDataOutput;

import java.util.List;

public interface ProductService {
    ProductDataOutput getProductDetail(Long id);
    List<ProductDataOutput> getListProduct(GetListProductDataInput input);
}
