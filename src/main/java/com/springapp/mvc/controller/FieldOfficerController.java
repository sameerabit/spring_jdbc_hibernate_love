package com.springapp.mvc.controller;


import com.springapp.mvc.entity.FieldOfficer;
import com.springapp.mvc.repository.BranchRepository;
import com.springapp.mvc.repository.FieldOfficerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ssvh on 3/4/16.
 */

@Controller
public class FieldOfficerController {

    @Autowired
    FieldOfficerRepository fieldOfficerRepository;

    @Autowired
    BranchRepository branchRepository;

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @RequestMapping(value = "/fieldOfficers", method = RequestMethod.GET)
    public String ListFieldOfficers(Model model)
    {
        model.addAttribute("fieldOfficer", new FieldOfficer());
        model.addAttribute("listFieldOfficer", this.fieldOfficerRepository.findAll());
        model.addAttribute("listBranch",this.branchRepository.findAll());
        return "fieldOfficer";
    }

    @RequestMapping(value= "/fieldOfficer/add", method = RequestMethod.POST)
    public String addFieldOfficer(@ModelAttribute("fieldOfficer") FieldOfficer officer){
        if(officer.getId() == 0){
            //new fieldOfficer, add it
            this.fieldOfficerRepository.save(officer);
        }else{
            //existing fieldOfficer, call update
            this.fieldOfficerRepository.save(officer);
        }

        return "redirect:/fieldOfficers";

    }

    @RequestMapping("/fieldOfficer/remove/{id}")
    public String removeFieldOfficer(@PathVariable("id") long id){

        this.fieldOfficerRepository.delete(id);
        return "redirect:/fieldOfficers";
    }

    @RequestMapping("/fieldOfficer/edit/{id}")
    public String editFieldOfficer(@PathVariable("id") long id, Model model){
        model.addAttribute("fieldOfficer", this.fieldOfficerRepository.getOne(id));
        model.addAttribute("listFieldOfficer", this.fieldOfficerRepository.findAll());
        model.addAttribute("listBranch",this.branchRepository.findAll());
        return "fieldOfficer";
    }


}
