create TABLE IF NOT EXISTS phones (
  id VARCHAR(36) DEFAULT RANDOM_UUID() PRIMARY KEY,
  technology VARCHAR NOT NULL,
  band_2g BOOL NOT NULL,
  band_3g BOOL NOT NULL,
  band_4g BOOL NOT NULL,
  booked_date DATETIME,
  booked_by VARCHAR
);
