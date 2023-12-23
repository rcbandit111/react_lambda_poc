package process;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import process.dto.Request;

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

	public String process(@RequestBody Request request)
	{
		// Do some processing. Return HTTP 200 if OK or return custom error code 500 with error message

		return "Hello, World " + request.getEmail();
	}
}
