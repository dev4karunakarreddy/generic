package com.cse.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository <V,K> extends JpaRepository<V,Long>, JpaSpecificationExecutor<V> {

    Page<V> findAll(Pageable pageable);

}
