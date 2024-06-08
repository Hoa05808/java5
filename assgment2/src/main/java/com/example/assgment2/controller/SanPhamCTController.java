package com.example.assgment2.controller;

import com.example.assgment2.entity.NhanVien;
import com.example.assgment2.entity.SanPhamCT;
import com.example.assgment2.repository.SanPhamCTRepository;
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
@RequestMapping("/sanphamct")
public class SanPhamCTController {
   @Autowired
    SanPhamCTRepository sanPhamCTRepository;
    @GetMapping("/hien-thi")
    public String hienthi(Model model) {
        model.addAttribute("list", sanPhamCTRepository.findAll());
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
        sanPhamCTRepository.save(sanPhamCT);
        return "redirect:/sanphamct/hien-thi";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("sanphamct", sanPhamCTRepository.findById(id).get());
        return "/sanphamct/detail";
    }

    @GetMapping("/view-update")
    public String showUpdate(@RequestParam("id") Integer id, Model model,HttpSession session) {
        NhanVien nhanVien= (NhanVien) session.getAttribute("user");
        if(nhanVien==null){
            model.addAttribute("message","bạn phải đăng nhập ");
            return "/sanphamct/thongbao";
        }
        model.addAttribute("sanphamct", sanPhamCTRepository.findById(id).get());
        return "/sanphamct/update";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("sanphamct")SanPhamCT sanPhamCT, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/sanphamct/update";
        }
        sanPhamCTRepository.save(sanPhamCT);
        return "redirect:/sanphamct/hien-thi";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id")Integer id, HttpSession session, Model model) {
        NhanVien nhanVien= (NhanVien) session.getAttribute("user");
        if(nhanVien==null){
            model.addAttribute("message","bạn phải đăng nhập ");
            return "/sanphamct/thongbao";
        }
        sanPhamCTRepository.deleteById(id);
        return "redirect:/sanphamct/hien-thi";
    }

    @GetMapping("/search")
    public String search(@RequestParam("ma")String ma, Model model) {
       SanPhamCT sanPhamCT = sanPhamCTRepository.findSanPhamCTSByMaSPCT(ma);
        List<SanPhamCT> list = new ArrayList<>();
        list.add(sanPhamCT);
        model.addAttribute("list", list);
        return "/sanphamct/index";
    }
}
