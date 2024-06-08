package com.example.assgment2.controller;

import com.example.assgment2.entity.HoaDonCT;
import com.example.assgment2.entity.NhanVien;
import com.example.assgment2.repository.HoaDonCTRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/hoadonct")
public class HoaDonCTController {
   @Autowired
    HoaDonCTRepository hoaDonCTRepository;
    @GetMapping("/hien-thi")
    public String hienthi(Model model) {
        model.addAttribute("list", hoaDonCTRepository.findAll());
        return "hoadonct/index";
    }
//    @GetMapping("/view-add")
//    public String showForm(Model model) {
//        model.addAttribute("hoadonct", new HoaDonCT());
//        return "/hoadonct/form";
//    }
//
//    @PostMapping("/add")
//    public String save(@Valid @ModelAttribute("hoadonct")HoaDonCT hoaDonCT, BindingResult result, Model model) {
//        if (result.hasErrors()) {
//            return "/hoadonct/form";
//        }
//       hoaDonCTRepository.save(hoaDonCT);
//        return "redirect:/hoadonct/hien-thi";
//    }

    @GetMapping("/detail")
    public String detail(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("hoadonct", hoaDonCTRepository.findById(id).get());
        return "/hoadonct/detail";
    }

    @GetMapping("/view-update")
    public String showUpdate(@RequestParam("id") Integer id, Model model, HttpSession session) {
        NhanVien nhanVien= (NhanVien) session.getAttribute("user");
        if(nhanVien==null){
            model.addAttribute("message","bạn phải đăng nhập");
            return "hoadonct/thongbao";
        }else if(nhanVien.isTrangThai()==false){
            model.addAttribute("message","bạn không có quyền try cập ");
            return "hoadonct/thongbao";
        }else {
            model.addAttribute("hoadonct",hoaDonCTRepository.findById(id).get() );
            return "/hoadonct/update";
        }
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("hoadonct")HoaDonCT hoaDonCT, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/hoadonct/update";
        }
        hoaDonCTRepository.save(hoaDonCT);
        return "redirect:/hoadonct/hien-thi";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Integer id,HttpServletRequest request,HttpSession session,Model model) {
        NhanVien nhanVien= (NhanVien) session.getAttribute("user");
        if(nhanVien==null){
            model.addAttribute("message","bạn phải đăng nhập");
            return "hoadonct/thongbao";
        }else if(nhanVien.isTrangThai()==false){
            model.addAttribute("message","bạn không có quyền try cập ");
            return "hoadonct/thongbao";
        }else {
            hoaDonCTRepository.deleteById(id);
            return "redirect:/hoadonct/hien-thi";
        }

    }

    @GetMapping("/search")
    public String search(@RequestParam("id") Integer id, Model model) {
        HoaDonCT hoaDonCT = hoaDonCTRepository.findHoaDonCTsById(id);
        List<HoaDonCT> list = new ArrayList<>();
        list.add(hoaDonCT);
        model.addAttribute("list", list);
        return "/hoadonct/index";
    }
}
