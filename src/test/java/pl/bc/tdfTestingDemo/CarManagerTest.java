package pl.bc.tdfTestingDemo;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.bc.tdfTestingDemo.CarEntityTestDataFactory.createCarWithYear;
import static pl.bc.tdfTestingDemo.CarEntityTestDataFactory.standardCarEntityBuilder;
import static pl.bc.tdfTestingDemo.DriverEntityTestDataFactory.standardDriverEntityBuilder;

import java.util.Calendar;
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
  public void registerNewCar_shouldSaveCar() {

    var currentYear = Calendar.getInstance().get(Calendar.YEAR);
    var myCar = standardCarEntityBuilder()
        .year(currentYear)
        .isElectric(true)
        .milesTravelled(0)
        .build();
    var driverId = "driverId";
    driverRepository.save(standardDriverEntityBuilder()
        .Id(driverId)
        .licenseTimestamp(1L)
        .build());

    carManager.registerNewCar(myCar, driverId);

    assertThat(carRepository.count()).isEqualTo(1L);
  }

}
