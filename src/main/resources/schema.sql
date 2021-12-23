DROP TABLE member;
DROP TABLE board;
DROP TABLE board_desc;
DROP TABLE menu;


CREATE TABLE member (--글을 작성할수 있는 회원의 테이블
                       id BIGINT AUTO_INCREMENT,
                       name VARCHAR(50) NOT NULL,
                       password VARCHAR(50) NOT NULL,
                       auth VARCHAR(50) NOT NULL,
                       contract_number VARCHAR(50) NOT NULL,
                       create_datetime TIMESTAMP NOT NULL,
                       update_datetime TIMESTAMP NOT NULL,
                       --fail_cnt BIGINT DEFAULT 0 NULL,
                       --last_fail_time TIMESTAMP NULL,
                       PRIMARY KEY (id)
);

CREATE TABLE board (--게시글 내용
                       boardId BIGINT AUTO_INCREMENT, -- 게시글 ID
                       title VARCHAR(500) NOT NULL, -- 글제목
                       create_datetime TIMESTAMP NOT NULL, -- 생성일
                       update_datetime TIMESTAMP NOT NULL, -- 수정일
                       PRIMARY KEY (boardId)
);

CREATE TABLE board_desc (--게시글 상세
                       board_descId BIGINT AUTO_INCREMENT, -- 게시글 상세 ID
                       boardId BIGINT AUTO_INCREMENT, -- 게시글 ID
                       text VARCHAR(2000) NOT NULL, --글 내용 차후 html 태그로 변경할것
                       create_datetime TIMESTAMP NOT NULL, --생성일
                       update_datetime TIMESTAMP NOT NULL, --수정일
                       PRIMARY KEY (board_descId)
);
CREATE TABLE menu (--메뉴리스트
                       id BIGINT AUTO_INCREMENT, --메뉴ID
                       menuName VARCHAR(500) NOT NULL, -- 메뉴명
                       menuUrl VARCHAR(500) NOT NULL, --메뉴의 URL
                       menuParentId BIGINT NULL, --부모 메뉴 ID
                       depth BIGINT NULL, -- 메뉴의 깊이 순서
                       menuSort BIGINT, -- 메뉴의 정렬 기준
                       create_datetime TIMESTAMP NOT NULL, -- 생성일
                       update_datetime TIMESTAMP NOT NULL, -- 수정일
                       PRIMARY KEY (id)
);