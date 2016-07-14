package com.springapp.mvc.controller;

import com.springapp.mvc.entity.Loan;
import com.springapp.mvc.entity.TransferDetail;
import com.springapp.mvc.repository.CustomerRepository;
import com.springapp.mvc.repository.FieldOfficerRepository;
import com.springapp.mvc.repository.LoanRepository;
import com.springapp.mvc.repository.TransferDetailRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by ssvh on 3/4/16.
 */

@Controller
public class LoanController {

    private LoanRepository loanService;

    private CustomerRepository customerService;

    private FieldOfficerRepository fieldOfficerService;

    private TransferDetailRepository transferDetailService;

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);


    @RequestMapping(value = "/loans", method = RequestMethod.GET)
    public String ListLoans(ModelMap model)
    {
        model.put("loan", new Loan());
        model.put("transferDetail",new TransferDetail());
        model.put("listTransferDetail", this.transferDetailService.findAll());
        model.put("listLoan", this.loanService.findAll());
        model.put("listCustomer",this.customerService.findAll());
        model.put("listFieldOfficer",this.fieldOfficerService.findAll());
        return "loan";
    }

    @RequestMapping(value= "/loan/add", method = RequestMethod.POST)
    public String addLoan(
            @ModelAttribute("transferDetail") TransferDetail transferDetail,
            @RequestParam Map<String,String> allRequestParams){
        transferDetail.setReason("ordinary method");
       // transferDetail.getLoan().setTransferDetails(transferDetails);
        //if(transferDetail.getLoan().getId() == 0){
            //new transferDetail, add it
          //  this.transferDetailService.addTransferDetail(transferDetail);
        //}else{
            //existing transferDetail, call update
         //   this.transferDetailService.addTransferDetail(transferDetail);
        //}

        return "redirect:/loans";

    }

    @RequestMapping("/loan/remove/{id}")
    public String removeLoan(@PathVariable("id") long id){

        this.loanService.delete(id);
        return "redirect:/loans";
    }

    @RequestMapping("/loan/edit/{id}")
    public String editLoan(@PathVariable("id") long id, Model model){
        model.addAttribute("loan", this.loanService.getOne(id));
        model.addAttribute("listLoan", this.loanService.findAll());
        model.addAttribute("listCustomer",this.customerService.findAll());
        model.addAttribute("listFieldOfficer",this.fieldOfficerService.findAll());
        return "loan";
    }


}
