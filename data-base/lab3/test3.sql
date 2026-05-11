INSERT INTO EventType (id, event_type_name) VALUES (10, 'ship_test');
INSERT INTO Observer (id, observer_description, observer_coordinates) VALUES (10, 'ship_observer', '(100,100,100)'::POINT_COORDINATES);
INSERT INTO SpaceShip (id, ship_name, ship_engine_type, ship_coordinates, ship_start_time, ship_end_time) VALUES 
    (10, 'TestShip', 'ION', '(100,100,100)'::POINT_COORDINATES, NOW(), NULL);
INSERT INTO ObservationTarget (id, ship_id) VALUES (10, 10);
INSERT INTO Observation (observation_description, observation_target_id, observer_id, event_type_id) 
VALUES ('авытываовыо', 10, 10, 10);

SELECT ship_end_time FROM SpaceShip WHERE id=10;