package org.example.buoi3.services.imp;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.example.buoi3.exception.NotFoundException;
import org.example.buoi3.inputs.product.GetListProductDataInput;
import org.example.buoi3.inputs.product.ProductDataInput;
import org.example.buoi3.mappers.ProductMapper;
import org.example.buoi3.models.AttributeDescription;
import org.example.buoi3.models.Image;
import org.example.buoi3.models.Product;
import org.example.buoi3.outputs.product.AttributeDescriptionDataOutput;
import org.example.buoi3.outputs.product.ProductDataOutput;
import org.example.buoi3.repositories.AttributeDescriptionRepository;
import org.example.buoi3.repositories.ImageRepository;
import org.example.buoi3.repositories.ProductRepository;
import org.example.buoi3.services.ProductService;
import org.example.buoi3.utils.UploadFile;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductServiceImp implements ProductService {

    private final ProductRepository productRepository;
    private final AttributeDescriptionRepository attributeDescriptionRepository;
    private final ProductMapper productMapper;
    private final ImageRepository imageRepository;

    public ProductServiceImp(ProductRepository productRepository, AttributeDescriptionRepository attributeDescriptionRepository, ProductMapper productMapper, ImageRepository imageRepository) {
        this.productRepository = productRepository;
        this.attributeDescriptionRepository = attributeDescriptionRepository;
        this.productMapper = productMapper;
        this.imageRepository = imageRepository;
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
        List<Product> productList = productRepository.getListProduct(input.getName(), PageRequest.of(input.getPage(), input.getSize()));
        return productList.stream().map(productMapper::toProductDataOutput).toList();
    }

    @Override
    public ProductDataOutput createProduct(ProductDataInput input) {
        Product product = productMapper.toProduct(input, null);
        productRepository.save(product);
        return productMapper.toProductDataOutput(product);
    }

    @Override
    public ProductDataOutput editProduct(ProductDataInput input, Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()){
            throw new NotFoundException("Not found product");
        }
        Product product1 = productMapper.toProduct(input, id);
        productRepository.save(product1);
        return productMapper.toProductDataOutput(product1);
    }

    @Override
    public ProductDataOutput deleteProduct(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()){
            throw new NotFoundException("Not found product");
        }
        productRepository.deleteById(id);
        return productMapper.toProductDataOutput(product.get());
    }
}
