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
public class Learner {

  private int learnerID;
  private String fullname;
  private String image;
  private boolean gender;
  private Date dob;
  private String address;
  private String email; //nho check email nha
  private String phone;
  private int accountID;

  public Learner() {
  }

    public Learner(int learnerID, String fullname, String image, boolean gender, Date dob, String address, String email, String phone) {
        this.learnerID = learnerID;
        this.fullname = fullname;
        this.image = image;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

  public Learner(int learnerID, String fullname, String image, boolean gender, Date dob, String address, String email, String phone, int accountID) {
    this.learnerID = learnerID;
    this.fullname = fullname;
    this.image = image;
    this.gender = gender;
    this.dob = dob;
    this.address = address;
    this.email = email;
    this.phone = phone;
    this.accountID = accountID;
  }

  public Learner(int learnerID, String fullname, boolean gender, Date dob, String address, String email, String phone) {
    this.learnerID = learnerID;
    this.fullname = fullname;
    this.gender = gender;
    this.dob = dob;
    this.address = address;
    this.email = email;
    this.phone = phone;
  }

  public Learner(int learnerID, String fullname, String image, Date dob, String address, String email, String phone) {
    this.learnerID = learnerID;
    this.fullname = fullname;
    this.image = image;
    this.dob = dob;
    this.address = address;
    this.email = email;
    this.phone = phone;
  }

  public Learner(String fullname, String email, String phone, int accountID) {
    this.fullname = fullname;
    this.email = email;
    this.phone = phone;
    this.accountID = accountID;
  }

  public int getLearnerID() {
    return learnerID;
  }

  public void setLearnerID(int learnerID) {
    this.learnerID = learnerID;
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

  public int getAccountID() {
    return accountID;
  }

  public void setAccountID(int accountID) {
    this.accountID = accountID;
  }

  @Override
  public String toString() {
    return "Learner{" + "learnerID=" + learnerID + ", fullname=" + fullname + ", image=" + image + ", gender=" + gender + ", dob=" + dob + ", address=" + address + ", email=" + email + ", phone=" + phone + ", accountID=" + accountID + '}';
  }

}
