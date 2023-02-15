package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
// 메모리 할당 <bean id="dao">

import com.sist.mapper.SeoulMapper;
import java.util.*;
@Repository("dao")
public class SeoulDAO {
  @Autowired  // 자동 주입 => setter DI
  private SeoulMapper mapper;
  public List<SeoulVO> seoulListData()
  {
	  return mapper.seoulListData();
  }
}
