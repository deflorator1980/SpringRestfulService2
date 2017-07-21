CREATE TABLE sale (
  sale_id  SERIAL PRIMARY KEY,
  gnome_id VARCHAR(45) NOT NULL,
  item_id  VARCHAR(45) NOT NULL,
  quantity INT      NOT NULL
);

CREATE TABLE gnome (
  gnome_id    VARCHAR(45) NOT NULL,
  gnome_name  VARCHAR(45) NOT NULL,
  gnome_money NUMERIC(20, 2),
  CONSTRAINT gnomes_pkey PRIMARY KEY (gnome_id)
);

CREATE TABLE item (
  item_id    VARCHAR(45) NOT NULL,
  item_name  VARCHAR(45) NOT NULL,
  item_price NUMERIC (20, 2),
  PRIMARY KEY (item_id)
);
