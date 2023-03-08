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
    <div id="app">
        <!--app Header component 태그!! 컴포넌트의 내용이 반영되어 나타남-->
        <app-header></app-header>
        <!-- <div> Content </div> -->
        <app-content></app-content>
        <app-footer></app-footer>
    </div>
    <div id="app2">
        <app-header></app-header>
        <app-footer></app-footer>
    </div>
    <script>
    
        // 전역 component 등록방법 (많이 쓰이지 않음)
        // Instance 를 생성할 때마다 따로 등록 X 기본적으로 모든 Instance에 등록되어있음.
        // Vue.component('컴포넌트 이름', 컴포넌트 내용);
        Vue.component('app-header',{
        // tamplate : 화면에 들어가는 html 태그
            template: '<h1>Header</h1>'
        });
        Vue.component('app-header', {
         // tamplate : 화면에 들어가는 html 태그
            template: '<div>Content</div>'
        });

        new Vue({
            el: '#app',
            // {} 객체 기호
            // 지역 component 등록방법
            // component's'!!!!! s주의 !!!!
            components: {
                //정의형태 : 'key' : 'value'
                // '컴포넌트 이름' : '컴포넌트 내용'
                'app-footer': {
                    template: '<footer>Footer</footer>'
                }
            },
        });

        new Vue({
            el: '#app2',
            components: {
                // 지역 component는 Instance마다 새로 생성!!!
                'app-footer': {
                    template: '<footer>Footer</footer>'
                }
            },
        });
        
    </script>
</body>
</html>