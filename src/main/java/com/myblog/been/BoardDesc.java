package com.myblog.been;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "BOARD_DESC")
@SequenceGenerator(
        name="BOARD_DESC_SEQ_GEN", //시퀀스 제너레이터 이름
        sequenceName="BOARD_DESC_SEQ", //시퀀스 이름
        allocationSize = 1 //시퀀스 크기
)
@AllArgsConstructor //모든 필드 값을 파라미터로 받는 생성자를 만듦
@NoArgsConstructor //파라미터가 없는 기본 생성자를 생성
public class BoardDesc {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            ,generator = "BOARD_DESC_SEQ_GEN")//의존성 시스템
    private long board_descId;
    private long boardId;
    private String text;

    @CreatedDate
    @Setter
    protected LocalDateTime createDatetime; // 등록일시

    @LastModifiedDate
    @Setter
    protected LocalDateTime updateDatetime; // 수정일시
}
