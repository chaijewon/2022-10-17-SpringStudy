package com.sist.web;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.sist.vo.*;
import com.sist.dao.*;
@RestController
public class FoodRestController {
   @Autowired
   private FoodDAO dao;
   /*
    *   axios.get("http://localhost/web/food/category_info_vue.do",{
    *        ==== GetMapping
			params:{
				cno:_this.cno ==>  매개변수 
			}
		}).then(function(response){
			console.log(response.data)
			_this.cate_info=response.data ==> return 
		})
    */
   @GetMapping(value="food/food_main_vue.do",produces = "text/plain;charset=UTF-8")
   public String food_main_vue()
   {
	   List<CategoryVO> list=dao.categoryListData();
	   JSONArray arr=new JSONArray();
	   for(CategoryVO vo:list)
	   {
		   JSONObject obj=new JSONObject();
		   obj.put("cno", vo.getCno());
		   obj.put("title", vo.getTitle());
		   obj.put("poster", vo.getPoster());
		   arr.add(obj);
	   }
	   return arr.toJSONString();
   }
   // Cookie전송 
   @GetMapping(value="food/cookie_data_vue.do",produces = "text/plain;charset=UTF-8")
   public String food_cookie_data(HttpServletRequest request)
   {
	   // new Cookie(key,value)
	   //           ---- ------
	   //          getNam() getValue()
	   Cookie[] cookies=request.getCookies();
	   List<FoodVO> list=new ArrayList<FoodVO>();
	   if(cookies!=null)
	   {
		   for(int i=cookies.length-1;i>=0;i--)
		   {
			   if(cookies[i].getName().startsWith("spring_food"))
			   {
				   String fno=cookies[i].getValue();
				   FoodVO vo=dao.foodCookieDetailData(Integer.parseInt(fno));
				   list.add(vo);
			   }
		   }
	   }
	   
	   // JSON 변환 
	   JSONArray arr=new JSONArray();
	   int i=0;
	   for(FoodVO vo:list)
	   {
		   if(i>9) break;
		   JSONObject obj=new JSONObject();
		   obj.put("fno", vo.getFno());
		   obj.put("name", vo.getName());
		   String poster=vo.getPoster();
		   poster=poster.substring(0,poster.indexOf("^"));
		   poster=poster.replace("#", "&");
		   obj.put("poster", poster);
		   arr.add(obj);
		   i++;
	   }
	   return arr.toJSONString();
   }
   @GetMapping(value="food/category_info_vue.do",produces = "text/plain;charset=UTF-8")
   public String category_info_vue(int cno)
   {
	   CategoryVO vo=dao.categoyInfoData(cno);
	   JSONObject obj=new JSONObject();
	   obj.put("title", vo.getTitle());
	   obj.put("subject", vo.getSubject());
	   return obj.toJSONString();
   }
   // fno,name,poster,score,tel,address,type
   @GetMapping(value="food/food_list_vue.do",produces = "text/plain;charset=UTF-8")
   public String food_list_vue(int cno)
   {
	   List<FoodVO> list=dao.foodListData(cno);
	   JSONArray arr=new JSONArray(); // []
	   for(FoodVO vo:list)
	   {
		   JSONObject obj=new JSONObject(); // VO => {}
		   obj.put("fno", vo.getFno());
		   obj.put("name", vo.getName());
		   obj.put("score", vo.getScore());
		   obj.put("tel", vo.getTel());
		   obj.put("type", vo.getType());
		   String addr=vo.getAddress();
		   addr=addr.substring(0,addr.lastIndexOf("지"));
		   obj.put("address", addr.trim());
		   String poster=vo.getPoster();
		   poster=poster.substring(0,poster.indexOf("^"));
		   poster=poster.replace("#","&");
		   obj.put("poster", poster);
		   arr.add(obj);
	   }
	   return arr.toJSONString();
   }
   
   @GetMapping(value="food/food_detail_vue.do",produces = "text/plain;charset=UTF-8")
   public String food_detail_vue(int fno)
   {
	   FoodVO vo=dao.foodDetailData(fno);
	   // VO=>{}
	   String address=vo.getAddress();
	   String addr1=address.substring(0,address.lastIndexOf("지"));
	   String addr2=address.substring(address.lastIndexOf("지")+3);
	   // 지번 서울시...
	   JSONObject obj=new JSONObject();
	   obj.put("fno", vo.getFno());
	   obj.put("name", vo.getName());
	   obj.put("score", vo.getScore());
	   obj.put("addr1", addr1.trim());
	   obj.put("addr2", addr2.trim());
	   obj.put("tel", vo.getTel());
	   obj.put("type", vo.getType());
	   obj.put("time", vo.getTime());
	   obj.put("price", vo.getPrice());
	   obj.put("parking", vo.getParking());
	   String menu=vo.getMenu();
	   if(!menu.equals("no"))
	   {
		   menu=menu.substring(0,menu.lastIndexOf("원"));
	   }
	   obj.put("menu", menu);
	   obj.put("poster", vo.getPoster());
	   return obj.toJSONString();
   }
   
}









