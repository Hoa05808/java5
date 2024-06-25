package com.example.assigment1.controller;

import com.example.assigment1.entity.NhanVien;
import com.example.assigment1.service.NhanVienService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/trangchu")
public class LoginController {
    private NhanVienService nhanVienService = new NhanVienService();

    @RequestMapping("/formdangnhap")
    public String form() {
        return "trangchu/login";
    }
    @RequestMapping(value = "/login" ,method = RequestMethod.POST)
    public  String login(HttpSession session,HttpServletRequest request){
        String tendangnhap=request.getParameter("username");
        String matkhau=request.getParameter("pass");
        NhanVien nhanVien=nhanVienService.finBylogin(tendangnhap,matkhau);
       if(nhanVien!=null&& nhanVien!=null){
           session.setAttribute("user",nhanVien);
           return "trangchu/index";
        }
       return "trangchu/login";
    }
}
