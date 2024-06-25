package com.example.assigment1.controller;

import com.example.assigment1.entity.MauSac;
import com.example.assigment1.entity.NhanVien;
import com.example.assigment1.service.MauSacService;
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
@RequestMapping("/mausac")
public class MauSacController {
    private MauSacService mauSacService=new MauSacService();
    @GetMapping("/hien-thi")
    public String hienthi(Model model) {
        model.addAttribute("list", mauSacService.getAll());
        return "mausac/index";
    }
    @GetMapping("/view-add")
    public String showForm(Model model, HttpSession session) {
        NhanVien nhanVien= (NhanVien) session.getAttribute("user");
        if(nhanVien==null){
            model.addAttribute("message","bạn phải đăng nhập ");
            return "/mausac/thongbao";
        }
        model.addAttribute("mausac", new MauSac());
        return "/mausac/form";
    }

    @PostMapping("/add")
    public String save(@Valid @ModelAttribute("mausac") MauSac mauSac, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/mausac/form";
        }
        mauSacService.add(mauSac);
        return "redirect:/mausac/hien-thi";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam("id") String id, Model model) {
        model.addAttribute("mausac", mauSacService.finByID(id));
        return "/mausac/detail";
    }

    @GetMapping("/view-update")
    public String showUpdate(@RequestParam("id") String id, Model model,HttpSession session) {
        NhanVien nhanVien= (NhanVien) session.getAttribute("user");
        if(nhanVien==null){
            model.addAttribute("message","bạn phải đăng nhập ");
            return "/mausac/thongbao";
        }
        model.addAttribute("mausac", mauSacService.finByID(id));
        return "/mausac/update";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("mausac") MauSac mauSac, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/mausac/update";
        }
       mauSacService.update(mauSac);
        return "redirect:/mausac/hien-thi";
    }

    @GetMapping("/delete")
    public String delete(HttpServletRequest request,HttpSession session,Model model) {
        NhanVien nhanVien= (NhanVien) session.getAttribute("user");
        if(nhanVien==null){
            model.addAttribute("message","bạn phải đăng nhập ");
            return "/mausac/thongbao";
        }
        mauSacService.delete(request.getParameter("id"));
        return "redirect:/mausac/hien-thi";
    }

    @GetMapping("/search")
    public String search(@RequestParam("ten") String ten, Model model) {
        MauSac mauSac = mauSacService.searchName(ten);
        List<MauSac> list = new ArrayList<>();
        list.add(mauSac);
        model.addAttribute("list", list);
        return "/mausac/index";
    }
}
