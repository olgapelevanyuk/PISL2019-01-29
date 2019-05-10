package blinets.controller;

import blinets.configuration.ControllersReturnRequests;
import blinets.dto.DepartmentDto;
import blinets.exceptions.DontExistsObjectInDatabaseException;
import blinets.exceptions.UniqueObjectException;
import blinets.services.CrudService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
@Log4j2
public class DepartmentController extends ControllersReturnRequests {

  private final CrudService<DepartmentDto> crudService;
//  private final DepartmentDtoValidator departmentDtoValidator;

  @Autowired
  public DepartmentController(CrudService<DepartmentDto> crudService
//      , DepartmentDtoValidator departmentDtoValidator
  ) {
    this.crudService = crudService;
//    this.departmentDtoValidator = departmentDtoValidator;
  }

  @GetMapping("/departments")
  public ResponseEntity getDepartments() {
    log.info("GetMapping departments");
    return new ResponseEntity<>(crudService.get(), HttpStatus.OK);
  }

  @GetMapping("/department/{id}")
  public ResponseEntity getOne(@PathVariable String id) {
    log.info("GetMapping department");
    return new ResponseEntity<>(crudService.get(id), HttpStatus.OK);
  }

  @PostMapping("/department")
  public ResponseEntity create(@RequestBody String  departmentDto,
      BindingResult bindingResult)
      throws UniqueObjectException, DontExistsObjectInDatabaseException {
//    departmentDtoValidator.validate(departmentDto, bindingResult);
//    if (returnBedRequestIfError(bindingResult) != null) {
//      return returnBedRequestIfError(bindingResult);
//    }
    return returnCreatedRequest("/department/" + crudService.create(new DepartmentDto(departmentDto)));
  }

  @PutMapping("/department/{id}")
  public ResponseEntity update(@PathVariable String id, @RequestBody String departmentName)
      throws DontExistsObjectInDatabaseException {
    log.info("PutMapping department " + departmentName);
    DepartmentDto departmentDto =  new DepartmentDto(departmentName);
    departmentDto.setIdDepartment(id);
    crudService.update(departmentDto);
    return returnOkRequest();
  }

  @DeleteMapping("/department/{id}")
  public ResponseEntity delete(@PathVariable String id) {
    crudService.remove(id);
    return returnOkRequest();
  }
}