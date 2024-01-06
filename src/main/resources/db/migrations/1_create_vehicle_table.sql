CREATE TABLE vehicle
(
    v_id                  VARCHAR(36)  NOT NULL,
    created_at            TIMESTAMP    NOT NULL,
    updated_at            TIMESTAMP    NOT NULL,
    v_name                VARCHAR(255) NOT NULL,
    v_registration_number VARCHAR(255) NOT NULL,
    v_is_fixed            BOOLEAN      NULL,
    v_color               INTEGER      NULL,
    v_production_date     INTEGER      NULL,
    CONSTRAINT pk_vehicle PRIMARY KEY (v_id)
);