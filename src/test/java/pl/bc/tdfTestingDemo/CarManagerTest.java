package pl.bc.tdfTestingDemo;

import static org.assertj.core.api.Assertions.assertThat;

import pl.bc.tdfTestingDemo.model.CarEntity;

import org.junit.Before;
import org.junit.Test;

public class CarManagerTest {

  private CarRepository carRepository;

  private CarManager carManager;

  @Before
  public void setUp() {

    carRepository = new CarTestRepository();
    carManager = new CarManager(carRepository);
  }

  @Test
  public void register_savesCar_toRepository() {

    var myCar = new CarEntity(
        "carId",
        "Toyota",
        "Auris",
        2015,
        87500,
        "description",
        10,
        "Bartek Ciulkin",
        false);

    carManager.register(myCar);

    assertThat(carRepository.count()).isEqualTo(1L);
  }
}
