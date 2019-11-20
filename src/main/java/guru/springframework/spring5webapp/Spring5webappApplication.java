package guru.springframework.spring5webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
public class Spring5webappApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Spring5webappApplication.class, args);

		DataSource ds = (DataSource) ctx.getBean("dataSource");

		JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
		int result = jdbcTemplate.queryForObject("SELECT count(*) FROM AUTHOR", Integer.class);
		System.out.println("Query Result:"+result);
	}
}
