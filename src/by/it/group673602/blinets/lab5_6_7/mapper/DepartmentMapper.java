package by.it.group673602.blinets.lab5_6_7.mapper;


import blinets.dto.DepartmentDto;
import blinets.entity.Department;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper
public interface DepartmentMapper {

  DepartmentDto departmentToDto(Department department);

  Department dtoToDepartment(DepartmentDto departmentDto);

  List<Department> convertDepartmentDTOListToDepartmentList(List<DepartmentDto> departmentDtoList);

  List<DepartmentDto> convertDepartmentListToDepartmentDto(List<Department> departments);
}
