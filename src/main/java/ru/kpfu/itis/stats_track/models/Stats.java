package ru.kpfu.itis.stats_track.models;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Builder
@Getter
@Setter
public class Stats {
    private Date __time;

    private String id;
    private String name;
}
