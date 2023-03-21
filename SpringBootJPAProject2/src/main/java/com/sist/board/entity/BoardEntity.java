package com.sist.board.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import lombok.Getter;
import lombok.Setter;

@Entity(name="board")
@Getter
@Setter
public class BoardEntity {
   @Id
   private int no;
   
   private String name,subject,content,pwd;
   private int hit;
   private LocalDateTime regdate;
   private String dbday;
  
   @PrePersist
   public void regdate() {
	   this.regdate=LocalDateTime.now();
	   this.dbday=this.regdate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
   }
}
