package com.backend.gini.domain.repository;

import com.backend.gini.domain.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRepository extends JpaRepository<MemberEntity, Integer> {
     MemberEntity findByName(String name);
}
