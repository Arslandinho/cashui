package ru.kpfu.itis.stats_track.models;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Data
@Builder
@Table
public class Stats {

    @PrimaryKey
    private String id;
    private String name;
}
