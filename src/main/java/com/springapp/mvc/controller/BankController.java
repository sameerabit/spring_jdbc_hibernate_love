package com.springapp.mvc.controller;

import com.springapp.mvc.entity.Bank;
import com.springapp.mvc.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ssvh on 2/6/16.
 */
@Controller
public class BankController {

    @Autowired
    private BankRepository bankRepository ;

    @RequestMapping(value = "/banks", method = RequestMethod.GET)
    public String ListBanks(Model model)
    {
        model.addAttribute("bank", new Bank());
        model.addAttribute("listBank", this.bankRepository.findAll());
        return "bank";
    }

    @RequestMapping(value= "/bank/add", method = RequestMethod.POST)
    public String addBank(@ModelAttribute("bank") Bank bank, BindingResult result){

        if(bank.getId() == 0){
            //new bank, add it
            bankRepository.save(bank);
        }else{
            //existing bank, call update
            bankRepository.save(bank);
        }

        return "redirect:/banks";

    }

    @RequestMapping("/bank/remove/{id}")
    public String removeBank(@PathVariable("id") Long id){

        this.bankRepository.delete(id);
        return "redirect:/banks";
    }

    @RequestMapping("/bank/edit/{id}")
    public String editBank(@PathVariable("id") int id, Model model){
     //   model.addAttribute("bank", this.bankRepository.getBank(id));
      //  model.addAttribute("listBank", this.bankRepository.listBank());
        return "bank";
    }
}
