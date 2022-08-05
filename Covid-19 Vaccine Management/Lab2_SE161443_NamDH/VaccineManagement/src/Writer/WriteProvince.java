/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Writer;


import OTP.Province;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class WriteProvince {
    public static void main(String[] args) {
        ArrayList<Province> list = new ArrayList<>();
        try {
            String provinceFile = "Province.txt";
            
            FileWriter fw = new FileWriter(provinceFile);
            PrintWriter pw = new PrintWriter(fw);
            list.add(new Province("An Giang"));
            list.add(new Province("Ba Ria Vung Tau")); 
            list.add(new Province("Bac Giang"));
            list.add(new Province("Bac Kan"));
            list.add(new Province("Bac Lieu")); 
            list.add(new Province("Bac Ninh"));
            list.add(new Province("Ben Tre"));
            list.add(new Province("Binh Dinh"));
            list.add(new Province("Binh Duong"));
            list.add(new Province("Binh Phuoc"));
            list.add(new Province("Binh Thuan"));
            list.add(new Province("Ca Mau"));
            list.add(new Province("Can Tho"));
            list.add(new Province("Cao Bang"));
            list.add(new Province("Da Nang"));
            list.add(new Province("Dak Lak"));
            list.add(new Province("Dak Nong"));
            list.add(new Province("Dien Bien"));
            list.add(new Province("Dong Nai"));
            list.add(new Province("Dong Thap"));
            list.add(new Province("Gia Lai"));
            list.add(new Province("Ha Giang"));
            list.add(new Province("Ha Nam"));
            list.add(new Province("Ha Noi"));
            list.add(new Province("Ha Tinh"));
            list.add(new Province("Hai Duong"));
            list.add(new Province("Hai Phong"));
            list.add(new Province("Hau Giang"));
            list.add(new Province("Hoa Binh"));
            list.add(new Province("Hung Yen"));
            list.add(new Province("Khanh Hoa"));
            list.add(new Province("Kien Giang"));
            list.add(new Province("Kon Tum"));
            list.add(new Province("Lai Chau"));
            list.add(new Province("Lam Dong"));
            list.add(new Province("Lang Son"));
            list.add(new Province("Lao Cai"));
            list.add(new Province("Long An"));
            list.add(new Province("Nam Dinh"));
            list.add(new Province("Nghe An"));
            list.add(new Province("Ninh Binh"));
            list.add(new Province("Ninh Thuan"));
            list.add(new Province("Phu Tho"));
            list.add(new Province("Phu Yen"));
            list.add(new Province("Quang Binh"));
            list.add(new Province("Quang Nam"));
            list.add(new Province("Quang Ngai"));
            list.add(new Province("Quang Ninh"));
            list.add(new Province("Quang Tri"));
            list.add(new Province("Soc Trang"));
            list.add(new Province("Son La"));
            list.add(new Province("Tay Ninh"));
            list.add(new Province("Thai Binh"));
            list.add(new Province("Thai Nguyen"));
            list.add(new Province("Thanh Hoa"));
            list.add(new Province("Thua Thien Hue"));
            list.add(new Province("Tien Giang"));
            list.add(new Province("TPHCM"));
            list.add(new Province("Tra Vinh"));
            list.add(new Province("Tuyen Quang"));
            list.add(new Province("Vinh Long"));
            list.add(new Province("Vinh Phuc"));
            list.add(new Province("Yen Bai"));
   
            for (Province o : list) {
                pw.println(o.getProvince());
            }
            System.out.println("Saving Successfully");
            System.out.println("\n");
          fw.close();
          pw.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}