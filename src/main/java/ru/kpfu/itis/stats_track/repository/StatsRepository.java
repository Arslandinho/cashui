package ru.kpfu.itis.stats_track.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.stats_track.models.Stats;

@Repository
public interface StatsRepository extends CassandraRepository<Stats, String> {
}
