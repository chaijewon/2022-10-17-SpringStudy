package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.JejuLocationVO;
@Repository
public class JejuDAO {
	@Autowired
    private JejuMapper mapper;
	
	/*@Select("SELECT no,title,poster,num "
			 +"FROM (SELECT no,title,poster,rownum as num "
			 +"FROM (SELECT no,title,poster "
			 +"FROM jejuLocation ORDER BY no ASC)) "
			 +"WHERE num BETWEEN #{start} AND #{end}")*/
	public List<JejuLocationVO> jejuLocationListData(Map map)
	{
		return mapper.jejuLocationListData(map);
	}
	  
	//@Select("SELECT CEIL(COUNT(*)/20.0) FROM jejuLocation")
	public int jejuTotalPage()
	{
		return mapper.jejuTotalPage();
	}
}
