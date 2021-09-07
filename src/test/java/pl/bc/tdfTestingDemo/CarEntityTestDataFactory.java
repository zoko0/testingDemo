package pl.bc.tdfTestingDemo;

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

    return CarEntity.builder()
        .Id("carId")
        .brand("WW")
        .model("Golf")
        .description("description2")
        .isElectric(false)
        .trunkCapacity(15)
        .milesTravelled(200500)
        .driver("Jan Andrzej")
        .year(2012);
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
