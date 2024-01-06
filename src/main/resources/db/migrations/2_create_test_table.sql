create TABLE test
(
    id                    UUID         NOT NULL,
    name                  VARCHAR(255) NOT NULL,
    CONSTRAINT pk_test    PRIMARY KEY (id)
);