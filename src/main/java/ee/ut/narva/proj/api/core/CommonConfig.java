package ee.ut.narva.proj.api.core;

import ee.ut.narva.proj.api.service.AllowanceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "application.properties")
public class CommonConfig implements ConfigurationUtil {

    @Bean
    public AllowanceService allowanceService(){
        return new AllowanceService();
    };

}
