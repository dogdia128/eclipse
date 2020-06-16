<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<!--
Design by TEMPLATED
http://templated.co
Released for free under the Creative Commons Attribution License

Name       : OfficialWork 
Description: A two-column, fixed-width design with dark color scheme.
Version    : 1.0
Released   : 20121012

-->
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>OfficialWork by TEMPLATED</title>
<link href="http://fonts.googleapis.com/css?family=Oswald"
   rel="stylesheet" type="text/css" />
<link href="style.css" rel="stylesheet" type="text/css" media="screen" />
<link href="./css/main.css" rel="stylesheet" type="text/css"
   media="screen" />
<style type="text/css">
@import "main.css";

#rightbox {
   float: right;
   display: inline;
   margin-right: 3vw;
   margin-top: 1vw;
}

#menu {
   background: -webkit-linear-gradient(bottom, #005bea, #00c6fb);
}

th {
   background: -webkit-linear-gradient(bottom, #005bea, #00c6fb);
   color: white;
   border: 5px solid white;
}

td {
   text-align: middle;
   margin: 0;
   background: #CEF6F5;
   border: 3px solid white;
}

}
</style>
<script src="./js/vue.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>

<body>
   <div id="board">
      <div id="wrapper">
         <div id="rightbox">
				<a href="./login.html"><font size="6em" color="#054175">로그인</font></a>
			</div>
			<div id="header">
				<div id="logo">
					<h1>
						<a href="index.html">알바 고래</a>
					</h1>
					<p>
						Design by <a href="http://templated.co" rel="nofollow">TEMPLATED</a>
					</p>
				</div>
			</div>
			<!-- end #header -->
			<div id="menu">
				<ul>
						<li><a class="font" href="index.html"><font
						size="6em">전체 보기</font></a></li>
				<li><div class="font">
						<font size="6em">직종별 모아보기</font>
						<input type="hidden" name="command" value="selectType"> <select
							name="type" v-model="selectedType">
								<option value="service" selected="selected">서비스</option>
								<option value="office">사무직</option>
								<option value="seller">판매</option>
								<option value="cooking">외식/음료</option>
								<option value="delivery">배달</option>
						</select> 
					<button>
						<font class="font" size="6em" @click="filterbyboard">입장</font>
					</button>
					</div></li>
					<li>
                     <a href="chart.html"><font size="6em">알바고래통계</font></a>
               		</li>	
					<li class="last"><button class="font" @click="myboard()">
							<font class="font" size="6em">내가 쓴 글만 보기</font>
						</button></li>
				</ul>
			</div>
         <div class="fail">
         <p class="style" style='color:#054175;'>${sessionScope.errorMsg}</p>
         <img src="images/pics03.jpg" width="468" height="175" alt="" />
      </div>
      <br><br><br><br>
			<div align=right>
				<span style="font-size: 25pt; color:#054175">&lt;<a
					href="index.html" style='color:#054175'>리스트로 돌아가기</a>&gt;&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
				</span>
			</div>
			<script>
	
               
	
      new Vue({
         el: '#board',
         data: {
            list: [],
            selectedType: '',
            currId: ''
         },
         mounted: function () {
             axios.get('controller?command=selectAll').then(response => { this.list = response.data; }).catch(error =>{console.log(error)});
             axios.get('controller?command=loginstatus').then(response => { this.currId = response.data.trim(); }).catch(error =>{console.log(error)});
         
         },
         methods: {
        	 myboard: function() {
         		var newlist = this.list.filter(item => item.writer.trim() == this.currId);
 				this.list = newlist;
         	 
         	 },
         	 filterbyboard: function() {
                 axios.get('controller?command=selectType&type='+this.selectedType).then(response => this.list = response.data ).catch(error =>{console.log(error)});
         	 }
         }
      });
   </script>
</body>
</html>