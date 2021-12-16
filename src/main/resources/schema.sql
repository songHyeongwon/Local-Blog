CREATE TABLE member (--글을 작성할수 있는 회원의 테이블
                       id BIGINT AUTO_INCREMENT,
                       name VARCHAR(50) NOT NULL,
                       password VARCHAR(50) NOT NULL,
                       auth VARCHAR(50) NOT NULL,
                       contract_number VARCHAR(50) NOT NULL,
                       create_datetime TIMESTAMP NOT NULL,
                       update_datetime TIMESTAMP NOT NULL,
                       fail_cnt BIGINT DEFAULT 0 NULL,
                       last_fail_time TIMESTAMP NULL,
                       PRIMARY KEY (id)
);

CREATE TABLE board (--게시글 내용
                       id BIGINT AUTO_INCREMENT,
                       name VARCHAR(50) NOT NULL,
                       password VARCHAR(50) NOT NULL,
                       auth VARCHAR(50) NOT NULL,
                       contract_number VARCHAR(50) NOT NULL,
                       create_datetime TIMESTAMP NOT NULL,
                       update_datetime TIMESTAMP NOT NULL,
                       fail_cnt BIGINT DEFAULT 0 NULL,
                       last_fail_time TIMESTAMP NULL,
                       PRIMARY KEY (id)
);

CREATE TABLE board_desc (--게시글 상세
                       id BIGINT AUTO_INCREMENT,
                       name VARCHAR(50) NOT NULL,
                       password VARCHAR(50) NOT NULL,
                       auth VARCHAR(50) NOT NULL,
                       contract_number VARCHAR(50) NOT NULL,
                       create_datetime TIMESTAMP NOT NULL,
                       update_datetime TIMESTAMP NOT NULL,
                       fail_cnt BIGINT DEFAULT 0 NULL,
                       last_fail_time TIMESTAMP NULL,
                       PRIMARY KEY (id)
);
CREATE TABLE menu (--메뉴리스트
                       id BIGINT AUTO_INCREMENT,
                       name VARCHAR(50) NOT NULL,
                       password VARCHAR(50) NOT NULL,
                       auth VARCHAR(50) NOT NULL,
                       contract_number VARCHAR(50) NOT NULL,
                       create_datetime TIMESTAMP NOT NULL,
                       update_datetime TIMESTAMP NOT NULL,
                       fail_cnt BIGINT DEFAULT 0 NULL,
                       last_fail_time TIMESTAMP NULL,
                       PRIMARY KEY (id)
);

INSERT INTO member (name, password, auth, contract_number, create_datetime, update_datetime) VALUES
('admin', '{noop}test', 'ROLE_MEMBER', '000-0000-0000', now(), now());

