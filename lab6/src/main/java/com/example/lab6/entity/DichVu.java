package com.example.lab6.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "dich_vu")
public class DichVu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name ="id_loai_dich_vu",referencedColumnName = "id")
    private LoaiDichVu loaiDichVu;
    @Column(name = "don_gia")
    private BigDecimal donGia;
    @Column(name = "don_vi_tien")
    private String donViTien;
    @Column(name = "don_vi_tinh")
    private String donViTinh;
    @Column(name = "mo_ta")
    private String moTa;
    @Column(name = "ten_dich_vu")
    private String tenDV;
    @Column(name = "trang_thai")
    private String trangThai;

}
