package com.example.lab6.Repository;

import com.example.lab6.entity.LoaiDichVu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaiDichVuRepository extends JpaRepository<LoaiDichVu,Integer> {
}
