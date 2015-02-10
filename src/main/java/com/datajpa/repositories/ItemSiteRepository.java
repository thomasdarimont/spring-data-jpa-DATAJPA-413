package com.datajpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.datajpa.ItemSite;
import com.datajpa.ItemSiteId;

/**
 * The Interface ItemRepository.
 */
public interface ItemSiteRepository extends JpaRepository<ItemSite, ItemSiteId>, JpaSpecificationExecutor<ItemSite> {

}
