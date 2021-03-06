package com.gdit.capture.entity;
// Generated 05/01/2011 03:33:03  by Hibernate Tools 3.2.0.beta7


import java.math.BigDecimal;

/**
 * UsersCategoriesId generated by hbm2java
 */
public class UsersCategoriesId  implements java.io.Serializable {

    // Fields    

     private long userId;
     private BigDecimal categoryId;

     // Constructors

    /** default constructor */
    public UsersCategoriesId() {
    }

    /** full constructor */
    public UsersCategoriesId(long userId, BigDecimal categoryId) {
       this.userId = userId;
       this.categoryId = categoryId;
    }
   
    // Property accessors
    public long getUserId() {
        return this.userId;
    }
    
    public void setUserId(long userId) {
        this.userId = userId;
    }
    public BigDecimal getCategoryId() {
        return this.categoryId;
    }
    
    public void setCategoryId(BigDecimal categoryId) {
        this.categoryId = categoryId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof UsersCategoriesId) ) return false;
		 UsersCategoriesId castOther = ( UsersCategoriesId ) other; 
         
		 return (this.getUserId()==castOther.getUserId())
 && ( (this.getCategoryId()==castOther.getCategoryId()) || ( this.getCategoryId()!=null && castOther.getCategoryId()!=null && this.getCategoryId().equals(castOther.getCategoryId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + (int) this.getUserId();
         result = 37 * result + ( getCategoryId() == null ? 0 : this.getCategoryId().hashCode() );
         return result;
   }   


}


