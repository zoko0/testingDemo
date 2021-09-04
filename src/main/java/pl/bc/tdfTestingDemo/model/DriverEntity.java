package pl.bc.tdfTestingDemo.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Builder(toBuilder = true)
@AllArgsConstructor
@Setter(value = AccessLevel.PACKAGE)
@Getter
@EqualsAndHashCode
public class DriverEntity {

  private String driverId;

  private String firstName;

  private String lastName;

  private Long licenseTimestamp;
}
