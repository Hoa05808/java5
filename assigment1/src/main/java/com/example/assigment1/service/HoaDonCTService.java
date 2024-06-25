package com.example.assigment1.service;

import com.example.assigment1.entity.HoaDon;
import com.example.assigment1.entity.HoaDonCT;

import java.util.ArrayList;
import java.util.List;

public class HoaDonCTService {
    List<HoaDonCT> list = new ArrayList<>();

    public HoaDonCTService() {
        list.add(new HoaDonCT("HDCT01", "HD01", "301", 50, 100, true));
        list.add(new HoaDonCT("HDCT02", "HD02", "302", 20, 200, true));
        list.add(new HoaDonCT("HDCT03", "HD03", "303", 80, 500, true));
        list.add(new HoaDonCT("HDCT04", "HD04", "304", 60, 300, true));
        list.add(new HoaDonCT("HDCT05", "HD05", "305", 90, 100, true));

    }

    public List<HoaDonCT> getAll() {
        return list;
    }

    public HoaDonCT finByID(String id) {
        for (HoaDonCT hoaDonCT : list) {
            if (hoaDonCT.getId().equals(id)) {
                return hoaDonCT;
            }
        }
        return null;
    }

    public void add(HoaDonCT hoaDonCT) {
        list.add(hoaDonCT);
    }

    public void update(HoaDonCT hoaDonCT1) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(hoaDonCT1.getId())) {
                list.set(i, hoaDonCT1);
            }
        }
    }

    public void delete(String id) {
        List<HoaDonCT> listDel = new ArrayList<HoaDonCT>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                listDel.add(list.get(i));
            }
        }
        list.removeAll(listDel);
    }

    public HoaDonCT searchName(String id) {
        for (HoaDonCT hoaDonCT : list) {
            if (hoaDonCT.getId().equals(id)) {
                return hoaDonCT;
            }
        }
        return null;
    }
}
