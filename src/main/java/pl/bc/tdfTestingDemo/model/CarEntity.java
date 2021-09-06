package pl.bc.tdfTestingDemo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class CarEntity {

  @Id
  private String Id;

  private String brand;

  private String model;

  private int year;

  private int milesTravelled;

  private String description;

  private int trunkCapacity;

  private String driver;

  private boolean isElectric;
}
