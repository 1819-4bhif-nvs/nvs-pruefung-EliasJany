package model;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "Surname.getAll", query = "select s FROM Surname s"),
        @NamedQuery(name = "Surname.findById",query = "select s from Surname s where s.Id=:ID")
})
public class Surname {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int ID;

    @Column
    public Gender Gender;
    @Column
    public String Firstname;

    public Surname(String firstname, Gender gender) {
        Gender = gender;
        Firstname = firstname;
    }

    public int getID() {
        return ID;
    }

    public Gender getGender() {
        return Gender;
    }

    public void setGender(Gender gender) {
        Gender = gender;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }
}
