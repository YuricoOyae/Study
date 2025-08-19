package com.example.spring_subject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring_subject.entity.UserEntity;

/**
 * ユーザー情報 Repository
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}