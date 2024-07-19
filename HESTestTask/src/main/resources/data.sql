INSERT INTO account (id, account_status, balance)
VALUES ('e793cb04-bb4a-4df4-84d6-e6cd61f26711', 'ACTIVE', 100.00);

INSERT INTO account (id, account_status, balance)
VALUES ('9afde3dd-9bc3-4d80-9db3-5b0bc927999c', 'BLOCKED', 50.00);




INSERT INTO user_pool (username, password, role)
VALUES ('admin', '$2a$12$E1kGUzqZ6T2Qr6suwGiCtufH5dmcZBOksfT.E0GEHyxmFoU0oGoLO', 'ADMIN');

INSERT INTO user_pool (username, password, role, account_id)
VALUES ('user1', '$2a$12$E1kGUzqZ6T2Qr6suwGiCtufH5dmcZBOksfT.E0GEHyxmFoU0oGoLO', 'ACCOUNT_HOLDER', 'e793cb04-bb4a-4df4-84d6-e6cd61f26711');

INSERT INTO user_pool (username, password, role, account_id)
VALUES ('user2', '$2a$12$E1kGUzqZ6T2Qr6suwGiCtufH5dmcZBOksfT.E0GEHyxmFoU0oGoLO', 'ACCOUNT_HOLDER', '9afde3dd-9bc3-4d80-9db3-5b0bc927999c');

-- unfortunately I'm hashing passwords manually, since users are created via this file. (all the users have password = '111')
-- however creation via API supports password hashing.
