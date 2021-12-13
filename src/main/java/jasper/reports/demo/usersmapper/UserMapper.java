package jasper.reports.demo.usersmapper;


import jasper.reports.demo.domain.Users;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<Users> {

    public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
        Users user = new Users();
        user.setId(rs.getLong("USER_ID"));
        user.setFullName(rs.getString("USER_NAME"));
        user.setEmail(rs.getString("EMAIL"));
        return user;
    }
}

