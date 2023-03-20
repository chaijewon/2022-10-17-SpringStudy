package com.sist.board.controller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sist.board.dao.*;
import com.sist.board.entity.*;

@Controller
public class BoardController {
  @Autowired
  private BoardDAO dao;
  
  @GetMapping("/list")
  public String board_list(String page,Model model)
  {
	  if(page==null)
		  page="1";
	  int curpage=Integer.parseInt(page);
	  int start=(curpage*10)-10;
	  List<BoardEntity> list=dao.boardListData(start);
	  int totalpage=dao.boardTotalPage();
	  model.addAttribute("list", list);
	  model.addAttribute("curpage", curpage);
	  model.addAttribute("totalpage", totalpage);
	  return "board/list";
  }
  @GetMapping("/insert")
  public String board_insert() {
	  return "board/insert";
  }
  @PostMapping("/insert_ok")
  public String board_insert_ok(BoardEntity vo)
  {
	  dao.save(vo);
	  return "redirect:/list";
  }
}
