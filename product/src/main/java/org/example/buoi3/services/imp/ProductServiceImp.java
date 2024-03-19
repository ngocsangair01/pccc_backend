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
import org.example.buoi3.repositories.ProductRepository;
import org.example.buoi3.services.ProductService;
import org.example.buoi3.utils.UploadFile;
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
    private final UploadFile uploadFile;

    public ProductServiceImp(ProductRepository productRepository, AttributeDescriptionRepository attributeDescriptionRepository, ProductMapper productMapper, UploadFile uploadFile) {
        this.productRepository = productRepository;
        this.attributeDescriptionRepository = attributeDescriptionRepository;
        this.productMapper = productMapper;
        this.uploadFile = uploadFile;
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

    @Override
    public ProductDataOutput createProduct(ProductDataInput input) {
        Product product = new Product();
        product.setName(input.getName());
        product.setCode(input.getCode());
        product.setImage(uploadFile.imageToUrl(input.getImage()));
        return new ProductDataOutput(product.getCode(), product.getName(), product.getImage());
    }

    @Override
    public ProductDataOutput createImagesProduct(ProductDataInput input) {
        Product product = new Product();
        product.setCode(input.getCode());
        product.setName(input.getName());
        List<Image> imageList = new ArrayList<>();
        List<String> images = new ArrayList<>();
        List<String> fileList = uploadFile.imagesToUrl(input.getImages());
        for (int i = 0; i < fileList.size(); i++) {
            Image image = new Image();
            image.setLink(fileList.get(i));
            imageList.add(image);
        }
        product.setImages(imageList);
        for (int i = 0; i < imageList.size(); i++) {
            String image = imageList.get(i).getLink();
            images.add(image);
        }
        return new ProductDataOutput(product.getCode(), product.getName(), images);
    }
}
