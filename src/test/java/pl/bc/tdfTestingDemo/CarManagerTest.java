package pl.bc.tdfTestingDemo;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.bc.tdfTestingDemo.CarEntityTestDataFactory.createCarWithYear;

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

    var myCar = createCarWithYear(2015);

    carManager.register(myCar);

    assertThat(carRepository.count()).isEqualTo(1L);
  }

  @Test
  public void register_shouldNotSaveCar_toRepository() {

    var myCar = createCarWithYear(1998);

    carManager.register(myCar);

    assertThat(carRepository.count()).isZero();
  }

}
