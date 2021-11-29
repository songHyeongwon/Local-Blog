CREATE TABLE member (
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
('admin', '{noop}secret', 'ROLE_ADMIN', '000-0000-0000', now(), now()),
('test0', '{noop}test', 'ROLE_ADMIN', '000-0000-0000', now(), now()),
('test1', '{noop}test', 'ROLE_ADMIN', '000-0000-0000', now(), now()),
('test2', '{noop}test', 'ROLE_ADMIN', '000-0000-0000', now(), now()),
('test3', '{noop}test', 'ROLE_ADMIN', '000-0000-0000', now(), now()),
('test4', '{noop}test', 'ROLE_ADMIN', '000-0000-0000', now(), now()),
('test5', '{noop}test', 'ROLE_ADMIN', '000-0000-0000', now(), now()),
('test6', '{noop}test', 'ROLE_ADMIN', '000-0000-0000', now(), now()),
('test7', '{noop}test', 'ROLE_ADMIN', '000-0000-0000', now(), now()),
('test8', '{noop}test', 'ROLE_ADMIN', '000-0000-0000', now(), now()),
('test9', '{noop}test', 'ROLE_ADMIN', '000-0000-0000', now(), now()),

('test10', '{noop}test', 'ROLE_MEMBER', '000-0000-0000', now(), now()),
('test11', '{noop}test', 'ROLE_MEMBER', '000-0000-0000', now(), now()),
('test12', '{noop}test', 'ROLE_MEMBER', '000-0000-0000', now(), now()),
('test13', '{noop}test', 'ROLE_MEMBER', '000-0000-0000', now(), now()),
('test14', '{noop}test', 'ROLE_MEMBER', '000-0000-0000', now(), now()),
('test15', '{noop}test', 'ROLE_MEMBER', '000-0000-0000', now(), now()),
('test16', '{noop}test', 'ROLE_MEMBER', '000-0000-0000', now(), now()),
('test17', '{noop}test', 'ROLE_MEMBER', '000-0000-0000', now(), now()),
('test18', '{noop}test', 'ROLE_MEMBER', '000-0000-0000', now(), now()),
('test19', '{noop}test', 'ROLE_MEMBER', '000-0000-0000', now(), now()),

('user1', '{noop}password1', 'ROLE_MEMBER', '000-0000-0000', now(), now()),
('user2', '{noop}password2', 'ROLE_MEMBER', '000-0000-0000', now(), now());

