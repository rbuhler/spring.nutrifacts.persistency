package io.github.rbuhler.nutrifactspersistency;

//import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NutrifactsPersistencyApplication {

	public static void main(String[] args) {

		SpringApplication.run(NutrifactsPersistencyApplication.class, args);

/**		// Create the Flyway instance
		Flyway flyway = new Flyway();

		// Point it to the database
		flyway.setDataSource("jdbc:h2:file:./target/nutrifacts", "sa", null);

		// Start the migration
		flyway.migrate();
 **/
	}
}