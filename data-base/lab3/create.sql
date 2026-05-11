CREATE TYPE ENGINE_TYPE_ENUM AS ENUM (
    'ION',
    'PLASMA',
    'CHEMICAL',
    'NUCLEAR'
);

CREATE TYPE OBJECT_TYPE_ENUM AS ENUM (
    'ASTEROID',
    'PLANET',
    'STAR',
    'COMET'
);

CREATE TYPE POINT_COORDINATES AS (
    x NUMERIC,
    y NUMERIC,
    z NUMERIC
);


CREATE TABLE EventType (
    id BIGSERIAL PRIMARY KEY,
    event_type_name VARCHAR(100),
    event_type_description TEXT
);


CREATE TABLE Observer (
    id BIGSERIAL PRIMARY KEY,
    observer_description TEXT,
    observer_coordinates POINT_COORDINATES NOT NULL
);


CREATE TABLE Route (
    id BIGSERIAL PRIMARY KEY,
    route_coordinates_start POINT_COORDINATES NOT NULL,
    route_coordinates_end POINT_COORDINATES NOT NULL
);


CREATE TABLE SpaceShip (
    id BIGSERIAL PRIMARY KEY,
    ship_name VARCHAR(100) NOT NULL,
    ship_engine_type ENGINE_TYPE_ENUM,
    ship_coordinates POINT_COORDINATES NOT NULL,
    ship_route_id BIGINT REFERENCES Route(id),
    ship_start_time TIMESTAMP DEFAULT NOW(),
    ship_end_time TIMESTAMP
);


CREATE TABLE SpaceObject (
    id BIGSERIAL PRIMARY KEY,
    object_name VARCHAR(100),
    object_coordinates POINT_COORDINATES NOT NULL,
    object_type OBJECT_TYPE_ENUM
);


CREATE TABLE ObservationTarget (
    id BIGSERIAL PRIMARY KEY,
    ship_id BIGINT UNIQUE REFERENCES SpaceShip(id),
    object_id BIGINT UNIQUE REFERENCES SpaceObject(id),

    CONSTRAINT check_target CHECK (
        (ship_id IS NOT NULL AND object_id IS NULL)
        OR
        (ship_id IS NULL AND object_id IS NOT NULL)
    )
);


CREATE TABLE Observation (
    id BIGSERIAL PRIMARY KEY,
    observation_time TIMESTAMP DEFAULT NOW(),
    observation_description TEXT,

    observation_target_id BIGINT NOT NULL
        REFERENCES ObservationTarget(id),

    observer_id BIGINT NOT NULL
        REFERENCES Observer(id),

    event_type_id BIGINT NOT NULL
        REFERENCES EventType(id)
);


CREATE TABLE Characteristic (
    id BIGSERIAL PRIMARY KEY,
    characteristic_name VARCHAR(100),
    characteristic_value VARCHAR(100)
);


CREATE TABLE SpaceShipCharacteristic (
    ship_id BIGINT NOT NULL
        REFERENCES SpaceShip(id),

    characteristic_id BIGINT NOT NULL
        REFERENCES Characteristic(id),

    PRIMARY KEY (ship_id, characteristic_id)
);


CREATE TABLE SpaceObjectCharacteristic (
    object_id BIGINT NOT NULL
        REFERENCES SpaceObject(id),

    characteristic_id BIGINT NOT NULL
        REFERENCES Characteristic(id),

    PRIMARY KEY (object_id, characteristic_id)
);


CREATE TABLE CharacteristicLog (
    id BIGSERIAL PRIMARY KEY,
    characteristic_id BIGINT NOT NULL
        REFERENCES Characteristic(id),
    characteristic_name VARCHAR(100) NOT NULL,
    old_value VARCHAR(100),
    new_value VARCHAR(100),
    update_time TIMESTAMP DEFAULT NOW()
);