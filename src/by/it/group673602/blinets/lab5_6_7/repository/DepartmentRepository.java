package by.it.group673602.blinets.lab5_6_7.repository;

import blinets.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {

  Department findByIdDepartment(String id);

  Department findByDepartmentName(String name);
}
