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

import entity.FresherCandidate;
import utils.ConnectDB;



/**
 * @author User
 *FresherDAL
 */
public class FresherDAL implements InterfaceDAL<FresherCandidate> {

    static Logger log = Logger.getLogger(FresherDAL.class);
    /* (non-Javadoc)
     * @see dal.InterfaceDAL#getList(java.lang.String)
     */
    @Override
    public List<FresherCandidate> getList(String sql) {
        List<FresherCandidate> list = new ArrayList<FresherCandidate>();
        Connection cnn = ConnectDB.connect();
        try {
            Statement stm = cnn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                FresherCandidate fres = new FresherCandidate();
                fres.setCandidateID(rs.getInt("candidateID"));
                fres.setFirstName(rs.getString("firstName"));
                fres.setLastName(rs.getString("lastName"));
                fres.setBirthDate(rs.getInt("birthDate"));
                fres.setAddress(rs.getString("address"));
                fres.setPhone(rs.getInt("phone"));
                fres.setEmail(rs.getString("email"));
                fres.setCandidateType(rs.getInt("candidateType"));
                fres.setGraduationDate(rs.getString("graduationDate"));
                fres.setGraduationRank(rs.getString("graduationRank"));
                fres.setEducation(rs.getString("education"));
                list.add(fres);
                
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            log.error("Loi getList FresherDAL..! ");
        }
        return list;
    }

    /* (non-Javadoc)
     * @see dal.InterfaceDAL#show(java.util.List)
     */
    @Override
    public void show(List<FresherCandidate> object) {
        for (FresherCandidate fre : object) {
            System.out.println(fre);
        }
    }

    /* (non-Javadoc)
     * @see dal.InterfaceDAL#insert(java.lang.Object)
     */
    @Override
    public boolean insert(FresherCandidate object) {
Connection cnn = ConnectDB.connect();
        
        String sql = "INSERT INTO `nhansu`.`candidate` (`candidateID`, `firstName`, `lastName`, `birthDate`, `address`, `phone`, `email`, `candidateType`, `graduationDate`, `graduationRank`, `education`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement prepared = cnn.prepareStatement(sql);
            prepared.setInt(1, object.getCandidateID());
            prepared.setString(2, object.getFirstName());
            prepared.setString(3, object.getLastName());
            prepared.setInt(4, object.getBirthDate());
            prepared.setString(5, object.getAddress());
            prepared.setInt(6, object.getPhone());
            prepared.setString(7, object.getEmail());
            prepared.setInt(8, object.getCandidateType());
            prepared.setString(9, object.getGraduationDate());
            prepared.setString(10, object.getGraduationRank());
            prepared.setString(11, object.getEducation());
            
            prepared.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            log.error("Loi insert FresherDAL..! ");
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
