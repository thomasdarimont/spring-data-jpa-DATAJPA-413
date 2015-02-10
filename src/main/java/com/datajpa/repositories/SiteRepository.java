package com.datajpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.datajpa.Site;

/**
 * The Interface SiteRepository.
 */
public interface SiteRepository extends JpaRepository<Site, Integer>, JpaSpecificationExecutor<Site> {

}
