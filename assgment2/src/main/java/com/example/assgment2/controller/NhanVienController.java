package com.example.assgment2.controller;

import com.example.assgment2.entity.NhanVien;
import com.example.assgment2.repository.NhanVienRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
@RequestMapping("/nhanvien")
public class NhanVienController {
    @Autowired
    NhanVienRepository nhanVienRepository;
    @GetMapping("/hien-thi")
    public String hienthi(Model model) {
        model.addAttribute("list", nhanVienRepository.findAll());
        return "nhanvien/index";
    }
//    @GetMapping("/hien-thi")
//    public String hienthi(Model model,@RequestParam(name = "page",defaultValue = "0")Integer page) {
//        Pageable pageable= PageRequest.of(page,3);
//        Page<NhanVien>nhanViens=nhanVienRepository.findAll(pageable);
//
//        List<NhanVien>list=nhanViens.getContent();
//
//        model.addAttribute("page",nhanViens);
//
//        model.addAttribute("list", list);
//        return "nhanvien/index";
//    }

    @GetMapping("/view-add")
    public String showForm(Model model, HttpSession session) {
        NhanVien nhanVien = (NhanVien) session.getAttribute("user");
        if (nhanVien == null) {
            model.addAttribute("message", "bạn phải đăng nhập ");
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
        nhanVienRepository.save(nhanVien);
        return "redirect:/nhanvien/hien-thi";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("nhanvien", nhanVienRepository.findById(id).get());
        return "/nhanvien/detail";
    }

    @GetMapping("/view-update")
    public String showUpdate(@RequestParam("id") Integer id, Model model, HttpSession session) {
        NhanVien nhanVien = (NhanVien) session.getAttribute("user");
        if (nhanVien == null) {
            model.addAttribute("message", "bạn phải đăng nhập ");
            return "/nhanvien/thongbao";
        }
        model.addAttribute("nhanvien", nhanVienRepository.findById(id).get());
        return "/nhanvien/update";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("nhanvien") NhanVien nhanVien, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/nhanvien/update";
        }
        nhanVienRepository.save(nhanVien);
        return "redirect:/nhanvien/hien-thi";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id")Integer id , HttpSession session, Model model) {
        NhanVien nhanVien= (NhanVien) session.getAttribute("user");
        if(nhanVien==null){
            model.addAttribute("message","bạn phải đăng nhập ");
            return "/nhanvien/thongbao";
        }
      nhanVienRepository.deleteById(id);
        return "redirect:/nhanvien/hien-thi";
    }

    @GetMapping("/search")
    public String search(@RequestParam("ten") String ten, Model model) {
       NhanVien nhanVien = nhanVienRepository.findNhanViensByTen(ten);
        List<NhanVien> list = new ArrayList<>();
        list.add(nhanVien);
        model.addAttribute("list", list);
        return "/nhanvien/index";
    }
}
