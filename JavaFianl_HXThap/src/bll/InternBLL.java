/**
 * 
 */
package bll;

import java.util.List;

import dal.InternDAL;
import entity.InternCandidate;

/**
 * @author User
 *
 */
public class InternBLL implements InterfaceBLL<InternCandidate>{

    private InternDAL internDAL;

    public InternBLL() {
        internDAL = new InternDAL();
    }
    @Override
    public List<InternCandidate> getList(String sql) {
        // TODO Auto-generated method stub
        return internDAL.getList(sql);
    }

    /* (non-Javadoc)
     * @see bll.InterfaceBLL#show(java.util.List)
     */
    @Override
    public void show(List<InternCandidate> object) {
        internDAL.show(object);
    }

    /* (non-Javadoc)
     * @see bll.InterfaceBLL#insert(java.lang.Object)
     */
    @Override
    public void insert(InternCandidate object) {
        internDAL.insert(object);
    }

}
