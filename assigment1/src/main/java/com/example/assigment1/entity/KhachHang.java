package com.example.assigment1.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class KhachHang {
    private String id;
    private String ten;
    private String sdt;
    private String maKH;
    private boolean trangThai;

}
