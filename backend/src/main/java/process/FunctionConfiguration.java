package process;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import process.dto.Application;
import process.dto.Root;

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

	public String process(Application request) throws JsonProcessingException
	{
		// Do some processing. Return HTTP 200 if OK or return custom error code 500 with error message

		ObjectMapper om = new ObjectMapper();

		Root root = om.readValue(request.getBody(), Root.class);

        return "Hello, World " + root.getEmail();
	}
}
