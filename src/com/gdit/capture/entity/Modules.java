package com.gdit.capture.entity;
// Generated 27/10/2010 06:02:39 � by Hibernate Tools 3.2.0.beta7


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Modules generated by hbm2java
 */
public class Modules  implements java.io.Serializable {

    // Fields    

     private int id;
     private String name;
     private String notes;
     private Set modulesRoleses = new HashSet(0);

     // Constructors

    /** default constructor */
    public Modules() {
    }

	/** minimal constructor */
    public Modules(int id, String name) {
        this.id = id;
        this.name = name;
    }
    /** full constructor */
    public Modules(int id, String name, String notes, Set modulesRoleses) {
       this.id = id;
       this.name = name;
       this.notes = notes;
       this.modulesRoleses = modulesRoleses;
    }
   
    // Property accessors
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getNotes() {
        return this.notes;
    }
    
    public void setNotes(String notes) {
        this.notes = notes;
    }
    public Set getModulesRoleses() {
        return this.modulesRoleses;
    }
    
    public void setModulesRoleses(Set modulesRoleses) {
        this.modulesRoleses = modulesRoleses;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Modules other = (Modules) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.id;
        return hash;
    }

    @Override
    public String toString() {
        return name;
    }

    


}


