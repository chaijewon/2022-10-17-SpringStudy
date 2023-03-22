package com.sist.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.web.dao.*;
import com.sist.web.entity.*;
@RestController
@RequestMapping("food/")
@CrossOrigin("http://localhost:3000")
public class FoodRestController {
    @Autowired
    private FoodLocationDAO fDao;
    @Autowired
    private CategoryDAO cDao;
    @Autowired
    private FoodDAO dao;
    
    @GetMapping(value = "category_react")
    public List<CategoryEntity> categoryChangeData(int cno)
    {
    	int start=0,end=0;
    	if(cno==1)
    	{
    		start=1;
    		end=12;
    	}
    	else if(cno==2)
    	{
    		start=13;
    		end=18;
    	}
    	else if(cno==3)
    	{
    		start=19;
    		end=30;
    	}
    	List<CategoryEntity> list=cDao.categoryChangeData(start, end);//[{},{}]
    	return list;
    }
    
    @GetMapping(value = "location_react")
    public List<FoodLocationEntity> foodLocationData()
    {
    	List<FoodLocationEntity> list=fDao.foodTop20();
    	for(FoodLocationEntity vo:list)
    	{
    		String poster=vo.getPoster();
    		poster=poster.substring(0,poster.indexOf("^"));
    		poster=poster.replace("#", "&");
    		vo.setPoster(poster);
    	}
    	return list;
    }
    @GetMapping("category_info_react")
    public CategoryEntity category_info(int cno)
    {
    	CategoryEntity vo=cDao.findByCno(cno);
    	return vo;
    }
    @GetMapping("food_list_react")
    public List<FoodEntity> food_list(int cno)
    {
       List<FoodEntity> list=dao.findByCno(cno);
 	   for(FoodEntity vo:list)
 	   {
 		   String address=vo.getAddress();
 		   address=address.substring(0,address.lastIndexOf("지"));
 		   vo.setAddress(address);
 		   
 		   String poster=vo.getPoster();
 		   poster=poster.substring(0,poster.indexOf("^"));
 		   poster=poster.replace("#", "&");
 		   vo.setPoster(poster);
 	   }
 	   return list;
    }
}







