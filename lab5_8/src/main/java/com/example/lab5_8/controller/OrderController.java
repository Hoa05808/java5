package com.example.lab5_8.controller;

import com.example.lab5_8.Repository.CustomerRepository;
import com.example.lab5_8.Repository.OrderRepository;
import com.example.lab5_8.entity.Customer;
import com.example.lab5_8.entity.Order;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    OrderRepository orderRepository;

    @GetMapping("/hienthi")
    public String hienthi(Model model) {
        model.addAttribute("order", orderRepository.findAll());
        return "order/index";
    }
    @GetMapping("/create")
    public String add(){
        return "order/create";
    }
    @ModelAttribute("customer")
    List<Customer>getlist(){
        return customerRepository.findAll();
    }
    @PostMapping("/add")
    public String add(Order order){
        orderRepository.save(order);
        return "redirect:/order/hienthi";
    }
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id")Integer id,Model model){
        model.addAttribute("order",orderRepository.findById(id).get());
        return "order/detail";
    }

}
