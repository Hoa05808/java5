package com.example.assigment1.controller;

import com.example.assigment1.entity.NhanVien;
import com.example.assigment1.entity.SanPham;
import com.example.assigment1.service.SanPhamService;
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
@RequestMapping("/sanpham")
public class SanPhamController {
    private SanPhamService sanPhamService = new SanPhamService();

    @GetMapping("/hien-thi")
    public String hienthi(Model model) {
        model.addAttribute("list", sanPhamService.getAll());
        return "sanpham/index";
    }
    @GetMapping("/view-add")
    public String showForm(Model model, HttpSession session) {
        NhanVien nhanVien= (NhanVien) session.getAttribute("user");
        if(nhanVien==null){
            model.addAttribute("message","bạn phải đăng nhập ");
            return "/sanpham/thongbao";
        }
        model.addAttribute("sanpham", new SanPham());
        return "sanpham/form";
    }
    @PostMapping("/add")
    public String save(@Valid @ModelAttribute("sanpham") SanPham sanPham, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/sanpham/form";
        }
       sanPhamService.add(sanPham);
        return "redirect:/sanpham/hien-thi";
    }
    @GetMapping("/detail")
    public String detail(@RequestParam("id") String id, Model model) {
        model.addAttribute("sanpham", sanPhamService.finByID(id));
        return "/sanpham/detail";
    }

    @GetMapping("/view-update")
    public String showUpdate(@RequestParam("id") String id, Model model,HttpSession session) {
        NhanVien nhanVien= (NhanVien) session.getAttribute("user");
        if(nhanVien==null){
            model.addAttribute("message","bạn phải đăng nhập ");
            return "/sanpham/thongbao";
        }
        model.addAttribute("sanpham", sanPhamService.finByID(id));
        return "/sanpham/update";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("sanpham") SanPham sanPham, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/sanpham/update";
        }
        sanPhamService.update(sanPham);
        return "redirect:/sanpham/hien-thi";
    }

    @GetMapping("/delete")
    public String delete(HttpServletRequest request,HttpSession session,Model model) {
        NhanVien nhanVien= (NhanVien) session.getAttribute("user");
        if(nhanVien==null){
            model.addAttribute("message","bạn phải đăng nhập ");
            return "/sanpham/thongbao";
        }
        sanPhamService.delete(request.getParameter("id"));
        return "redirect:/sanpham/hien-thi";
    }

    @GetMapping("/search")
    public String search(@RequestParam("ten") String ten, Model model) {
        SanPham searchName = sanPhamService.searchName(ten);
        List<SanPham> list = new ArrayList<>();
        list.add(searchName);
        model.addAttribute("list", list);
        return "/sanpham/hienthi";
    }
}
