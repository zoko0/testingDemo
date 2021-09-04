package pl.bc.tdfTestingDemo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.bc.tdfTestingDemo.model.CarEntity;

@Service
@AllArgsConstructor
public class CarManager {

  private final CarRepository carRepository;

  public void register(CarEntity car) {

    carRepository.save(car);
  }
}
