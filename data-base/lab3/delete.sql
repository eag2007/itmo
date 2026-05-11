DROP TRIGGER IF EXISTS trg_limit_observations_per_day ON Observation;
DROP TRIGGER IF EXISTS trg_log_characteristic_update ON SpaceObjectCharacteristic;
DROP TRIGGER IF EXISTS trg_check_for_possible_collision ON Observation;
DROP TRIGGER IF EXISTS trg_update_ship_end_time ON Observation;

DROP TABLE IF EXISTS Observation CASCADE;
DROP TABLE IF EXISTS SpaceShipCharacteristic CASCADE;
DROP TABLE IF EXISTS SpaceObjectCharacteristic CASCADE;
DROP TABLE IF EXISTS ObservationTarget CASCADE;
DROP TABLE IF EXISTS Characteristic CASCADE;
DROP TABLE IF EXISTS SpaceShip CASCADE;
DROP TABLE IF EXISTS SpaceObject CASCADE;
DROP TABLE IF EXISTS Observer CASCADE;
DROP TABLE IF EXISTS Route CASCADE;
DROP TABLE IF EXISTS EventType CASCADE;
DROP TABLE IF EXISTS CharacteristicLog;

DROP TYPE IF EXISTS ENGINE_TYPE_ENUM CASCADE;
DROP TYPE IF EXISTS OBJECT_TYPE_ENUM CASCADE;
DROP TYPE IF EXISTS POINT_COORDINATES CASCADE;

DROP FUNCTION IF EXISTS limit_observations_per_day();
DROP FUNCTION IF EXISTS log_characteristic_update();
DROP FUNCTION IF EXISTS check_for_possible_collision();
DROP FUNCTION IF EXISTS update_ship_end_time();