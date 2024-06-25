package com.example.assigment1.controller;

import com.example.assigment1.entity.KhachHang;
import com.example.assigment1.entity.NhanVien;
import com.example.assigment1.entity.SanPhamCT;
import com.example.assigment1.service.SanPhamCTService;
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
@RequestMapping("/sanphamct")
public class SanPhamCTController {
    private SanPhamCTService sanPhamCTService=new SanPhamCTService();
    @GetMapping("/hien-thi")
    public String hienthi(Model model) {
        model.addAttribute("list", sanPhamCTService.getAll());
        return "sanphamct/index";
    }
    @GetMapping("/view-add")
    public String showForm(Model model, HttpSession session ) {
        NhanVien nhanVien= (NhanVien) session.getAttribute("user");
        if(nhanVien==null){
            model.addAttribute("message","bạn phải đăng nhập ");
            return "/sanphamct/thongbao";
        }
        model.addAttribute("sanphamct", new SanPhamCT());
        return "/sanphamct/form";
    }

    @PostMapping("/add")
    public String save(@Valid @ModelAttribute("sanphamct")SanPhamCT sanPhamCT, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/sanphamct/form";
        }
        sanPhamCTService.add(sanPhamCT);
        return "redirect:/sanphamct/hien-thi";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam("id") String id, Model model) {
        model.addAttribute("sanphamct", sanPhamCTService.finByID(id));
        return "/sanphamct/detail";
    }

    @GetMapping("/view-update")
    public String showUpdate(@RequestParam("id") String id, Model model,HttpSession session) {
        NhanVien nhanVien= (NhanVien) session.getAttribute("user");
        if(nhanVien==null){
            model.addAttribute("message","bạn phải đăng nhập ");
            return "/sanphamct/thongbao";
        }
        model.addAttribute("sanphamct", sanPhamCTService.finByID(id));
        return "/sanphamct/update";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("sanphamct")SanPhamCT sanPhamCT, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/sanphamct/update";
        }
        sanPhamCTService.update(sanPhamCT);
        return "redirect:/sanphamct/hien-thi";
    }

    @GetMapping("/delete")
    public String delete(HttpServletRequest request,HttpSession session,Model model) {
        NhanVien nhanVien= (NhanVien) session.getAttribute("user");
        if(nhanVien==null){
            model.addAttribute("message","bạn phải đăng nhập ");
            return "/sanphamct/thongbao";
        }
        sanPhamCTService.delete(request.getParameter("id"));
        return "redirect:/sanphamct/hien-thi";
    }

    @GetMapping("/search")
    public String search(@RequestParam("ten") String ten, Model model) {
       SanPhamCT sanPhamCT = sanPhamCTService.searchName(ten);
        List<SanPhamCT> list = new ArrayList<>();
        list.add(sanPhamCT);
        model.addAttribute("list", list);
        return "/sanphamct/index";
    }
}
