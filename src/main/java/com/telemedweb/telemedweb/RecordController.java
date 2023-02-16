package com.telemedweb.telemedweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.List;

@Controller
public class RecordController {

    User currUser;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RecordRepository recordRepository;

    // PATIENT METHODS

    @GetMapping("/records")
    public String showRecords (long userId, Model model) {
        User currUser = userRepository.findById (userId).get ();
        model.addAttribute ("currUser", currUser);
        model.addAttribute (recordRepository.findByUser (currUser));

        return "patientrecord.html";
    }

    @GetMapping("/addNewRecord")
    public String addNewRecord (long userId, int sistol, int dijastol, int otkucaji, String opis) {
        User currUser = userRepository.findById (userId).get ();
        Record newRecord = new Record (new Date (), sistol, dijastol, otkucaji, opis);
        newRecord.setUser (currUser);
        recordRepository.save (newRecord);

        return "redirect:/records?userId=" + userId;
    }

    @GetMapping("/redirectToUserForm")
    public String redirectToCreateRecord (long userId, Model model) {
        User currUser = userRepository.findById (userId).get ();
        model.addAttribute ("currUser", currUser);
        return "patientinput.html";
    }

    @GetMapping("/delete")
    public String delete (Long id) {

        Record record = recordRepository.findById (id).get ();
        recordRepository.delete (record);


        return "redirect:/records?userId=" + record.getUser ().getId ();

    }


    // DOCTOR METHODS

    @GetMapping("/users")
    public String showUsers (Model model) {
        model.addAttribute (userRepository.findByType (0));

        return "doctordashboard.html";
    }

    @GetMapping("/showRecordsForUser")
    public String showRecordsForUser (long userId, Model model) {
        User user = userRepository.findById (userId).get ();
        model.addAttribute (user);
        model.addAttribute (recordRepository.findByUser (user));

        return "doctorcheckrecords.html";
    }

    @GetMapping("/addNewUser")
    public String addNewUser (String fname, String lname, String phone, String email, String password, String mbo) {
        User newUser = new User (fname, lname, phone, email, password, mbo);
        userRepository.save (newUser);

        return "redirect:/users";
    }

    @GetMapping("/redirectToForm")
    public String redirectToCreateUser () {

        return "doctorcreatepatient.html";
    }

    @GetMapping("/deleteRecordByDoctor")
    public String deleteRecordByDoctor (Long id) {
        Record record = recordRepository.findById (id).get ();
        recordRepository.delete (record);

        return "redirect:/showRecordsForUser?userId=" + record.getUser ().getId ();
    }

    @GetMapping("/deletePatientByDoctor")
    public String deletePatientByDoctor (Long id) {
        User user = userRepository.findById (id).get ();
        userRepository.delete (user);

        return "redirect:/users";
    }

// LOGIN METHODS

    @GetMapping("/login")
    public String login () {

        return "login.html";
    }

    @GetMapping("/loginProcess")
    public String login (String email, String password, Model model) {

        User user = userRepository.findByEmailAndPassword (email, password);

        if (user != null) {
            System.out.println ("User found: " + user);
            currUser = user;
            if (user.getType () == 0)
                return "redirect:/records?userId=" + user.getId ();
            else
                return "redirect:/users";
        } else {
            model.addAttribute ("userMessage", "Nepostojeći korisnik!");
            return "login.html";
        }
    }

    // UTITILTY METHODS

    @GetMapping("/")
    public String redirectToLogin () {

        return "redirect:/login";
    }
}

