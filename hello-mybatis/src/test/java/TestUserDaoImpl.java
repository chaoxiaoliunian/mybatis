import org.junit.Test;
import sjqi.dao.UserDaoImpl;
import sjqi.model.UserData;

/**
 * @ClassName TestUserDaoImpl
 * @Description TODO 1.maven规范中，单元测试类的包命名必须和被测试类一致吗？junit有相关的约束吗？
 * @Author sjqi
 * @Date 11:45 2019/3/22
 * @Version 1.0
 **/
public class TestUserDaoImpl extends TestInit {
    @Test
    public void testInsertOne() {
        init();
        UserDaoImpl user = new UserDaoImpl(sqlSessionFactory);
        //TODO: 编写随机产生姓名，性别，年龄，地址的函数。
        int num = user.insertOne(new UserData("黄晓明03", "男", 30, "北京二环"));
        System.out.println(num);
    }

    @Test
    public void testDeleteOne() {
        init();
        UserDaoImpl user = new UserDaoImpl(sqlSessionFactory);
        int num = user.deleteUser(1);
        System.out.println(num);
    }

    @Test
    public void testUpdateOne() {
        init();
        UserDaoImpl user = new UserDaoImpl(sqlSessionFactory);
        int num = user.modifyUser(new UserData(3, "黄晓明小时候", "男", 29, "北京"));
        System.out.println(num);
    }

    @Test
    public void testFindOne() {
        init();
        UserDaoImpl user = new UserDaoImpl(sqlSessionFactory);
        UserData userData = user.selectOne(3);
        System.out.println(userData);
    }
}
