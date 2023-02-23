package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.FoodVO;
import com.sist.vo.SeoulLocationVO;

public interface SeoulMapper {
	// 목록 (여행지)
	  @Select("SELECT no,title,poster,num "
			 +"FROM (SELECT no,title,poster,rownum as num "
			 +"FROM (SELECT no,title,poster "
			 +"FROM seoul_location ORDER BY no ASC)) "
			 +"WHERE num BETWEEN #{start} AND #{end}")
	  public List<SeoulLocationVO> seoulLocationListData(Map map);
	  
	  @Select("SELECT CEIL(COUNT(*)/20.0) FROM seoul_location")
	  public int seoulTotalPage();
	  
	  @Select("SELECT * FROM seoul_location WHERE no=#{no}")
	  public SeoulLocationVO seoulDetailData(int no);
	  
	  @Select("SELECT fno,name,poster,score,rownum "
			 +"FROM food_location "
			 +"WHERE rownum<=4 AND address LIKE '%'||#{addr}||'%'")
	  public List<FoodVO> seoulFoodData(Map map);
}
