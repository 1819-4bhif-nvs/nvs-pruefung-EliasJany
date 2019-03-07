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


@Startup
@Singleton
public class InitBean {

    @Inject
    EntityManager em;

    @PostConstruct
    public void init(){

        new BufferedReader(new InputStreamReader(this.getClass()
                .getResourceAsStream("maennlich.csv"), Charset.defaultCharset()))
                .lines()
                .skip(1)
                .map(a -> new Surname(a,"Maennlich"))
                .forEach(em::persist);

        new BufferedReader(new InputStreamReader(this.getClass()
                .getResourceAsStream("weiblich.csv"), Charset.defaultCharset()))
                .lines()
                .skip(1)
                .map(a -> new Surname(a,"Weiblich"))
                .forEach(em::persist);
    }
}
