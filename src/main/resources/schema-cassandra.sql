create keyspace if not exists stats_track
with replication = {'class': 'SimpleStrategy', 'replication_factor': 1}
and durable_writes = true;

CREATE TABLE  "stats" (
	"id" TEXT PRIMARY KEY,
	"name" TEXT NOT NULL
);