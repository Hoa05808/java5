package com.example.assgment2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "spchitiet")
public class SanPhamCT {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "maspct")
    @NotBlank(message = "mã spct không được trống ")
    private String maSPCT;
    @Column(name = "idkichthuoc")
    @NotBlank(message = "id khích thước không được trống ")
    private String idKichThuoc;
    @Column(name = "idmausac")
    @NotBlank(message = "id màu sắc không được trống ")
    private String idMauSac;
    @Column(name = "idsanpham")
    @NotBlank(message = "id sản phẩm không được trống ")
    private String idSanPham;
    @Column(name = "soluong")
    @NotNull(message = "số lượng không được trống ")
    @Min(value =1,message = "tuổi phải lơn hơn 0")
    private int soLuong;
    @Column(name = "dongia")
    @NotNull(message = "đơn giá không được trống ")
    private int donGia;
    @Column(name = "trangthai")
    private boolean trangThai;
}
