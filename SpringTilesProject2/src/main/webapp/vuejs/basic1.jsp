<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
      Front-End 
      ---------
       JQuery = Ajax (이전) = web2.0
       VueJS , ReactJS => web3.0
       ---------------
       Vuejs => vuex => vue3 => angularjs(구글) => 파생 => 엣지 => 양방향 , 속도
       --------------
         jsp <=> mvc
       reactjs => Redux => mobx(배민),saga 
       ----------------   -----------
         jsp      mvc       spring 
         
       라이브러리 
       --------
       1. 형식
       2. 디렉티브
       3. 이벤트 처리
       4. 컴포넌트 Vue.Component() => 반복적인 경우 
       5. 사용자 정의 이벤트 : 이벤트 버스 (실시간 채팅)
       6. 서버와 연결 : axios
       7. 화면 변경 : 라우터 
       
       장점 : 양방향 통신 : v-model , 속도가 빠르다 (가상돔) , 사용하기 편리하다(자바스크립트라이브러리중에 가장 쉬운 프로그램)
             SpringBuffer / Spring          ------- 임시저장 장소  
       
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<!-- <script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('#msg').keyup(function(){
		let value=$(this).val();
		$('#print').text(value);
	})
})
</script> -->
</head>
<body>
 <div id="app">
   <input type=text size=35 v-model="msg">
   <p>{{msg}}</p>
   <input type=text size=35 v-model="message">
   <p>{{message}}</p>
 </div>
 <div class="info">
  이름:{{name}}<br>
  성별:{{sex}}
 </div>
  <script>
   new Vue({
	   el:'#app',
	   data:{
		   msg:'',
		   message:'',
		   name:'홍길동',
		   sex:'남자'
	   }
   })
   new Vue({
	   el:'.info',
	   data:{
		   name:'심청이',
		   sex:'여자'
	   }
   })
  </script>
</body>
</html>






