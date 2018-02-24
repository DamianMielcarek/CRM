insert into role (role_id, role) values (1, 'ROLE_ADMIN'), (2, 'ROLE_USER'), (3, 'ROLE_MANAGER'), (4, 'ROLE_OWNER');

INSERT INTO users (id, email, enabled, first_name, last_name, password, username, role_role_id)
VALUES ('1', 'a@u', '1', 'AFN', 'ALN', '$2a$10$iPgnenFIoM67cYL9let/iOLBphbDaEkAz3BmiXOCmWq5A4M2TkXAG', 'admin', '1'),
  ('2', 'u@m', '1', 'UFN', 'ULN', '$2a$10$Ad.n7DA3e9QT.a8hXymxI.JKnAYTLR4nD4stJtfMiCLcr7FiZ/st.', 'user', '2'),
  ('3', 'm@m', '1', 'MFN', 'MLN', '$2a$10$iQy1MYc97kkXBwrCJ5I9gO/QcRT.rdY6UDKriBvG.iyX29miDaKDe', 'manager', '3'),
  ('4', 'o@m', '1', 'OFN', 'OLN', '$2a$10$VVH6bnOWLMczmH12BY99c.T6JMzMErt/gZKRCPfYlXcq7JMFoqkWW', 'owner', '4');
# admin - pass = admin
# user - pass = user
# manager - pass = manager
# owner - pass = owner
SET FOREIGN_KEY_CHECKS=0;
INSERT INTO category (category_id, category)
VALUES ('1', 'small'), ('2', 'medium'), ('3', 'big');

INSERT INTO customer (id, address, city, email, enabled, first_name, last_name, name, phone)
VALUES ('1', 'Small Street', 'Smallville', 'smallmail@mail.com', '1', 'SmallFN', 'SmallLN', 'Small INC', '123'),
  ('2', 'Medium Street', 'Midtown', 'midmail@mail.com', '1', 'MidFN', 'MidLN', 'Mid INC', '456'),
  ('3', 'Big Street', 'Big City', 'bigmail@mail.com', '1', 'BigFN', 'BigLN', 'Big INC', '789');

INSERT INTO customer_category (customer_id, category_id)
VALUES (1, 1), (2, 2), (3, 3);

INSERT INTO contract (id, begin_date, content, end_date, name, status, value, customer_id, user_id)
VALUES ('1', '2018-02-24 00:00:00', 'contract content', '2018-02-25 00:00:00', 'ContractName', 'PROPOSED', '100000.00', '2', '2');

SET FOREIGN_KEY_CHECKS=1;