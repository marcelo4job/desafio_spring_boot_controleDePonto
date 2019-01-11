package com.pontocontrole.repositories;

import com.pontocontrole.domain.RecordTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordTimeRepository extends JpaRepository<RecordTime, Integer> {

}
