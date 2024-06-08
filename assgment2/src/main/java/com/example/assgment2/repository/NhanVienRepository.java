package com.example.assgment2.repository;

import com.example.assgment2.entity.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien,Integer> {
    public NhanVien findNhanVienByTenDangNhapAndMatKhau(String tendangnha,String matkhau);
    public  NhanVien findNhanViensByTen(String ma);
    Page<NhanVien>findAll(Pageable pageable);
}
