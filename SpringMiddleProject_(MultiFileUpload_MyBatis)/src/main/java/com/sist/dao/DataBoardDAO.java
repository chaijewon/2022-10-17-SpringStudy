package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;

@Repository
public class DataBoardDAO {
   @Autowired
   private DataBoardMapper mapper;
   
       /*@Select("SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit,filecount,num "
			  +"FROM (SELECT no,subject,name,regdate,hit,filecount,rownum as num "
			  +"FROM (SELECT /*+ INDEX_DESC(spring_databoard sd_no_pk)no,subject,name,regdate,hit,filecount "
			  +"FROM spring_databoard)) "
			  +"WHERE num BETWEEN #{start} AND #{end}")*/
	   public List<DataBoardVO> databoardListData(Map map)
	   {
		   return mapper.databoardListData(map);
	   }
	   
	   //@Select("SELECT CEIL(COUNT(*)/10.0) FROM spring_databoard")
	   public int databoardTotalPage()
	   {
		   return mapper.databoardTotalPage();
	   }
	   
	   //2.추가 
	   //Sequence
	   /*@SelectKey(keyProperty = "no",resultType = int.class, before = true,
			      statement = "SELECT NVL(MAX(no)+1,1) as no FROM spring_databoard")
	   
	   @Insert("INSERT INTO spring_databoard(no,name,subject,content,pwd,filename,filesize,filecount) "
			  +"VALUES(#{no},#{name},#{subject},#{content},#{pwd},#{filename},#{filesize},#{filecount})")*/
	   public void databoardInsert(DataBoardVO vo)
	   {
		   mapper.databoardInsert(vo);
	   }
}
