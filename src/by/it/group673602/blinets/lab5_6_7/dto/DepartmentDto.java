package by.it.group673602.blinets.lab5_6_7.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class DepartmentDto {

  @JsonProperty("id")
  private String idDepartment;
  @NonNull
  @JsonProperty("departement_name")
  private String departmentName;
  @JsonProperty("workers_quantity")
  private Integer workersQuantity;


}
