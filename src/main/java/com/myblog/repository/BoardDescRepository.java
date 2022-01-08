package com.myblog.repository;

import com.myblog.been.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardDescRepository extends JpaRepository<Board, Long> {

}
