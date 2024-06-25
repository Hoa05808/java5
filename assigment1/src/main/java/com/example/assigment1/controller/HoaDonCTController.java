package com.example.assigment1.controller;

import com.example.assigment1.entity.HoaDonCT;
import com.example.assigment1.entity.NhanVien;
import com.example.assigment1.entity.SanPhamCT;
import com.example.assigment1.service.HoaDonCTService;
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
@RequestMapping("/hoadonct")
public class HoaDonCTController {
    private HoaDonCTService hoaDonCTService=new HoaDonCTService();
    @GetMapping("/hien-thi")
    public String hienthi(Model model) {
        model.addAttribute("list", hoaDonCTService.getAll());
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
//       hoaDonCTService.add(hoaDonCT);
//        return "redirect:/hoadonct/hien-thi";
//    }

//    @GetMapping("/detail")
//    public String detail(@RequestParam("id") String id, Model model) {
//        model.addAttribute("hoadonct", hoaDonCTService.finByID(id));
//        return "/hoadonct/detail";
//    }

    @GetMapping("/view-update")
    public String showUpdate(@RequestParam("id") String id, Model model, HttpSession session) {
        NhanVien nhanVien= (NhanVien) session.getAttribute("user");
        if(nhanVien==null){
            model.addAttribute("message","bạn phải đăng nhập");
            return "hoadonct/thongbao";
        }else if(nhanVien.isTrangThai()==false){
            model.addAttribute("message","bạn không có quyền try cập ");
            return "hoadonct/thongbao";
        }else {
            model.addAttribute("hoadonct", hoaDonCTService.finByID(id));
            return "/hoadonct/update";
        }
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("hoadonct")HoaDonCT hoaDonCT, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/hoadonct/update";
        }
        hoaDonCTService.update(hoaDonCT);
        return "redirect:/hoadonct/hien-thi";
    }

    @GetMapping("/delete")
    public String delete(HttpServletRequest request,HttpSession session,Model model) {
        NhanVien nhanVien= (NhanVien) session.getAttribute("user");
        if(nhanVien==null){
            model.addAttribute("message","bạn phải đăng nhập");
            return "hoadonct/thongbao";
        }else if(nhanVien.isTrangThai()==false){
            model.addAttribute("message","bạn không có quyền try cập ");
            return "hoadonct/thongbao";
        }else {
            hoaDonCTService.delete(request.getParameter("id"));
            return "redirect:/hoadonct/hien-thi";
        }

    }

    @GetMapping("/search")
    public String search(@RequestParam("ten") String ten, Model model) {
        HoaDonCT hoaDonCT = hoaDonCTService.searchName(ten);
        List<HoaDonCT> list = new ArrayList<>();
        list.add(hoaDonCT);
        model.addAttribute("list", list);
        return "/hoadonct/index";
    }
}
