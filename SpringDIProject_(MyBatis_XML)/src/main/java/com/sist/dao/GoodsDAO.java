package com.sist.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
/*
 *   <select id="goodsListData" resultType="GoodsVO">
   SELECT no,name,price,rownum
   FROM (SELECT no,goods_name as name,goods_price as price FROM goods_all ORDER BY no ASC)
   WHERE rownum&lt;=30
  </select>
 */
import java.util.*;
import com.sist.vo.*;
public class GoodsDAO extends SqlSessionDaoSupport{
   public List<GoodsVO> goodsListData()
   {
	   return getSqlSession().selectList("goodsListData");//no mappered
   }
}
