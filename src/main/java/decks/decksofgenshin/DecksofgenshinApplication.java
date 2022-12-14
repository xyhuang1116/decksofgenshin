package decks.decksofgenshin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@SpringBootApplication
public class DecksofgenshinApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(DecksofgenshinApplication.class, args);
	}

	@Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("home");
    }
}
