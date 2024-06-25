package com.example.assigment1.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NhanVien {
    @NotBlank(message = "id không được trống ")
    private String id;
    @NotBlank(message = "ten không được trống ")
    private String ten;
    @NotBlank(message = "manv không được trống ")
    private String maNV;
    @NotBlank(message = "tên đăng nhập không được trống ")
    private String tenDangNhap;
    @NotBlank(message = "mật khẩu không được trống ")
    private String matKhau;
    private boolean trangThai;
}
