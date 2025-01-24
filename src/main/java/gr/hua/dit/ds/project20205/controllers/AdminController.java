package gr.hua.dit.ds.project20205.controllers;
import gr.hua.dit.ds.project20205.service.UserService;
import gr.hua.dit.ds.project20205.entities.Property;
import gr.hua.dit.ds.project20205.service.PropertyService;
import gr.hua.dit.ds.project20205.service.RentalApplicationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final PropertyService propertyService;
    private final RentalApplicationService rentalApplicationService;
    public AdminController(PropertyService propertyService, RentalApplicationService rentalApplicationService, UserService userService) {
        this.propertyService = propertyService;
        this.rentalApplicationService = rentalApplicationService;

    }

    // Πίνακας επιλογών του Admin
    @GetMapping("/dashboard")
    public String adminDashboard() {
        return "admin/admin-dashboard"; // Συνδέεται με το admin-dashboard.html
    }
    @GetMapping("/admin-dashboard")
    public String redirectToAdminDashboard() {
        return "redirect:/admin/dashboard";
    }
    @GetMapping("/pending-properties")
    public String viewPendingProperties(Model model) {
        System.out.println("Fetching pending properties...");
        model.addAttribute("pendingProperties", propertyService.getPropertiesByStatus(Property.Status.PENDING));
        return "admin/pending-properties"; // Συνδέεται με το pending-properties.html
    }

    // Έγκριση ακινήτου
    @PostMapping("/approve/{id}")
    public String approveProperty(@PathVariable Long id) {
        propertyService.updatePropertyStatus(id, Property.Status.APPROVED);
        return "redirect:/admin/pending-properties";
    }

    // Απόρριψη ακινήτου
    @PostMapping("/reject/{id}")
    public String rejectProperty(@PathVariable Long id) {
        propertyService.updatePropertyStatus(id, Property.Status.REJECTED);
        return "redirect:/admin/pending-properties";
    }

    // Διαχείριση εγκεκριμένων ακινήτων
    @GetMapping("/manage-properties")
    public String manageProperties(Model model) {
        model.addAttribute("properties", propertyService.getAllProperties());
        return "admin/manage-properties"; // Συνδέεται με το manage-properties.html
    }

}


