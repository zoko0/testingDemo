package pl.bc.tdfTestingDemo;


import java.time.LocalDateTime;
import java.time.ZoneOffset;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.bc.tdfTestingDemo.model.DriverEntity;

@Service
@AllArgsConstructor
public class DriverManager {

  private static final long LICENSE_VALID_SINCE_TIMESTAMP = LocalDateTime.of(2016, 1, 1, 0, 0).toEpochSecond(ZoneOffset.UTC);

  private final DriverRepository driverRepository;

  public DriverEntity getDriverWithValidLicense(String driverId) {

    var driverEntity = driverRepository.findById(driverId);
    if (driverEntity.isPresent() && !filterOffInexperienceDrivers(driverEntity.get())) {
      return null;
    }
    //noinspection OptionalGetWithoutIsPresent
    return driverEntity.get();
  }

  private boolean filterOffInexperienceDrivers(DriverEntity driverEntity) {

    var licenseTimestamp = driverEntity.getLicenseTimestamp();
    return licenseTimestamp < LICENSE_VALID_SINCE_TIMESTAMP;
  }
}
