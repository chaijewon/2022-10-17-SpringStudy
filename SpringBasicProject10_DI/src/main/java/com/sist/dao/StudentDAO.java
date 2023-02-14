package com.sist.dao;
import java.util.*;

import org.mybatis.spring.support.SqlSessionDaoSupport;
public class StudentDAO extends SqlSessionDaoSupport{
   // 1. 데이터 추가 
	/*
	 *     <insert id="studentInsert" parameterType="StudentVO">
		     <!-- sequence -->
		     <selectKey keyProperty="hakbun" resultType="int" order="BEFORE">
		       SELECT NVL(MAX(hakbun)+1,1) as hakbun FROM student
		     </selectKey>
		     INSERT INTO student VALUES(#{hakbun},#{name},#{kor},#{eng},#{math})
		     <!-- 
		          ${id} request.getAttribute("id")
		          #{name} = vo.getName() 
		          #{eng}  = vo.getEng()
		      -->
		   </insert>
		   
		   map.put("studentInsert", INSERT INTO student VALUES(#{hakbun},#{name},#{kor},#{eng},#{math}))
	 */
   public void studentInsert(StudentVO vo)
   {
	   getSqlSession().insert("studentInsert",vo);
   }
   /*
    *   <!-- 데이터 목록 -->
		   <select id="studentListData" resultType="StudentVO">
		    <include refid="select-data"/>
		   </select>
    */
   public List<StudentVO> studentListData()
   {
	   return getSqlSession().selectList("studentListData");
   }
   
   /*
    *   <select id="studentDetailData" resultType="StudentVO" parameterType="int">
		    <include refid="select-data"/>
		    WHERE hakbun=#{hakbun}
		   </select>
    */
   public StudentVO studentDetailData(int hakbun)
   {
	   return getSqlSession().selectOne("studentDetailData", hakbun);
   }
   
   /*
    *   <update id="studentUpdate" parameterType="StudentVO">
	     UPDATE student SET
	     kor=#{kor},eng=#{eng},math=#{math}
	     WHERE hakbun=#{hakbun}
	   </update>
    */
   public void studentUpdate(StudentVO vo)
   {
	   getSqlSession().update("studentUpdate",vo);
   }
   /*
    *   <delete id="studentDelete" parameterType="int">
	     DELETE FROM student
	     WHERE hakbun=#{hakbun}
	   </delete>
    */
   public void studentDelete(int hakbun)
   {
	   getSqlSession().delete("studentDelete",hakbun);
   }
}
