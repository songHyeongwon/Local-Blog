package com.myblog.mapper;

import com.myblog.been.Board;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@Mapper
@MapperScan
public interface MenuMapper {
    public List<Board> findMapperBoard(Board board);
}
