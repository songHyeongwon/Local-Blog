package com.myblog.repository;

import com.myblog.been.Board;
import com.myblog.been.BoardDesc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardDescRepository extends JpaRepository<BoardDesc, Long> {

}
