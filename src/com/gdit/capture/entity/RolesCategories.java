package com.gdit.capture.entity;
// Generated 05/01/2011 04:28:00  by Hibernate Tools 3.2.0.beta7

import java.math.BigDecimal;




/**
 * RolesCategories generated by hbm2java
 */
public class RolesCategories  implements java.io.Serializable {

    // Fields    

     private RolesCategoriesId id;
     private Roles roles;
     private Category category;

     // Constructors

    /** default constructor */
    public RolesCategories() {
        id = new RolesCategoriesId();
    }

    /** full constructor */
    public RolesCategories(RolesCategoriesId id, Roles roles, Category category) {
       this.id = id;
       this.roles = roles;
       this.category = category;
    }
   
    // Property accessors
    public RolesCategoriesId getId() {
        return this.id;
    }
    
    public void setId(RolesCategoriesId id) {
        this.id = id;
    }
    public Roles getRoles() {
        return this.roles;
    }
    
    public void setRoles(Roles roles) {
        id.setRoleId(roles.getId());
        this.roles = roles;
    }
    public Category getCategory() {
        return this.category;
    }
    
    public void setCategory(Category category) {
        id.setCategoryId(category.getId());
        this.category = category;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RolesCategories other = (RolesCategories) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }




}


