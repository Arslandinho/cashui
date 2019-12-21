package ru.kpfu.itis.stats_track.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.stats_track.models.Stats;
import ru.kpfu.itis.stats_track.repository.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class BenchmarkService {
    private final StatsRepository statsRepository;

    public Double doBenchmarkOneTable() {
        long start = System.currentTimeMillis();

        int transactionCount = 500000;
        for (int i = 0; i < transactionCount; i++) {
            String imprint = generateId();

            statsRepository.save(generateStatsModelWithRandomData(imprint));
        }
        long stop = System.currentTimeMillis();

        return (double) transactionCount / ((stop - start) / 1000.0);
    }

    private Stats generateStatsModelWithRandomData(String name) {
        ThreadLocalRandom random = ThreadLocalRandom.current();

        return Stats.builder()
                .id(generateId())
                .name(name)
                .build();
    }

    private String generateId() {
        return UUID.randomUUID().toString()
                + UUID.randomUUID().toString()
                + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
    }
}
