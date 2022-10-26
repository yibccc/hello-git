package mapper;

import POJO.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    List<Brand> selectall();

    Brand selectAllById(int id);

//    List<Brand> selectByCondition(@Param("status") int status,@Param("companyName") String companyName,@Param("brandName") String brandName);
    List<Brand> selectByCondition(Map map);

    void add(Brand brand);

}
