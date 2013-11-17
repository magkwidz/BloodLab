package pl.biomed.mkwidzinska.bloodlab;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("people")
@Stateless
@Produces(MediaType.APPLICATION_JSON)
public class People {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @GET
    public BloodResults getBloodResultsFromQuery(@QueryParam("pesel") String pesel) {
        return getBloodResultsFromPath(pesel);
    }

    @GET
    @Path("{pesel}")
    public BloodResults getBloodResultsFromPath(@PathParam("pesel") String pesel) {
       // BloodParameter p = new BloodParameter("ISO", 1300.0f, 200.0f, 400.0f);
        //BloodParameter p2 = new BloodParameter("Hemoglobine", 150.0f, 100.0f, 400.0f);
       // BloodParameter[] bloodparameters = {p,p};
       // return new BloodResults(pesel, "Jan", Arrays.asList(bloodparameters));
        return entityManager.find(BloodResults.class, pesel);
    }
    
    @PUT
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void addResult(BloodResults bloodResults) {
        entityManager.merge(bloodResults);
    }
}
