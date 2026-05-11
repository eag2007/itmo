INSERT INTO EventType (event_type_name, event_type_description) VALUES 
    ('Launch', 'Spacecraft launch event'),
    ('Landing', 'Spacecraft landing event'),
    ('Observation', 'Regular observation event'),
    ('Maneuver', 'Spacecraft maneuver event'),
    ('Docking', 'Spacecraft docking event'),
    ('Emergency', 'Emergency situation event');


INSERT INTO Observer (observer_description, observer_coordinates) VALUES 
    ('Ground Station Alpha', ROW(0,0,0)),
    ('Space Observatory Beta', ROW(1000,1000,1000)),
    ('Mobile Observer Gamma', ROW(500,500,500)),
    ('Research Station Delta', ROW(200,300,400)),
    ('Patrol Ship Observer', ROW(50,60,70));


INSERT INTO Route (route_coordinates_start, route_coordinates_end) VALUES 
    (ROW(0,0,0), ROW(100,150,200)),
    (ROW(100,150,200), ROW(300,400,500)),
    (ROW(0,0,0), ROW(1000,1000,1000)),
    (ROW(50,50,50), ROW(200,200,200)),
    (ROW(25,25,25), ROW(400,400,400));


INSERT INTO SpaceShip (
    ship_name,
    ship_engine_type,
    ship_coordinates,
    ship_route_id,
    ship_start_time,
    ship_end_time
) VALUES 
    ('Восток-1', 'CHEMICAL', ROW(0,0,200), 1, '2025-03-15 09:00:00', '2025-03-15 15:30:00'),
    ('Союз МС-25', 'CHEMICAL', ROW(45,67,210), 2, '2025-03-16 12:00:00', NULL),
    ('Прогресс МС-27', 'CHEMICAL', ROW(78,92,205), 2, '2025-03-14 08:30:00', '2025-03-17 10:15:00'),
    ('Союз МС-24', 'CHEMICAL', ROW(67,89,215), 3, '2025-02-10 11:00:00', '2025-02-25 09:30:00'),
    ('Прогресс МС-26', 'CHEMICAL', ROW(34,56,208), 4, '2025-01-20 14:00:00', '2025-02-05 16:45:00'),
    ('Starship', 'ION', ROW(1000,1200,500), 3, '2025-03-01 08:00:00', NULL),
    ('Dragon', 'CHEMICAL', ROW(200,300,350), 5, '2025-03-10 13:30:00', '2025-03-18 11:20:00'),
    ('Шэньчжоу-18', 'CHEMICAL', ROW(45,67,212), 2, '2025-03-05 10:15:00', NULL),
    ('Cygnus', 'CHEMICAL', ROW(56,78,205), 3, '2025-02-28 09:45:00', '2025-03-12 08:30:00'),
    ('Dream Chaser', 'ION', ROW(90,110,220), 4, '2025-03-20 16:00:00', NULL);


INSERT INTO SpaceObject (
    object_name,
    object_coordinates,
    object_type
) VALUES 
    ('Астероид-245', ROW(100,200,300), 'ASTEROID'),
    ('Комета Галлея', ROW(50,60,70), 'COMET'),
    ('Марс-Станция', ROW(150,250,350), 'PLANET'),
    ('Лунная-База', ROW(75,85,95), 'ASTEROID'),
    ('Звезда-Бетельгейзе', ROW(1000,2000,3000), 'STAR'),
    ('Астероид-999', ROW(500,600,700), 'ASTEROID'),
    ('Комета-Свифта', ROW(200,300,400), 'COMET');


INSERT INTO ObservationTarget (ship_id, object_id) VALUES 
    (1, NULL),
    (2, NULL),
    (3, NULL),
    (4, NULL),
    (5, NULL),
    (6, NULL),
    (7, NULL),
    (8, NULL),
    (9, NULL),
    (10, NULL),
    (NULL, 1),
    (NULL, 2),
    (NULL, 3),
    (NULL, 4),
    (NULL, 5),
    (NULL, 6),
    (NULL, 7);


INSERT INTO Observation (
    observation_time,
    observation_description,
    observation_target_id,
    observer_id,
    event_type_id
) VALUES 
    ('2025-03-15 11:00:00', 'Запуск Восток-1 успешно выполнен', 1, 1, 1),
    ('2025-03-16 13:00:00', 'Союз МС-25 на маршруте к МКС', 2, 1, 3),
    ('2025-03-14 10:00:00', 'Прогресс МС-27 стыковка', 3, 2, 5),
    ('2025-03-17 09:00:00', 'Наблюдение астероида', 11, 3, 3),
    ('2025-03-01 10:00:00', 'Starship тестовый полет', 6, 4, 1),
    ('2025-03-18 12:00:00', 'Dragon возвращение', 7, 5, 2),
    ('2025-03-05 11:00:00', 'Шэньчжоу-18 запуск', 8, 1, 1),
    ('2025-03-12 09:00:00', 'Cygnus завершение миссии', 9, 3, 2),
    ('2025-03-20 17:00:00', 'Dream Chaser в полете', 10, 4, 3),
    ('2025-03-16 15:00:00', 'Наблюдение кометы', 12, 2, 3),
    ('2025-03-17 14:00:00', 'Марс-Станция на орбите', 13, 5, 3),
    ('2025-03-18 10:00:00', 'Лунная база активна', 14, 3, 3);


INSERT INTO Characteristic (
    characteristic_name,
    characteristic_value
) VALUES 
    ('mass', '2500 tons'),
    ('crew', '15'),
    ('max_speed', '50000 km/h'),
    ('fuel', '500 kg'),
    ('weapons', 'laser cannons'),
    ('sensor_range', '1 light-hour'),
    ('stealth', 'yes'),
    ('cargo', '5000 tons'),
    ('science_lab', 'yes'),
    ('engine_power', '500 MW');


INSERT INTO SpaceShipCharacteristic (ship_id, characteristic_id) VALUES 
    (1, 1), (1, 2), (1, 3),
    (2, 1), (2, 8), (2, 2),
    (3, 1), (3, 6), (3, 7),
    (4, 1), (4, 4), (4, 5),
    (5, 1), (5, 9), (5, 2),
    (6, 1), (6, 10), (6, 3),
    (7, 1), (7, 2), (7, 3),
    (8, 1), (8, 2), (8, 3),
    (9, 1), (9, 8), (9, 2),
    (10, 1), (10, 10), (10, 3);


INSERT INTO SpaceObjectCharacteristic (object_id, characteristic_id) VALUES 
    (1, 1), (1, 3),
    (2, 1), (2, 6),
    (3, 1), (3, 2),
    (4, 1), (4, 2),
    (5, 1), (5, 3),
    (6, 1), (6, 3),
    (7, 1), (7, 6);