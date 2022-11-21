package spo.ifsp.edu.br.juntossomosmaischallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import spo.ifsp.edu.br.juntossomosmaischallenge.infra.CsvUserHttpClient;

@SpringBootApplication
@EnableAutoConfiguration
public class JuntossomosmaischallengeApplication {

	public static void main(String[] args) throws Exception {
		CsvUserHttpClient client = new CsvUserHttpClient();

		client.getUsers();

		SpringApplication.run(JuntossomosmaischallengeApplication.class, args);
	}

}
