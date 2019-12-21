CREATE TYPE "continents" AS ENUM (
  'africa',
  'asia',
  'europe',
  'north_america',
  'south_america',
  'australia_oceania'
);

CREATE TABLE "countries" (
  "id" int PRIMARY KEY,
  "name" varchar(32),
  "continent_name" continents
);

CREATE TABLE "clubs" (
  "id" int PRIMARY KEY,
  "name" varchar(64) NOT NULL,
  "created_at" timestamp,
  "country_id" int
);

CREATE TABLE "players" (
  "id" int PRIMARY KEY,
  "full_name" varchar(128) NOT NULL,
  "club_id" int,
  "registered_at" timestamp,
  "country_id" int
);

ALTER TABLE "clubs" ADD FOREIGN KEY ("country_id") REFERENCES "countries" ("id");

ALTER TABLE "players" ADD FOREIGN KEY ("club_id") REFERENCES "clubs" ("id");

ALTER TABLE "players" ADD FOREIGN KEY ("country_id") REFERENCES "countries" ("id");

CREATE TABLE "player_stats" (
 "player_id" int,
 "stats_id" int
);