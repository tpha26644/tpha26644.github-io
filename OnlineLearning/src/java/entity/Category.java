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
public class Category {

    private int CategoryID;
    private String categoryName;
    private boolean status;

    public Category() {
    }

    public Category(String categoryName, boolean status) {
        this.categoryName = categoryName;
        this.status = status;
    }

    public Category(int CategoryID, String categoryName, boolean status) {
        this.CategoryID = CategoryID;
        this.categoryName = categoryName;
        this.status = status;
    }

    public int getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(int CategoryID) {
        this.CategoryID = CategoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Category{" + "CategoryID=" + CategoryID + ", categoryName=" + categoryName + ", status=" + status + '}';
    }

}
