package com.telemedweb.telemedweb;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TelemedController {

    public TelemedController () {
        patientList.add (new Patient ("Matija", "Pavišić", "0911234567", "1234", "123456789", "matija@gmail.com"));
        patientList.add (new Patient ("Karlo", "Magdić", "0911234567", "1234", "123456789", "karlo@gmail.com"));
        patientList.add (new Patient ("Mirko", "Božić", "0911234567", "1234", "123456789", "mirko@gmail.com"));
    }
    List<Patient> patientList = new ArrayList<> ();

    @GetMapping("/addPatient")
    public String addPatient (String fname, String lname,  String phone, String email, String password, String mbo, Model model) {
        Patient newPatient = new Patient (fname, lname, phone, email, password, mbo);
        patientList.add (newPatient);
        return "redirect:/listPatients";

    }

    @GetMapping("/listPatients")
    public String listPatients (Model model) {
        model.addAttribute (patientList);
        return "doctordashboard.html";
    }

    @GetMapping("/redirectToForm")
    public String redirectPatients (Model model) {
        model.addAttribute (patientList);
        return "doctorcreatepatient.html";

    }

    @GetMapping("/redirectToPatient")
    public String redirectToPatient (Model model) {
        model.addAttribute (patientList);
        return "doctorcheckrecords.html"; /*kako napraviti da se otvori pacijent na kojeg se klikne a ne uvijek isti*/
    }
}