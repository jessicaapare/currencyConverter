/*DROP TABLE IF EXISTS conversion;

CREATE TABLE conversion (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  userId INT NOT NULL,
  sourceCurrency VARCHAR(250) DEFAULT NULL,
  sourceValue VARCHAR(250) DEFAULT NULL,
  targetCurrency VARCHAR(250) DEFAULT NULL,
  targetValue VARCHAR(250) DEFAULT NULL ,
  rate VARCHAR(250) DEFAULT NULL,
  dateTime DATE(250) DEFAULT NULL,
   
);*/
/*
INSERT INTO conversion (userId, sourceCurrency, sourceValue,targetCurrency,targetValue,rate,dateTime) VALUES
  (1,'USD', '10,00', 'BRL', '','',''),
  (1,'BRL', '10,00', 'EUR', '','','',
  (1,'EUR', '10,00', 'jpy', '','',''); */