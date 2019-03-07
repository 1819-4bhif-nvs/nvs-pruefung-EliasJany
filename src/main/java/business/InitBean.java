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

        List<Surname> maennlich = new ArrayList<>();
        new BufferedReader(new InputStreamReader(this.getClass()
                .getResourceAsStream("maennlich.csv"), Charset.defaultCharset()))
                .lines()
                .skip(1)
                .map(a -> new Surname(a,"Maennlich"))
                .forEach(a -> maennlich.add(a));

        List<Surname> weiblich = new ArrayList<>();
        new BufferedReader(new InputStreamReader(this.getClass()
                .getResourceAsStream("weiblich.csv"), Charset.defaultCharset()))
                .lines()
                .skip(1)
                .map(a -> new Surname(a,"Weiblich"))
                .forEach(a -> weiblich.add(a));

        for (Surname s:maennlich) {
            System.out.println(s.ID+" "+s.Firstname+" "+s.Gender);
            //em.persist(s);
        }

        for (Surname s:weiblich) {
            System.out.println(s.ID+" "+s.Firstname+" "+s.Gender);
            //em.persist(s);
        }
    }
}
