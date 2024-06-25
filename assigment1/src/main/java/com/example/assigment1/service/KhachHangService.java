package com.example.assigment1.service;

import com.example.assigment1.entity.KhachHang;
import com.example.assigment1.entity.KichThuoc;

import java.util.ArrayList;
import java.util.List;

public class KhachHangService {
    List<KhachHang> list = new ArrayList<>();

    public KhachHangService() {
        list.add(new KhachHang("201", "Tuan", "0923424", "KH01", true));
        list.add(new KhachHang("202", "Quang", "0976543", "KH02", true));
        list.add(new KhachHang("203", "Trung", "0754232", "KH03", true));
        list.add(new KhachHang("204", "Huy", "09234656", "KH04", true));
        list.add(new KhachHang("205", "Hoa", "0934244", "KH05", true));
    }

    public List<KhachHang> getAll() {
        return list;
    }

    public KhachHang finByID(String id) {
        for (KhachHang khachHang : list) {
            if (khachHang.getId().equals(id)) {
                return khachHang;
            }
        }
        return null;
    }

    public void add(KhachHang khachHang) {
        list.add(khachHang);
    }

    public void update(KhachHang khachHang1) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(khachHang1.getId())) {
                list.set(i, khachHang1);
            }
        }
    }

    public void delete(String id) {
        List<KhachHang> listDel = new ArrayList<KhachHang>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                listDel.add(list.get(i));
            }
        }
        list.removeAll(listDel);
    }

    public KhachHang searchName(String ten) {
        for (KhachHang khachHang : list) {
            if (khachHang.getTen().equals(ten)) {
                return khachHang;
            }
        }
        return null;
    }
}
