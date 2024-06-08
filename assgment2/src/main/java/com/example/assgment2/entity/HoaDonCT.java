package com.example.assgment2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "hoadonchitiet")
public class HoaDonCT {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "idhoadon")
    private String idHoaDon;
    @Column(name = "idspct")
    private String idSPCT;
    @Column(name = "soluong")
    private int soLuong;
    @Column(name = "dongia")
    private int donGia;
    @Column(name = "trangthai")
    private boolean trangThai;

}
