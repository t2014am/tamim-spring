/*
-- Query: SELECT * FROM dbjavaadv.user
LIMIT 0, 1000

-- Date: 2017-10-20 12:28

WERKENDE ADMIN GEBRUIKER: tamim WACHTWOORD tamim

PASSWORDS: asdff    OR    fdsaa   OR asdfg
*/
INSERT INTO `users` (`dob`,`email`, `username`, `firstName`,`gender`,`lastName`,`password`,`tel`, `enabled`) VALUES ('2017-10-01 00:00:00','tamim@asefi.com', 'tamim@asefi.com','Tamim',NULL,'Asefi','$2a$10$X.nvPzfQQHYG.LWQyCjyC.kJ4SrQRbSaPgO2TWnZ0wW6tvz81sTnK','0486651811', b'1');
INSERT INTO `users` (`dob`,`email`, `username`,`firstName`,`gender`,`lastName`,`password`,`tel`, `enabled`) VALUES ('2017-10-01 00:00:00','dries@donckers.com','dries@donckers.com','Dries',NULL,'Donckers','$2a$10$QSkxfoAfDE.WdLs6SSzOEe2Kgo.HnvHLgMnyXPwlNbonWHI3FjINy','tele', b'1');
INSERT INTO `users` (`dob`,`email`, `username`,`firstName`,`gender`,`lastName`,`password`,`tel`, `enabled`) VALUES ('2017-10-01 00:00:00','erik@vanreusel.com','erik@vanreusel.com','Erik',NULL,'Van Reusel','$2a$10$82SCO3.WS3QwwZJAF9lpEevpZaDY.CNiPvSeMWxT/Zk1F2g2rVN9K','telefoooooooon', b'1');
INSERT INTO `users` (`dob`,`email`, `username`,`firstName`,`gender`,`lastName`,`password`,`tel`, `enabled`) VALUES ('2017-10-01 00:00:00','nicky@vandenbrande.com','nicky@vandenbrande.com','Nicky',NULL,'Van den Brande','$2a$10$U3BMWPuU0o/mm2v9CVmcI.hdcw8u1u8hl0dvQ378ggmmzhp9qcy3S','telefooooooooooon', b'1');
INSERT INTO `users` (`dob`,`email`, `username`,`firstName`,`gender`,`lastName`,`password`,`tel`, `enabled`) VALUES ('2017-10-01 00:00:00','pieterjan@dergent.com','pieterjan@dergent.com','Pieter-jan',NULL,'Dergent','$2a$10$rbYWeXrP9oeecp2J051dReKQTFu2UD8v79X6IwHhet/ei3.AFSRFu','telepoooon', b'1');
INSERT INTO `dbjavaadv`.`users` (`enabled`, `firstName`, `lastName`, `password`, `tel`, `username`) VALUES (b'1', 'tamim', 'tamim', 'tamim', 't', 'tamim');
INSERT INTO `dbjavaadv`.`authorities` (`authority`, `username`) VALUES ('ROLE_ADMIN', 'tamim');
