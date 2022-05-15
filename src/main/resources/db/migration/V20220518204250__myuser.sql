CREATE TABLE myuser (
        id BIGSERIAL PRIMARY KEY,
        login TEXT UNIQUE,
        password TEXT);