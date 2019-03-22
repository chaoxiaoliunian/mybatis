import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import sjqi.dao.UserDaoImpl;
import sjqi.model.UserData;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName TestUserDaoImpl
 * @Description TODO maven规范中，单元测试类的包命名必须和被测试类一致吗？junit有相关的约束吗？
 * @Author sjqi
 * @Date 11:45 2019/3/22
 * @Version 1.0
 **/
public class TestUserDaoImpl {
    SqlSessionFactory sqlSessionFactory;

    public void init() {
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testInsertOne() {
        init();
        UserDaoImpl user = new UserDaoImpl(sqlSessionFactory);
        int num=user.insertOne(new UserData("anglerbaby","女",30,"北京二环"));
        System.out.println(num);
    }
    @Test
    public void testDeleteOne(){
        init();
        UserDaoImpl user = new UserDaoImpl(sqlSessionFactory);
        int num=user.deleteUser(1);
        System.out.println(num);
    }
}
