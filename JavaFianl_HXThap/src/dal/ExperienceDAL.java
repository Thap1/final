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

import entity.ExperienceCandidate;
import utils.ConnectDB;
import utils.Constants;


/**
 * @author User
 *  ExperienceDAL
 */
public class ExperienceDAL implements InterfaceDAL<ExperienceCandidate> {

    static Logger log = Logger.getLogger(ExperienceDAL.class);
    /* (non-Javadoc)
     * @see dal.InterfaceDAL#getList(java.lang.String)
     */
    @Override
    public List<ExperienceCandidate> getList(String sql) {
        List<ExperienceCandidate> list = new ArrayList<ExperienceCandidate>();
        Connection cnn = ConnectDB.connect();
        try {
            Statement stm = cnn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                ExperienceCandidate ex = new ExperienceCandidate();
                ex.setCandidateID(rs.getInt("candidateID"));
                ex.setFirstName(rs.getString("firstName"));
                ex.setLastName(rs.getString("lastName"));
                ex.setBirthDate(rs.getInt("birthDate"));
                ex.setAddress(rs.getString("address"));
                ex.setPhone(rs.getInt("phone"));
                ex.setEmail(rs.getString("email"));
                ex.setCandidateType(rs.getInt("candidateType"));
                ex.setExpInYear(rs.getInt("expInYear"));
                ex.setProSkill(rs.getString("proSkill"));
                list.add(ex);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            log.error(" Loi getList ExerienceDAL...! ");
        }
        return list;
    }

    /* (non-Javadoc)
     * @see dal.InterfaceDAL#show(java.util.List)
     */
    @Override
    public void show(List<ExperienceCandidate> object) {
        for (ExperienceCandidate experienceCandidate : object) {
            System.out.println(experienceCandidate);
        }
    }

    /* (non-Javadoc)
     * @see dal.InterfaceDAL#insert(java.lang.Object)
     */
    @Override
    public boolean insert(ExperienceCandidate object) {
        Connection cnn = ConnectDB.connect();
           
        try {
            PreparedStatement prs = cnn.prepareStatement(Constants.ExperienceCandidate.INSERT_EXP);
            prs.setInt(1, object.getCandidateID());
            prs.setString(2, object.getFirstName());
            prs.setString(3, object.getLastName());
            prs.setInt(4, object.getBirthDate());
            prs.setString(5, object.getAddress());
            prs.setInt(6, object.getPhone());
            prs.setString(7, object.getEmail());
            prs.setInt(8, object.getCandidateType());
            prs.setInt(9, object.getExpInYear());
            prs.setString(10, object.getProSkill());
            
            prs.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            log.error(" Loi insert ExerienceDAL...! ");
        }finally {
            try {
                cnn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return true;
    }

}
