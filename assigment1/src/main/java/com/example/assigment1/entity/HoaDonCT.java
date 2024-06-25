package com.example.assigment1.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HoaDonCT {
    private String id;
    private String idHoaDon;
    private String idSPCT;
    private int soLuong;
    private int donGia;
    private boolean trangThai;

}
