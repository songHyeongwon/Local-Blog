INSERT INTO member (name, password, auth, contract_number, create_datetime, update_datetime) VALUES
('admin', '{noop}test', 'ROLE_MEMBER', '000-0000-0000', now(), now());


INSERT INTO MENU (menuName, menuUrl, menuParentId, depth, menuSort, create_datetime,update_datetime) VALUES
('전체', 'aaa', null, null, now(), now());