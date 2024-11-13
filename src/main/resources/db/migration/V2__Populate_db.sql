-- Вставка даних у таблицю clients (клієнти)
INSERT INTO clients (name) VALUES
                               ('Alice'),
                               ('Bob'),
                               ('Charlie'),
                               ('David'),
                               ('Eva'),
                               ('Frank'),
                               ('Grace'),
                               ('Hank'),
                               ('Ivy'),
                               ('Jack');

-- Вставка даних у таблицю planets (планети)
INSERT INTO planets (id, name) VALUES
                                   ('MARS', 'Mars'),
                                   ('VEN', 'Venus'),
                                   ('EARTH', 'Earth'),
                                   ('JUPITER', 'Jupiter'),
                                   ('SATURN', 'Saturn');

-- Вставка даних у таблицю tickets (квитки)
INSERT INTO tickets (created_at, client_id, from_planet_id, to_planet_id) VALUES
                                                                              ('2024-11-13 10:00:00', 1, 'MARS', 'VEN'),
                                                                              ('2024-11-13 10:05:00', 2, 'EARTH', 'MARS'),
                                                                              ('2024-11-13 10:10:00', 3, 'JUPITER', 'VEN'),
                                                                              ('2024-11-13 10:15:00', 4, 'SATURN', 'EARTH'),
                                                                              ('2024-11-13 10:20:00', 5, 'VEN', 'JUPITER'),
                                                                              ('2024-11-13 10:25:00', 6, 'MARS', 'SATURN'),
                                                                              ('2024-11-13 10:30:00', 7, 'EARTH', 'JUPITER'),
                                                                              ('2024-11-13 10:35:00', 8, 'JUPITER', 'EARTH'),
                                                                              ('2024-11-13 10:40:00', 9, 'SATURN', 'MARS'),
                                                                              ('2024-11-13 10:45:00', 10, 'VEN', 'SATURN');
