package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.FoodVO;
import com.sist.vo.SeoulLocationVO;
@Repository
public class SeoulDAO {
    @Autowired
	private SeoulMapper mapper;
    
    /*@Select("SELECT no,title,poster,num "
			 +"FROM (SELECT no,title,poster,rownum as num "
			 +"FROM (SELECT no,title,poster "
			 +"FROM seoul_location ORDER BY no ASC)) "
			 +"WHERE num BETWEEN #{start} AND #{end}")*/
	  public List<SeoulLocationVO> seoulLocationListData(Map map)
	  {
		  return mapper.seoulLocationListData(map);
	  }
	  
	  //@Select("SELECT CEIL(COUNT(*)/20.0) FROM seoul_location")
	  public int seoulTotalPage()
	  {
		  return mapper.seoulTotalPage();
	  }
	  
	  //@Select("SELECT * FROM seoul_location WHERE no=#{no}")
	  public SeoulLocationVO seoulDetailData(int no)
	  {
		  return mapper.seoulDetailData(no);
	  }
	  
	  /*@Select("SELECT no,title,poster,score,rownum "
			 +"FROM food_location "
			 +"WHERE rownum<=4 AND address LIKE '%'||#{addr}||'%'")*/
	  public List<FoodVO> seoulFoodData(Map map)
	  {
		  return mapper.seoulFoodData(map);
	  }
   
}
