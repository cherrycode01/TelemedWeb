package com.telemedweb.telemedweb;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class DoctorPatientController {
    Users currUsers;
    List<Record> recordList = new ArrayList<> ();

    List<Record> getRecordListForUsersId (int usersId) {
        // filter todos only for that user
        List<Record> recordForUsers = new ArrayList<> ();
        for (Record record : recordList) {
            if (record.getUsers () != null)
                if (record.getUsers ().getId () == usersId)
                    recordForUsers.add (record);
        }
        return recordForUsers;
    }

    @Autowired
    UserRepositoryMem userRepository;

    @PostConstruct
    public void initData () {

        Record record1 = new Record (new Date (), 50, 50, 50, "Super");
        record1.setUsers (userRepository.getUsersById (1));
        recordList.add (record1);

        Record record2 = new Record (new Date (), 100, 100, 100, "Grozno");
        record1.setUsers (userRepository.getUsersById (2));
        recordList.add (record2);

        Record record3 = new Record (new Date (), 150, 150, 150, "Loše");
        record1.setUsers (userRepository.getUsersById (3));
        recordList.add (record3);
    }

    // PATIENT METHODS

    @GetMapping("/records")
    public String showRecords (int userId, Model model) {
        model.addAttribute (getRecordListForUsersId (userId));
        model.addAttribute ("currUser", userRepository.getUsersById (userId));
        return "patientrecord.html";
    }

    @GetMapping("/addNewRecord")
    public String addnewRecord (int userId, int sistol, int dijastol, int otkucaji, String opis, Model model) {
        Record newRecord = new Record (new Date (), sistol, dijastol, otkucaji, opis);
        newRecord.setUsers (userRepository.getUsersById (userId));
        recordList.add (newRecord);

        return "redirect:/records?userId=" + userId;

    }

    @GetMapping("/showNewRecord")
    public String shownewRecord (Model model) {
        model.addAttribute (recordList);
        return "patientinput.html";

    }


    // DOCTOR METHODS

    @GetMapping("/users")
    public String showUsers (Model model) {
        model.addAttribute (userRepository.getUsersListWhichArePatients ());
        return "doctordashboard.html";
    }

    @GetMapping("/showRecordsForPatient")
    public String showRecordsForPatient (int userId, Model model) {
        Users users = userRepository.getUsersById (userId);
        model.addAttribute (users);

        // filter records only for that patient
        model.addAttribute (getRecordListForUsersId (userId));

        return "patientrecord.html";
    }

    @GetMapping("/redirectToForm")
    public String redirectUsers () {
        return "doctorcreatepatient.html";

    }

    @GetMapping("/addPatient")
    public String addPatient (String fname, String lname, String phone, String email, String password, String mbo) {
        Users newUsers = new Users (fname, lname, phone, email, password, mbo);
        userRepository.getUsersList ().add (newUsers);
        return "redirect:/users";
    }


    // LOGIN METHODS

    @GetMapping("/login")
    public String login () {
        return "login.html";
    }

    @GetMapping("/loginProcess")
    public String login (String email, String password, Model model) {

        // find user in list
        Users users = userRepository.getUsersByEmailAndPassword (email, password);

        if (users != null) {
            System.out.println ("User found: " + users);
            currUsers = users;
            if (users.getType () == 0)
                return "redirect:/records?userId=" + users.getId ();
            else
                return "redirect:/users";
        } else {
            model.addAttribute ("userMessage", "Nepostojeći korisnik!");
            return "login.html";
        }
    }
}