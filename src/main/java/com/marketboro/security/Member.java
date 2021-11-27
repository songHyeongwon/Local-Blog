package com.marketboro.security;

import com.sun.istack.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Getter
@Setter
@ToString
@Table(name = "member")
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderMethodName = "entityBuilder", toBuilder = true)
public class Member implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//의존성 시스템
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
