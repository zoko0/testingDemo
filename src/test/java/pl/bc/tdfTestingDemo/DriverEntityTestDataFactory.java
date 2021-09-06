package pl.bc.tdfTestingDemo;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.bc.tdfTestingDemo.model.DriverEntity;
import pl.bc.tdfTestingDemo.model.DriverEntity.DriverEntityBuilder;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DriverEntityTestDataFactory {

  public static DriverEntity standardDriverEntity() {

    return standardDriverEntityBuilder()
        .build();
  }

  public static DriverEntityBuilder standardDriverEntityBuilder() {

    return DriverEntity.builder()
        .Id("driverId")
        .firstName("Jan")
        .lastName("Kowalski")
        .licenseTimestamp(123456678L);
  }
}
