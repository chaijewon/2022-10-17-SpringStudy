<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="https://unpkg.com/bootstrap/dist/css/bootstrap.min.css"/>
<link type="text/css" rel="stylesheet" href="https://unpkg.com/bootstrap-vue@latest/dist/bootstrap-vue.css"/>
<script src="https://cdn.jsdelivr.net/npm/vue@2.5.16/dist/vue.js"></script>
<script src="https://unpkg.com/babel-polyfill@latest/dist/polyfill.min.js"></script>
<script src="https://unpkg.com/bootstrap-vue@latest/dist/bootstrap-vue.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<style type="text/css">
.container{
   margin-top: 50px;
}
.row{
   margin: 0px auto;
   width: 1300px;
}
h1{
   text-align: center;
}
.details:hover{
   cursor: pointer
}
</style>
</head>
<body>
<div class="wrapper row3 rows">
  <main class="container clear"> 
    <div class="row">
     <div class="inline text-center">
	     <button class="btn btn-lg btn-danger" v-on:click="change(1)">상황</button>
	     <button class="btn btn-lg btn-success" v-on:click="change(2)">감성</button>
	     <button class="btn btn-lg btn-info" v-on:click="change(3)">스타일</button>
	     <button class="btn btn-lg btn-warning" v-on:click="change(4)">날씨/계절</button>
     </div>
    </div>
    <div style="height: 20px"></div>
    <div class="row">
      <div class="inline text-center">
        <span class="btn btn-lg btn-primary" v-for="r in recommand_list" style="margin-left: 15px" v-on:click="recommandData(r)">{{r}}</span>
      </div>
    </div>
    <div style="height: 20px"></div>
    <div class="row">
      <recommand_result v-bind:redata="recommand_data"></recommand_result>
    </div>
    <div class="dialog" title="맛집 상세보기" style="display:none">
     <p>This is the default dialog which is useful for displaying information. The dialog window can be moved, resized and closed with the &apos;x&apos; icon.</p>
    </div>
  </main>
</div>
<script>
 Vue.component("recommand_result",{
	 props:['redata'],
	 template:'<div class="text-center">'
	           +'<div class="col-md-3" v-for="vo in redata">'
	           +'<div class="thumbnail">'
	           +'<img :src="vo.poster" style="width:250px;height: 180px" class="details" v-on:click="recommandDetail(vo.fno)">'
	           +'<div class="caption">'
	           +'<p><h4 class="details" v-on:click="recommandDetail(vo.fno)">{{vo.name}}&nbsp;<span style="color:orange">{{vo.score}}</span></h4></p>'
	           +'</div>'
	           +'</div>'
	           +'</div>'
	           +'</div>'
	           +'</div>',
	  methods:{
		  recommandDetail:function(fno){
			  this.$parent.recommandDetail(fno)
			  $('.dialog').dialog({
					 autoOpen:false,
					 modal:true,
					 width:1200,
					 height:800
				 }).dialog("open")
		  }  
	  }
	 
 })
 new Vue({
	 el:'.rows',
	 data:{
		 recommand_list:[],
		 recommand_data:[],
		 recommand_detail:{}
	 },
	 methods:{
		 change:function(no){
			 let _this=this;
			 axios.get("http://localhost/web/food/recommand_change.do",{
				 params:{
					 no:no 
				 }
			 }).then(function(response){
				 console.log(response.data)
				 _this.recommand_list=response.data;
			 })
		 },
		 recommandData:function(r){
			 let _this=this;
			 axios.get("http://localhost/web/food/recommand_result.do",{
				 params:{
					 ss:r
				 }
			 }).then(function(response){
				 console.log(response.data)
				 _this.recommand_data=response.data
			 })
		 },
		 recommandDetail:function(fno){
			 alert("fno="+fno)
			 let _this=this;
			 axios.get("http://localhost/web/food/recommand_detail.do",{
				 params:{
					 fno:fno
				 }
			 }).then(function(response){
				 console.log(response.data)
				 _this.recommand_detail=response.data
				 
			 })
		 }
	 }
 })
</script>
</body>
</html>










