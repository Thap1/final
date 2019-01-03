/**
 * 
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import entity.Candidate;
import utils.ConnectDB;
import utils.DBUtils;

/**
 * @author User
 *
 */
public class CandidateDAL {
    private ConnectDB connectDB;
    private DBUtils dbUtils;

    static Logger log = Logger.getLogger(Candidate.class);

    public List<Candidate> getAllCandidate() {
            connectDB = new ConnectDB();
            dbUtils = new DBUtils();
            Connection conn = connectDB.connect();
            List<Candidate> listCandidates = new ArrayList<>();
            Statement statement = null;
            ResultSet resultSet = null;
            Candidate candidate = null;

            String sql = "select * from Candidate";
            try {
                    statement = conn.createStatement();
                    resultSet = statement.executeQuery(sql);
                    while (resultSet.next()) {
                            int id = resultSet.getInt("fandidateID");
                            String firstName = resultSet.getString("firstName");
                            String lastName = resultSet.getString("LastName");
                            int birthDate = resultSet.getInt("birthDate");
                            String address = resultSet.getString("address");
                            int phone = resultSet.getInt("Phone");
                            String email = resultSet.getString("Email");
                            int candidateType = resultSet.getInt("CandidateType");


                            candidate = new Candidate(id, firstName, lastName, birthDate, address, phone,email, candidateType);
                            listCandidates.add(candidate);

                    }
            } catch (SQLException e) {
                    log.error("Loi hien thi danh sach candidate");
                    e.printStackTrace();
            } finally {
                    dbUtils.closeResultSet(resultSet);
                    dbUtils.closeStatement(statement);
                    dbUtils.closeConnection(conn);
            }
            return listCandidates;

    }

    public Candidate findCandidateByID(int id) {
            connectDB = new ConnectDB();
            dbUtils = new DBUtils();
            Connection conn = connectDB.connect();
            ResultSet resultSet = null;
            Candidate candidate = null;
            PreparedStatement preparedStatement = null;
            String sql = "select CandidateType from Candidate where CandidateID = ?";
            try {
                    preparedStatement = conn.prepareStatement(sql);
                    preparedStatement.setInt(1, id);
                    resultSet = preparedStatement.executeQuery();
                    
                    while (resultSet.next()) {
                            int candidateType = resultSet.getInt("CandidateType");
                            candidate = new Candidate();
                            candidate.setCandidateType(candidateType);
                    }
            } catch (SQLException e) {
                    log.error("Loi tim candidate theo id");
                    e.printStackTrace();
            } finally {
                    dbUtils.closeResultSet(resultSet);
                    dbUtils.closePreparedStatement(preparedStatement);
                    dbUtils.closeConnection(conn);

            }

            return candidate;
    }
}
