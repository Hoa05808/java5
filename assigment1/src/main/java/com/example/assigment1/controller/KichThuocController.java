package com.example.assigment1.controller;

import com.example.assigment1.entity.KichThuoc;
import com.example.assigment1.entity.MauSac;
import com.example.assigment1.entity.NhanVien;
import com.example.assigment1.service.KichThuocService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/kichthuoc")
public class KichThuocController {
    private KichThuocService kichThuocService=new KichThuocService();
    @GetMapping("/hien-thi")
    public String hienthi(Model model) {
        model.addAttribute("list", kichThuocService.getAll());
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
       kichThuocService.add(kichThuoc);
        return "redirect:/kichthuoc/hien-thi";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam("id") String id, Model model) {
        model.addAttribute("kichthuoc", kichThuocService.finByID(id));
        return "/kichthuoc/detail";
    }

    @GetMapping("/view-update")
    public String showUpdate(@RequestParam("id") String id, Model model,HttpSession session) {
        NhanVien nhanVien= (NhanVien) session.getAttribute("user");
        if(nhanVien==null){
            model.addAttribute("message","bạn phải đăng nhập ");
            return "/kichthuoc/thongbao";
        }
        model.addAttribute("kichthuoc", kichThuocService.finByID(id));
        return "/kichthuoc/update";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("kichthuoc") KichThuoc kichThuoc, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/kichthuoc/update";
        }
        kichThuocService.update(kichThuoc);
        return "redirect:/kichthuoc/hien-thi";
    }

    @GetMapping("/delete")
    public String delete(HttpServletRequest request,HttpSession session,Model model) {
        NhanVien nhanVien= (NhanVien) session.getAttribute("user");
        if(nhanVien==null){
            model.addAttribute("message","bạn phải đăng nhập ");
            return "/kichthuoc/thongbao";
        }
        kichThuocService.delete(request.getParameter("id"));
        return "redirect:/kichthuoc/hien-thi";
    }

    @GetMapping("/search")
    public String search(@RequestParam("ten") String ten, Model model) {
        KichThuoc kichThuoc = kichThuocService.searchName(ten);
        List<KichThuoc> list = new ArrayList<>();
        list.add(kichThuoc);
        model.addAttribute("list", list);
        return "/kichthuoc/index";
    }
}
