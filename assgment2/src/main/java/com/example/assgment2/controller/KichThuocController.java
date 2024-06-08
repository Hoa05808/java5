package com.example.assgment2.controller;

import com.example.assgment2.entity.KichThuoc;
import com.example.assgment2.entity.MauSac;
import com.example.assgment2.entity.NhanVien;
import com.example.assgment2.repository.KichThuocRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/kichthuoc")
public class KichThuocController {
   @Autowired
    KichThuocRepository kichThuocRepository;
    @GetMapping("/hien-thi")
    public String hienthi(Model model) {
        model.addAttribute("list", kichThuocRepository.findAll());
        return "kichthuoc/index";
    }
    @GetMapping("/view-add")
    public String showForm(Model model, HttpSession session) {
        NhanVien nhanVien= (NhanVien) session.getAttribute("user");
        if(nhanVien==null){
            model.addAttribute("message","bạn phải đăng nhập ");
            return "/kichthuoc/thongbao";
        }
        model.addAttribute("kichthuoc", new KichThuoc());
        return "/kichthuoc/form";
    }

    @PostMapping("/add")
    public String save(@Valid @ModelAttribute("kichthuoc")KichThuoc kichThuoc, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/kichthuoc/form";
        }
      kichThuocRepository.save(kichThuoc);
        return "redirect:/kichthuoc/hien-thi";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("kichthuoc", kichThuocRepository.findById(id).get());
        return "/kichthuoc/detail";
    }

    @GetMapping("/view-update")
    public String showUpdate(@RequestParam("id") Integer id, Model model,HttpSession session) {
        NhanVien nhanVien= (NhanVien) session.getAttribute("user");
        if(nhanVien==null){
            model.addAttribute("message","bạn phải đăng nhập ");
            return "/kichthuoc/thongbao";
        }
        model.addAttribute("kichthuoc", kichThuocRepository.findById(id).get());
        return "/kichthuoc/update";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("kichthuoc") KichThuoc kichThuoc, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/kichthuoc/update";
        }
        kichThuocRepository.save(kichThuoc);
        return "redirect:/kichthuoc/hien-thi";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id")Integer id, HttpSession session, Model model) {
        NhanVien nhanVien= (NhanVien) session.getAttribute("user");
        if(nhanVien==null){
            model.addAttribute("message","bạn phải đăng nhập ");
            return "/kichthuoc/thongbao";
        }
        kichThuocRepository.deleteById(id);
        return "redirect:/kichthuoc/hien-thi";
    }

    @GetMapping("/search")
    public String search(@RequestParam("ten") String ten, Model model) {
        KichThuoc kichThuoc = kichThuocRepository.findKichThuocsByTen(ten);
        List<KichThuoc> list = new ArrayList<>();
        list.add(kichThuoc);
        model.addAttribute("list", list);
        return "/kichthuoc/index";
    }
}
