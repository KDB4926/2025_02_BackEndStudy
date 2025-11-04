package com.example.shop.order;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    @Transactional
    public Long createOrder(OrderCreateRequest request) {
        Order order = new Order(
                request.getLoginId(),
                request.getOrder(),
        );

        orderRepository.save(order);

        return order.getOrder();
    }

    @Transactional
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        Order order = orderRepository.findById(id);

        if(order == null) {
            throw new RuntimeException("Order Not Found");
        }

        return order;
    }

    @Transactional
    public void deleteOrder(Long id) {
        Order order = orderRepository.findById(id);

        if(order == null) {
            throw new RuntimeException("Order Not Found");
        }
        orderRepository.deleteById(id);
    }
}
