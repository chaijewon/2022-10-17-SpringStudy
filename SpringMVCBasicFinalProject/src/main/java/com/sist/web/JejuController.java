package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
@Controller
// 요청 ==> Controller => JSP
public class JejuController {
   @Autowired
   private JejuDAO dao;
   
   @GetMapping("jeju/list.do")
   //jeju/list.do?page=1&no=10
   public String jeju_list(String page,Model model)
   {
	   if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page);
	   Map map=new HashMap();
	   int rowSize=20;
	   int start=(rowSize*curpage)-(rowSize-1);
	   int end=rowSize*curpage;
	   map.put("start", start);
	   map.put("end", end);
	   List<JejuLocationVO> list=dao.jejuLocationListData(map);
	   for(JejuLocationVO vo:list)
	   {
		   String title=vo.getTitle();
		   if(title.length()>19)
		   {
			   title=title.substring(0,16)+"...";
			   vo.setTitle(title);
		   }
		   vo.setTitle(title);
	   }
	   int totalpage=dao.jejuTotalPage();
	   
	   final int BLOCK=5;
	   int startPage=((curpage-1)/BLOCK*BLOCK)+1;
	   int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
	   // 1 2 3 4 5
	   // 6 7 8 9 10
	   if(endPage>totalpage)
		   endPage=totalpage;
	   
	   model.addAttribute("curpage", curpage);
	   model.addAttribute("totalpage", totalpage);
	   model.addAttribute("startPage", startPage);
	   model.addAttribute("endPage", endPage);
	   model.addAttribute("list", list);
	   return "jeju/list";
   }
   //jeju/detail.do?no=${vo.no }
   @GetMapping("jeju/detail.do")
   public String jeju_detail(int no,Model model)
   {
	   
	   return "jeju/detail";
   }
}
