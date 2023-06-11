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
public class Course {

    private int courseID;
    private String image;
    private String courseName;
    private String overview;
    private String description;
    private Date createDate;
    private Lecture author;
    private Category category;
    private boolean status;

    public Course() {
    }

    public Course(String image, String courseName, String overview, String description, Date createDate, Lecture author, Category category, boolean status) {
        this.image = image;
        this.courseName = courseName;
        this.overview = overview;
        this.description = description;
        this.createDate = createDate;
        this.author = author;
        this.category = category;
        this.status = status;
    }

    public Course(String image, String courseName, String overview, String description, Category category, int courseID) {
        this.image = image;
        this.courseName = courseName;
        this.overview = overview;
        this.description = description;
        this.category = category;
        this.courseID = courseID;
    }

    public Course(int courseID, String image, String courseName, String overview, String description, Date createDate, boolean status) {
        this.courseID = courseID;
        this.image = image;
        this.courseName = courseName;
        this.overview = overview;
        this.description = description;
        this.createDate = createDate;
        this.status = status;
    }

    public Course(int courseID, String image, String courseName, String overview, String description, Date createDate, Lecture author, Category category, boolean status) {
        this.courseID = courseID;
        this.image = image;
        this.courseName = courseName;
        this.overview = overview;
        this.description = description;
        this.createDate = createDate;
        this.author = author;
        this.category = category;
        this.status = status;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Lecture getAuthor() {
        return author;
    }

    public void setAuthor(Lecture author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Course{" + "courseID=" + courseID + ", image=" + image + ", courseName=" + courseName + ", overview=" + overview + ", description=" + description + ", createDate=" + createDate + ", author=" + author + ", category=" + category + ", status=" + status + '}';
    }

}
