package process;

import java.util.function.Function;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
public class FunctionConfiguration {

	/*
	 * You need this main method (empty) or explicit <start-class>example.FunctionConfiguration</start-class>
	 * in the POM to ensure boot plug-in makes the correct entry
	 */
	public static void main(String[] args) {
		// empty unless using Custom runtime at which point it should include
		// SpringApplication.run(FunctionConfiguration.class, args);
	}

	@Bean
	public Function<String, String> uppercase() {
		return value -> {
			if (value.equals("exception")) {
				throw new RuntimeException("Intentional exception");
			}
			else {
				return value.toUpperCase();
			}
		};
	}

	@RequestMapping("/")
	public ResponseEntity<?> process(@RequestBody Request request)
	{
		// Do some processing

		String email = request.getEmail();

		return ResponseEntity.ok().build();
	}
}
