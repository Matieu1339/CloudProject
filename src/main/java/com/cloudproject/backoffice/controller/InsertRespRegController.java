package com.cloudproject.backoffice.controller;

import com.cloudproject.backoffice.model.Administrateur;
import com.cloudproject.backoffice.model.ResponsableRegion;
import com.cloudproject.backoffice.service.RegionService;
import com.cloudproject.backoffice.service.ResponsableRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class InsertRespRegController {

    private ResponsableRegionService responsableRegionService;
    private RegionService regionService;

    @Autowired
    public void setResponsableRegionService(ResponsableRegionService responsableRegionService) {
        this.responsableRegionService = responsableRegionService;
    }

    @Autowired
    public void setRegionService(RegionService regionService) {
        this.regionService = regionService;
    }

    @RequestMapping(value = "/insertResp", method = RequestMethod.POST)
    public String insertResp(@ModelAttribute("ResponsableRegion") @Validated ResponsableRegion responsableRegion,
            BindingResult bindingResult, Model model, HttpServletRequest request) {
        HttpSession sess=request.getSession(false);
        if(sess.getAttribute("IdAdmin")==null){
            model.addAttribute("Administrateur",new Administrateur());
            return "index";
        } else {
            if (bindingResult.hasErrors()) {
                String nomAdmin = (String) sess.getAttribute("nomAdmin");

                model.addAttribute("nomAdmin", nomAdmin);
                model.addAttribute("ResponsableRegion", responsableRegion);
                model.addAttribute("ListRegion", regionService.getRegion());
                return "FormRespRegion";
            } else {
                responsableRegionService.insertResp(Integer.parseInt(request.getParameter("idRegion")), request.getParameter("Nom"), request.getParameter("Prenom"), request.getParameter("Email"), request.getParameter("MotDePasse"));

                String nomAdmin = (String) sess.getAttribute("nomAdmin");

                model.addAttribute("nomAdmin", nomAdmin);
                model.addAttribute("ResponsableRegion", responsableRegion);
                model.addAttribute("ListRegion", regionService.getRegion());
                model.addAttribute("success", "insertion reussie");
                return "FormRespRegion";
            }
        }

    }

}
