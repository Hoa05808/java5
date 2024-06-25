package com.example.lab6.controller;

import com.example.lab6.Repository.DichVuRepository;
import com.example.lab6.Repository.LoaiDichVuRepository;
import com.example.lab6.entity.LoaiDichVu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/dichvu")
public class DichVuController {
    @Autowired
    DichVuRepository dichVuRepository;
    @Autowired
    LoaiDichVuRepository loaiDichVuRepository;
    @GetMapping("/hien-thi")
    public String hienthi(Model model){
        model.addAttribute("dichvu",dichVuRepository.findAll());
        return"dichvu/index";
    }
    @ModelAttribute("list")
    List<LoaiDichVu>getlist(){
        return loaiDichVuRepository.findAll();
    }
    @GetMapping("/viewadd")
    public String  viewadd(){
        return "dichvu/create";
    }
}
