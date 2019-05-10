package by.it.group673602.blinets.lab5_6_7.services;

import blinets.dto.DepartmentDto;
import blinets.entity.Department;
import blinets.exceptions.DontExistsObjectInDatabaseException;
import blinets.exceptions.UniqueObjectException;
import blinets.mapper.DepartmentMapper;
import blinets.repository.DepartmentRepository;
import java.util.List;
import java.util.UUID;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Log4j2
@Service
@Transactional
public class DepartmentService implements CrudService<DepartmentDto> {

  @Getter
  private DepartmentRepository departmentRepository;

  private DepartmentMapper mapperDepartment = Mappers.getMapper(DepartmentMapper.class);

  @Autowired
  public DepartmentService(DepartmentRepository departmentRepository) {
    this.departmentRepository = departmentRepository;
  }

  @Override
  public List<DepartmentDto> get() {
    log.info("get departments list service");
    return mapperDepartment.convertDepartmentListToDepartmentDto(departmentRepository.findAll());
  }

  @Override
  public String create(DepartmentDto departmentDto) throws UniqueObjectException {
    log.info("create department  service");
    if (departmentRepository.findByDepartmentName(departmentDto.getDepartmentName()) == null) {
      departmentDto.setIdDepartment(UUID.randomUUID().toString());
      departmentRepository.save(mapperDepartment.dtoToDepartment(departmentDto));
      return departmentRepository
          .findByIdDepartment(departmentDto.getIdDepartment())
          .getIdDepartment();
    } else {
      log.warn("Object already exists");
      throw new UniqueObjectException();
    }
  }

  @Override
  public void remove(String id) {
    log.info("remove department  service");
    departmentRepository.deleteById(id);
  }

  @Override
  public void update(DepartmentDto departmentDto) throws DontExistsObjectInDatabaseException {
    log.info("update department  service");
    Department department = mapperDepartment.dtoToDepartment(departmentDto);
    if (departmentRepository.existsById(department.getIdDepartment())) {
      departmentRepository.deleteById(department.getIdDepartment());
      departmentRepository.save(department);
    } else {
      log.warn("object don't  exists in database");
      throw new DontExistsObjectInDatabaseException();
    }
  }

  public DepartmentDto get(String id) {
    return mapperDepartment.departmentToDto(departmentRepository.findByIdDepartment(id));
  }
}
