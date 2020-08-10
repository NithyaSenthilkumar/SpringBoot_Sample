package com.itech.itechapp;


import com.itech.itechapp.model.Employee;
import com.itech.itechapp.model.Role;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class EmpController {
    List<Employee> el =new ArrayList();
    @RequestMapping(value = "/employee/all")
    List<Employee> getEmployees() {
        Employee e1 = new Employee();
        e1.setId(1);
        e1.setName("VM");
        Role r = new Role();
        r.setDesignation("SE");
        r.setDept("EEE");
        e1.setRole(r);
        Employee e2 = new Employee();
        e2.setId(2);
        e2.setName("Aparna");
        Role r1 = new Role();
        r1.setDesignation("Senior software engineer");
        r1.setDept("ICT");
        e2.setRole(r1);
        el.add(e1);
        el.add(e2);
        return el;
    }

    @RequestMapping(value = "/employee/{id}")
    public ResponseEntity getEmployeeById(@PathVariable("id") Integer id) {
        List<Employee> el = prepareData();
        for (Employee em : el) {
            if (em.getId() == id) {
                ResponseEntity re = new ResponseEntity(em, HttpStatus.OK);
                return re;

            }
        }
        Map<String ,String> map=new HashMap<>();
        map.put("Message","Employee not found");
        ResponseEntity re=new ResponseEntity( map,HttpStatus.NOT_FOUND);
        return re;
    }

    @RequestMapping(value="/employee",method= RequestMethod.POST)
    public ResponseEntity createEmp(@RequestBody Employee emp)
    { addEmployee(emp);
        Map<String,String> map=new HashMap<>();
        map.put("Message","Employee added successfully");
        ResponseEntity re=new ResponseEntity(map,HttpStatus.OK);
        return re;
    }
    @RequestMapping(value="/employee",method=RequestMethod.PUT)
    public ResponseEntity updateEmp(@RequestBody Employee emp)
    {
                 updateMyEmp(emp);
        Map<String,String> map=new HashMap<>();
        map.put("Message","Employee updated successfully");
        ResponseEntity re=new ResponseEntity(map,HttpStatus.OK);
        return re;
    }

    private List<Employee> prepareData() {
        if(el.isEmpty()) {
            Employee e1 = new Employee();
            e1.setId(1);
            e1.setName("VM");
            Role r = new Role();
            r.setDesignation("SE");
            r.setDept("EEE");
            e1.setRole(r);
            Employee e2 = new Employee();
            e2.setId(2);
            e2.setName("Aparna");
            Role r1 = new Role();
            r1.setDesignation("Senior software engineer");
            r1.setDept("ICT");
            e2.setRole(r1);
            el.add(e1);
            el.add(e2);
        }
        return el;

    }
    private void addEmployee(Employee emp)
    {
     el.add(emp);
    }
    private void updateMyEmp(Employee ue)
    {
        List<Employee> el=prepareData();
        boolean re=false;
        Iterator<Employee> it=el.iterator();
        while(it.hasNext())
        {
        Employee ey=it.next();
        if(ey.getId()== ue.getId())
        {
            it.remove();
            re=true;
            break;
        }
    }
    if(re)
        el.add(ue);
}}