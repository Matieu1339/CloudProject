/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloudproject.backoffice.controller;

import com.cloudproject.backoffice.model.Administrateur;
import com.cloudproject.backoffice.service.AdministrateurService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author samko
 */
@Controller
public class Acceuil {
    
    @GetMapping("/Acceuil")
    public String AfficheAcceuil(Model model,HttpServletRequest request){
        HttpSession sess=request.getSession(false);
        if(sess.getAttribute("IdAdmin")==null){
            model.addAttribute("Administrateur",new Administrateur());
            return "index";
        } else {
            String nomAdmin=(String) sess.getAttribute("nomAdmin");
            model.addAttribute("nomAdmin",nomAdmin);
            return "Acceuil";
        }
    }
}
