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

INSERT INTO constructors (id, name, team_chief, image_url, engine, number_of_wins)
VALUES (6,'Alpine','Bruno Famin','https://media.formula1.com/image/upload/f_auto,c_limit,q_75,w_1320/content/dam/fom-website/2018-redesign-assets/team%20logos/alpine','RENAULT', 21);

INSERT INTO constructors (id, name, team_chief, image_url, engine, number_of_wins)
VALUES (7,'RB','Laurent Mekies','https://media.formula1.com/image/upload/f_auto,c_limit,q_75,w_1320/content/dam/fom-website/2018-redesign-assets/team%20logos/rb','HONDA', 2);

INSERT INTO constructors (id, name, team_chief, image_url, engine, number_of_wins)
VALUES (8,'Williams','James Vowles','https://media.formula1.com/image/upload/f_auto,c_limit,q_75,w_1320/content/dam/fom-website/2018-redesign-assets/team%20logos/williams','MERCEDES', 114);

INSERT INTO constructors (id, name, team_chief, image_url, engine, number_of_wins)
VALUES (9,'Kick Sauber','Alessandro Alunni Bravi','https://media.formula1.com/image/upload/f_auto,c_limit,q_75,w_1320/content/dam/fom-website/2018-redesign-assets/team%20logos/kick%20sauber','FERRARI', 1);

INSERT INTO constructors (id, name, team_chief, image_url, engine, number_of_wins)
VALUES (10,'Haas','Ayao Komatsu','https://media.formula1.com/image/upload/f_auto,c_limit,q_75,w_1320/content/dam/fom-website/2018-redesign-assets/team%20logos/haas','FERRARI', 0);

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

INSERT INTO drivers (id, name, country, level, image_url, number_of_wins, race_number, constructor_id)
VALUES (11, 'Pierre Gasly','France','ADVANCED','https://media.formula1.com/image/upload/f_auto,c_limit,q_75,w_1320/content/dam/fom-website/drivers/2024Drivers/gasly', 1, 10, 6);

INSERT INTO drivers (id, name, country, level, image_url, number_of_wins, race_number, constructor_id)
VALUES (12, 'Esteban Ocon','France','ADVANCED','https://media.formula1.com/image/upload/f_auto,c_limit,q_75,w_1320/content/dam/fom-website/drivers/2024Drivers/ocon', 1, 31, 6);

INSERT INTO drivers (id, name, country, level, image_url, number_of_wins, race_number, constructor_id)
VALUES (13, 'Daniel Ricciardo','Australia','ADVANCED','https://media.formula1.com/image/upload/f_auto,c_limit,q_75,w_1320/content/dam/fom-website/drivers/2024Drivers/ricciardo', 8, 3, 7);

INSERT INTO drivers (id, name, country, level, image_url, number_of_wins, race_number, constructor_id)
VALUES (14, 'Yuki Tsunoda','Japan','ROOKIE','https://media.formula1.com/image/upload/f_auto,c_limit,q_75,w_1320/content/dam/fom-website/drivers/2024Drivers/tsunoda', 0, 22, 7);

INSERT INTO drivers (id, name, country, level, image_url, number_of_wins, race_number, constructor_id)
VALUES (15, 'Alexander Albon','Thailand','ADVANCED','https://media.formula1.com/image/upload/f_auto,c_limit,q_75,w_1320/content/dam/fom-website/drivers/2024Drivers/albon', 0, 23, 8);

INSERT INTO drivers (id, name, country, level, image_url, number_of_wins, race_number, constructor_id)
VALUES (16, 'Logan Sargeant','United States','ROOKIE','https://media.formula1.com/image/upload/f_auto,c_limit,q_75,w_1320/content/dam/fom-website/drivers/2024Drivers/sargeant', 0, 2, 8);

INSERT INTO drivers (id, name, country, level, image_url, number_of_wins, race_number, constructor_id)
VALUES (17, 'Valtteri Bottas','Finland','ADVANCED','https://media.formula1.com/image/upload/f_auto,c_limit,q_75,w_1320/content/dam/fom-website/drivers/2024Drivers/bottas', 10, 77, 9);

INSERT INTO drivers (id, name, country, level, image_url, number_of_wins, race_number, constructor_id)
VALUES (18, 'Zhou Guanyu','China','ROOKIE','https://media.formula1.com/image/upload/f_auto,c_limit,q_75,w_1320/content/dam/fom-website/drivers/2024Drivers/zhou', 0, 24, 9);

INSERT INTO drivers (id, name, country, level, image_url, number_of_wins, race_number, constructor_id)
VALUES (19, 'Nico Hulkenberg','Germany','ADVANCED','https://media.formula1.com/image/upload/f_auto,c_limit,q_75,w_1320/content/dam/fom-website/drivers/2024Drivers/hulkenberg', 0, 27, 10);

INSERT INTO drivers (id, name, country, level, image_url, number_of_wins, race_number, constructor_id)
VALUES (20, 'Kevin Magnussen','Denmark','ADVANCED','https://media.formula1.com/image/upload/f_auto,c_limit,q_75,w_1320/content/dam/fom-website/drivers/2024Drivers/magnussen', 0, 20, 10);

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



INSERT INTO constructors_drivers
VALUES (6, 11);

INSERT INTO constructors_drivers
VALUES (6, 12);

INSERT INTO constructors_drivers
VALUES (7, 13);

INSERT INTO constructors_drivers
VALUES (7, 14);

INSERT INTO constructors_drivers
VALUES (8, 15);

INSERT INTO constructors_drivers
VALUES (8, 16);

INSERT INTO constructors_drivers
VALUES (9, 17);

INSERT INTO constructors_drivers
VALUES (9, 18);

INSERT INTO constructors_drivers
VALUES (10, 19);

INSERT INTO constructors_drivers
VALUES (10, 20);

-- Tracks
INSERT INTO tracks(id, name, country, country_flag_url, image_url, first_race, number_of_laps, lap_record, lap_record_holder_id)
VALUES (1,'Circuit de Spa-Francorchamps','Belgium','https://upload.wikimedia.org/wikipedia/commons/6/65/Flag_of_Belgium.svg','https://media.formula1.com/image/upload/f_auto,c_limit,q_auto,w_1320/content/dam/fom-website/2018-redesign-assets/Circuit%20maps%2016x9/Belgium_Circuit', 1950, 44,'1:44.701', 9);

INSERT INTO tracks(id, name, country, country_flag_url, image_url, first_race, number_of_laps, lap_record, lap_record_holder_id)
VALUES (2,'Albert Park Grand Prix Circuit','Australia','https://upload.wikimedia.org/wikipedia/commons/8/88/Flag_of_Australia_%28converted%29.svg','https://media.formula1.com/image/upload/f_auto,c_limit,q_auto,w_771/content/dam/fom-website/2018-redesign-assets/Circuit%20maps%2016x9/Australia_Circuit', 1996, 58, '1:19.813', 3);

INSERT INTO tracks(id, name, country, country_flag_url, image_url, first_race, number_of_laps, lap_record, lap_record_holder_id)
VALUES (3,'Suzuka Circuit','Japan','https://upload.wikimedia.org/wikipedia/en/9/9e/Flag_of_Japan.svg','https://media.formula1.com/image/upload/f_auto,c_limit,q_auto,w_1320/content/dam/fom-website/2018-redesign-assets/Circuit%20maps%2016x9/Japan_Circuit', 1987, 53, '1:30.983', 5);

INSERT INTO tracks(id, name, country, country_flag_url, image_url, first_race, number_of_laps, lap_record, lap_record_holder_id)
VALUES (4,'Circuit de Monaco','Monaco','https://cdn.britannica.com/50/2750-050-688E6E49/Flag-Monaco.jpg','https://media.formula1.com/image/upload/f_auto,c_limit,q_auto,w_1320/content/dam/fom-website/2018-redesign-assets/Circuit%20maps%2016x9/Monoco_Circuit', 1950, 78, '1:12.909', 5);

INSERT INTO tracks(id, name, country, country_flag_url, image_url, first_race, number_of_laps, lap_record, lap_record_holder_id)
VALUES (5,'Silverstone Circuit','Great Britain','https://upload.wikimedia.org/wikipedia/en/thumb/a/ae/Flag_of_the_United_Kingdom.svg/1280px-Flag_of_the_United_Kingdom.svg.png','https://media.formula1.com/image/upload/f_auto,c_limit,q_auto,w_1320/content/dam/fom-website/2018-redesign-assets/Circuit%20maps%2016x9/Great_Britain_Circuit', 1950, 52, '1:27.097', 1);

INSERT INTO tracks(id, name, country, country_flag_url, image_url, first_race, number_of_laps, lap_record, lap_record_holder_id)
VALUES (6,'Autodromo Nazionale Monza','Italy','https://upload.wikimedia.org/wikipedia/en/0/03/Flag_of_Italy.svg','https://media.formula1.com/image/upload/f_auto,c_limit,q_auto,w_1320/content/dam/fom-website/2018-redesign-assets/Circuit%20maps%2016x9/Italy_Circuit', 1950, 53, '1:21.046', 7);

INSERT INTO tracks(id, name, country, country_flag_url, image_url, first_race, number_of_laps, lap_record, lap_record_holder_id)
VALUES (7,'Hungaroring','Hungary','https://cdn.britannica.com/55/1455-004-5897143C/Flag-Hungary.jpg','https://media.formula1.com/image/upload/f_auto,c_limit,q_auto,w_1320/content/dam/fom-website/2018-redesign-assets/Circuit%20maps%2016x9/Hungary_Circuit', 1986, 70, '1:16.627', 5);

INSERT INTO tracks(id, name, country, country_flag_url, image_url, first_race, number_of_laps, lap_record, lap_record_holder_id)
VALUES (8,'Autódromo José Carlos Pace','Brasil','https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/Flag_of_Brazil.svg/1060px-Flag_of_Brazil.svg.png','https://media.formula1.com/image/upload/f_auto,c_limit,q_auto,w_1320/content/dam/fom-website/2018-redesign-assets/Circuit%20maps%2016x9/Brazil_Circuit', 1973, 71, '1:10.540', 17);

INSERT INTO tracks(id, name, country, country_flag_url, image_url, first_race, number_of_laps, lap_record, lap_record_holder_id)
VALUES (9,'Las Vegas Strip Circuit','USA','https://cdn.britannica.com/33/4833-004-828A9A84/Flag-United-States-of-America.jpg','https://media.formula1.com/image/upload/f_auto,c_limit,q_auto,w_1320/content/dam/fom-website/2018-redesign-assets/Circuit%20maps%2016x9/Las_Vegas_Circuit', 2023, 50, '1:35.490', 8);


-- Races
INSERT INTO races (id, track_id, winner_id, fastest_lap_holder_id, weather)
VALUES (1, 1, 1, 3, 'RAINY');

INSERT INTO races (id, track_id, winner_id, fastest_lap_holder_id, weather)
VALUES (2, 2, 4, 7, 'SUNNY');

INSERT INTO races (id, track_id, winner_id, fastest_lap_holder_id, weather)
VALUES (3, 3, 1, 9, 'CLOUDY');

INSERT INTO races (id, track_id, winner_id, fastest_lap_holder_id, weather)
VALUES (4, 4, 3, 1, 'SUNNY');