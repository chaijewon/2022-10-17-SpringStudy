package com.sist.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import java.util.*;
public class EmpDAO extends SqlSessionDaoSupport{
   /*
    *  <select id="empListData" resultType="EmpVO">
		    SELECT empno,ename,job 
		    FROM emp
		  </select>
    */
	public List<EmpVO> empListData()
	{
		return getSqlSession().selectList("empListData");
	}
	public EmpVO empDetailData(int empno)
	{
		return getSqlSession().selectOne("empDetailData",empno);
	}
}
