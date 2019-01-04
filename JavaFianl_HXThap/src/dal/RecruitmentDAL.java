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
import entity.Recruitment;

import utils.ConnectDB;
import utils.Constants;




/**
 * @author User
 *
 */
public class RecruitmentDAL {
    static Logger log = Logger.getLogger(RecruitmentDAL.class);
    public List<Recruitment> getAllRecruitment() {
        
        Connection conn = ConnectDB.connect();
        List<Recruitment> listRecruitments = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        Recruitment recruitment = null;
       
        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery(Constants.Recruitment.SELECT_RE);
            while (resultSet.next()) {
                int id = resultSet.getInt("RecruitmentCode");
                String position = resultSet.getString("Position");
                String recruitmentPackage = resultSet.getString("RecruitmentPackage");
                int amount = resultSet.getInt("Amount");
                recruitment = new Recruitment(id, position, recruitmentPackage, amount);
                listRecruitments.add(recruitment);
            }
        } catch (SQLException e) {
            log.error("Loi ko lay duoc list recruitment");
            e.printStackTrace();
        } finally {
        	try {
				conn.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

        }
        return listRecruitments;

    }

    public Recruitment findRecruitmentByID(int id) {
        Connection conn = ConnectDB.connect();
        ResultSet resultSet = null;
        Recruitment recruitment = null;
        PreparedStatement preparedStatement = null;
        
        try {
            preparedStatement = conn.prepareStatement(Constants.Recruitment.SELECT_RE_ID);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                recruitment = new Recruitment();
                recruitment.setRecruimentCode(resultSet.getInt(1));
                recruitment.setPosition(resultSet.getString(2));
                recruitment.setRecruitmentPackage(resultSet.getString(3));
                recruitment.setAmount(resultSet.getInt(4));
            }
        } catch (SQLException e) {
            log.error("Loi ko lay duoc object recruitment");
        } finally {
        	try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

        }
        return recruitment;
    }

    public boolean submitCandidateToRecruitment(Candidate candidate, Recruitment recruitment) {
        Connection conn = ConnectDB.connect();
        PreparedStatement preparedStatement = null;
        int candidateType = candidate.getCandidateType();
        String recruitmentPackageMatching = "";
        if (candidateType == 0) {
            recruitmentPackageMatching = "A";
        } else if (candidateType == 1) {
            recruitmentPackageMatching = "B";
        } else {
            recruitmentPackageMatching = "C";
        }
        if (recruitmentPackageMatching.equals(recruitment.getRecruitmentPackage())) {
            try {
                preparedStatement = conn.prepareStatement(Constants.Recruitment.UP_RE_CODE);
                preparedStatement.setInt(1, recruitment.getAmount() + 1);
                preparedStatement.setInt(2, recruitment.getRecruimentCode());
                preparedStatement.executeUpdate();
                System.out.println("Submitted this candidate succesfully");
                
            } catch (SQLException e) {
                log.error("Loi khi update recruitment");
                e.printStackTrace();
            } finally {
            	try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        } else {
        	System.out.println();
            System.err.println("This candidate is not matching");
        }

        return false;
    }
}
