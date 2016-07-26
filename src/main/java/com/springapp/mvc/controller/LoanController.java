package com.springapp.mvc.controller;

import com.springapp.mvc.entity.FieldOfficer;
import com.springapp.mvc.entity.Loan;
import com.springapp.mvc.entity.TransferDetail;
import com.springapp.mvc.repository.CustomerRepository;
import com.springapp.mvc.repository.FieldOfficerRepository;
import com.springapp.mvc.repository.LoanRepository;
import com.springapp.mvc.repository.TransferDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ssvh on 7/24/16.
 */

@Controller
public class LoanController{

    @Autowired
    LoanRepository loanRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    FieldOfficerRepository fieldOfficerRepository;

    @Autowired
    TransferDetailRepository transferDetailRepository;

    @RequestMapping(value = "loan/add",method= RequestMethod.POST)
    public String addLoan(@ModelAttribute("transferDetail")TransferDetail transferDetail) {
        transferDetail.setReason("new loan added.");
        transferDetailRepository.save(transferDetail);
        return "redirect:/loans";
    }

    @RequestMapping(value = "loans",method= RequestMethod.GET)
    public String listLoans(ModelMap modelMap) {
        modelMap.addAttribute("transferDetail",new TransferDetail());
        modelMap.addAttribute("listCustomer",customerRepository.findAll());
        modelMap.addAttribute("listTransferDetail",transferDetailRepository.findAll());
        modelMap.addAttribute("listFieldOfficer",fieldOfficerRepository.findAll());
        return "loan";
    }

}
