package pl.bc.tdfTestingDemo;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.bc.tdfTestingDemo.model.CarEntity;
import pl.bc.tdfTestingDemo.model.CarEntity.CarEntityBuilder;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CarEntityTestDataFactory {

  public static CarEntity standardCarEntity() {

    return standardCarEntityBuilder().build();
  }

  private static CarEntityBuilder standardCarEntityBuilder() {

    return CarEntity.builder()
        .carId("otherCarId")
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
}
