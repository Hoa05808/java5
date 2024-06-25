package com.example.assigment1.controller;

import com.example.assigment1.entity.NhanVien;
import com.example.assigment1.service.NhanVienService;
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
@RequestMapping("/nhanvien")
public class NhanVienController {
    private NhanVienService nhanVienService =new NhanVienService();
    @GetMapping("/hien-thi")
    public String hienthi(Model model) {
        model.addAttribute("list", nhanVienService.getAll());
        return "nhanvien/index";
    }
    @GetMapping("/view-add")
    public String showForm(Model model, HttpSession session) {
        NhanVien nhanVien= (NhanVien) session.getAttribute("user");
        if(nhanVien==null){
            model.addAttribute("message","bạn phải đăng nhập ");
            return "/nhanvien/thongbao";
        }
        model.addAttribute("nhanvien", new NhanVien());
        return "/nhanvien/form";
    }

    @PostMapping("/add")
    public String save(@Valid @ModelAttribute("nhanvien") NhanVien nhanVien, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/nhanvien/form";
        }
      nhanVienService.add(nhanVien);
        return "redirect:/nhanvien/hien-thi";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam("id") String id, Model model) {
        model.addAttribute("nhanvien", nhanVienService.finByID(id));
        return "/nhanvien/detail";
    }

    @GetMapping("/view-update")
    public String showUpdate(@RequestParam("id") String id, Model model,HttpSession session) {
        NhanVien nhanVien= (NhanVien) session.getAttribute("user");
        if(nhanVien==null){
            model.addAttribute("message","bạn phải đăng nhập ");
            return "/nhanvien/thongbao";
        }
        model.addAttribute("nhanvien", nhanVienService.finByID(id));
        return "/nhanvien/update";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("nhanvien") NhanVien nhanVien, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/nhanvien/update";
        }
      nhanVienService.update(nhanVien);
        return "redirect:/nhanvien/hien-thi";
    }

    @GetMapping("/delete")
    public String delete(HttpServletRequest request,HttpSession session,Model model) {
        NhanVien nhanVien= (NhanVien) session.getAttribute("user");
        if(nhanVien==null){
            model.addAttribute("message","bạn phải đăng nhập ");
            return "/nhanvien/thongbao";
        }
       nhanVienService.delete(request.getParameter("id"));
        return "redirect:/nhanvien/hien-thi";
    }

    @GetMapping("/search")
    public String search(@RequestParam("ten") String ten, Model model) {
       NhanVien nhanVien = nhanVienService.searchName(ten);
        List<NhanVien> list = new ArrayList<>();
        list.add(nhanVien);
        model.addAttribute("list", list);
        return "/nhanvien/index";
    }
}
