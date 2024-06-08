package com.example.assgment2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "nhanvien")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "ten")
    @NotBlank(message = "ten không được trống ")
    private String ten;
    @Column(name = "manv")
    @NotBlank(message = "manv không được trống ")
    private String maNV;
    @Column(name = "tendangnhap")
    @NotBlank(message = "tên đăng nhập không được trống ")
    private String tenDangNhap;
    @Column(name = "matkhau")
    @NotBlank(message = "mật khẩu không được trống ")
    private String matKhau;
    @Column(name = "trangthai")
    private boolean trangThai;
}
