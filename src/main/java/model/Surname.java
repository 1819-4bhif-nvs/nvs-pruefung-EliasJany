package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Surname {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int ID;

    public String Gender;
    public String Firstname;

    public Surname(String firstname, String gender) {
        Gender = gender;
        Firstname = firstname;
    }

    public int getID() {
        return ID;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }
}
