package com.example.assigment1.service;

import com.example.assigment1.entity.NhanVien;

import java.util.ArrayList;
import java.util.List;

public class NhanVienService {
    List<NhanVien>list =new ArrayList<>();
     public NhanVienService(){
         list.add(new NhanVien("01","Hoa","NV01","DangHoa","123",true));
         list.add(new NhanVien("02","Hùng","NV02","HHung","123",false));
         list.add(new NhanVien("03","Tuấn","NV03","NTuan","123",false));
         list.add(new NhanVien("04","Thủy","NV04","HThuy","123",false));
         list.add(new NhanVien("05","Linh","NV05","DLinh","123",true));
     }
     public List<NhanVien>getAll(){
         return list;
     }
    public NhanVien finByID(String id) {
        for (NhanVien nhanVien : list) {
            if (nhanVien.getId().equals(id)) {
                return nhanVien;
            }
        }
        return null;
    }
    public NhanVien finBylogin(String tenDN,String pass) {
        for (NhanVien nhanVien : list) {
            if (nhanVien.getTenDangNhap().equals(tenDN)&&nhanVien.getMatKhau().equals(pass)) {
                return nhanVien;
            }

        }
        return null;
    }
     public  void add(NhanVien nhanVien){
         list.add(nhanVien);
     }
    public void update(NhanVien nhanVien1) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(nhanVien1.getId())) {
                list.set(i, nhanVien1);
            }
        }
    }

    public void delete(String id) {
        List<NhanVien> listDel = new ArrayList<NhanVien>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                listDel.add(list.get(i));
            }
        }
        list.removeAll(listDel);
    }

    public NhanVien searchName(String ten) {
        for (NhanVien nhanVien : list) {
            if (nhanVien.getTen().equals(ten)) {
                return nhanVien;
            }
        }
        return null;
    }
}
