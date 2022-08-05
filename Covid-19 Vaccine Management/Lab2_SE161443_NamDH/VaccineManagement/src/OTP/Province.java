/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OTP;

/**
 *
 * @author Administrator
 */
public class Province {
    private String province;

    public Province(String province) {
        this.province = province;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void printProvince(){
        String msg;
        msg = String.format("||%-20.20s||", province);
        System.out.println(msg);
    }
    
}
