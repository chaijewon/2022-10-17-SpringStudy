package com.sist.myapp;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sist.dao.*;
@Component("mc")
public class MainClass {

	@Autowired
	private EmpDAO edao;
	
	@Autowired
	private DeptDAO ddao;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
