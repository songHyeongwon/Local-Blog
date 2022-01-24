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
@Table(name = "BOARD")
@SequenceGenerator(
        name="BOARD_SEQ_GEN", //시퀀스 제너레이터 이름
        sequenceName="BOARD_SEQ", //시퀀스 이름
        allocationSize = 1 //시퀀스 크기
)
@AllArgsConstructor //모든 필드 값을 파라미터로 받는 생성자를 만듦
@NoArgsConstructor //파라미터가 없는 기본 생성자를 생성
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            ,generator = "BOARD_SEQ_GEN")//의존성 시스템
    private long boardId;

    private String title;
    private long menuId;
    @CreatedDate
    @Setter
    protected LocalDateTime createDatetime; // 등록일시

    @LastModifiedDate
    @Setter
    protected LocalDateTime updateDatetime; // 수정일시

    @OneToOne
    @JoinTable( name ="BOARD_DESC",//조인 테이블명
                joinColumns = @JoinColumn(name="boardId"),//외래키
                inverseJoinColumns = @JoinColumn(name = "boardId") //반대 테이블의 외래키
    )
    BoardDesc boardDesc;
}
