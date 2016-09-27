package com.springapp.mvc.controller;

import com.springapp.mvc.entity.Cheque;
import com.springapp.mvc.entity.Credit;
import com.springapp.mvc.entity.InstallmentPayment;
import com.springapp.mvc.entity.Loan;
import com.springapp.mvc.repository.InstallPaymentRepository;
import com.springapp.mvc.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.enterprise.inject.Model;
import java.awt.*;
import java.util.*;
import java.util.List;

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
        modelMap.addAttribute("payment",new InstallmentPayment());
        modelMap.addAttribute("loan",loanRepository.findAll());
        return "installPayment";
    }

    @RequestMapping("/payment/{id}")
    public String payment(@PathVariable("id") int id,ModelMap modelMap){
        InstallmentPayment installmentPayment = new InstallmentPayment();
        Loan loan =loanRepository.getOne(id);
        installmentPayment.setLoan(loan);
        modelMap.addAttribute("payment",installmentPayment);
        return "installPayment";
    }


    @RequestMapping("/payment/add")
    public String addPayments(@ModelAttribute("payment")InstallmentPayment installmentPayment){
        List<Credit> creditData = installmentPayment.getCredit();
        int size =creditData.size();
        if(size>0){
            for (int i=0;i<size;i++){
                Credit credit = creditData.get(i);
                if(credit!=null){
                    credit.setInstallmentPayment(installmentPayment);
                    creditData.set(i,credit);
                }
            }
            installmentPayment.setCredit(creditData);
        }

        List<Cheque> chequeData = installmentPayment.getCheque();
        int chequeSize =chequeData.size();
        if(size>0){
            for (int i=0;i<chequeSize;i++){
                Cheque cheque = chequeData.get(i);
                if(cheque!=null){
                    cheque.setInstallmentPayment(installmentPayment);
                    chequeData.set(i,cheque);
                }
            }
            installmentPayment.setCheque(chequeData);
        }

        installPaymentRepository.save(installmentPayment);
        return "installPayment";
    }

}
