/**
 * 
 */
package bll;

import java.util.List;

import dal.ExperienceDAL;
import entity.ExperienceCandidate;

/**
 * @author User
 *
 */
public class ExperienceBLL implements InterfaceBLL<ExperienceCandidate> {

    private ExperienceDAL experienceDAL;

    public ExperienceBLL() {
        experienceDAL = new ExperienceDAL();
    }

    @Override
    public List<ExperienceCandidate> getList(String sql) {
        // TODO Auto-generated method stub
        return experienceDAL.getList(sql);
    }

    /*
     * (non-Javadoc)
     * 
     * @see bll.InterfaceBLL#show(java.util.List)
     */
    @Override
    public void show(List<ExperienceCandidate> object) {
        experienceDAL.show(object);
    }

    /*
     * (non-Javadoc)
     * 
     * @see bll.InterfaceBLL#insert(java.lang.Object)
     */
    @Override
    public void insert(ExperienceCandidate object) {
        experienceDAL.insert(object);

    }

}
