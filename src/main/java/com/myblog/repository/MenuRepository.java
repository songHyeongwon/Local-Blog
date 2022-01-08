package com.myblog.repository;

import com.myblog.been.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Member, Long> {
	
}
