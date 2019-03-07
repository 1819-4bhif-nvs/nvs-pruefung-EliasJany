package business;

import model.Surname;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;


@Startup
@Singleton
public class InitBean {

    @Inject
    EntityManager em;

    @PostConstruct
    public void init(){
        List<Surname> surnames = new ArrayList<>();

        new BufferedReader(new InputStreamReader(this.getClass()
                .getResourceAsStream("maennlich.csv"), Charset.defaultCharset()))
                .lines()
                .skip(1)
                .map(a -> new Surname(a,"Maennlich"))
                .forEach(a -> surnames.add(a));

        new BufferedReader(new InputStreamReader(this.getClass()
                .getResourceAsStream("weiblich.csv"), Charset.defaultCharset()))
                .lines()
                .skip(1)
                .map(a -> new Surname(a,"Weiblich"))
                .forEach(a -> surnames.add(a));

        for (Surname s:surnames) {
            System.out.println(s.ID+" "+s.Firstname+" "+s.Gender);
            em.persist(s);
        }
    }
}
