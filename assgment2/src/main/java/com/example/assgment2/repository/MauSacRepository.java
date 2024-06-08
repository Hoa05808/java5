package com.example.assgment2.repository;

import com.example.assgment2.entity.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MauSacRepository extends JpaRepository<MauSac,Integer> {
    public MauSac findMauSacByTen(String ten);
}
