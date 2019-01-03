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
import utils.DBUtils;



/**
 * @author User
 *
 */
public class RecruitmentDAL {
    static Logger log = Logger.getLogger(RecruitmentDAL.class);
    public List<Recruitment> getAllRecruitment() {
        ConnectDB connectDB = new ConnectDB();
        DBUtils dbUtils = null;
        Connection conn = connectDB.connect();
        List<Recruitment> listRecruitments = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        Recruitment recruitment = null;
        String sql = "SELECT * FROM nhansu.recruitment;";
        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sql);
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
            dbUtils.closeResultSet(resultSet);
            dbUtils.closeStatement(statement);
            dbUtils.closeConnection(conn);
        }
        return listRecruitments;

    }

    public Recruitment findRecruitmentByID(int id) {
        ConnectDB connectDB = new ConnectDB();
        DBUtils dbUtils = null;
        Connection conn = connectDB.connect();
        ResultSet resultSet = null;
        Recruitment recruiment = null;
        PreparedStatement preparedStatement = null;
        String sql = "select Amount from Recruitment where RecruitmentCode = ?";
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int amount = resultSet.getInt("Amount");
                recruiment = new Recruitment();
                recruiment.setAmount(amount);
            }
        } catch (SQLException e) {
            log.error("Loi ko lay duoc object recruitment");
        } finally {
            dbUtils.closeResultSet(resultSet);
            dbUtils.closePreparedStatement(preparedStatement);
            dbUtils.closeConnection(conn);
        }
        return recruiment;
    }

    public boolean submitCandidateToRecruitment(Candidate candidate, Recruitment recruitment) {
        ConnectDB connectDB = new ConnectDB();
        DBUtils dbUtils = null;
        Connection conn = connectDB.connect();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
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
            String sql = "update Recruitment set Amount = ? where RecruitmentCode = ?";
            try {
                preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1, recruitment.getAmount() + 1);
                preparedStatement.setInt(2, recruitment.getRecruimentCode());
                preparedStatement.executeUpdate();
                System.err.println("Submitted this candidate succesfully");

            } catch (SQLException e) {
                log.error("Loi khi update recruitment");
                e.printStackTrace();
            } finally {
                dbUtils.closeResultSet(resultSet);
                dbUtils.closePreparedStatement(preparedStatement);
                dbUtils.closeConnection(conn);
            }
        } else {
            System.err.println("This candidate is not matching");
        }

        return false;
    }
}
