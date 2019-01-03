/**
 * 
 */
package bll;

import java.util.List;

/**
 * @author User
 *
 */
public interface InterfaceBLL<T> {
    /**
     * Create by: HoangThap - CMC
     * Create date: Jan 3, 2019
     * Modifier: HoangThap
     * Modified date: Jan 3, 2019
     * Description: getListBLL
     * Version 1.0
     * @param sql
     * @return
     */
    List<T> getList(String sql);
    /**
     * Create by: HoangThap - CMC
     * Create date: Jan 3, 2019
     * Modifier: HoangThap
     * Modified date: Jan 3, 2019
     * Description: showInterface
     * Version 1.0
     * @param object
     */
    void show (List<T> object);
    /**
     * Create by: HoangThap - CMC
     * Create date: Jan 3, 2019
     * Modifier: HoangThap
     * Modified date: Jan 3, 2019
     * Description: InsertInterface
     * Version 1.0
     * @param object
     */
    void insert (T object);
}
