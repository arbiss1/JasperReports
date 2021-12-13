package jasper.reports.demo.service;

import java.io.IOException;
import java.sql.SQLException;

import jasper.reports.demo.dao.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;

@Service
public class UserService {
    @Autowired
    private UserDaoImpl userDao;

    public JasperPrint exportPdfFile() throws SQLException, JRException, IOException {
        return userDao.exportPdfFile();
    }


}
