package eg.com.vois;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableConfigurationProperties({
})
@ComponentScan(value="eg.com.vois")
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

}
