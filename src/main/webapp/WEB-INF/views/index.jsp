<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<!-- <link rel="stylesheet" href="resources/css/common.css" type="text/css"> -->
<style>
	*{
		margin: 0 auto;
	}

/* 	header{
		width: 100%;
		height: 100px;
		background: #ccc;	
	} */
	table{
    margin-top: 180;
    width: 500px;
    height: 300px;
    text-align: center;
    border: 1px solid #ccc;
}
	
	input [type="text"]{
		width: 500px;
		height: 10px;
	}
	body {
   padding: 0;
   margin: 0;
   font-family: "DomaineText", Georgia, serif;
   font-weight: normal;
   line-height: 1.5;
   color: #443235;
   background: #e6ddde;
   /* -webkit-font-smoothing: antialiased;
   -moz-osx-font-smoothing: grayscale; */
}
header div.tagline {
   margin-top: 0.0625rem;
   font-family: "DomaineText", Georgia, serif;
   font-weight: normal;
   font-style: normal;
   font-size: 1.125rem;
   line-height: 1.5;
   letter-spacing: 0;
   text-transform: none;
   text-align: center;
}

header div.tagline a, header div.tagline a:hover, header div.tagline a:focus
   {
   color: #654a4e;
}

.logo>a>img {
   max-width: 15%;
   height: auto;
   -ms-interpolation-mode: bicubic;
   display: flex;
  justify-content: center;
  align-items: center;
}

a {
   color: #2e2c2c;
   text-decoration: none;
   line-height: inherit;
   cursor: pointer;
}
</style>
</head>
<body>
	<header class="row">
         <div class="small-12 medium-12 large-12 columns">

            <div class="logo">
               <a href="logoimg"><img src="resources/logos/logo.png" alt="Typewolf"></a>
            </div>
            <div class="tagline">
               <a href="logoimg">ROPA DE CLIMA</a>
            </div>
         </div>
      </header>

	<form action="login" method="post">
	<table>
		<tr>
			<th>ID</th>
			<td colspan="2"><input type="text" name="id" /></td>
		</tr>
		<tr>
			<th>PW</th>
			<td colspan="2"><input type="password" name="pw" /></td>
		</tr>
		<tr>
			<th colspan="3">
				<input type="submit" value="LOGIN"/>
				<!-- spring 에서는 jsp 페이지로 직접 이동이 금지된다(보안상의 이유로 반드시 컨트롤러를 거쳐야 한다.) -->
				
			</th>
		</tr>
		<tr>
			<td> <button type="button" value="아이디 찾기" onclick="location.href='find_id'">이메일 찾기</button> </td>
			<td> <button type="button" onclick="location.href='find_pw'">비밀번호 찾기</button> </td>
			<td> <input type="button" value="회원가입" onclick="location.href='joinForm'"/></td>
		</tr>
	</table>	
	</form>
</body>
<script>
var msg = "${msg}";
if(msg != ""){
	alert(msg);
}
</script>
</html>







