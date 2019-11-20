package guru.springframework.spring5webapp;

import guru.springframework.spring5webapp.bootstrap.AuthorMapper;
import guru.springframework.spring5webapp.bootstrap.AuthorResultSetExtractor;
import guru.springframework.spring5webapp.bootstrap.AuthorRowCallback;
import guru.springframework.spring5webapp.model.Author;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

@SpringBootApplication
public class Spring5webappApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Spring5webappApplication.class, args);

		DataSource ds = (DataSource) ctx.getBean("dataSource");

		JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
		List<Author> authorList = jdbcTemplate.query("SELECT * FROM AUTHOR", new AuthorMapper());
		System.out.println("Record count:"+authorList.size());

        AuthorRowCallback authorRowCallback = new AuthorRowCallback();
        jdbcTemplate.query("SELECT * FROM AUTHOR", authorRowCallback);
        System.out.println("id sum:"+authorRowCallback.getId_sum());

        List<Author> authorList2 = jdbcTemplate.query("SELECT * FROM AUTHOR", new AuthorResultSetExtractor());
        System.out.println("Record count:"+authorList2.size());
	}
}
