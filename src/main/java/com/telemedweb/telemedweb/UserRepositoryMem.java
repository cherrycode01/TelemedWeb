package com.telemedweb.telemedweb;

import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryMem {
    List<Users> usersList = new ArrayList<> ();

    public UserRepositoryMem () {

        // three patients
        usersList.add (new Users ("Matija", "Pavišić", "0911234567", "123456788", "matija@gmail.com", "test123"));
        usersList.add (new Users ("Branimir", "Golub", "0911234567", "123456788", "branimir@gmail.com", "test123"));
        usersList.add (new Users ("Dominik", "Gašpar", "0911234567", "123456788", "dominik@gmail.com", "test123"));

        // one doctor
        Users u = new Users ("Mirko", "Božić", "0911234567", "123456788", "mirko@gmail.com", "test123");
        u.setType (1);
        usersList.add (u);

    }

    public List<Users> getUsersList () {
        return usersList;
    }


    public List<Users> getUsersListWhichArePatients () {
        List<Users> usersListPat = new ArrayList<> ();

        for (Users u : usersList) {
            if (u.getType () == 0) // 0 is patient
                usersListPat.add (u);
        }

        return usersListPat;
    }

    public Users getUsersByEmailAndPassword (String email, String password) {
        Users users = null;
        for (Users u : usersList) {
            if (u.getEmail ().equals (email) &&
                    u.getPassword ().equals (password))
                users = u;

        }
        return users;
    }

    public Users getUsersById (int id) {
        Users users = null;
        for (Users u : usersList) {
            if (u.getId () == id)
                users = u;
        }
        return users;
    }
}