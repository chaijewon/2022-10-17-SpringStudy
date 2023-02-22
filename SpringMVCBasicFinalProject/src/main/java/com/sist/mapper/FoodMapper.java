package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface FoodMapper {
  @Select({
	  "<script>"
	  +"SELECT cno,title,poster,subject "
	  +"FROM project_category "
	  +"WHERE "
	  +"<if test='cno==1'>"
	  +"cno BETWEEN 1 AND 12"
	  +"</if>"
	  +"<if test='cno==2'>"
	  +"cno BETWEEN 13 AND 18"
	  +"</if>"
	  +"<if test='cno==3'>"
	  +"cno BETWEEN 19 AND 30"
	  +"</if>"
	  +"</script>"
  })
  public List<CategoryVO> categoryListData(Map map);
  // 카테고리별 목록 출력 
  @Select("SELECT fno,name,poster,address,tel,type,score "
		 +"FROM project_food "
		 +"WHERE cno=#{cno}")
  public List<FoodVO> foodListData(int cno);
	  
  @Select("SELECT title,subject FROM project_category "
		 +"WHERE cno=#{cno}")
  public CategoryVO categoryInfoData(int cno);
  
  //  상세보기 
  @Select("SELECT * FROM project_food "
		 +"WHERE fno=#{fno}")
  public FoodVO foodDetailData(int fno);
}
