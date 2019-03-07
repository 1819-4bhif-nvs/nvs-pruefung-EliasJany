package rs;

import model.Surname;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("surname")
@Stateless
public class SurnameEndpoint {

    @PersistenceContext
    EntityManager em;

    @Path("histogramm")
    @GET
    public Response Histogramm(){
        return null;
    }

}
