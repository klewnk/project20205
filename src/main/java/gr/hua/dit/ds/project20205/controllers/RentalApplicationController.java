package gr.hua.dit.ds.project20205.controllers;

import gr.hua.dit.ds.project20205.entities.RentalApplication;
import gr.hua.dit.ds.project20205.service.RentalApplicationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class RentalApplicationController {

    private final RentalApplicationService rentalApplicationService;

    public RentalApplicationController(RentalApplicationService rentalApplicationService) {
        this.rentalApplicationService = rentalApplicationService;
    }

    @GetMapping("/applications")
    public String viewApplications(Model model) {
        List<RentalApplication> applications = rentalApplicationService.getAllApplications();
        model.addAttribute("applications", applications);
        return "applications"; // Το όνομα του HTML αρχείου
    }

    @PostMapping("/applications/delete")
    public String deleteApplication(@RequestParam Long id) {
        rentalApplicationService.deleteApplication(id);
        return "redirect:/applications";
    }
}
