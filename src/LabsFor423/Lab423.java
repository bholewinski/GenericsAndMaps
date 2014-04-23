package LabsFor423;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ben Holewinski
 */
public class Lab423 {
    public static void main(String[] args) {
        
        List employee = new ArrayList(4);
        employee.add(0,new Employee("Solverson", "Molly", "123-45-6789"));
        employee.add(1,new Employee("Malvo", "Lorne", "123-45-6789"));
        employee.add(2,new Employee("Nygaard", "Lester", "369-85-2147"));
        employee.add(3,new Employee("Grimly", "Gus", "741-25-8963"));
        
        //Printing out List Size
        System.out.println("Da size of yur Array iz: " + employee.size());
        
        //Next, retrieve the 2nd item in the list and store it in an 
        //Employee Variable.
        //Verify that a cast is necessary.
        
        //Employee employee2 = employee.get(1);
        //The Above Code Errors
        
        Employee employee2 = (Employee)employee.get(1);
        
        //Now output the toString() value of the variable to the console and 
        //verify that the information output is correct.
        
        System.out.println(employee2.toString());
        
        //Now create an old style for loop with counter variable and output 
        //all items to the console. Finally, experiment with at least two other 
        //operations on a List, not including “add” and “get”.
        
        for(int i = 0; i < employee.size(); i++) {
            System.out.println(employee.get(i).toString());
            System.out.println("This Employee is at Index: " 
                    + employee.indexOf(i));
            
            if(employee.get(i).equals(employee2)) {
                System.out.println("The second employee is in the list.");
            }
            
        }
    }
}
