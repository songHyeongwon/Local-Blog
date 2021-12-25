package com.myblog.been;

import com.sun.istack.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.*;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "MEMBER")
@SequenceGenerator(
		name="MEMBER_SEQ_GEN", //시퀀스 제너레이터 이름
		sequenceName="MEMBER_SEQ" //시퀀스 이름
)
@Builder(builderMethodName = "entityBuilder", toBuilder = true)
@AllArgsConstructor //모든 필드 값을 파라미터로 받는 생성자를 만듦
@NoArgsConstructor //파라미터가 없는 기본 생성자를 생성
@Data
public class Member implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE
	,generator = "MEMBER_SEQ_GEN")//의존성 시스템
	private Long id;

	private String name;

	private String password;

	private String auth;

	private String contractNumber;

	@CreatedDate
	@Setter
	protected LocalDateTime createDatetime; // 등록일시

	@LastModifiedDate
	@Setter
	protected LocalDateTime updateDatetime; // 수정일시


	public static Member builder(
		@NotNull String name,
		@NotNull String password) {

		return entityBuilder()
				.name(name)
				.password(password)
				.build();
	}
}
