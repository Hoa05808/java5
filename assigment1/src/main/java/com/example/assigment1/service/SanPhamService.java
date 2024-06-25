package com.example.assigment1.service;

import com.example.assigment1.entity.NhanVien;
import com.example.assigment1.entity.SanPham;
import com.example.assigment1.entity.SanPhamCT;

import java.util.ArrayList;
import java.util.List;

public class SanPhamService {
    List<SanPham> list = new ArrayList<>();

    public SanPhamService() {
        list.add(new SanPham("001", "SP01", "Áo thun nam", true));
        list.add(new SanPham("002", "SP02", "Áo sơ mi", true));
        list.add(new SanPham("003", "SP03", "Áo mùa đông", true));
        list.add(new SanPham("004", "SP04", "Áo phông", true));
        list.add(new SanPham("005", "SP05", "Áo polo", true));
    }

    public List<SanPham> getAll() {
        return list;
    }
    public SanPham finByID(String id) {
        for (SanPham sanPham : list) {
            if (sanPham.getId().equals(id)) {
                return sanPham;
            }
        }
        return null;
    }

    public void add(SanPham sanPham) {
        list.add(sanPham);
    }

    public void update(SanPham sanPham1) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(sanPham1.getId())) {
                list.set(i, sanPham1);
            }
        }
    }

    public void delete(String id) {
        List<SanPham> listDel = new ArrayList<SanPham>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                listDel.add(list.get(i));
            }
        }
        list.removeAll(listDel);
    }

    public SanPham searchName(String ten) {
        for (SanPham sanPham : list) {
            if (sanPham.getTen().equals(ten)) {
                return sanPham;
            }
        }
        return null;
    }

}
