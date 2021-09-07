package pl.bc.tdfTestingDemo;

import static com.tngtech.valueprovider.ValueProviderFactory.createRandomValueProvider;

import java.util.Calendar;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.bc.tdfTestingDemo.model.CarEntity;
import pl.bc.tdfTestingDemo.model.CarEntity.CarEntityBuilder;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CarEntityTestDataFactory {

  public static CarEntity standardCarEntity() {

    return standardCarEntityBuilder().build();
  }

  public static CarEntityBuilder standardCarEntityBuilder() {

    var provider = createRandomValueProvider();
    return CarEntity.builder()
        .Id(provider.fixedDecoratedString("carId"))
        .brand(provider.fixedDecoratedString("WW"))
        .model(provider.fixedDecoratedString("Golf"))
        .description(provider.fixedDecoratedString("description2"))
        .isElectric(provider.booleanValue())
        .trunkCapacity(provider.intNumber(5,30))
        .milesTravelled(provider.positiveIntNumber())
        .driver(provider.fixedDecoratedString("Jan Andrzej"))
        .year(provider.intNumber(1999,2021));
  }

  public static CarEntity createCarWithYear(int year) {

    return standardCarEntityBuilder()
        .year(year)
        .build();
  }

  public static CarEntity createNewCar() {

    var currentYear = Calendar.getInstance().get(Calendar.YEAR);
    return standardCarEntityBuilder()
        .year(currentYear)
        .isElectric(true)
        .milesTravelled(0)
        .build();
  }
}
