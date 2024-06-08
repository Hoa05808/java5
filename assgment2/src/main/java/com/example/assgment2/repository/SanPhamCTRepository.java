package com.example.assgment2.repository;

import com.example.assgment2.entity.SanPhamCT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SanPhamCTRepository extends JpaRepository<SanPhamCT,Integer> {
    public SanPhamCT findSanPhamCTSByMaSPCT(String ma);
}
