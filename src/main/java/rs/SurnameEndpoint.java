package rs;

import model.Gender;
import model.Surname;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

public class SurnameEndpoint {
    @PersistenceContext
    EntityManager em;

    @Path("surname")
    @Produces("application/json")
    public String surname()
    {
        int peopleCount,maleCount = 0,femaleCount = 0;
        List<Surname> surnames =  em.createNamedQuery("Surname.all", Surname.class).getResultList();
        peopleCount = surnames.size() - 1;
        for(Surname s : surnames)
        {
            if(s.Gender == Gender.Maennlich)
                maleCount++;
            else
                femaleCount++;
        }
        return "{ total_all : "+ peopleCount+", total_male"+ maleCount +", total_female"+ femaleCount +"}";
    }

    @Path("histogramm")
    @GET
    public Response histogramm(){
        return null;
    }

    @Path("find/{id}")
    @GET
    public Response findSurname(){
        return null;
    }

    @Path("new")
    @POST
    public Response newSurname(){
        return null;
    }

    @Path("delete/{id}")
    @DELETE
    public Response deleteSurname(){
        return null;
    }

    @Path("update/{id}")
    @PUT
    public Response updateSurname(){
        return null;
    }
}
