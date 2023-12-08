package emay.paint;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:8080") // Add the origins allowed to make requests
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS"); // Add allowed HTTP methods
    }
}