import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName TestInit
 * @Description
 * @Author sjqi
 * @Date 18:34 2019/3/22
 * @Version 1.0
 **/
public abstract class TestInit {
    SqlSessionFactory sqlSessionFactory;

    public void init() {
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        /**
         * build()方法就是读取xml配置文件,将配置信息放入Configuration 文件，使用的DefaultSqlSessionFactory
         */
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
}
