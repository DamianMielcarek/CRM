package crm;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.dialect.springdata.SpringDataDialect;

@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/admin").setViewName("admin/panel");
        registry.addViewController("/search").setViewName("search");
        registry.addViewController("/403").setViewName("403");
        registry.addViewController("/logout").setViewName("logout");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

    @Bean
    public SpringDataDialect springDataDialect() {
        return new SpringDataDialect();
    }

}
