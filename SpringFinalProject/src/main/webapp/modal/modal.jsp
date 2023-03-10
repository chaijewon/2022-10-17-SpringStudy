<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<style type="text/css">
.container{
   margin-top: 50px;
}
.row{
  margin: 0px auto;
  width:800px;
}
.black-bg{
  width:100%;
  height: 100%;
  background: rgba(0,0,0,0.6);
  position: fixed;
}
.white-bg{
  width:90%;
  margin:80% auto;
  background: white;
  border-radius: 5px;
  padding: 20px 0;
}
.close{
  cursor:pointer;
  border:none;
  background: #6667AB;
  color:white;
  font-weight: blod;
  border-radius: 5px;
  padding:5px 15px;
}
.close:hover{
   color:white;
   font-weight: blod;
   transform:scale(1.1);
   transition:all 0.5s;
}
</style>
</head>
<body>
  <div class="container">
    <div class="row">
     <input type=button value="클릭" class="btn btn-sm btn-danger">
    </div>
    <div class="black-bg" v-if="openModal" v-on:click="close()">
      <div class="white-bg">
        <h4>상세보기</h4>
        <p>상세보기 내용</p>
        <button class="close">닫기</button>
      </div>
    </div>
  </div>
  <script>
    new Vue({
    	el:'.container',
    	data:{
    		openModal:false
    	},
    	methods:{
    		close:function(){
    			/*if(event.target.classList.contains('black-bg')||event.target.classList.contains('close'))
    			{
    				this.openModal=false;
    			}
    			else if(event.target.classList.contains('white-bg'))
    			{
    				this.openModal=true;
    			}*/
    			this.openModal=true
    		}
    	}
    })
  </script>
</body>
</html>