package com.datajpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.datajpa.SalesDevice;

// TODO: Auto-generated Javadoc
/**
 * The Interface EmployeeDepartmentsAssignedRepository.
 */
public interface SalesDeviceRepository extends JpaRepository<SalesDevice, Integer>, JpaSpecificationExecutor<SalesDevice> {

}
