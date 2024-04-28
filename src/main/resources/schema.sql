DROP TABLE SUGGESTED_EXERCISE;
CREATE table suggested_exercise (
                      ID int not null AUTO_INCREMENT PRIMARY KEY,
                      NAME varchar(255) not null,
                      DESCRIPTION VARCHAR(1000) not null
);