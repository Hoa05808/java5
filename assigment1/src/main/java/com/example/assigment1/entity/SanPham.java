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

public class SanPham {
    @NotBlank(message = "ID không được trống")
    private String id;
    @NotBlank(message = "mã không được trống")
    private String ma;
    @NotBlank(message = "tên không được trống")
    private String ten;
    private boolean trangThai;

}
