/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Linh
 */
public class Account {

    private int accountID;
    private String username;
    private String password; //password co 8 ki tu
    private boolean status;
    private int roleID;

    public Account() {
    }

        public Account(String username, String password, int roleID) {
        this.username = username;
        this.password = password;
        this.roleID = roleID;
    }

    public Account(String username, String password, boolean status, int roleID) {
        this.username = username;
        this.password = password;
        this.status = status;
        this.roleID = roleID;
    }

    public Account(int accountID, String username, String password, boolean status, int roleID) {
        this.accountID = accountID;
        this.username = username;
        this.password = password;
        this.status = status;
        this.roleID = roleID;
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
        return "Account{" + "accountID=" + accountID + ", username=" + username + ", password=" + password + ", status=" + status + ", roleID=" + roleID + '}';
    }

}
