package ru.kpfu.itis.stats_track;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.kpfu.itis.stats_track.models.Stats;
import ru.kpfu.itis.stats_track.service.BenchmarkService;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class StatsTrackApplication implements CommandLineRunner {

    @Autowired
    private BenchmarkService benchmarkService;

    public static void main(String[] args) {
        SpringApplication.run(StatsTrackApplication.class, args);
    }

    @Override
    public void run(String... args) {
//        Double tps = benchmarkService.doBenchmarkOneTable();
//
//        String filename = "cassandra" + new Date().getTime() + ".txt";
//        try (FileWriter writer = new FileWriter(filename, false)) {
//            writer.write(tps.toString());
//
//            writer.flush();
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }
//
//        System.out.println(tps);

        String filename = "druid" + new Date().getTime() + ".json";

        System.out.println("generate");
        List<Stats> data = benchmarkService.generateData();
        System.out.println("generated");
        try (FileWriter writer = new FileWriter(filename, false)) {
            for (Stats stats : data) {
                writer.write(new ObjectMapper().writeValueAsString(stats));
                writer.write(System.lineSeparator());
            }
            System.out.println("write");

            writer.flush();
            System.out.println("written");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
