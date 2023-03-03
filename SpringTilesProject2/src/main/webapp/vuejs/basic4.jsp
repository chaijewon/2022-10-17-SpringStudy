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
    <div class="row">
      <div class="text-center">
       <button class="btn btn-sm btn-danger" v-on:click="movieListData(1)">일일 박스오피스</button>
       <button class="btn btn-sm btn-success" v-on:click="movieListData(2)">실시간 예매율</button>
       <button class="btn btn-sm btn-info" v-on:click="movieListData(3)">좌석점유율순위</button>
       <button class="btn btn-sm btn-primary" v-on:click="movieListData(4)">온라인상영관 일일</button>
      </div>
    </div>
    <div style="height: 20px"></div>
    <div class="row">
      <div class="col-sm-8">
        <table class="table table-hover">
          <thead>
            <tr>
              <th class="text-center">순위</th>
              <th class="text-center"></th>
              <th class="text-center">영화명</th>
              <th class="text-center">감독</th>
              <th class="text-center">장르</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="(vo,index) in movie_list">
              <td class="text-center">{{vo.rank}}</td>
              <td class="text-center">
                <img :src="'https://www.kobis.or.kr/'+vo.thumbUrl" style="width: 30px;height: 30px">
              </td>
              <td>{{vo.movieNm}}</td>
              <td>{{vo.director}}</td>
              <td>{{vo.genre}}</td>
            </tr>
          </tbody>
        </table>
      </div>
      <div class="col-sm-4">
        <h3 v-if="isShow">Hello</h3>
      </div>
    </div>
  </div>
  <%--
      <script type="text/javascript"> ES 5
      <script type="text/babel"> ES 6
   --%>
  <script>
    new Vue({
    	el:'.container-fluid',
    	data:{
    		movie_list:[],
    		movie_detail:{},
    		isShow:false
    	},
    	//callback
    	mounted:function(){
    		let _this=this;
			axios.get("http://localhost/web/movie/movie_list_vue.do",{
				params:{
					no:1
				}
			}).then(function(response){
				//결과값 받기 
				console.log(response.data);
				_this.movie_list=response.data;
			})
    	},
    	//사용자 정의 함수
    	methods:{
    		movieListData:function(no){
    			this.isShow=true
    			let _this=this;
    			axios.get("http://localhost/web/movie/movie_list_vue.do",{
    				params:{
    					no:no
    				}
    			}).then(function(response){
    				//결과값 받기 
    				console.log(response.data);
    				_this.movie_list=response.data;
    			})
    		}
    	}
    })
  </script>
</body>
</html>






