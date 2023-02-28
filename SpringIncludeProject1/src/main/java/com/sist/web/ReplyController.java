package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

import javax.servlet.http.HttpSession;

import com.sist.dao.*;
import com.sist.vo.*;
@Controller
public class ReplyController {
   @Autowired
   private ReplyDAO dao;
   
   @PostMapping("reply/insert")
   // forward => Model , redirect => RedirectAttributes
   public String reply_insert(ReplyVO vo,RedirectAttributes ra,HttpSession session)
   {
	   // 객체 단위 => 커맨드 객체 
	   String id=(String)session.getAttribute("id");
	   String name=(String)session.getAttribute("name");
	   vo.setId(id);
	   vo.setName(name);
	   dao.replyInsert(vo);
	   ra.addAttribute("fno", vo.getRno());
	   ra.addAttribute("type", vo.getType());
	   return "redirect:../food/detail.do";
   }
}
