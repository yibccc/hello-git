package mybatistest;

import POJO.Brand;
import mapper.BrandMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisTest {
    @Test
    public void Testadd() throws IOException {

        int status = 1;
        String companyName = "aa";
        String brandName = "aa";
        String description = "aaaaaa";
        int order = 100;

        Brand aa = new Brand();
        aa.setBrandName(brandName);
        aa.setCompanyName(companyName);
        aa.setDescription(description);
        aa.setOrdered(order);
        aa.setStatus(status);



//        companyName = "%" + companyName + "%";
//        brandName = "%" + brandName + "%";

//        Map map = new HashMap();
//        map.put("status",status);
//        map.put("companyName",companyName);
//        map.put("brandName",brandName);

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

//        List<Brand> brands = mapper.selectByCondition(map);

//        System.out.println(brands);
        brandMapper.add(aa);
        Integer id = aa.getId();
        System.out.println(id);

        sqlSession.commit();

        sqlSession.close();
    }
}
