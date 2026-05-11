
INSERT INTO Characteristic (id, characteristic_name, characteristic_value) VALUES (1, 'Temp', '100');
UPDATE Characteristic SET characteristic_value = '500' WHERE id = 1;
SELECT * FROM CharacteristicLog;