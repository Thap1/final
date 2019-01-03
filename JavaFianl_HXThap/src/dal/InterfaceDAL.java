/**
 * 
 */
package dal;

import java.util.List;

/**
 * @author User
 *
 */
public interface InterfaceDAL<T> {
    /**
     * Create by: HoangThap - CMC
     * Create date: Jan 3, 2019
     * Modifier: HoangThap
     * Modified date: Jan 3, 2019
     * Description: getList InterFace
     * Version 1.0
     * @param sql
     * @return
     */
    public List<T> getList (String sql);
    /**
     * Create by: HoangThap - CMC
     * Create date: Jan 3, 2019
     * Modifier: HoangThap
     * Modified date: Jan 3, 2019
     * Description: show InterFace
     * Version 1.0
     * @param object
     */
    void show (List<T> object);
    /**
     * Create by: HoangThap - CMC
     * Create date: Jan 3, 2019
     * Modifier: HoangThap
     * Modified date: Jan 3, 2019
     * Description: Insert InterFace
     * Version 1.0
     * @param object
     * @return
     */
    boolean insert (T object);
}
