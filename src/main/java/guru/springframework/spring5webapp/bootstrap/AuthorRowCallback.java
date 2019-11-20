package guru.springframework.spring5webapp.bootstrap;

import org.springframework.jdbc.core.RowCallbackHandler;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorRowCallback implements RowCallbackHandler {
    private int id_sum;

    public AuthorRowCallback()
    {
        id_sum=0;
    }

    @Override
    public void processRow(ResultSet resultSet) throws SQLException {
        id_sum += resultSet.getInt("id");
    }

    public int getId_sum() {
        return id_sum;
    }
}
