/*
-- Query: SELECT * FROM public.user
LIMIT 0, 1000

-- Date: 2017-10-20 12:28

PASSWORDS: asdff    OR    fdsaa   OR asdfg

USERS WITH ENCRYPTED PASSWORDS:
*/
INSERT INTO users (dob,email, username, firstName,gender,lastName,password,tel, "enabled") VALUES ('2017-10-01 00:00:00','tamim@asefi.com', 'tamim@asefi.com','Tamim',NULL,'Asefi','$2a$10$X.nvPzfQQHYG.LWQyCjyC.kJ4SrQRbSaPgO2TWnZ0wW6tvz81sTnK','0486651811', true);
INSERT INTO users (dob,email, username,firstName,gender,lastName,password,tel, "enabled") VALUES ('2017-10-01 00:00:00','dries@donckers.com','dries@donckers.com','Dries',NULL,'Donckers','$2a$10$QSkxfoAfDE.WdLs6SSzOEe2Kgo.HnvHLgMnyXPwlNbonWHI3FjINy','tele', true);
INSERT INTO users (dob,email, username,firstName,gender,lastName,password,tel, "enabled") VALUES ('2017-10-01 00:00:00','erik@vanreusel.com','erik@vanreusel.com','Erik',NULL,'Van Reusel','$2a$10$82SCO3.WS3QwwZJAF9lpEevpZaDY.CNiPvSeMWxT/Zk1F2g2rVN9K','telefoooooooon', true);
INSERT INTO users (dob,email, username,firstName,gender,lastName,password,tel, "enabled") VALUES ('2017-10-01 00:00:00','nicky@vandenbrande.com','nicky@vandenbrande.com','Nicky',NULL,'Van den Brande','$2a$10$U3BMWPuU0o/mm2v9CVmcI.hdcw8u1u8hl0dvQ378ggmmzhp9qcy3S','telefooooooooooon', true);
INSERT INTO users (dob,email, username,firstName,gender,lastName,password,tel, "enabled") VALUES ('2017-10-01 00:00:00','pieterjan@dergent.com','pieterjan@dergent.com','Pieter-jan',NULL,'Dergent','$2a$10$rbYWeXrP9oeecp2J051dReKQTFu2UD8v79X6IwHhet/ei3.AFSRFu','telepoooon', true);

/* CREATE tamim tamim as admin! UNENCRYPTED PASSWORD*/
/*
INSERT INTO `public`.`users` (`"enabled"`, `firstName`, `lastName`, `password`, `tel`, `username`) VALUES (true, 'tamim', 'tamim', 'tamim', 't', 'tamim');
INSERT INTO `public`.`authorities` (`authority`, `username`) VALUES ('ROLE_ADMIN', 'tamim');
*/

/* CREATE tamim tamim as admin! ENCRYPTED PASSWORD!
*/
INSERT INTO public.users ("enabled", firstName, lastName, password, tel, username) VALUES (true, 'tamim', 'tamim', '$2a$10$POI3LyPoy7vOivCm1tE/iuCDfXiAF2ERJvGrG5Pax2yZsrs7b/QAi', 't', 'tamim');
INSERT INTO public.authorities (authority, username) VALUES ('ROLE_ADMIN', 'tamim');


/* CREATE user password as user! UNENCRYPTED PASSWORD*/
/*
INSERT INTO `public`.`users` (`"enabled"`, `firstName`, `lastName`, `password`, `tel`, `username`) VALUES (true, 'tamim', 'tamim', 'password', 't', 'user');
INSERT INTO `public`.`authorities` (`authority`, `username`) VALUES ('ROLE_USER', 'user');
*/


/* CREATE user password as user! ENCRYPTED PASSWORD*/
INSERT INTO public.users ("enabled", firstName, lastName, password, tel, username) VALUES (true, 'tamim', 'tamim', '$2a$10$49wIAR/kOiIszWbxhDauoeUXlA4ypg4Uba0HKmVaY0DkfV71W0M1.', 't', 'user');
INSERT INTO public.authorities (authority, username) VALUES ('ROLE_USER', 'user');


/* CREATE admin password as admin! UNENCRYPTED PASSWORD*/
/*
INSERT INTO `public`.`users` (`"enabled"`, `firstName`, `lastName`, `password`, `tel`, `username`) VALUES (true, 'tamim', 'tamim', 'password', 't', 'admin');
INSERT INTO `public`.`authorities` (`authority`, `username`) VALUES ('ROLE_USER', 'admin');
*/

/* CREATE admin password as admin! ENCRYPTED PASSWORD*/
INSERT INTO public.users ("enabled", firstName, lastName, password, tel, username) VALUES (true, 'tamim', 'tamim', '$2a$10$49wIAR/kOiIszWbxhDauoeUXlA4ypg4Uba0HKmVaY0DkfV71W0M1.', 't', 'admin');
INSERT INTO public.authorities (authority, username) VALUES ('ROLE_USER', 'admin');
