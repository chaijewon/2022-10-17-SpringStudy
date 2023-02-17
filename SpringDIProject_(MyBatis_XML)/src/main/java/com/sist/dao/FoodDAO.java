package com.sist.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import java.util.*;
import com.sist.vo.*;
public class FoodDAO extends SqlSessionDaoSupport{
	/*
	 *    <select id="foodListData" resultType="FoodVO">
		    SELECT fno,name,type,rownum
		    FROM (SELECT fno,name,type FROM food_location ORDER BY fno ASC)
		    WHERE <![CDATA[
		          rownum<=30
		    ]]>
		  </select>
		  
		  MyBatis 
		  Map
		  map.put("foodListData","SELECT fno,name,type,rownum
		    FROM (SELECT fno,name,type FROM food_location ORDER BY fno ASC)
		    WHERE <![CDATA[
		          rownum<=30
		    ]]>")
		    map.put("foodListData","SELECT fno,name,type,rownum
		    FROM (SELECT fno,name,type FROM food_location ORDER BY fno ASC)
		    WHERE <![CDATA[
		          rownum<=30
		    ]]>")
		    ==> id가 중복되면 오류
	 */
    public List<FoodVO> foodListData()
    {
    	return getSqlSession().selectList("foodListData");
    }
}
