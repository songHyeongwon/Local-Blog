package com.myblog.repository;

import com.myblog.been.BoardDesc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<BoardDesc, Long> {

}
