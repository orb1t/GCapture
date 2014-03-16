package com.gdit.capture.entity;
// Generated 27/10/2010 12:03:53   by Hibernate Tools 3.2.0.beta7



/**
 * ComputersGroupsId generated by hbm2java
 */
public class ComputersGroupsId  implements java.io.Serializable {

    // Fields    

     private int computerId;
     private int groupId;

     // Constructors

    /** default constructor */
    public ComputersGroupsId() {
    }

    /** full constructor */
    public ComputersGroupsId(int computerId, int groupId) {
       this.computerId = computerId;
       this.groupId = groupId;
    }
   
    // Property accessors
    public int getComputerId() {
        return this.computerId;
    }
    
    public void setComputerId(int computerId) {
        this.computerId = computerId;
    }
    public int getGroupId() {
        return this.groupId;
    }
    
    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ComputersGroupsId) ) return false;
		 ComputersGroupsId castOther = ( ComputersGroupsId ) other; 
         
		 return (this.getComputerId()==castOther.getComputerId())
 && (this.getGroupId()==castOther.getGroupId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getComputerId();
         result = 37 * result + this.getGroupId();
         return result;
   }   


}


