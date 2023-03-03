<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container-fluid{
   margin-top: 50px;
}
.row{
   margin: 0px auto;
   width: 100%;
}
h1{
   text-align: center
}
</style>
</head>
<body>
   <div class="container-fluid">
      <div class="col-sm-4">
        <div class="text-center">
          <button class="btn btn-sm btn-info">믿고 보는 맛집 리스트</button>
          <button class="btn btn-sm btn-success">지역별 맛집 리스트</button>
          <button class="btn btn-sm btn-warning">메뉴별 맛집 리스트</button>
        </div>
        <div style="height: 10px"></div>
         <div class="col-md-6" v-for="vo in cate_list">
		    <div class="thumbnail">
		        <img :src="vo.poster" style="width:200px;height: 150px">
		        <div class="caption">
		          <p>{{vo.title}}</p>
		        </div>
		    </div>
		  </div>
      </div>
      <div class="col-sm-3">
      
      </div>
      <div class="col-sm-5">
      
      </div>
    </div>
    <script>
     new Vue({
    	 el:'.container-fluid',
    	 data:{
    		 cate_list:[],
    		 food_list:[],
    		 food_detail:{}
    	 },
    	 mounted:function(){
    		 
    	 },
    	 methods:{
    		 
    	 }
     })
    </script>
</body>
</html>







