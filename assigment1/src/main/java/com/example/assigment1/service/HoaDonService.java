package com.example.assigment1.service;

import com.example.assigment1.entity.HoaDon;


import java.util.ArrayList;
import java.util.List;

public class HoaDonService {
    List<HoaDon> list=new ArrayList<>();
    public HoaDonService() {
        list.add(new HoaDon("HD01", "01", "201", "05/05/2024", true));
        list.add(new HoaDon("HD02", "02", "202", "15/05/2024", true));
        list.add(new HoaDon("HD03", "03", "203", "25/05/2024", true));
        list.add(new HoaDon("HD04", "04", "204", "16/05/2024", true));
        list.add(new HoaDon("HD05", "05", "205", "20/05/2024", true));
    }

    public  List<HoaDon>getAll(){
        return list;
    }
    public HoaDon finByID(String id) {
        for (HoaDon hoaDon : list) {
            if (hoaDon.getId().equals(id)) {
                return hoaDon;
            }
        }
        return null;
    }
    public  void add(HoaDon hoaDon){
        list.add(hoaDon);
    }
    public void update(HoaDon hoaDon1) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(hoaDon1.getId())) {
                list.set(i, hoaDon1);
            }
        }
    }

    public void delete(String id) {
        List<HoaDon> listDel = new ArrayList<HoaDon>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                listDel.add(list.get(i));
            }
        }
        list.removeAll(listDel);
    }

    public HoaDon searchName(String id) {
        for (HoaDon hoaDon : list) {
            if (hoaDon.getId().equals(id)) {
                return hoaDon;
            }
        }
        return null;
    }
}
