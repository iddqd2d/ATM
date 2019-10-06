CREATE TABLE IF NOT EXISTS ATM
(
  id bigserial NOT NULL,
  card_number bigint,
  valid_thru bigint,
  cvv int,
  pin int,
  balance bigint,
  PRIMARY KEY (id)
);
