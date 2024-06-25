package com.example.assigment1.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HoaDon {
    private String id;
    private String idNV;
    private String idKhachHang;
    private String ngayMuaHang;
    private boolean trangThai;

}
