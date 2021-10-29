package productiveparameter.Kyselypalvelu_ilmanRESTia.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface KysymysRepo extends CrudRepository<Kysymys, Long> {

    List<Kysymys> findByid(int id);
    List<Kysymys> findByKysely(Optional<Kysely> kysely);
  
    
}
