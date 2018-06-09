package com.he.giving.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.he.giving.model.Log;

@Transactional
//@Service("logRepo")
@Repository
public interface LogRepository extends JpaRepository<Log, Long> {
	
	public List<Log> findById(int id);

    @Query("select l from Log s where l.eventType = ?")
    public List<Log> findByEventTypeEqual (String eventType);
}
