package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Bean
    String database() {
        return "hello";
    }

    @Override
    public void run(String... strings) throws Exception {

        /*
String commands
String cleanTable = "DROP TABLE customers IF EXISTS";
String createTable = "CREATE TABLE customers(id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))";
String getIds = "SELECT id, first_name, last_name FROM customers WHERE first_name = ?";

log.info("Creating tables");

jdbcTemplate.execute(cleanTable);
jdbcTemplate.execute(createTable);

// Split up the array of whole names into an array of first/last names
List<Object[]> splitUpNames = Arrays.asList("hits/forwards blah", "Jeff Dean", "Josh Bloch", "Josh Long").stream()
.map(name -> name.split(" "))
.collect(Collectors.toList());

// Use a Java 8 stream to print out each tuple of the list
splitUpNames.forEach(name -> log.info(String.format("Inserting customer record for %s %s", name[0], name[1])));

// Uses JdbcTemplate's batchUpdate operation to bulk load data
jdbcTemplate.batchUpdate("INSERT INTO customers(first_name, last_name) VALUES (?,?)", splitUpNames);

log.info("Querying for customer records where first_name = 'Josh':");
jdbcTemplate.query(
getIds, new Object[] { "Josh" },
(rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"))
).forEach(customer -> log.info(customer.toString()));
*/
    }
}