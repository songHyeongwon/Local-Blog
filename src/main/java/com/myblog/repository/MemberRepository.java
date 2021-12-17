package com.myblog.repository;

import java.util.Optional;

import com.myblog.been.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemberRepository extends JpaRepository<Member, Long> {

	Optional<Member> findByName(String userId);
	//List<Member> findByNameLike(String userName);
	Page<Member> findByNameLike(String userName , Pageable pageable);

	long countByNameLike(String userName);
	long countByName(String userName);

	@Query(nativeQuery = true , value = "SELECT MAX(ID) FROM member")
	long maxById();
}
