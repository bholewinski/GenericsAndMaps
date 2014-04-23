package LabsFor423;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Ben Holewinski
 */
public class Lab423part5 {
    public static void main(String[] args) {
        
        HashMap<String, Employee> emp = new HashMap();
        
        emp.put("123-45-6789", new Employee("Solverson", "Molly", "123-45-6789"));
        emp.put("123-45-6789", new Employee("Malvo", "Lorne", "123-45-6789"));
        emp.put("369-85-2147", new Employee("Nygaard", "Lester", "369-85-2147"));
        emp.put("741-25-8963", new Employee("Grimly", "Gus", "741-25-8963"));
        
        System.out.println(emp.get("123-45-6789"));
        
        for(int i = 0; i < emp.size(); i++) {
            System.out.println("Hash Map Key: " + emp.getKey(i));
            System.out.println("This Employee is at Index: " 
                    + employee.indexOf(i));
            
            if(employee.get(i).equals(employee2)) {
                System.out.println("The second employee is in the list.");
            }
            
        }
    }
}
