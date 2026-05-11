CREATE TYPE TARGET_TYPE_ENUM AS ENUM ('SHIP', 'OBJECT');
CREATE TYPE ENGINE_TYPE_ENUM AS ENUM ('ION', 'PLASMA', 'CHEMICAL', 'NUCLEAR');z
CREATE TYPE OBJECT_TYPE_ENUM AS ENUM ('ASTEROID', 'PLANET', 'STAR', 'COMET');

CREATE TYPE POINT_COORDINATES AS (
    x NUMERIC,
    y NUMERIC,
    z NUMERIC
);

CREATE TABLE EventType (
    event_type_id BIGSERIAL PRIMARY KEY,
    name_type VARCHAR(100),
    description_event TEXT
);

CREATE TABLE Observer (
    observer_id BIGSERIAL PRIMARY KEY,
    observer_description TEXT,
    coordinate POINT_COORDINATES NOT NULL
);

CREATE TABLE Route (
    route_id BIGSERIAL PRIMARY KEY,
    coordinates_start POINT_COORDINATES NOT NULL,
    coordinates_end POINT_COORDINATES NOT NULL
);

CREATE TABLE SpaceShip (
    ship_id BIGSERIAL PRIMARY KEY,
    ship_name VARCHAR(100) NOT NULL,
    engine_type ENGINE_TYPE_ENUM,
    coordinates POINT_COORDINATES NOT NULL,
    route_id BIGINT REFERENCES Route(route_id),
    start_time TIMESTAMP DEFAULT NOW(),
    end_time TIMESTAMP
);

CREATE TABLE SpaceObject (
    object_id BIGSERIAL PRIMARY KEY,
    object_name VARCHAR(100),
    coordinates POINT_COORDINATES NOT NULL,
    object_type OBJECT_TYPE_ENUM
);

CREATE TABLE ObservationTarget (
    observation_target_id BIGSERIAL PRIMARY KEY,
    target_type TARGET_TYPE_ENUM,
    ship_id BIGINT UNIQUE REFERENCES SpaceShip(ship_id),
    object_id BIGINT UNIQUE REFERENCES SpaceObject(object_id),
    CONSTRAINT check_target CHECK (
        (ship_id IS NOT NULL AND object_id IS NULL) OR 
        (ship_id IS NULL AND object_id IS NOT NULL)
    )
);

CREATE TABLE Observation (
    ID BIGSERIAL PRIMARY KEY,
    observation_time TIMESTAMP DEFAULT NOW(),
    observation_description TEXT,
    observation_target_id BIGINT NOT NULL REFERENCES ObservationTarget(observation_target_id),
    observer_id BIGINT NOT NULL REFERENCES Observer(observer_id),
    event_type_id BIGINT NOT NULL REFERENCES EventType(event_type_id)
);

CREATE TABLE Characteristic (
    characteristic_id BIGSERIAL PRIMARY KEY,
    key VARCHAR(100),
    value VARCHAR(100)
);

CREATE TABLE SpaceShipCharacteristic (
    ship_id BIGINT NOT NULL REFERENCES SpaceShip(ship_id),
    characteristic_id BIGINT NOT NULL REFERENCES Characteristic(characteristic_id),
    PRIMARY KEY (ship_id, characteristic_id)
);

CREATE TABLE SpaceObjectCharacteristic (
    object_id BIGINT NOT NULL REFERENCES SpaceObject(object_id),
    characteristic_id BIGINT NOT NULL REFERENCES Characteristic(characteristic_id),
    PRIMARY KEY (object_id, characteristic_id)
);


SELECT target_type, COUNT(*) FROM ObservationTarget GROUP BY CUBE(target_type, ship_id);