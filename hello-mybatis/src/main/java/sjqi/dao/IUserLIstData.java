package sjqi.dao;

import sjqi.model.UserData;

import java.util.List;

/**
 * @ClassName IUserLIstData
 * @Description 用户的批量操作接口
 * @Author sjqi
 * @Date 16:41 2019/3/22
 * @Version 1.0
 **/
public interface IUserLIstData {
    void insertUserList(UserData[] userList);

    void deleteByIdList(int[] idList);

    void updateByIdList(int[] idList);

    List<UserData> findAddrLike(String addr);

}
