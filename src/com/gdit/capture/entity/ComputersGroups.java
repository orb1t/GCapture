package com.gdit.capture.entity;
// Generated 27/10/2010 12:03:53   by Hibernate Tools 3.2.0.beta7



/**
 * ComputersGroups generated by hbm2java
 */
public class ComputersGroups  implements java.io.Serializable {

    // Fields    

     private ComputersGroupsId id;
     private Groups groups;
     private Computers computers;

     // Constructors

    /** default constructor */
    public ComputersGroups() {
        id = new ComputersGroupsId();
    }

    /** full constructor */
    public ComputersGroups(ComputersGroupsId id, Groups groups, Computers computers) {
       this.id = id;
       this.groups = groups;
       this.computers = computers;
    }
   
    // Property accessors
    public ComputersGroupsId getId() {
        return this.id;
    }
    
    public void setId(ComputersGroupsId id) {
        this.id = id;
    }
    public Groups getGroups() {
        return this.groups;
    }
    
    public void setGroups(Groups groups) {
        id.setGroupId(groups.getId());
        this.groups = groups;
    }
    public Computers getComputers() {
        return this.computers;
    }
    
    public void setComputers(Computers computers) {
        id.setComputerId(computers.getId());
        this.computers = computers;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ComputersGroups other = (ComputersGroups) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

   


}


