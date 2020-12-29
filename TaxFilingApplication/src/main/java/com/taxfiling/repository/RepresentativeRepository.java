package com.taxfiling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taxfiling.entity.Representative;

@Repository
public interface RepresentativeRepository extends JpaRepository<Representative, Long> {

}
