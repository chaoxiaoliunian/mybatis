import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import sjqi.dao.IUserLIstData;
import sjqi.model.UserData;

/**
 * @ClassName TestUserList
 * @Description TODO：完成批量删除，修改，查询，模糊查询，分页插件。
 * @Author sjqi
 * @Date 18:35 2019/3/22
 * @Version 1.0
 **/
public class TestUserList extends TestInit {
    @Test
    public void testInsertUserList() {
        UserData[] userList = new UserData[]{
                new UserData("欧阳娜娜", "女", 20, "香港一环"),
                new UserData("欧阳娜娜02", "女", 20, "香港一环"),
                new UserData("欧阳娜娜03", "男", 25, "香港一环"),
        };
        init();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //使用的是代理模式，遵循sql声明规范，无需提供实现类。
        IUserLIstData userListDao = sqlSession.getMapper(IUserLIstData.class);
        userListDao.insertUserList(userList);
        sqlSession.commit();
        sqlSession.close();
    }
}
