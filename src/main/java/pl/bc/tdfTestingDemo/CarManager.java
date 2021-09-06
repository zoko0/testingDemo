package pl.bc.tdfTestingDemo;

import java.util.Calendar;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.bc.tdfTestingDemo.model.CarEntity;

@Service
@AllArgsConstructor
public class CarManager {

  private static final int ACCEPTED_YEAR = 2011;

  private final CarRepository carRepository;
  private final DriverManager driverManager;

  public void registerOldCar(CarEntity car) {

    if (car.getYear() < ACCEPTED_YEAR) {
      return;
    }
    carRepository.save(car);
  }

  public void registerNewCar(CarEntity car, String driverId) {

    if (car.getYear() != Calendar.getInstance().get(Calendar.YEAR)) {
      return;
    }
    if (!car.isElectric()) {
      return;
    }
    if (car.getMilesTravelled() != 0) {
      return;
    }

    var driverEntity = driverManager.getDriverWithValidLicense(driverId);
    if (driverEntity != null) {
      car.setDriver(driverEntity.getFirstName() + " " + driverEntity.getLastName());
      carRepository.save(car);
    }
  }
}
