package com.dreamshops.service.product;


import com.dreamshops.dto.ImageDto;
import com.dreamshops.dto.ProductDto;
import com.dreamshops.exceptions.AlreadyExistsException;
import com.dreamshops.exceptions.ProductNotFoundException;
import com.dreamshops.model.Category;
import com.dreamshops.model.Image;
import com.dreamshops.model.Product;
import com.dreamshops.repository.CategoryRepository;
import com.dreamshops.repository.ImageRepository;
import com.dreamshops.repository.ProductRepository;
import com.dreamshops.request.AddProductRequest;
import com.dreamshops.request.ProductUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final CategoryRepository categoryRepository;
    private final ImageRepository imageRepository;

    @Override
    public Product addProduct(AddProductRequest addProductRequest) {

        //check if the category is not found
        //if yes, set it as the new product category
        //if no , the save it as a new category
        //the set as the new product category

        if (productExists(addProductRequest.getName(), addProductRequest.getBrand())) {
            throw new AlreadyExistsException(addProductRequest.getBrand() + " " + addProductRequest.getName() + " already exists, you may update this product instead!");
        }

        Category category = Optional.ofNullable(categoryRepository.findByName(addProductRequest.getCategory().getName()))
                .orElseGet(() -> {
                    Category newCategory = new Category(addProductRequest.getCategory().getName());
                    return categoryRepository.save(newCategory);
                });
        addProductRequest.setCategory(category);
        return productRepository.save(createProduct(addProductRequest, category));
    }

    private boolean productExists(String name, String brand) {
        return productRepository.existsByNameAndBrand(name, brand);
    }


    private Product createProduct(AddProductRequest request, Category category) {
        return new Product(
                request.getName(),
                request.getBrand(),
                request.getPrice(),
                request.getInventory(),
                request.getDescription(),
                category);
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found"));
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.findById(id)
                .ifPresentOrElse(productRepository::delete,
                        () -> {
                            throw new ProductNotFoundException("Product not found");
                        });
    }

    @Override
    public Product updateProduct(ProductUpdateRequest request, Long productId) {
        return productRepository.findById(productId)
                .map(existingProduct -> updateExistingProduct(existingProduct, request))
                .map(productRepository::save)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));
    }

    private Product updateExistingProduct(Product existingProduct, ProductUpdateRequest request) {
        existingProduct.setName(request.getName());
        existingProduct.setBrand(request.getBrand());
        existingProduct.setPrice(request.getPrice());
        existingProduct.setInventory(request.getInventory());
        existingProduct.setDescription(request.getDescription());

        Category category = categoryRepository.findByName(request.getCategory().getName());
        existingProduct.setCategory(category);
        return existingProduct;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategoryName(category);
    }

    @Override
    public List<Product> getProductsByBrand(String brand) {
        return productRepository.findByBrand(brand);
    }

    @Override
    public List<Product> getProductsByCategoryAndBrand(String category, String brand) {
        return productRepository.findByCategoryNameAndBrand(category, brand);
    }

    @Override
    public List<Product> getProductsByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public List<Product> getProductsByBrandAndName(String brand, String name) {
        return productRepository.findByBrandAndName(brand, name);
    }

    @Override
    public Long countProductsByBrandAndName(String brand, String name) {
        return productRepository.countByBrandAndName(brand, name);
    }

    @Override
    public List<ProductDto> getConvertedProducts(List<Product> products) {
        return products.stream().map(this::convertToDto).toList();
    }

    @Override
    public ProductDto convertToDto(Product product) {
        ProductDto productDto = modelMapper.map(product, ProductDto.class);
        List<Image> images = imageRepository.findByProductId(product.getId());
        List<ImageDto> imageDtoList = images.stream()
                .map(image -> modelMapper.map(image, ImageDto.class))
                .toList();
        productDto.setImages(imageDtoList);
        return productDto;
    }
}
