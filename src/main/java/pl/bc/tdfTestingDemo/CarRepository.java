package pl.bc.tdfTestingDemo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.bc.tdfTestingDemo.model.CarEntity;

@Repository
interface CarRepository extends CrudRepository<CarEntity, String> {

}
