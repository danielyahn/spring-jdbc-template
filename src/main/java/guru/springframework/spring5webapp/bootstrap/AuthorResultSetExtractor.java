package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorResultSetExtractor implements ResultSetExtractor<List<Author>> {
    @Override
    public List<Author> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        List<Author> authorList = new ArrayList<Author>();
        while(resultSet.next()) {
            Author author = new Author();
            author.setId(resultSet.getLong("id"));
            author.setFirstName(resultSet.getString("first_name"));
            author.setLastName(resultSet.getString("last_name"));

            authorList.add(author);
        }
        return authorList;
    }
}
