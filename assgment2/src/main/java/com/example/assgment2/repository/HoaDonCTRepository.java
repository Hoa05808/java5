package com.example.assgment2.repository;

import com.example.assgment2.entity.HoaDonCT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoaDonCTRepository extends JpaRepository<HoaDonCT,Integer> {
    public HoaDonCT findHoaDonCTsById(Integer id);
}
