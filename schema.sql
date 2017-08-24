CREATE TABLE sale (
  id  SERIAL PRIMARY KEY,
  gnome_id VARCHAR(45) NOT NULL,
  item_id  VARCHAR(45) NOT NULL,
  quantity INT      NOT NULL
);

CREATE TABLE gnome (
  id    VARCHAR(45) NOT NULL,
  name  VARCHAR(45) NOT NULL,
  money NUMERIC(20, 2),
  PRIMARY KEY (id)
);

CREATE TABLE item (
  id    VARCHAR(45) NOT NULL,
  name  VARCHAR(45) NOT NULL,
  price NUMERIC (20, 2),
  PRIMARY KEY (id)
);

ALTER TABLE sale ADD CONSTRAINT fk_sale_gnome FOREIGN KEY (gnome_id) REFERENCES gnome (id);

ALTER TABLE sale ADD CONSTRAINT fk_sale_item FOREIGN KEY (item_id) REFERENCES item (id);

INSERT INTO gnome (id, name, money) VALUES ('001', 'vova1', '10');
INSERT INTO gnome (id, name, money) VALUES ('002', 'dasha1', '1');
INSERT INTO gnome (id, name, money) VALUES ('003', 'yasha1', '100');

INSERT INTO item (id, name, price) VALUES ('01', 'sword', 10);
INSERT INTO item (id, name, price) VALUES ('02', 'spear', 4);
INSERT INTO item (id, name, price) VALUES ('03', 'grenade', 2);