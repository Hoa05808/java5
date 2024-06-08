package com.example.assgment2.repository;

import com.example.assgment2.entity.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon,Integer> {
    public HoaDon findHoaDonsById(Integer id);
}
