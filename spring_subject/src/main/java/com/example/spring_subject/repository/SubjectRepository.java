package com.example.spring_subject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring_subject.entity.SubjectEntity;

/**
* 科目情報 Repository
*/
@Repository
public interface SubjectRepository extends JpaRepository<SubjectEntity, Integer> {
}
