package com.sist.web;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.vo.*;
import com.sist.dao.*;

@Controller
public class FoodController {
  @Autowired
  private FoodDAO dao;
  
  @GetMapping("food/food_list.do")
  public String food_list(int cno,Model model)
  {
	  
	  return "food/food_list";
  }
}
