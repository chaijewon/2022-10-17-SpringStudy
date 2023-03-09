package com.sist.vo;

import lombok.Getter;
import lombok.Setter;

/*
 *  CHEF         VARCHAR2(1000) 
	POSTER       VARCHAR2(1000) 
	MEM_CONT1    VARCHAR2(100)  
	MEM_CONT3    VARCHAR2(100)  
	MEM_CONT7    VARCHAR2(100)  
	MEM_CONT2    VARCHAR2(100)
 */
@Getter
@Setter
public class ChefVO {
  private String chef,poster,mem_cont1,mem_cont3,mem_cont7,mem_cont2;
}
