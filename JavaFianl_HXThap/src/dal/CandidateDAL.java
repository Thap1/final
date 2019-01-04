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
import utils.Constants;


/**
 * @author User
 *CandidateDAL
 */
public class CandidateDAL {
    static Logger log = Logger.getLogger(Candidate.class);

    /**
     * Create by: HoangThap - CMC
     * Create date: Jan 4, 2019
     * Modifier: HoangThap
     * Modified date: Jan 4, 2019
     * Description: getAllCandidate
     * Version 1.0
     * @return
     */
    public List<Candidate> getAllCandidate() {
            new ConnectDB();
      
            Connection conn = ConnectDB.connect();
            List<Candidate> listCandidates = new ArrayList<>();
            Statement statement = null;
            ResultSet resultSet = null;
            Candidate candidate = null;

            try {
                    statement = conn.createStatement();
                    resultSet = statement.executeQuery(Constants.Candidate.SHOW_ALL_CAN);
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
                    try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            }
            return listCandidates;

    }

    /**
     * Create by: HoangThap - CMC
     * Create date: Jan 4, 2019
     * Modifier: HoangThap
     * Modified date: Jan 4, 2019
     * Description: findCandidateByID
     * Version 1.0
     * @param id
     * @return
     */
    public Candidate findCandidateByID(int id) {
            new ConnectDB();
            
            Connection conn = ConnectDB.connect();
            ResultSet resultSet = null;
            Candidate candidate = null;
            PreparedStatement preparedStatement = null;
           
            try {
                    preparedStatement = conn.prepareStatement(Constants.Candidate.SHOW_CAN_ID);
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
                   try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

            }

            return candidate;
    }
}
