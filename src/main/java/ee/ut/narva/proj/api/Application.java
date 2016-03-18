package ee.ut.narva.proj.api;

//import ee.ut.narva.proj.api.service.SeedDataService;
import ee.ut.narva.proj.api.service.SeedDataService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        ConfigurableApplicationContext context = app.run(args);
        SeedDataService seedDataService = context.getBean(SeedDataService.class);
        seedDataService.populateSeedData();
    }
}
