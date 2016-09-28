package com.springapp.mvc.controller;


import com.springapp.mvc.entity.Expenses;
import com.springapp.mvc.repository.BranchRepository;
import com.springapp.mvc.repository.ExpenseRepository;
import com.springapp.mvc.repository.ExpenseRepository;
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
public class ExpensesController {

    @Autowired
    ExpenseRepository expenseRepository;
    
    @Autowired
    BranchRepository branchRepository;

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @RequestMapping(value = "/expenses", method = RequestMethod.GET)
    public String ListExpenses(Model model)
    {
        model.addAttribute("expense", new Expenses());
        model.addAttribute("listExpense", this.expenseRepository.findAll());
        model.addAttribute("listBranch",this.branchRepository.findAll());
        return "expense";
    }

    @RequestMapping(value= "/expense/add", method = RequestMethod.POST)
    public String addExpense(@ModelAttribute("expense") Expenses expense){
        if(expense.getId() == 0){
            //new expense, add it
            this.expenseRepository.save(expense);
        }else{
            //existing expense, call update
            this.expenseRepository.save(expense);
        }

        return "redirect:/expenses";

    }

    @RequestMapping("/expense/remove/{id}")
    public String removeExpense(@PathVariable("id") int id){

        this.expenseRepository.delete(id);
        return "redirect:/expenses";
    }

    @RequestMapping("/expense/edit/{id}")
    public String editExpense(@PathVariable("id") int id, Model model){
        model.addAttribute("expense", this.expenseRepository.getOne(id));
        model.addAttribute("listExpense", this.expenseRepository.findAll());
        model.addAttribute("listBranch",this.branchRepository.findAll());
        return "expense";
    }


}
