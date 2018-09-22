package site.hhsa.demo.organizations.controllers;

import groovy.lang.ObjectRange;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import site.hhsa.demo.organizations.models.Event;
import site.hhsa.demo.organizations.models.Organization;
import site.hhsa.demo.organizations.repositories.CategoryRepo;
import site.hhsa.demo.organizations.repositories.OrgRepo;
import site.hhsa.demo.users.models.User;
import site.hhsa.demo.users.repositories.UserRepo;

import java.util.Date;

@Controller
public class OrgController {
    UserRepo userDao;
    OrgRepo orgDao;
    CategoryRepo categoryDao;

    public OrgController(OrgRepo orgDao, CategoryRepo categoryDao, UserRepo userDao) {
        this.orgDao = orgDao;
        this.categoryDao = categoryDao;
        this.userDao = userDao;
    }

    @GetMapping("/orgs")
    public String OrgHome(Model model) {
        model.addAttribute("orgs", orgDao.findAll());
        return "organizations/index";
    }

    @GetMapping("/orgs/{org_name}")
    public String OrgShow(@PathVariable String org_name, Model model){
        Organization org = orgDao.findOrganizationByOrgName(org_name);
        User user = org.getUser();
        model.addAttribute("user", user);
        return "organizations/show";
    }

    @GetMapping("/orgs/{org_name}/dashboard")
    public String OrgDashboard(@PathVariable String org_name, Model model){
        Organization org = orgDao.findOrganizationByOrgName(org_name);
        User user = org.getUser();
        model.addAttribute("user", user);
        return "organizations/dashboard";
    }

    @GetMapping("/{username}/orgs/register")
    public String OrgNew(@PathVariable String username, Model model){
        User user = userDao.findByUsername(username);
//        user.setOrganization(new Organization());
        model.addAttribute("user", user);
        return "organizations/register";
    }

    @PostMapping("/{username}/orgs/register")
    public String OrgCreate(@ModelAttribute User user,@PathVariable String username, Model model){
        user.getOrganization().setUser(userDao.findByUsername(username));
        orgDao.save(user.getOrganization());
        return "redirect:/orgs/"+ user.getOrganization().getOrgName()+"/dashboard";
    }

    @GetMapping("orgs/{org_name}/events/create")
    public String orgNewEvent(@PathVariable String org_name, Model model){
        Organization myOrg = orgDao.findOrganizationByOrgName(org_name);
        model.addAttribute("myOrg", myOrg);
        model.addAttribute("newEvent", new Event());
        return "organizations/create-event";
    }

    @GetMapping("orgs/{org_name}/events")
    public String orgEvents(@PathVariable String org_name, Model model){
        Organization myOrg = orgDao.findOrganizationByOrgName(org_name);
        model.addAttribute("myOrg", myOrg);
        return "events/show";
    }

// ======== Listener for org to create event and insert into database ===== \\
//    @PostMapping("orgs/{org_name/events/create")
//    public String orgInsertEvent(@PathVariable String org_name, @ModelAttribute){
//
//        return "redirect:/organizations/dashboard";
//    }

}


