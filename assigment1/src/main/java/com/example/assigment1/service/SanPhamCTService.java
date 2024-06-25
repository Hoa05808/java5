package com.example.assigment1.service;

import com.example.assigment1.entity.HoaDon;
import com.example.assigment1.entity.SanPhamCT;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SanPhamCTService {
    List<SanPhamCT> list = new ArrayList<>();

    public SanPhamCTService() {
        list.add(new SanPhamCT("301", "SPCT01", "2001", "1001", "001", 200, 150, true));
        list.add(new SanPhamCT("302", "SPCT02", "2002", "1002", "002", 200, 150, true));
        list.add(new SanPhamCT("303", "SPCT03", "2003", "1003", "003", 200, 150, true));
        list.add(new SanPhamCT("304", "SPCT04", "2004", "1004", "004", 200, 150, true));
        list.add(new SanPhamCT("305", "SPCT05", "2001", "1005", "005", 200, 150, true));

    }

    public List<SanPhamCT> getAll() {
        return list;
    }

    public SanPhamCT finByID(String id) {
        for (SanPhamCT sanPhamCT : list) {
            if (sanPhamCT.getId().equals(id)) {
                return sanPhamCT;
            }
        }
        return null;
    }

    public void add(SanPhamCT sanPhamCT) {
        list.add(sanPhamCT);
    }

    public void update(SanPhamCT sanPhamCT1) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(sanPhamCT1.getId())) {
                list.set(i, sanPhamCT1);
            }
        }
    }

    public void delete(String id) {
        List<SanPhamCT> listDel = new ArrayList<SanPhamCT>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                listDel.add(list.get(i));
            }
        }
        list.removeAll(listDel);
    }

    public SanPhamCT searchName(String ma) {
        for (SanPhamCT sanPhamCT : list) {
            if (sanPhamCT.getMaSPCT().equals(ma)) {
                return sanPhamCT;
            }
        }
        return null;
    }
}
