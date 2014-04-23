package simple.maps;

import LabsFor423.Employee;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * This class is the same as Example1 except it uses Generics, so no casting
 * is required.
 *
 * @author jlombardo
 */
public class Example3 {
    public static void main(String[] args) {
        
        Employee e1 = new Employee(1,"Doe", "John", "333-33-3333");
        Employee e2 = new Employee(2,"Smith", "Sally", "111-11-1111");
        Employee e3 = new Employee(3,"Jones","Bob", "444-44-4444");
        Employee e4 = new Employee(4,"Clinton","Bill", "666-66-6666");
                
        Map<String,Employee> acmeChemicalEmployees = new HashMap<String,Employee>(); // edit this!
        acmeChemicalEmployees.put("333-33-3333", e1);
        acmeChemicalEmployees.put("111-11-1111", e2);
                
        Map<String,Employee> thriftyGarageEmployees = new HashMap<String,Employee>(); // edit this!
        thriftyGarageEmployees.put("444-44-4444", e3);
        thriftyGarageEmployees.put("666-66-6666", e4);
        
        List<Map> companies = new ArrayList<Map>();
        companies.add(acmeChemicalEmployees);
        companies.add(thriftyGarageEmployees);
        
        Map<String,Map> companiesMap = new HashMap<String,Map>();
        companiesMap.put("acme chemical", acmeChemicalEmployees);
        companiesMap.put("thrifty garage", thriftyGarageEmployees);
        Map<String,Employee> thriftyEmployees = companiesMap.get("thrifty garage");
    }
}
