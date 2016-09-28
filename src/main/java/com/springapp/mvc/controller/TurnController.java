package com.springapp.mvc.controller;


import com.springapp.mvc.entity.Turn;
import com.springapp.mvc.repository.FieldOfficerRepository;
import com.springapp.mvc.repository.TurnRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
public class TurnController {

    @Autowired
    TurnRepository turnRepository;

    @Autowired
    FieldOfficerRepository fieldOfficerRepository;

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @RequestMapping(value = "/turn", method = RequestMethod.GET)
    public String ListTurns(Model model)
    {
        model.addAttribute("turn", new Turn());
        model.addAttribute("listTurn", this.turnRepository.findAll());
        model.addAttribute("listFieldOfficer",this.fieldOfficerRepository.findAll());
        return "turn";
    }

    @RequestMapping(value= "/turn/add", method = RequestMethod.POST)
    public String addTurn(@ModelAttribute("turn") Turn officer){
        if(officer.getId() == 0){
            //new turn, add it
            this.turnRepository.save(officer);
        }else{
            //existing turn, call update
            this.turnRepository.save(officer);
        }

        return "redirect:/turn";

    }

    @RequestMapping("/turn/remove/{id}")
    public String removeTurn(@PathVariable("id") int id){

        this.turnRepository.delete(id);
        return "redirect:/turn";
    }

    @RequestMapping("/turn/edit/{id}")
    public String editTurn(@PathVariable("id") int id, Model model){
        model.addAttribute("turn", this.turnRepository.getOne(id));
        model.addAttribute("listTurn", this.turnRepository.findAll());
        model.addAttribute("listFieldOfficer",this.fieldOfficerRepository.findAll());
        return "turn";
    }


}
