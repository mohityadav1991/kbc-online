package com.kbc.dao.jpa;

import com.kbc.domain.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface VendorRepository extends JpaRepository<Vendor, Long> {

    List<Vendor> findAll();
}
