package com.example.shop.order; // 패키지명 변경

import com.example.shop.order.Order; // Order 엔티티 임포트 (경로 가정)
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import java.util.List; // List 임포트 추가

@Repository
public class OrderRepository { // 클래스명 변경

    @PersistenceContext
    private EntityManager em;

    public Order findByOrderId(Long id) { // 메서드명 및 반환 타입 변경
        return em.find(Order.class, id); // 엔티티 클래스 변경
    }

    public List<Order> findAll() { // 반환 타입 변경
        // JPQL 쿼리 및 별칭(alias) 변경 (p -> o)
        return em.createQuery("SELECT o FROM Order o", Order.class)
                .getResultList();
    }

    public Order findByOrderId(String orderId) { // 메서드명 및 파라미터명 변경
        List<Order> result = em.createQuery(
                // JPQL 쿼리 변경 및 :namedParameter 사용
                "SELECT o From Order o WHERE o.orderId = :orderId", Order.class
        ).setParameter("orderId", orderId).getResultList(); // 파라미터 바인딩

        return result.isEmpty() ? null : result.get(0);
    }

    public void save(Order order) { // 파라미터 타입 및 이름 변경
        em.persist(order); // 변수명 변경
    }

    public void deleteByOrderId(Long id) { // 메서드명 변경
        Order order = em.find(Order.class, id); // 엔티티 클래스 및 변수명 변경
        if (order != null) { // null 체크 추가 (권장)
            em.remove(order); // 변수명 변경
        }
    }
}
