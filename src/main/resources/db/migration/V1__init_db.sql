CREATE TABLE IF NOT EXISTS bank_card
(
  id serial NOT NULL,
  card_number character varying(255),
  valid_thru bigint,
  cvv int,
  pin character varying(255),
  balance bigint,
  PRIMARY KEY (id)
);
