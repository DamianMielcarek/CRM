insert into role (role_id, role) values (1, 'ROLE_ADMIN'), (2, 'ROLE_USER'), (3, 'ROLE_MANAGER'), (4, 'ROLE_OWNER');

INSERT INTO `crm`.`users` (`id`, `email`, `enabled`, `first_name`, `last_name`, `password`, `username`, `role_role_id`)
VALUES ('1', 'a@u', '1', 'AFN', 'ALN', '$2a$10$iPgnenFIoM67cYL9let/iOLBphbDaEkAz3BmiXOCmWq5A4M2TkXAG', 'admin', '1'),
  ('2', 'u@m', '1', 'UFN', 'ULN', '$2a$10$Ad.n7DA3e9QT.a8hXymxI.JKnAYTLR4nD4stJtfMiCLcr7FiZ/st.', 'user', '2'),
  ('3', 'm@m', '1', 'MFN', 'MLN', '$2a$10$iQy1MYc97kkXBwrCJ5I9gO/QcRT.rdY6UDKriBvG.iyX29miDaKDe', 'manager', '3'),
  ('4', 'o@m', '1', 'OFN', 'OLN', '$2a$10$VVH6bnOWLMczmH12BY99c.T6JMzMErt/gZKRCPfYlXcq7JMFoqkWW', 'owner', '4');
# admin - pass = admin
# user - pass = user
# manager - pass = manager
# owner - pass = owner