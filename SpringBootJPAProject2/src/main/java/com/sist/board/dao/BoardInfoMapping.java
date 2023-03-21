package com.sist.board.dao;

import java.time.LocalDateTime;

public interface BoardInfoMapping {
	public int getNo();
	public String getName();
	public String getSubject();
	//public LocalDateTime getRegdate();
	public int getHit();
	public String getDbday();
}
