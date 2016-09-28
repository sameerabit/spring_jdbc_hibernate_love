package com.springapp.mvc.controller;

import com.springapp.mvc.entity.*;
import com.springapp.mvc.repository.*;
import org.hibernate.Hibernate;
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

    @Autowired
    CashRepository cashRepository;

    @Autowired
    CreditRepository creditRepository;

    @Autowired
    ChequeRepository chequeRepository;

    @RequestMapping("/payment/listPayments")
    public String listPayments(ModelMap modelMap){
        modelMap.addAttribute("listInstallPayments",installPaymentRepository.findAll());
        return "paymentList";
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
        if(installmentPayment.getId()!=0){
            installPaymentRepository.save(installmentPayment);
            return "installPayment";
        }
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

        if(installmentPayment.getCash()!=null){
            Cash cash=installmentPayment.getCash();
            cash.setInstallmentPayment(installmentPayment);
        }

        installPaymentRepository.save(installmentPayment);
        return "installPayment";
    }

    @RequestMapping("/payment/edit/{id}")
    public String editPayment(@PathVariable("id") int id,ModelMap modelMap){
        InstallmentPayment installmentPayment = installPaymentRepository.findOne(id);
      //  (installmentPayment.getCash().getId())
        modelMap.addAttribute("payment",installmentPayment);
        modelMap.addAttribute("credit",installmentPayment.getCredit());
        modelMap.addAttribute("cheque",installmentPayment.getCheque());
        return "installPayment";
    }

}
