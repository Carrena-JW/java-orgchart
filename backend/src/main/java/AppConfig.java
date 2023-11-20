import carrena.orgchart.interceptor.ResponseWrapperInterceptor;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.MappedInterceptor;

//작동을 안하네 하
@Configuration
public class AppConfig implements WebMvcConfigurer {

    @Bean
    public MappedInterceptor responseWrapperInterceptor() {
        return new MappedInterceptor(null, new ResponseWrapperInterceptor());
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(responseWrapperInterceptor());
    }
}
