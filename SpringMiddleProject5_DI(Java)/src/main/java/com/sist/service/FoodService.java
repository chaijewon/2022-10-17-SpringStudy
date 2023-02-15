package com.sist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
// DAO여러개를 통합 (BI)
// 99.9% => DAO VS Service의 차이점  => SI/SM

import com.sist.mapper.CategoryMapper;
import com.sist.mapper.FoodMapper;
import com.sist.vo.CategoryVO;
import com.sist.vo.FoodVO;
@Service
public class FoodService {
	@Autowired
    private FoodMapper fMapper;
	@Autowired
    private CategoryMapper gMapper;
	
	public List<CategoryVO> categoryListData()
	{
		return gMapper.categoryListData();
	}
	
	public List<FoodVO> foodListData(int cno)
	{
		return fMapper.foodListData(cno);
	}
	
	
}
