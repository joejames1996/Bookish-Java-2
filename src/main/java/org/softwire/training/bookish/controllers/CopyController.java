package org.softwire.training.bookish.controllers;

import org.softwire.training.bookish.databaseModels.Booking;
import org.softwire.training.bookish.databaseModels.Copy;
import org.softwire.training.bookish.services.CopyService;
import org.softwire.training.bookish.viewModels.CopiesPageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class CopyController
{
    @Autowired
    private CopyService copyService;

    @RequestMapping("/copies")
    ModelAndView copies() {

        List<Copy> allCopies = copyService.getAllCopies();
        Copy.allCopies = allCopies;

        CopiesPageModel copiesPageModel = new CopiesPageModel();
        copiesPageModel.copies = allCopies;

        return new ModelAndView("copies", "model", copiesPageModel);
    }

    @RequestMapping("/copy/add")
    RedirectView addCopy(@ModelAttribute Copy copy) {

        copyService.addCopy(copy);

        return new RedirectView("/copies");
    }

    @RequestMapping("/copies/delete")
    RedirectView deleteCopy(@RequestParam int copyId) {

        copyService.deleteCopy(copyId);

        return new RedirectView("/copies");
    }
}

