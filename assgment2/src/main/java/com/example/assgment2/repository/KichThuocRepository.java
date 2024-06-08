package com.example.assgment2.repository;

import com.example.assgment2.entity.KichThuoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KichThuocRepository extends JpaRepository<KichThuoc,Integer> {
    public KichThuoc findKichThuocsByTen(String ten);
}
