package productiveparameter.Kyselypalvelu.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
// @CrossOrigin("https://kyselypalvelu-ppfront.herokuapp.com/")
// kommentoin tän toistaseks pois kun muuten ei voi laittaa pyyntöjä kotoa (vain herokusta) - sampsa
public interface KyselyRepo extends CrudRepository<Kysely, Long>  {

    List<Kysely> findByNimi(String nimi);
 
    
}
