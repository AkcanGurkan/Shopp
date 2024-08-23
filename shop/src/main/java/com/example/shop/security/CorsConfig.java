import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Tüm endpointler için CORS'u etkinleştir
                .allowedOrigins("http://localhost:4200") // İzin verilen frontend origin
                .allowedMethods("GET", "POST", "PUT", "DELETE") // İzin verilen HTTP metodları
                .allowedHeaders("*"); // İzin verilen HTTP başlıkları
    }
}