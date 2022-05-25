package com.employee.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface employeeRepository extends JpaRepository<Employee,Integer> {

}
