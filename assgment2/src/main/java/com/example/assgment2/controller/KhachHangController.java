package com.example.assgment2.controller;

import com.example.assgment2.entity.KhachHang;
import com.example.assgment2.entity.NhanVien;
import com.example.assgment2.repository.KhachHangRepository;
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
@RequestMapping("/khachhang")
public class KhachHangController {
    @Autowired
    KhachHangRepository khachHangRepository;
    @GetMapping("/hien-thi")
    public String hienthi(Model model) {
        model.addAttribute("list", khachHangRepository.findAll());
        return "khachhang/index";
    }
    @GetMapping("/view-add")
    public String showForm(Model model, HttpSession session) {
        NhanVien nhanVien= (NhanVien) session.getAttribute("user");
        if(nhanVien==null){
            model.addAttribute("message","bạn phải đăng nhập ");
            return "/khachhang/thongbao";
        }
        model.addAttribute("khachhang", new KhachHang());
        return "/khachhang/form";
    }

    @PostMapping("/add")
    public String save(@Valid @ModelAttribute("khachhang") KhachHang khachHang, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/khachhang/form";
        }
        khachHangRepository.save(khachHang);
        return "redirect:/khachhang/hien-thi";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("khachhang", khachHangRepository.findById(id).get());
        return "/khachhang/detail";
    }

    @GetMapping("/view-update")
    public String showUpdate(@RequestParam("id") Integer id, Model model,HttpSession session) {
        NhanVien nhanVien= (NhanVien) session.getAttribute("user");
        if(nhanVien==null){
            model.addAttribute("message","bạn phải đăng nhập ");
            return "redirect:/trangchu/formdangnhap";
        }
        model.addAttribute("khachhang", khachHangRepository.findById(id).get());
        return "/khachhang/update";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("Khachhang")KhachHang khachHang, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/khachhang/update";
        }
       khachHangRepository.save(khachHang);
        return "redirect:/khachhang/hien-thi";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id")Integer id, HttpSession session, Model model) {
        NhanVien nhanVien= (NhanVien) session.getAttribute("user");
        if(nhanVien==null){
            model.addAttribute("message","bạn phải đăng nhập ");
            return "khachhang/thongbao";
        }
       khachHangRepository.deleteById(id);
        return "redirect:/khachhang/hien-thi";
    }

    @GetMapping("/search")
    public String search(@RequestParam("ten") String ten, Model model) {
        KhachHang khachHang = khachHangRepository.findKhachHangByTen(ten);
        List<KhachHang> list = new ArrayList<>();
        list.add(khachHang);
        model.addAttribute("list", list);
        return "/khachhang/index";
    }
}
