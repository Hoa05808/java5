package com.example.assgment2.controller;

import com.example.assgment2.entity.MauSac;
import com.example.assgment2.entity.NhanVien;
import com.example.assgment2.repository.MauSacRepository;
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
@RequestMapping("/mausac")
public class MauSacController {
   @Autowired
    MauSacRepository mauSacRepository;
    @GetMapping("/hien-thi")
    public String hienthi(Model model) {
        model.addAttribute("list", mauSacRepository.findAll());
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
        mauSacRepository.save(mauSac);
        return "redirect:/mausac/hien-thi";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("mausac",mauSacRepository.findById(id).get());
        return "/mausac/detail";
    }

    @GetMapping("/view-update")
    public String showUpdate(@RequestParam("id") Integer id, Model model,HttpSession session) {
        NhanVien nhanVien= (NhanVien) session.getAttribute("user");
        if(nhanVien==null){
            model.addAttribute("message","bạn phải đăng nhập ");
            return "/mausac/thongbao";
        }
        model.addAttribute("mausac",mauSacRepository.findById(id).get());
        return "/mausac/update";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("mausac") MauSac mauSac, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/mausac/update";
        }
        mauSacRepository.save(mauSac);
        return "redirect:/mausac/hien-thi";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id")Integer id, HttpSession session, Model model) {
        NhanVien nhanVien= (NhanVien) session.getAttribute("user");
        if(nhanVien==null){
            model.addAttribute("message","bạn phải đăng nhập ");
            return "/mausac/thongbao";
        }
        mauSacRepository.deleteById(id);
        return "redirect:/mausac/hien-thi";
    }

    @GetMapping("/search")
    public String search(@RequestParam("ten") String ten, Model model) {
        MauSac mauSac = mauSacRepository.findMauSacByTen(ten);
        List<MauSac> list = new ArrayList<>();
        list.add(mauSac);
        model.addAttribute("list", list);
        return "/mausac/index";
    }
}
