package rs;

import model.Gender;
import model.Surname;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public class SurnameEndpoint {
    @PersistenceContext
    EntityManager em;

    @Path("surname")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public String surname()
    {
        int peopleCount = 0;
        int maleCount = 0;
        int femaleCount = 0;
        List<Surname> surnames =  em.createNamedQuery("Surname.getAll", Surname.class).getResultList();

        peopleCount = surnames.size() - 1;
        for(Surname s : surnames)
        {
            if(s.Gender == Gender.Maennlich)
                maleCount++;
            else
                femaleCount++;
        }

        return "{ total_all: "+ peopleCount+", total_male: "+ maleCount +", total_female: "+ femaleCount+" }";
    }

    @Path("surname/histogramm")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response histogramm(){
        return null;
    }

    @Path("find/{id}")
    @GET
    public Surname findSurname(@PathParam(("id"))long id){
        Surname result = em.createNamedQuery("Surname.findById",Surname.class).setParameter("ID",id).getSingleResult();
        return result;
    }

    @Path("new")
    @POST
    public void newSurname(){

    }

    @Path("delete/{id}")
    @DELETE
    public void deleteSurname(@PathParam(("id"))long id){
        Surname s = em.createNamedQuery("Surname.findById",Surname.class).setParameter("ID",id).getSingleResult();
        em.remove(s);
    }

    @Path("update/{id}")
    @PUT
    public void updateSurname(){

    }
}
