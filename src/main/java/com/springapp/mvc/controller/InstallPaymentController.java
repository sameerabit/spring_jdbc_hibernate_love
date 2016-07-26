package com.springapp.mvc.controller;

import com.springapp.mvc.entity.InstallmentPayment;
import com.springapp.mvc.repository.InstallPaymentRepository;
import com.springapp.mvc.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.enterprise.inject.Model;

/**
 * Created by ssvh on 7/24/16.
 */

@Controller
public class InstallPaymentController {

    @Autowired
    LoanRepository loanRepository;

    @Autowired
    InstallPaymentRepository installPaymentRepository;

    @RequestMapping("/listPayments")
    public String listPayments(ModelMap modelMap){
        modelMap.addAttribute("installPayment",new InstallmentPayment());
        modelMap.addAttribute("loan",loanRepository.findAll());
        return "installPayment";
    }

    @RequestMapping("/payment/add")
    public String addPayments(@ModelAttribute("payment")InstallmentPayment installmentPayment){
        installPaymentRepository.save(installmentPayment);
        return "installPayment";
    }

}
