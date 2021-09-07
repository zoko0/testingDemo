package pl.bc.tdfTestingDemo;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.bc.tdfTestingDemo.CarEntityTestDataFactory.createCarWithYear;
import static pl.bc.tdfTestingDemo.CarEntityTestDataFactory.createNewCar;
import static pl.bc.tdfTestingDemo.DriverEntityTestDataFactory.standardDriverEntityBuilder;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import org.junit.Before;
import org.junit.Test;

public class CarManagerTest {

  private DriverRepository driverRepository;
  private CarRepository carRepository;
  private CarManager carManager;

  @Before
  public void setUp() {

    carRepository = new CarTestRepository();
    driverRepository = new DriverTestRepository();
    var driverManager = new DriverManager(driverRepository);
    carManager = new CarManager(carRepository, driverManager);
  }

  @Test
  public void registerOldCar_savesCar_toRepository() {

    var myCar = createCarWithYear(2015);

    carManager.registerOldCar(myCar);

    assertThat(carRepository.count()).isEqualTo(1L);
  }

  @Test
  public void registerOldCar_shouldNotSaveCar_toRepository() {

    var myCar = createCarWithYear(1998);

    carManager.registerOldCar(myCar);

    assertThat(carRepository.count()).isZero();
  }

  @Test
  public void registerNewCar_shouldSaveCar_whenDriverIsExperienced() {

    var newCar = createNewCar();
    var driverId = "driverId";
    driverRepository.save(standardDriverEntityBuilder()
        .Id(driverId)
        .licenseTimestamp(1L)
        .build());

    carManager.registerNewCar(newCar, driverId);

    assertThat(carRepository.count()).isEqualTo(1L);
  }

  @Test
  public void registerNewCar_shouldSaveCar_whenDriverIsNotExperienced() {

    var newCar = createNewCar();
    var driverId = "driverId";
    long licenseTimestamp = LocalDateTime.of(2021, 1, 1, 0, 0).toEpochSecond(ZoneOffset.UTC);
    driverRepository.save(standardDriverEntityBuilder()
        .Id(driverId)
        .licenseTimestamp(licenseTimestamp)
        .build());

    carManager.registerNewCar(newCar, driverId);

    assertThat(carRepository.count()).isZero();
  }

}
