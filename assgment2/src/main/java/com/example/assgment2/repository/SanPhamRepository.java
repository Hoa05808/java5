package com.example.assgment2.repository;

import com.example.assgment2.entity.NhanVien;
import com.example.assgment2.entity.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham,Integer> {
 public SanPham findSanPhamsByTen(String ten);
 Page<SanPham> findAll(Pageable pageable);
}
