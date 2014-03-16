package com.gdit.capture.entity;
// Generated 15/12/2010 08:54:04 � by Hibernate Tools 3.2.0.beta7

import java.util.Date;

/**
 * NsecHejraToGregorianId generated by hbm2java
 */
public class NsecHejraToGregorianId implements java.io.Serializable {

    // Fields    
    private int hejraDd;
    private int hejraMm;
    private int hejraYyyy;
    private Date gregorianDate;

    // Constructors
    /** default constructor */
    public NsecHejraToGregorianId() {
    }

    /** full constructor */
    public NsecHejraToGregorianId(int hejraDd, int hejraMm, int hejraYyyy, Date gregorianDate) {
        this.hejraDd = hejraDd;
        this.hejraMm = hejraMm;
        this.hejraYyyy = hejraYyyy;
        this.gregorianDate = gregorianDate;
    }

    // Property accessors
    public int getHejraDd() {
        return this.hejraDd;
    }

    public void setHejraDd(int hejraDd) {
        this.hejraDd = hejraDd;
    }

    public int getHejraMm() {
        return this.hejraMm;
    }

    public void setHejraMm(int hejraMm) {
        this.hejraMm = hejraMm;
    }

    public int getHejraYyyy() {
        return this.hejraYyyy;
    }

    public void setHejraYyyy(int hejraYyyy) {
        this.hejraYyyy = hejraYyyy;
    }

    public Date getGregorianDate() {
        return this.gregorianDate;
    }

    public void setGregorianDate(Date gregorianDate) {
        this.gregorianDate = gregorianDate;
    }

    public boolean equals(Object other) {
        if ((this == other)) {
            return true;
        }
        if ((other == null)) {
            return false;
        }
        if (!(other instanceof NsecHejraToGregorianId)) {
            return false;
        }
        NsecHejraToGregorianId castOther = (NsecHejraToGregorianId) other;

        return ((this.getHejraDd() == castOther.getHejraDd()))
                && ((this.getHejraMm() == castOther.getHejraMm()) )
                && ((this.getHejraYyyy() == castOther.getHejraYyyy()))
                && ((this.getGregorianDate() == castOther.getGregorianDate()) );
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + (getHejraDd() );
        result = 37 * result + (getHejraMm() );
        result = 37 * result + (getHejraYyyy() );
        result = 37 * result + (getGregorianDate() == null ? 0 : this.getGregorianDate().hashCode());
        return result;
    }
}
