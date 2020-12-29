package com.taxfiling.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.taxfiling.entity.TaxForm;

@Transactional
public interface TaxFormRepository extends JpaRepository<TaxForm, Long>{

	@Modifying
	@Query("update TaxForm tf set tf.verifiedStatus='approvePending' where tf=:t")
	int fileReturn(TaxForm t);

	@Query("SELECT t FROM TaxForm t where t.pan=:pan")
	TaxForm getTaxFormByPan(String pan);
}
