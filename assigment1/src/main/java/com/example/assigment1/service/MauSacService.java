package com.example.assigment1.service;

import com.example.assigment1.entity.MauSac;
import com.example.assigment1.entity.NhanVien;

import java.util.ArrayList;
import java.util.List;

public class MauSacService {
    List<MauSac>list=new ArrayList<>();
    public MauSacService (){
        list.add(new MauSac("1001","M01","Vang",true));
        list.add(new MauSac("1002","M02","Đỏ",true));
        list.add(new MauSac("1003","M03","Xanh",true));
        list.add(new MauSac("1004","M04","Trắng",true));
        list.add(new MauSac("1005","M05","Đen",true));
    }
    public  List<MauSac>getAll(){
        return list;
    }
    public MauSac finByID(String id) {
        for (MauSac mauSac : list) {
            if (mauSac.getId().equals(id)) {
                return mauSac;
            }
        }
        return null;
    }
    public  void add(MauSac mauSac){
        list.add(mauSac);
    }
    public void update(MauSac mauSac1) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(mauSac1.getId())) {
                list.set(i, mauSac1);
            }
        }
    }

    public void delete(String id) {
        List<MauSac> listDel = new ArrayList<MauSac>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                listDel.add(list.get(i));
            }
        }
        list.removeAll(listDel);
    }

    public MauSac searchName(String ten) {
        for (MauSac mauSac : list) {
            if (mauSac.getTen().equals(ten)) {
                return mauSac;
            }
        }
        return null;
    }
}
