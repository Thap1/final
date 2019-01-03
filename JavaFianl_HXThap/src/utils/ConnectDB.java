/**
 * 
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;



/**
 * @author User
 *
 */
public class ConnectDB {
    static Logger log = Logger.getLogger(ConnectDB.class);
    static final String DIVER = "com.mysql.jdbc.Driver";
    static final String URL = "jdbc:mysql://localhost:3306/nhansu";
    static final String USER_NAME = "root";
    static final String PASSWORD = "hoangthap1";

    public static Connection connect() {
        // load driver
        try {
            Class.forName(DIVER);

        } catch (

        ClassNotFoundException e) {
            e.printStackTrace();
            log.error("Loi Diver ..");
        }
// get connection instance
        Connection cnn = null;
        try {
            cnn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);

        } catch (SQLException e) {
            e.printStackTrace();
            log.error("Loi Ket Noi ..");
        }
        return cnn;
    }

}
