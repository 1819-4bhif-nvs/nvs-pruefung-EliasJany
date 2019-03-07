package rs;

import model.Surname;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("surname")
@Stateless
public class SurnameEndpoint {

    @PersistenceContext
    EntityManager em;

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
