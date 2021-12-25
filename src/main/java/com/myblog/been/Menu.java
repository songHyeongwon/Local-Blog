package com.myblog.been;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "MENU")
@SequenceGenerator(
        name="MENU_SEQ_GEN", //시퀀스 제너레이터 이름
        sequenceName="MENU_SEQ" //시퀀스 이름
)
@AllArgsConstructor //모든 필드 값을 파라미터로 받는 생성자를 만듦
@NoArgsConstructor //파라미터가 없는 기본 생성자를 생성
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            ,generator = "MENU_SEQ_GEN")//의존성 시스템
    private long id;
    private String menuName;
    private String menuUrl;

    private long menuParentId;
    private long depth;
    private long menuSort;

    @CreatedDate
    @Setter
    protected LocalDateTime createDatetime; // 등록일시

    @LastModifiedDate
    @Setter
    protected LocalDateTime updateDatetime; // 수정일시

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "id", referencedColumnName = "menuParentId") //상대방쪽 테이블에 id 와 내 menuParentId를 조인
//    private Menu parentMenu; //부모객체
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parentMenu")
//    private List<Menu> childrenMenu;

}
