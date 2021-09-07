package pl.bc.tdfTestingDemo;

import static com.tngtech.valueprovider.ValueProviderFactory.createRandomValueProvider;

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

    var provider = createRandomValueProvider();
    return DriverEntity.builder()
        .Id(provider.fixedDecoratedString("driverId"))
        .firstName(provider.fixedDecoratedString("Jan"))
        .lastName(provider.fixedDecoratedString("Kowalski"))
        .licenseTimestamp(provider.longNumber(1234L, 123456789L));
  }
}
