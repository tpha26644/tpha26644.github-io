/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;

/**
 *
 * @author Linh
 */
public class Admin {

    private int adminID;
    private String fullname;
    private String image;
    private boolean gender;
    private Date dob;
    private String address;
    private String email; //nho check email nha
    private String phone;
    private int accountID;

    public Admin() {
    }

    public Admin(int adminID, String fullname, String image, boolean gender, Date dob, String address, String email, String phone, int accountID) {
        this.adminID = adminID;
        this.fullname = fullname;
        this.image = image;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.accountID = accountID;
    }

  public Admin(int adminID, String fullname, boolean gender, Date dob, String address, String email, String phone) {
    this.adminID = adminID;
    this.fullname = fullname;
    this.gender = gender;
    this.dob = dob;
    this.address = address;
    this.email = email;
    this.phone = phone;
  }

    public Admin(int adminID, String fullname, String image, Date dob, String address, String email, String phone) {
        this.adminID = adminID;
        this.fullname = fullname;
        this.image = image;
        this.dob = dob;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }
    
    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Admin{" + "adminID=" + adminID + ", fullname=" + fullname + ", image=" + image + ", gender=" + gender + ", dob=" + dob + ", address=" + address + ", email=" + email + ", phone=" + phone + ", accountID=" + accountID + '}';
    }

}
