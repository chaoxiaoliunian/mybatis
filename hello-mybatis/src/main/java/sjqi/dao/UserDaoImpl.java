package sjqi.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import sjqi.model.UserData;

/**
 * @ClassName UserDaoImpl
 * @Description 单个用户dao接口操作的实现类
 * @Author sjqi
 * @Date 11:24 2019/3/22
 * @Version 1.0
 **/
public class UserDaoImpl implements IUserDataDao {
    private SqlSessionFactory sqlSessionFactory;

    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public int insertOne(UserData userData) {
        //插入一个用户，并返回id

        SqlSession sqlSession = sqlSessionFactory.openSession();
        //result 1：操作成功 0:操作不成功
        int result = sqlSession.insert("user.insertOne", userData);
        sqlSession.commit();
        sqlSession.close();
        //xml 中配置了selectKey属性，会将数据库中的id存入java对象中。
        return userData.getId();
    }

    public int modifyUser(UserData userData) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int resultId = sqlSession.update("user.updateOne", userData);
        sqlSession.commit();
        sqlSession.close();
        return resultId;
    }

    public int deleteUser(int id) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        int num=sqlSession.delete("user.deleteOne",id);
        sqlSession.commit();
        sqlSession.close();
        return num;
    }

    public UserData selectOne(int id) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        UserData userData=sqlSession.selectOne("user.findOne",id);
        sqlSession.close();
        return userData;
    }
}
