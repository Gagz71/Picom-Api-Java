package fr.hb.businesscase.nomanhsland.PicomApi.business;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
public class Admin extends User {
    public Admin() {
    }

    public Admin(String email, String password, String lastname, String firstname) {
        super(email, password, lastname, firstname);
    }
}