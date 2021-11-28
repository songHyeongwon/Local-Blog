package com.marketboro.security;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

	Optional<Member> findByName(String userId);
	//List<Member> findByNameLike(String userName);
	Page<Member> findByNameLike(String userName , Pageable pageable);

	long countByNameLike(String userName);
}
