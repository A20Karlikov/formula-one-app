use `formula-one`;
-- User roles
INSERT INTO roles (id, role)
VALUES (1, 'ADMIN');
INSERT INTO roles (id, role)
VALUES (2, 'USER');

-- Test users
INSERT INTO users (id, username, password, email, age)
VALUES (1, 'admin', '12345', 'admin@gmail.com', 25);

INSERT INTO users (id, username, password, email, age)
VALUES (2, 'admin2', '54321', 'admin_two@gmail.com', 33);

INSERT INTO users (id, username, password, email, age)
VALUES (3, 'user', '12345', 'user@gmail.com', 29);

INSERT INTO users (id, username, password, email, age)
VALUES (4, 'petarPetrov', 'petrov20', 'p.petrov@gmail.com', 40);

-- User roles
-- admin1
INSERT INTO users_roles (`user_id`, `roles_id`)
VALUES (1, 1);
INSERT INTO users_roles (`user_id`, `roles_id`)
VALUES (1, 2);
-- admin2
INSERT INTO users_roles (`user_id`, `roles_id`)
VALUES (2, 1);
INSERT INTO users_roles (`user_id`, `roles_id`)
VALUES (2, 2);
-- user1
INSERT INTO users_roles (`user_id`, `roles_id`)
VALUES (3, 2);
-- user 2
INSERT INTO users_roles (`user_id`, `roles_id`)
VALUES (4, 2);

-- Constructors
INSERT INTO constructors (id, name, team_chief, image_url, engine, number_of_wins)
VALUES (1,'Red Bull Racing','Christian Horner','https://media.formula1.com/image/upload/f_auto,c_limit,q_75,w_1320/content/dam/fom-website/2018-redesign-assets/team%20logos/red%20bull','HONDA', 120);

INSERT INTO constructors (id, name, team_chief, image_url, engine, number_of_wins)
VALUES (2,'Scuderia Ferrari','Frédéric Vasseur','https://media.formula1.com/image/upload/f_auto,c_limit,q_auto,w_1320/content/dam/fom-website/2018-redesign-assets/team%20logos/ferrari','FERRARI', 246);

INSERT INTO constructors (id, name, team_chief, image_url, engine, number_of_wins)
VALUES (3,'Mercedes','Toto Wolff','https://media.formula1.com/image/upload/f_auto,c_limit,q_75,w_1320/content/dam/fom-website/2018-redesign-assets/team%20logos/mercedes','MERCEDES', 118);

INSERT INTO constructors (id, name, team_chief, image_url, engine, number_of_wins)
VALUES (4,'McLaren','Andrea Stella','https://media.formula1.com/image/upload/f_auto,c_limit,q_75,w_1320/content/dam/fom-website/2018-redesign-assets/team%20logos/mclaren','MERCEDES', 185);

INSERT INTO constructors (id, name, team_chief, image_url, engine, number_of_wins)
VALUES (5,'Aston Martin','Mike Krack','https://media.formula1.com/image/upload/f_auto,c_limit,q_75,w_1320/content/dam/fom-website/2018-redesign-assets/team%20logos/aston%20martin%202024','MERCEDES', 1);

-- Drivers
INSERT INTO drivers (id, name, country, level, image_url, number_of_wins, race_number, constructor_id)
VALUES (1, 'Max Verstappen','Netherlands','EPIC','https://media.formula1.com/image/upload/f_auto,c_limit,q_75,w_1320/content/dam/fom-website/drivers/2024Drivers/verstappen', 61, 1, 1);

INSERT INTO drivers (id, name, country, level, image_url, number_of_wins, race_number, constructor_id)
VALUES (2, 'Sergio Perez','Mexico','ADVANCED','https://media.formula1.com/image/upload/f_auto,c_limit,q_75,w_1320/content/dam/fom-website/drivers/2024Drivers/perez', 6, 11, 1);

INSERT INTO drivers (id, name, country, level, image_url, number_of_wins, race_number, constructor_id)
VALUES (3, 'Charles Leclerc','Monaco','EPIC','https://media.formula1.com/image/upload/f_auto,c_limit,q_75,w_1320/content/dam/fom-website/drivers/2024Drivers/leclerc', 6, 16, 2);

INSERT INTO drivers (id, name, country, level, image_url, number_of_wins, race_number, constructor_id)
VALUES (4, 'Carlos Sainz','Spain','ADVANCED','https://media.formula1.com/image/upload/f_auto,c_limit,q_75,w_1320/content/dam/fom-website/drivers/2024Drivers/sainz', 3, 55, 2);

INSERT INTO drivers (id, name, country, level, image_url, number_of_wins, race_number, constructor_id)
VALUES (5, 'Lewis Hamilton','Great Britain','EPIC','https://media.formula1.com/image/upload/f_auto,c_limit,q_75,w_1320/content/dam/fom-website/drivers/2024Drivers/hamilton', 104, 44, 3);

INSERT INTO drivers (id, name, country, level, image_url, number_of_wins, race_number, constructor_id)
VALUES (6, 'George Russell','Great Britain','ADVANCED','https://media.formula1.com/image/upload/f_auto,c_limit,q_75,w_1320/content/dam/fom-website/drivers/2024Drivers/russell', 2, 63, 3);

INSERT INTO drivers (id, name, country, level, image_url, number_of_wins, race_number, constructor_id)
VALUES (7, 'Lando Norris','Great Britain','ADVANCED','https://media.formula1.com/image/upload/f_auto,c_limit,q_75,w_1320/content/dam/fom-website/drivers/2024Drivers/norris', 1, 4, 4);

INSERT INTO drivers (id, name, country, level, image_url, number_of_wins, race_number, constructor_id)
VALUES (8, 'Oscar Piastri','Australia','ROOKIE','https://media.formula1.com/image/upload/f_auto,c_limit,q_75,w_1320/content/dam/fom-website/drivers/2024Drivers/piastri', 1, 81, 4);

INSERT INTO drivers (id, name, country, level, image_url, number_of_wins, race_number, constructor_id)
VALUES (9, 'Fernando Alonso','Spain','EPIC','https://media.formula1.com/image/upload/f_auto,c_limit,q_75,w_1320/content/dam/fom-website/drivers/2024Drivers/alonso', 32, 14, 5);

INSERT INTO drivers (id, name, country, level, image_url, number_of_wins, race_number, constructor_id)
VALUES (10, 'Lance Stroll','Canada','ROOKIE','https://media.formula1.com/image/upload/f_auto,c_limit,q_auto,w_1320/content/dam/fom-website/drivers/2024Drivers/stroll', 0, 18, 5);

-- Teams drivers
INSERT INTO constructors_drivers
VALUES (1, 1);

INSERT INTO constructors_drivers
VALUES (1, 2);

INSERT INTO constructors_drivers
VALUES (2, 3);

INSERT INTO constructors_drivers
VALUES (2, 4);

INSERT INTO constructors_drivers
VALUES (3, 5);

INSERT INTO constructors_drivers
VALUES (3, 6);

INSERT INTO constructors_drivers
VALUES (4, 7);

INSERT INTO constructors_drivers
VALUES (4, 8);

INSERT INTO constructors_drivers
VALUES (5, 9);

INSERT INTO constructors_drivers
VALUES (5, 10);

-- Tracks
INSERT INTO tracks(id, name, country, image_url, first_race, number_of_laps, lap_record_holder_id)
VALUES (1,'Circuit de Spa-Francorchamps','Belgium','https://media.formula1.com/image/upload/f_auto,c_limit,q_auto,w_1320/content/dam/fom-website/2018-redesign-assets/Circuit%20maps%2016x9/Belgium_Circuit', 1950, 44, 9);

INSERT INTO tracks(id, name, country, image_url, first_race, number_of_laps, lap_record_holder_id)
VALUES (2,'Albert Park Grand Prix Circuit','Australia','https://media.formula1.com/image/upload/f_auto,c_limit,q_auto,w_771/content/dam/fom-website/2018-redesign-assets/Circuit%20maps%2016x9/Australia_Circuit', 1996, 58, 3);

INSERT INTO tracks(id, name, country, image_url, first_race, number_of_laps, lap_record_holder_id)
VALUES (3,'Suzuka Circuit','Japan','https://media.formula1.com/image/upload/f_auto,c_limit,q_auto,w_1320/content/dam/fom-website/2018-redesign-assets/Circuit%20maps%2016x9/Japan_Circuit', 1987, 53, 5);

INSERT INTO tracks(id, name, country, image_url, first_race, number_of_laps, lap_record_holder_id)
VALUES (4,'Circuit de Monaco','Monaco','https://media.formula1.com/image/upload/f_auto,c_limit,q_auto,w_1320/content/dam/fom-website/2018-redesign-assets/Circuit%20maps%2016x9/Monoco_Circuit', 1950, 78, 5);

INSERT INTO tracks(id, name, country, image_url, first_race, number_of_laps, lap_record_holder_id)
VALUES (5,'Silverstone Circuit','Great Britain','https://media.formula1.com/image/upload/f_auto,c_limit,q_auto,w_1320/content/dam/fom-website/2018-redesign-assets/Circuit%20maps%2016x9/Great_Britain_Circuit', 1950, 52, 1);

INSERT INTO tracks(id, name, country, image_url, first_race, number_of_laps, lap_record_holder_id)
VALUES (6,'Autodromo Nazionale Monza','Italy','https://media.formula1.com/image/upload/f_auto,c_limit,q_auto,w_1320/content/dam/fom-website/2018-redesign-assets/Circuit%20maps%2016x9/Italy_Circuit', 1950, 53, 7);

INSERT INTO tracks(id, name, country, image_url, first_race, number_of_laps, lap_record_holder_id)
VALUES (7,'Hungaroring','Hungary','https://media.formula1.com/image/upload/f_auto,c_limit,q_auto,w_1320/content/dam/fom-website/2018-redesign-assets/Circuit%20maps%2016x9/Hungary_Circuit', 1986, 70, 5);

INSERT INTO tracks(id, name, country, image_url, first_race, number_of_laps, lap_record_holder_id)
VALUES (8,'Autódromo José Carlos Pace','Brasil','https://media.formula1.com/image/upload/f_auto,c_limit,q_auto,w_1320/content/dam/fom-website/2018-redesign-assets/Circuit%20maps%2016x9/Brazil_Circuit', 1973, 71, 9);

INSERT INTO tracks(id, name, country, image_url, first_race, number_of_laps, lap_record_holder_id)
VALUES (9,'Las Vegas Strip Circuit','USA','https://media.formula1.com/image/upload/f_auto,c_limit,q_auto,w_1320/content/dam/fom-website/2018-redesign-assets/Circuit%20maps%2016x9/Las_Vegas_Circuit', 2023, 50, 8);


-- Races
INSERT INTO races (id, track_id, winner_id, fastest_lap_holder_id, weather)
VALUES (1, 1, 1, 3, 'RAINY');

INSERT INTO races (id, track_id, winner_id, fastest_lap_holder_id, weather)
VALUES (2, 2, 4, 7, 'SUNNY');

INSERT INTO races (id, track_id, winner_id, fastest_lap_holder_id, weather)
VALUES (3, 3, 1, 9, 'CLOUDY');

INSERT INTO races (id, track_id, winner_id, fastest_lap_holder_id, weather)
VALUES (4, 4, 3, 1, 'SUNNY');