package kpn.cms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kpn.cms.models.CMSUser;
import kpn.cms.repositories.UserRepository;

@RestController
public class WebController {
    @Autowired
    UserRepository repository;
     
    @RequestMapping("/save")
    public String process(){
        repository.save(new CMSUser("Jack", "Smith"));
        repository.save(new CMSUser("Adam", "Johnson"));
        repository.save(new CMSUser("Kim", "Smith"));
        repository.save(new CMSUser("David", "Williams"));
        repository.save(new CMSUser("Peter", "Davis"));
        return "Done";
    }
     
     
    @RequestMapping("/findall")
    public String findAll(){
        String result = "<html>";
         
        for(CMSUser cust : repository.findAll()){
            result += "div>" + cust.toString() + "</div>";
        }
         
        return result + "</html>";
    }
     
    @RequestMapping("/findbyid")
    public String findById(@RequestParam("id") long id){
        String result = "";
        result = repository.findOne(id).toString();
        return result;
    }
     
    @RequestMapping("/findbylastname")
    public String fetchDataByLastName(@RequestParam("lastname") String lastName){
        String result = "<html>";
         
        for(CMSUser cust: repository.findByLastName(lastName)){
            result += "<div>" + cust.toString() + "</div>"; 
        }
         
        return result + "</html>";
    }
}