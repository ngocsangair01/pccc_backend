package org.example.buoi3.services.imp;

import org.example.buoi3.exception.NotFoundException;
import org.example.buoi3.inputs.product.GetListProductDataInput;
import org.example.buoi3.mappers.ProductMapper;
import org.example.buoi3.models.AttributeDescription;
import org.example.buoi3.models.Product;
import org.example.buoi3.outputs.product.AttributeDescriptionDataOutput;
import org.example.buoi3.outputs.product.ProductDataOutput;
import org.example.buoi3.repositories.AttributeDescriptionRepository;
import org.example.buoi3.repositories.ProductRepository;
import org.example.buoi3.services.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImp implements ProductService {

    private final ProductRepository productRepository;
    private final AttributeDescriptionRepository attributeDescriptionRepository;
    private final ProductMapper productMapper;

    public ProductServiceImp(ProductRepository productRepository, AttributeDescriptionRepository attributeDescriptionRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.attributeDescriptionRepository = attributeDescriptionRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductDataOutput getProductDetail(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()){
            throw new NotFoundException("Not found product");
        }
        ProductDataOutput output = productMapper.toProductDataOutput(product.get());
        List<AttributeDescription> attributeDescription = attributeDescriptionRepository.findAllByProduct(product.get());
        List<AttributeDescriptionDataOutput> attributeOutput = attributeDescription.stream().map(productMapper::toAttributeDescriptionOutput).toList();
        output.setAttributeDescriptionDataOutputs(attributeOutput);
        return output;
    }

    @Override
    public List<ProductDataOutput> getListProduct(GetListProductDataInput input) {
        return null;
    }
}
