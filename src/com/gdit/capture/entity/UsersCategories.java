package com.gdit.capture.entity;
// Generated 05/01/2011 03:33:03   by Hibernate Tools 3.2.0.beta7



/**
 * UsersCategories generated by hbm2java
 */
public class UsersCategories  implements java.io.Serializable {

    // Fields    

     private UsersCategoriesId id;
     private Users users;
     private Category category;

     // Constructors

    /** default constructor */
    public UsersCategories() {
    }

    /** full constructor */
    public UsersCategories(UsersCategoriesId id, Users users, Category category) {
       this.id = id;
       this.users = users;
       this.category = category;
    }
   
    // Property accessors
    public UsersCategoriesId getId() {
        return this.id;
    }
    
    public void setId(UsersCategoriesId id) {
        this.id = id;
    }
    public Users getUsers() {
        return this.users;
    }
    
    public void setUsers(Users users) {
        this.users = users;
    }
    public Category getCategory() {
        return this.category;
    }
    
    public void setCategory(Category category) {
        this.category = category;
    }




}

