/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import util.FileHelper;

/**
 *
 * @author ADMIN
 */
public class QLSinhVien {

    private ArrayList<SinhVien> dsSinhVien;

    public QLSinhVien() {
        dsSinhVien = new ArrayList<>();
    }

    public QLSinhVien(ArrayList<SinhVien> dsSinhVien) {
        this.dsSinhVien = dsSinhVien;
    }

    public ArrayList<SinhVien> getDsSinhVien() {
        return dsSinhVien;
    }

    public void setDsSinhVien(ArrayList<SinhVien> dsSinhVien) {
        this.dsSinhVien = dsSinhVien;
    }

    public void DocDanhSachSinhVien(String filename) {
        //sinh viên viết code 
        ArrayList<String> data = FileHelper.readFileText(filename); //doc file
        //đổ dữ liệu vào danh sách
        dsSinhVien.clear();
        for (String item : data) {
            String[] arr = item.split(";");
            SinhVien sv = new SinhVien();
            sv.setMaso(arr[0]);
            sv.setHoten(arr[1]);
            sv.setGioitinh(Boolean.parseBoolean(arr[2]));
            sv.setDiemTB(Double.parseDouble(arr[3]));
            dsSinhVien.add(sv);
        }
    }

    public boolean GhiDanhSachSinhVien(String filename) {
        //sinh viên viết code 
        ArrayList<String> data = new ArrayList<>();
        for (SinhVien sv : dsSinhVien) {
            String info = sv.getMaso() + ";" + sv.getHoten() + ";" + sv.isGioitinh() + ";" + sv.getDiemTB();
            data.add(info);
        }
        return FileHelper.writeFileText(filename, data);
    }

    public boolean themSV(SinhVien sv) {
        //sinh viên viết code 
        //cách 1
//        for(SinhVien item : dsSinhVien)
//        {
//           if(item.getMaso().equals(sv.getMaso()))
//           {
//              return false;
//           }
//        }
        //cách 2: (Lưu ý: phải bồ sung phương thức equals cho lớp SinhVien) 
        if (dsSinhVien.contains(sv)) {
            return false;
        }

        dsSinhVien.add(sv);
        return true;
    }

    public boolean xoaSV(String maso) {
        //sinh viên viết code
        //cách 1 
//        for (int i = 0; i < dsSinhVien.size(); i++) {
//             if(dsSinhVien.get(i).getMaso().equals(maso))
//             {
//                 dsSinhVien.remove(i);
//                 return true;
//             }
//            
//        }       
//        return false;
       
        //cách 2 (Lưu ý: phải bồ sung phương thức equals cho lớp SinhVien)         
        SinhVien sv = new SinhVien(maso);
        if (dsSinhVien.contains(sv)) {
            dsSinhVien.remove(sv);
            return true;
        }
        return false;
    }

    public void sapXepTheoHocLuc() {
        //sinh viên viết code    
        Comparator<SinhVien> cmp = (sv1, sv2) -> {
            return Double.compare(sv1.getDiemTB(), sv2.getDiemTB());
        };
        Collections.sort(dsSinhVien, cmp);
    }

}
