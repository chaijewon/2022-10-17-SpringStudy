package com.sist.dao;
import com.sist.vo.*;
import com.sist.mapper.*;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class FoodDAO {
   @Autowired
   private FoodMapper mapper;
   
   //@Select("SELECT cno,title,poster,subject FROM project_category")
   public List<CategoryVO> categoryListData()
   {
	   return mapper.categoryListData();
   }
   
   /*@Select("SELECT fno,cno,name,tel,address,type,poster "
			 +"FROM project_food "
			 +"WHERE cno=#{cno}")*/
   public List<FoodVO> foodListData(int cno)
   {
	   return mapper.foodListData(cno);
   }
}
