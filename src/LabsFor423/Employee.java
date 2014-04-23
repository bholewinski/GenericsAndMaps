package LabsFor423;

import com.sun.org.apache.bcel.internal.util.Objects;
import org.apache.commons.lang3.builder.CompareToBuilder;


public class Employee implements Comparable {
    private String lastName;
    private String firstName;
    private String ssn;

    public Employee(String lastName, String firstName, String ssn) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.ssn = ssn;
    }
    
    

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employee other = (Employee) obj;
        if (this.ssn != other.ssn) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.ssn);
        return hash;
    }


    public int compareTo(Object other) {
        
        Employee o = (Employee)other;
        
        return new CompareToBuilder()
               .append(this.ssn, o.ssn)
               .toComparison();
//        // NO Magic numbers! Use constants for readability!
//        final int BEFORE = -1;
//	final int EQUAL = 0;
//	final int AFTER = 1;
//
//        Employee e = (Employee)other;
//
//        if(this.equals(e)) return EQUAL;
////
////        if(this.empID > e.empID) return BEFORE;
////        if(this.empID < e.empID) return AFTER;
//
//        // The String class already has a compareTo implementation, so
//        // just use that.
//        int comparison = this.ssn.compareTo(e.getSsn());
//        if( comparison != EQUAL) return comparison;
//
//        return EQUAL; // default
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String value) throws IllegalArgumentException {
            if(value == null || value.length() == 0) {
                    throw new IllegalArgumentException("value cannot be null or zero length");
            }
            firstName = value;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Employee{" + "lastName=" + lastName + ", firstName=" + firstName + ", ssn=" + ssn + '}';
    }

}
