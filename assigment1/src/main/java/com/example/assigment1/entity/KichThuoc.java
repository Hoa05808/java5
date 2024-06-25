package com.example.assigment1.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class KichThuoc {
    private String id;
    private String ma;
    private String  ten;
    private boolean trangThai;
}
