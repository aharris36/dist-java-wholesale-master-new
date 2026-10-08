package edu.wctc.wholesale.controller.rest;

import edu.wctc.wholesale.dto.WholesaleOrderDto;
import edu.wctc.wholesale.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orders/")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<WholesaleOrderDto> getAllOrders() {
        return orderService.findAll();
    }

    @GetMapping("/{id}")
    public WholesaleOrderDto findById(int id) {
        return orderService.findById(id);
    }


}
