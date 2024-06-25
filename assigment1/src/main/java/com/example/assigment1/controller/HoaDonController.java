package com.example.assigment1.controller;

import com.example.assigment1.entity.HoaDon;
import com.example.assigment1.entity.NhanVien;
import com.example.assigment1.service.HoaDonService;
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
@RequestMapping("/hoadon")
public class HoaDonController {

    private HoaDonService hoaDonService=new HoaDonService();
    @GetMapping("/hien-thi")
    public String hienthi(Model model) {
        model.addAttribute("list", hoaDonService.getAll());
        return "hoadon/index";
    }
//    @GetMapping("/view-add")
//    public String showForm(Model model) {
//        model.addAttribute("hoadon", new HoaDon());
//        return "/hoadon/form";
//    }

//    @PostMapping("/add")
//    public String save(@Valid @ModelAttribute("hoadon")HoaDon hoaDon, BindingResult result, Model model) {
//        if (result.hasErrors()) {
//            return "/hoadon/form";
//        }
//        hoaDonService.add(hoaDon);
//        return "redirect:/hoadon/hien-thi";
//    }

    @GetMapping("/detail")
    public String detail(@RequestParam("id") String id, Model model) {
        model.addAttribute("hoadon", hoaDonService.finByID(id));
        return "/hoadon/detail";
    }

    @GetMapping("/view-update")
    public String showUpdate(@RequestParam("id") String id, Model model,HttpSession session) {
        NhanVien nhanVien= (NhanVien) session.getAttribute("user");
        if(nhanVien==null){
            model.addAttribute("message","bạn phải đăng nhập");
            return "hoadon/thongbao";
        }else if(nhanVien.isTrangThai()==false){
            model.addAttribute("message","bạn không có quyền try cập ");
            return "hoadon/thongbao";
        }else {
            model.addAttribute("hoadon", hoaDonService.finByID(id));
            return "/hoadon/update";
        }
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("hoadon")HoaDon hoaDon, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/hoadon/update";
        }
        hoaDonService.update(hoaDon);
        return "redirect:/hoadon/hien-thi";
    }

    @GetMapping("/delete")
    public String delete(HttpServletRequest request,HttpSession session,Model model) {
        NhanVien nhanVien= (NhanVien) session.getAttribute("user");
        if(nhanVien==null){
            model.addAttribute("message","bạn phải đăng nhập");
            return "hoadon/thongbao";
        }else if(nhanVien.isTrangThai()==false){
            model.addAttribute("message","bạn không có quyền try cập ");
            return "hoadon/thongbao";
        }else {
            hoaDonService.delete(request.getParameter("id"));
            return "redirect:/hoadon/hien-thi";
        }

    }

    @GetMapping("/search")
    public String search(@RequestParam("ten") String ten, Model model) {
        HoaDon hoaDon = hoaDonService.searchName(ten);
        List<HoaDon> list = new ArrayList<>();
        list.add(hoaDon);
        model.addAttribute("list", list);
        return "/hoadon/index";
    }
}
