package sjqi.api;

import sjqi.model.UserData;

/**
 * @ClassName IUserDataDao
 * @Description 完成一个用户的增删改查功能
 * @Author sjqi
 * @Date 19:58 2019/3/21
 * @Version 1.0
 **/
public interface IUserDataDao {
    /**
     * 插入一个用户
     *
     * @param userData
     * @return
     */
    int insertOne(UserData userData);

    /**
     * 修改一个用户
     *
     * @param userData
     * @return
     */
    int modifyUser(UserData userData);

    /**
     * 删除一个用户
     *
     * @param id
     * @return
     */
    int deleteUser(int id);

    /**
     * 查询一个用户
     *
     * @param id
     * @return
     */
    int selectOne(int id);

}
