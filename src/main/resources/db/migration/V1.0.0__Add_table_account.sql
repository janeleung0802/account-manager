CREATE TABLE IF NOT EXISTS account (
    id   VARCHAR(8) NOT NULL,
    balance DECIMAL(19,6) NOT NULL,
    currency VARCHAR(3) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO account (id, balance, currency) VALUES ('12345678', 1000000, 'HKD');
INSERT INTO account (id, balance, currency) VALUES ('88888888', 1000000, 'HKD');
