<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
}

td {
   margin: auto;
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

<table style='width: 1000px; text-align: center; cellpadding: 5; cellspacing: 2; border: 1; margin: auto;'>
    <tr>
        <th width="1000px" height="10px" colspan="4">
            <p align="center"><font color="white" size="3"><b>
            ${resultContent.num}  번 게시물 자세히보기</b></font></p>
        </th>
    </tr>
    <tr>
        <td class="leftTable">작성자&nbsp;&nbsp;&nbsp;
        </td>
        <td width="500px" height="20px" style='text-align: left;'><b>
      ${resultContent.writer}</b></span></td>
    </tr>
    <tr>
        <td class="leftTable">작성일&nbsp;&nbsp;&nbsp;</td>
        <td class="rightTable"><b>
      ${resultContent.writeday}</b></td>
        <td class="leftTable">조회수&nbsp;&nbsp;&nbsp;
      </td>
        <td class="rightTable"><b>
            ${resultContent.readnum}</b>
      </td>
    </tr>
    <tr>
        <td class="leftTable">제 목&nbsp;&nbsp;&nbsp;</td>
        <td class="rightTable"><b>
      ${resultContent.title}</b></td>
    </tr>
    <tr>
      <td class="leftTable">모집 공고&nbsp;&nbsp;&nbsp;</td>
      <!-- 브라우저에 글 내용을 뿌려줄 때는 개행문자(\n)가 <br>태그로 변환된 문자열을 보여줘야 한다. -->
        <td class="rightTable"><b>
      ${resultContent.content}</b></td>
    </tr>
    <tr>
           <!-- <table>
            <tr>
               <td>
                  수정시 필요한 데이터들을 hidden으로 숨겨놓고 폼 데이터로 보내준다.
                     <input type=button value="수정하기" onClick='href="controller?command=updateForm"'>
                     <a value="삭제하기" href="controller?command=delete&num=16&writer=ssd">삭제하기</a>
               </td>
            </tr>
         </table> -->
      </td>
    </tr>
</table>
<hr>
<br><br><br><br>
         <div align=right>
            <span style="font-size: 25pt; color:#054175">&lt;<a
               href="index.html" style='color:#054175'>리스트로 돌아가기</a>&gt;&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
            </span>
         </div>
         </div>
         </div>
         </body>
        </html>