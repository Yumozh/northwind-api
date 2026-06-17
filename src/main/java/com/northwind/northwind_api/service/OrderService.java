package com.northwind.northwind_api.service;

import com.northwind.northwind_api.model.Order;
import com.northwind.northwind_api.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
    public Optional<Order> getOrderById(Integer id) {
        return orderRepository.findById(id);
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public boolean deleteOrder(Integer id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Order> getOrderByCustomerId(Long customerId){
        return orderRepository.findByCustomerId(customerId);
    }

    public List<Order> getOrderByEmployeeId(Long employeeId){
        return orderRepository.findByEmployeeId(employeeId);
    }

    public Optional<Order> updateOrder(Integer id, Order order){
        return orderRepository.findById(id).map(existing -> {
            existing.setOrderDate(order.getOrderDate());
            existing.setRequiredDate(order.getRequiredDate());
            existing.setShippedDate(order.getShippedDate());
            existing.setShipVia(order.getShipVia());
            existing.setFreight(order.getFreight());
            existing.setShipName(order.getShipName());
            existing.setShipAddress(order.getShipAddress());
            existing.setShipCity(order.getShipCity());
            existing.setShipRegion(order.getShipRegion());
            existing.setShipPostalCode(order.getShipPostalCode());
            existing.setShipCountry(order.getShipCountry());
            return orderRepository.save(existing);
        });
    }
}
