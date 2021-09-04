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

    var myCar = CarEntity.builder()
        .carId("carId")
        .brand("Toyota")
        .model("Auris")
        .description("description")
        .isElectric(false)
        .trunkCapacity(10)
        .milesTravelled(87500)
        .driver("Bartek Ciulkin")
        .year(2015)
        .build();

    carManager.register(myCar);

    assertThat(carRepository.count()).isEqualTo(1L);
  }

  @Test
  public void register_shouldNotSaveCar_toRepository() {

    var myCar = CarEntity.builder()
        .carId("otherCarId")
        .brand("WW")
        .model("Golf")
        .description("description2")
        .isElectric(false)
        .trunkCapacity(15)
        .milesTravelled(200500)
        .driver("Jan Andrzej")
        .year(1998)
        .build();

    carManager.register(myCar);

    assertThat(carRepository.count()).isZero();
  }
}
