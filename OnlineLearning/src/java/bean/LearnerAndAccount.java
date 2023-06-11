/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.sql.Date;

/**
 *
 * @author NHATNAM-PC
 */
public class LearnerAndAccount {

  private int learnerID;
  private String fullname;
  private String image;
  private boolean gender;
  private Date dob;
  private String address;
  private String email; //nho check email nha
  private String phone;
  private int accountID;
  private String username;
  private String password; //password co 8 ki tu
  private boolean status;
  private int roleID;

  public LearnerAndAccount() {
  }

  public LearnerAndAccount(int learnerID, String fullname, String image, boolean gender, Date dob, String address, String email, String phone, int accountID, String username, String password, boolean status, int roleID) {
    this.learnerID = learnerID;
    this.fullname = fullname;
    this.image = image;
    this.gender = gender;
    this.dob = dob;
    this.address = address;
    this.email = email;
    this.phone = phone;
    this.accountID = accountID;
    this.username = username;
    this.password = password;
    this.status = status;
    this.roleID = roleID;
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

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public boolean isStatus() {
    return status;
  }

  public String getStatus() {
    return String.valueOf(status);
  }
  
  public void setStatus(boolean status) {
    this.status = status;
  }

  public int getRoleID() {
    return roleID;
  }

  public void setRoleID(int roleID) {
    this.roleID = roleID;
  }

  @Override
  public String toString() {
    return "LearnerAndAccount{" + "learnerID=" + learnerID + ", fullname=" + fullname + ", image=" + image + ", gender=" + gender + ", dob=" + dob + ", address=" + address + ", email=" + email + ", phone=" + phone + ", accountID=" + accountID + ", username=" + username + ", password=" + password + ", status=" + status + ", roleID=" + roleID + '}';
  }
  
}
