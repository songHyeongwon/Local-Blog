package com.myblog.mapper;

import com.myblog.been.Board;
import com.myblog.been.Member;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@Mapper
@MapperScan
public interface MemberMapper {
    public List<Member> findMapperMember(Member member);
}
