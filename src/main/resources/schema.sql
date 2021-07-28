CREATE TABLE member (
                       id BIGINT AUTO_INCREMENT,
                       name VARCHAR(50) NOT NULL,
                       password VARCHAR(50) NOT NULL,
                       auth VARCHAR(50) NOT NULL,
                       contract_number VARCHAR(50) NOT NULL,
                       create_datetime TIMESTAMP NOT NULL,
                       update_datetime TIMESTAMP NOT NULL,
                       PRIMARY KEY (id)
);

INSERT INTO member (name, password, auth, contract_number, create_datetime, update_datetime) VALUES
('admin', '{noop}secret', 'ROLE_ADMIN', '000-0000-0000', now(), now()),
('user1', '{noop}password1', 'ROLE_MEMBER', '000-0000-0000', now(), now()),
('user2', '{noop}password2', 'ROLE_MEMBER', '000-0000-0000', now(), now());

