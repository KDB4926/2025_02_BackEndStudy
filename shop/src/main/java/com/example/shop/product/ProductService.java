package com.example.shop.product;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;;

    //@Transactional
    public Long createProduct(ProductCreateRequest request) {
        Product existingProduct = productRepository.findByProductId(request.getProductId());
        if (existingProduct != null) {
            request.setProductCount()++;
        }

        Product product = new Product(
                request.getProductId();
                request.getProductName();
                request.getProductCount();
        );
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        Product product = productRepository.findById(id);

        if(product == null) {
            throw new RuntimeException("상품을 찾을 수 없습니다.");
        }

        return product;
    }

    public void updateProduct(Long id, ProductUpdateRequest request) {
        Product product = productRepository.findById(id);

        if(product == null) {
            throw new RuntimeException("상품을 찾을 수 없습니다.");
        }

        product.updateInfo(request.getId(), request.getProductName(), request.getProductCount());
    }

    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id);

        if(product == null) {
            throw new RuntimeException("상품을 찾을 수 없습니다.");
        }

        productRepository.deleteById(id);
    }
}
