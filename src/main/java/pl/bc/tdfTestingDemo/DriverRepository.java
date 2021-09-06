package pl.bc.tdfTestingDemo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.bc.tdfTestingDemo.model.DriverEntity;

@Repository
public interface DriverRepository extends CrudRepository<DriverEntity, String> {

}
