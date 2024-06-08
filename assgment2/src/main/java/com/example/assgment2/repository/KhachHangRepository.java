package com.example.assgment2.repository;

import com.example.assgment2.entity.KhachHang;
import com.example.assgment2.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang,Integer> {
    public KhachHang findKhachHangByTen(String ten);
}
