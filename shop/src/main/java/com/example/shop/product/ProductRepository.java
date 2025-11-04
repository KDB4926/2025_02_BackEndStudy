package com.example.shop.product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository
public class ProductRepository {

    @PersistenceContext
    private EntityManager em;

    public Product findByProductId(Long id) {
        return em.find(Product.class, id);
    }

    public List<Product> findAll() {
        return em.createQuery("SELECT p FROM Product p", Product.class)
                .getResultList();
    }

    public Product findByProductId(String productId) {
        List<Product> result = em.createQuery(
                "SELECT p From Product p WHERE p.ProductId = productId", Product.class
        ).setParameter("ProductId", productId).getResultList();

        return result.isEmpty() ? null : result.get(0);
    }

    public void save(Product product) {
        em.persist(product);
    }

    public void deleteByProductId(Long id) {
        Product product = em.find(Product.class, id);
        em.remove(product);
    }

}
