package com.springapp.mvc.controller;

import com.springapp.mvc.entity.Branch;
import com.springapp.mvc.repository.BranchRepository;
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
public class BranchController {

    @Autowired
    private BranchRepository branchRepository ;

    @RequestMapping(value = "/branches", method = RequestMethod.GET)
    public String ListBranchs(Model model)
    {
        model.addAttribute("branch", new Branch());
        model.addAttribute("listBranch", this.branchRepository.findAll());
        return "branch";
    }

    @RequestMapping(value= "/branch/add", method = RequestMethod.POST)
    public String addBranch(@ModelAttribute("branch") Branch branch){

        if(branch.getId() == 0){
            //new branch, add it
            this.branchRepository.save(branch);
        }else{
            //existing branch, call update
            this.branchRepository.save(branch);
        }

        return "redirect:/branches";

    }

    @RequestMapping("/branch/remove/{id}")
    public String removeBranch(@PathVariable("id") int id){
        this.branchRepository.delete(id);
        return "redirect:/branches";
    }

    @RequestMapping("/branch/edit/{id}")
    public String editBranch(@PathVariable("id") int id, Model model){
   //     model.addAttribute("branch", this.branchRepository.getBranch(id));
     //   model.addAttribute("listBranch", this.branchRepository.listBranch());
        return "branch";
    }
}
