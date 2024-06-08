package com.example.assgment2.controller;

import com.example.assgment2.repository.SanPhamRepository;
import com.example.assgment2.entity.NhanVien;
import com.example.assgment2.entity.SanPham;
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
@RequestMapping("/sanpham")
public class SanPhamController {
   @Autowired
    SanPhamRepository sanPhamRepository;

    @GetMapping("/hien-thi")
    public String hienthi(Model model) {
        model.addAttribute("list", sanPhamRepository.findAll());
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
     sanPhamRepository.save(sanPham);
        return "redirect:/sanpham/hien-thi";
    }
    @GetMapping("/detail")
    public String detail(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("sanpham", sanPhamRepository.findById(id).get());
        return "/sanpham/detail";
    }

    @GetMapping("/view-update")
    public String showUpdate(@RequestParam("id") Integer id, Model model,HttpSession session) {
        NhanVien nhanVien= (NhanVien) session.getAttribute("user");
        if(nhanVien==null){
            model.addAttribute("message","bạn phải đăng nhập ");
            return "/sanpham/thongbao";
        }
        model.addAttribute("sanpham", sanPhamRepository.findById(id).get());
        return "/sanpham/update";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("sanpham") SanPham sanPham, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/sanpham/update";
        }
        sanPhamRepository.save(sanPham);
        return "redirect:/sanpham/hien-thi";
    }

   @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id")Integer id , HttpSession session, Model model) {
        NhanVien nhanVien= (NhanVien) session.getAttribute("user");
        if(nhanVien==null){
            model.addAttribute("message","bạn phải đăng nhập ");
            return "/sanpham/thongbao";
        }
      sanPhamRepository.deleteById(id);
        return "redirect:/sanpham/hien-thi";
    }

    @GetMapping("/search")
    public String search(@RequestParam("ten") String ten, Model model) {
        SanPham searchName = sanPhamRepository.findSanPhamsByTen(ten);
        List<SanPham> list = new ArrayList<>();
        list.add(searchName);
        model.addAttribute("list", list);
        return "/sanpham/index";
    }
}
