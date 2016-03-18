package ee.ut.narva.proj.api.core;

import org.springframework.core.env.Environment;

import java.util.Arrays;

interface ConfigurationUtil {
    default Boolean isLiveOrHerokuProfileActive(Environment environment) {
        return Arrays.asList(environment.getActiveProfiles()).stream().filter(x -> "live".equals(x) || "heroku".equals(x)).findFirst().isPresent();
    }
}
