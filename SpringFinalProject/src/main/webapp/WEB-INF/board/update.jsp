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
</head>
<body>
<div class="wrapper row3 rows">
  <main class="container clear">
    <table class="table">
      <tr>
        <th width=20%>이름</th>
        <td width=80%><input type=text size="15" class="input-sm" v-model="name" :value="name"></td>
      </tr>
      <tr>
        <th width=20%>제목</th>
        <td width=80%><input type=text size="55" class="input-sm" v-model="subject" :value="subject"></td>
      </tr>
      <tr>
        <th width=20%>내용</th>
        <td width=80%><textarea rows="10" cols="55" v-model="content">{{content}}</textarea></td>
      </tr>
      <tr>
        <th width=20%>비밀번호</th>
        <td width=80%><input type=password size="10" class="input-sm" v-model="pwd"></td>
      </tr>
      <tr>
        <td colspan="2" class="text-center">
         <input type=button value="수정하기" class="btn btn-sm btn-primary" v-on:click="write()">
         <input type=button value="취소" class="btn btn-sm btn-info" onclick="javascript:history.back()">
        </td>
      </tr>
    </table>
  </main>
</div>
<script>
  new Vue({
	  el:'.rows',
	  data:{
		  name:'',
		  subject:'',
		  content:'',
		  pwd:'',
		  no:${no}
	  },
	  methods:{
		  write:function(){
			  let _this=this;
			  axios.get('http://localhost/web/board/update_vue.do',{
				  params:{
					 no:this.no
				  }
			  }).then(function(response){
				  _this.name=response.data.name
				  _this.subject=response.data.subject
				  _this.content=response.data.content
			  })
		  }
	  }
  })
</script>
</body>
</html>