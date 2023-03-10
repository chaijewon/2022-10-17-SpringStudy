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
    <!-- Add this after vue.js -->
    <script src="https://unpkg.com/babel-polyfill@latest/dist/polyfill.min.js"></script>
    <script src="https://unpkg.com/bootstrap-vue@latest/dist/bootstrap-vue.js"></script>
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
    <!-- <script>
      window.Vue = Vue;
      Vue.use(VuePlugin);
    </script> -->
    <style type="text/css">
    .container{
       margin-top: 50px;
    }
    .row{
      margin: 0px auto;
      width:800px;
    }
    </style>
</head>
<body>
<div id="vm">
  <div class="container">
    <div class="row">
         <template>
		  <div>
		    <b-table striped hover :items="items"></b-table>
		  </div>
		 </template>
    </div>
  </div>
  
</div>
<script>
new Vue({
	el:'#vm',
	data:{
		items: [
	          { age: 40, first_name: 'Dickerson', last_name: 'Macdonald' },
	          { age: 21, first_name: 'Larsen', last_name: 'Shaw' },
	          { age: 89, first_name: 'Geneva', last_name: 'Wilson' },
	          { age: 38, first_name: 'Jami', last_name: 'Carney' }
	        ]
	}
})
</script>
</body>
</html>