package productiveparameter.Kyselypalvelu.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
// @CrossOrigin("https://https://kyselypalvelu-ppfront.herokuapp.com/")
// kommentoin nää toistaseks pois kun muuten ei voi laittaa pyyntöjä kotoa (vain herokusta)
public interface KysymysRepo extends CrudRepository<Kysymys, Long> {

	   List<Kysymys> findByTeksti(String teksti);
	    List<Kysymys> findByKysely(Optional<Kysely> kysely);
	    
	    
	 
	  
  
    
}
