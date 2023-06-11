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
public class Role {

    private int roleID;
    private String name;
    private boolean status;

    public Role() {
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Role(String name, boolean status) {
        this.name = name;
        this.status = status;
    }

    public Role(int roleID, String name, boolean status) {
        this.roleID = roleID;
        this.name = name;
        this.status = status;
    }

    public Role(int roleID) {
        this.roleID = roleID;
    }

    @Override
    public String toString() {
        return "Role{" + "roleID=" + roleID + ", name=" + name + ", status=" + status + '}';
    }

}
