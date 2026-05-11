

CREATE OR REPLACE FUNCTION log_characteristic_update()
RETURNS TRIGGER AS
$$
BEGIN
    INSERT INTO CharacteristicLog (characteristic_id, characteristic_name, old_value, new_value, update_time)
    VALUES (OLD.id, OLD.characteristic_name, OLD.characteristic_value, NEW.characteristic_value, NOW());
    RETURN NEW;
END;
$$
LANGUAGE plpgsql;

CREATE TRIGGER trg_log_characteristic_update
    AFTER UPDATE ON Characteristic
    FOR EACH ROW
    EXECUTE FUNCTION log_characteristic_update();




CREATE OR REPLACE FUNCTION check_for_possible_collision()
RETURNS TRIGGER AS
$$
DECLARE
    target_object_id BIGINT;
BEGIN
    SELECT object_id INTO target_object_id
    FROM ObservationTarget
    WHERE id = NEW.observation_target_id;
    
    IF target_object_id IS NOT NULL THEN
        IF EXISTS (
            SELECT 1
            FROM SpaceObject so1, SpaceObject so2
            WHERE so1.id = target_object_id
              AND so2.id != so1.id
              AND ABS((so1.object_coordinates).x - (so2.object_coordinates).x) < 100
              AND ABS((so1.object_coordinates).y - (so2.object_coordinates).y) < 100
              AND ABS((so1.object_coordinates).z - (so2.object_coordinates).z) < 100
        ) THEN
            RAISE EXCEPTION 'Риск столкновения с другим объектом';
        END IF;
    END IF;
    
    RETURN NEW;
END;
$$
LANGUAGE plpgsql;

CREATE TRIGGER trg_check_for_possible_collision
    BEFORE INSERT ON Observation
    FOR EACH ROW
    EXECUTE FUNCTION check_for_possible_collision();





CREATE OR REPLACE FUNCTION update_ship_end_time()
RETURNS TRIGGER AS
$$
DECLARE
    v_ship_id BIGINT;
BEGIN
    SELECT ship_id INTO v_ship_id
    FROM ObservationTarget
    WHERE id = NEW.observation_target_id;
    
    IF v_ship_id IS NOT NULL THEN
        UPDATE SpaceShip
        SET ship_end_time = NOW()
        WHERE id = v_ship_id AND ship_end_time IS NULL;
    END IF;
    RETURN NEW;
END;
$$
LANGUAGE plpgsql;

CREATE TRIGGER trg_update_ship_end_time
    AFTER INSERT ON Observation
    FOR EACH ROW
    EXECUTE FUNCTION update_ship_end_time();