package com.example.assgment2.controller;

import com.example.assgment2.repository.NhanVienRepository;
import com.example.assgment2.entity.NhanVien;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/trangchu")
public class LoginController {
    @Autowired
    NhanVienRepository nhanVienRepository;

    @RequestMapping("/formdangnhap")
    public String form() {
        return "trangchu/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, HttpServletRequest request , Model model) {
        String tendangnhap = request.getParameter("username");
        String matkhau = request.getParameter("pass");
        NhanVien nhanVien = nhanVienRepository.findNhanVienByTenDangNhapAndMatKhau(tendangnhap, matkhau);
        if (nhanVien!=null) {
            session.setAttribute("user", nhanVien);
            return "trangchu/index";
        }else {
            model.addAttribute("mess","tên đăng nhập hoặc mật khẩu ko đúng");
            return "trangchu/login";
        }

    }
}
