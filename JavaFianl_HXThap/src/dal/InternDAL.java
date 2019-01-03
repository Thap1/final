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

import entity.InternCandidate;
import utils.ConnectDB;


/**
 * @author User
 *  InternDAL
 */
public class InternDAL implements InterfaceDAL<InternCandidate>{
    
    static Logger log = Logger.getLogger(InternDAL.class);
    /* (non-Javadoc)
     * @see dal.InterfaceDAL#getList(java.lang.String)
     */
    @Override
    public List<InternCandidate> getList(String sql) {
        List<InternCandidate> list = new ArrayList<InternCandidate>();
        Connection cnn = ConnectDB.connect();
        try {
            Statement stm = cnn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                InternCandidate inc = new InternCandidate();
                inc.setCandidateID(rs.getInt("candidateID"));
                inc.setFirstName(rs.getString("firstName"));
                inc.setLastName(rs.getString("lastName"));
                inc.setBirthDate(rs.getInt("birthDate"));
                inc.setAddress(rs.getString("address"));
                inc.setPhone(rs.getInt("phone"));
                inc.setEmail(rs.getString("email"));
                inc.setCandidateType(rs.getInt("candidateType"));
                inc.setMajors(rs.getString("majors"));
                inc.setSemester(rs.getString("semester"));
                inc.setUniversityName(rs.getString("universityName"));
                list.add(inc);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            log.error("Loi getList InternDAL ..");
        }
        return list;
    }

    /* (non-Javadoc)
     * @see dal.InterfaceDAL#show(java.util.List)
     */
    @Override
    public void show(List<InternCandidate> object) {
        for (InternCandidate internCandidate : object) {
            System.out.println(internCandidate);
        }
    }

    /* (non-Javadoc)
     * @see dal.InterfaceDAL#insert(java.lang.Object)
     */
    @Override
    public boolean insert(InternCandidate object) {
        Connection cnn = ConnectDB.connect();
        String sql = "INSERT INTO `nhansu`.`candidate` (`candidateID`, `firstName`, `lastName`, `birthDate`, `address`, `phone`, `email`, `candidateType`, `majors`, `semester`, `universityName`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pre = cnn.prepareStatement(sql);

            pre.setInt(1, object.getCandidateID());
            pre.setString(2, object.getFirstName());
            pre.setString(3, object.getLastName());
            pre.setInt(4, object.getBirthDate());
            pre.setString(5, object.getAddress());
            pre.setInt(6, object.getPhone());
            pre.setString(7, object.getEmail());
            pre.setInt(8, object.getCandidateType());
            pre.setString(9, object.getMajors());
            pre.setString(10, object.getSemester());
            pre.setString(11, object.getUniversityName());
            pre.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            log.error("Loi Insert InternDAL ..");
        }
        finally {
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
