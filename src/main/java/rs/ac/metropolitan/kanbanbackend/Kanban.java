package rs.ac.metropolitan.kanbanbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import rs.ac.metropolitan.kanbanbackend.entity.data.Locale;

import java.time.ZoneId;
import java.util.TimeZone;

@SpringBootApplication()
public class Kanban {

    public static void main(String[] args) {
        SpringApplication.run(Kanban.class, args);
    }

}
