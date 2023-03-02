package com.sist.mapper;
import com.sist.vo.*;
import java.util.*;

import org.apache.ibatis.annotations.Select;
public interface FoodMapper {
  @Select("SELECT cno,title,poster,subject FROM project_category")
  public List<CategoryVO> categoryListData();
  @Select("SELECT fno,cno,name,tel,address,type,poster "
		 +"FROM project_food "
		 +"WHERE cno=#{cno}")
  public List<FoodVO> foodListData(int cno);
}
