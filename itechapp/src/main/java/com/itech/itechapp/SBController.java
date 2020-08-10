package com.itech.itechapp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SBController {
    @RequestMapping(value="/test-json")
    public Map testJson()
    {
        Map<String,Object> map=new HashMap<>();
        map.put("name","Sweta");
        map.put("city","Thanjavur");
        map.put("workplace","Chennai");
        map.put("pincode",610001);
        return map;
    }
    @RequestMapping(value="/Sweta")
    public Person getSweta()
    {
        Address address=new Address();
        address.city="Thanjavur";
        address.state="Tamil Nadu";
        address.pincode=610001;
        List<String> languages =new ArrayList<>();
        languages.add("Tamil");
        languages.add("English");
        languages.add("Korean");
        Person person=new Person();
        person.id=1;
        person.name="Sweta";
        person.address=address;
        person.languages=languages;
        return person;

    }



}
