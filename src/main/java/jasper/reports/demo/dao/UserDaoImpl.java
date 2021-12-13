package jasper.reports.demo.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jasper.reports.demo.domain.Users;
import jasper.reports.demo.usersmapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;


@Transactional
@Repository
public class UserDaoImpl {

    @Autowired
    @Qualifier("jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ResourceLoader resourceLoader;

    public JasperPrint exportPdfFile() throws SQLException, JRException, IOException {
        findInDb();

        Connection conn = jdbcTemplate.getDataSource().getConnection();

        String path = resourceLoader.getResource("classpath:users.jrxml").getURI().getPath();

        JasperReport jasperReport = JasperCompileManager.compileReport(path);

        // Parameters for report
        Map<String, Object> parameters = new HashMap<String, Object>();

        //adding parameter on jasper reports
        parameters.put("user_name","Arbis Malasi");

        JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conn);


        return print;
    }


    public String findInDb(){


        String sql = "SELECT * FROM USER";
        List<Users> users = jdbcTemplate.query(sql, new UserMapper());

       return String.valueOf(users);

    }

}
