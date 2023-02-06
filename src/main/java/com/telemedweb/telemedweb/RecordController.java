package com.telemedweb.telemedweb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class RecordController {

    List<Record> recordList = new ArrayList<> ();

    public RecordController () {
        recordList.add (new Record (1, new Date(), 50, 50, 50, "Super"));
        recordList.add (new Record (2, new Date(), 100, 100, 100, "Grozno"));
        recordList.add (new Record (3, new Date(), 150, 150, 150, "Loše"));
    }
    @GetMapping("/records")
    public String showRecord(Model model) {
        model.addAttribute(recordList);
        return "patientrecord.html";
    }
    @GetMapping("/shownewrecord")
    public String shownewRecord(Model model) {
        model.addAttribute(recordList);
        return "patientinput.html";
    }
    @GetMapping("/addnewrecord")
    public String addnewRecord(int sistol, int dijastol, int otkucaji, String opis, Model model) {
        model.addAttribute(recordList);
        Record r = new Record (0, new Date(), sistol, dijastol, otkucaji, opis);
        recordList.add(r);
        return "redirect:/records";
    }
}
