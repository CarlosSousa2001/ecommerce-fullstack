INSERT INTO category (id, category) VALUES (1, 'Electronics');
INSERT INTO category (id, category) VALUES (2, 'Movies');
INSERT INTO category (id, category) VALUES (3, 'Clothing');
INSERT INTO category (id, category) VALUES (4, 'Sports');
INSERT INTO category (id, category) VALUES (5, 'Furniture');
INSERT INTO category (id, category) VALUES (6, 'Games');

INSERT INTO attribute (name) VALUES ('RAM');
INSERT INTO attribute (name) VALUES ('COR');
INSERT INTO attribute (name) VALUES ('MEMORY');

INSERT INTO deal_of_the_day (deal_price, deal_expiration) VALUES (500.00, '2024-12-31T23:59:59');

insert into product (product_owner, title, short_description, long_description, price, quantity, cod, photo_url, rating, status, deal_id) values ('An Apple', 'Apple iPad Pro 11 (2018)', 'Formation of cutaneous uretero-ileostomy', 'Aqui seria uma descrição muito longa mas nao quero complicar meu insert no banco de dados', 1474.44, 17, '49643-017', 'http://dummyimage.com/160x260.png/dddddd/000000', 2.0, true, 1);

insert into product (product_owner, title, short_description, long_description, price, quantity, cod, photo_url, rating, status) values ('Samsung', 'Galaxy s21', 'Formation of cutaneous uretero-ileostomy', 'Aqui seria uma descrição muito longa mas nao quero complicar meu insert no banco de dados', 1274.44, 12, '49743-017', 'http://dummyimage.com/160x260.png/dddddd/000000', 4.0, true);

INSERT INTO attribute_value (product_id, attribute_id, value) VALUES (1, 1, '8');
INSERT INTO attribute_value (product_id, attribute_id, value) VALUES (1, 2, 'ZINC');
INSERT INTO attribute_value (product_id, attribute_id, value) VALUES (1, 3, '256');

INSERT INTO attribute_value (product_id, attribute_id, value) VALUES (2, 1, '12');
INSERT INTO attribute_value (product_id, attribute_id, value) VALUES (2, 2, 'ZINC');
INSERT INTO attribute_value (product_id, attribute_id, value) VALUES (2, 3, '256');

INSERT INTO product_categories (product_id, categories_id) VALUES (1, 1);
INSERT INTO product_categories (product_id, categories_id) VALUES (2, 1);