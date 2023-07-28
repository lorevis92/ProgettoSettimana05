package epicode.ProgettoSettimana05.runners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import epicode.ProgettoSettimana05.configuration.BeanConfiguration;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@Order(2)
public class RunnerUtenti implements CommandLineRunner {
	@Override
	public void run(String... args) throws Exception {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfiguration.class);

		ctx.close();
	}

}
