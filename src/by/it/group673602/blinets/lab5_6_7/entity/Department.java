package by.it.group673602.blinets.lab5_6_7.entity;

import blinets.entity.constants.DepartmentConstants;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Department {

  @Id
  @Column(name = DepartmentConstants.COLUMN_ID_DEPARTMENT)
  private String idDepartment;

  @NotNull
  @Size(max = DepartmentConstants.LENGTH_NAME_DEPARTMENT)
  @NaturalId
  @Column(name = DepartmentConstants.COLUMN_NAME_DEPARTMENT)
  private String departmentName;


  @Column(name = "workersQuantity")
  private Integer workersQuantity;

//  @OneToMany(fetch = FetchType.EAGER, mappedBy = DepartmentConstants.DEPARTMENT_MAPPED)
//  private List<Worker> workers = new ArrayList<>();






}
