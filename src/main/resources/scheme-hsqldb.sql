CREATE TABLE JOURNAL (
  ID INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  FOOD_NAME VARCHAR(256),
  FOOD_UNIT VARCHAR(256),
  NUTRITION_TYPE VARCHAR(256),
  FOOD_AMOUNT DECIMAL(10,2),
  USER_ID INTEGER,
  INTAKE_DATE TIMESTAMP
);