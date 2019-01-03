/**
 * 
 */
package bll;

import java.util.List;

import dal.FresherDAL;
import entity.FresherCandidate;

/**
 * @author User
 *
 */
public class FresherBLL implements InterfaceBLL<FresherCandidate>{

    private FresherDAL fresherDAL;

    public FresherBLL() {
       fresherDAL = new FresherDAL();
    }
    @Override
    public List<FresherCandidate> getList(String sql) {
        // TODO Auto-generated method stub
        return fresherDAL.getList(sql);
    }

    @Override
    public void show(List<FresherCandidate> object) {
       fresherDAL.show(object);
    }

    /* (non-Javadoc)
     * @see bll.InterfaceBLL#insert(java.lang.Object)
     */
    @Override
    public void insert(FresherCandidate object) {
        fresherDAL.insert(object);
    }

}
