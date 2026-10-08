package edu.wctc.wholesale.controller;

import edu.wctc.wholesale.repo.OrderRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    private final OrderRepository orderRepository;

    public HomeController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/")
    public String showHomePage(Model model) {
        model.addAttribute("orderList", orderRepository.findAll());
        return "index";
    }
}
