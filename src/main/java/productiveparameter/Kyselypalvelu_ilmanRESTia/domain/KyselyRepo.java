package productiveparameter.Kyselypalvelu_ilmanRESTia.domain;
import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface KyselyRepo extends CrudRepository<Kysely, Long>  {

    List<Kysely> findBynimi(String nimi);
 
    
}