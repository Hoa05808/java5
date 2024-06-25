package com.example.assigment1.service;

import com.example.assigment1.entity.KichThuoc;
import com.example.assigment1.entity.MauSac;

import java.util.ArrayList;
import java.util.List;

public class KichThuocService {
    List<KichThuoc> list=new ArrayList<>();
    public KichThuocService (){
        list.add(new KichThuoc("2001","K01","S",true));
        list.add(new KichThuoc("2002","K02","M",true));
        list.add(new KichThuoc("2003","K03","X",true));
        list.add(new KichThuoc("2004","K04","XL",true));
    }
    public  List<KichThuoc>getAll(){
        return list;
    }
    public KichThuoc finByID(String id) {
        for (KichThuoc kichThuoc : list) {
            if (kichThuoc.getId().equals(id)) {
                return kichThuoc;
            }
        }
        return null;
    }
    public  void add(KichThuoc kichThuoc){
        list.add(kichThuoc);
    }
    public void update(KichThuoc kichThuoc1) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(kichThuoc1.getId())) {
                list.set(i, kichThuoc1);
            }
        }
    }

    public void delete(String id) {
        List<KichThuoc> listDel = new ArrayList<KichThuoc>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                listDel.add(list.get(i));
            }
        }
        list.removeAll(listDel);
    }

    public KichThuoc searchName(String ten) {
        for (KichThuoc kichThuoc : list) {
            if (kichThuoc.getTen().equals(ten)) {
                return kichThuoc;
            }
        }
        return null;
    }
}
