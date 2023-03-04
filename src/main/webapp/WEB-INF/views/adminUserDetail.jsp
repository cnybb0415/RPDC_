<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>관리자 메인</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


<style>
/*사이드바*/
/* 사이드바 래퍼 스타일 */
body {
	margin: 0px;
	padding: 0px;
}

#page-wrapper {
	padding-left: 250px;
}

#sidebar-wrapper {
	position: fixed;
	width: 250px;
	height: 100%;
	margin-left: -250px;
	background: #000;
	overflow-x: hidden;
	overflow-y: auto;
}

#page-content-wrapper {
	width: 100%;
	padding: 5px;
}
/* 사이드바 스타일 */
.sidebar-nav {
	font-size: 12px;
	width: 250px;
	margin: 0;
	padding: 0;
	list-style: none;
}

.sidebar-nav li {
	text-indent: 1.5em;
	line-height: 2.8em;
}

.sidebar-nav li a {
	display: block;
	text-decoration: none;
	color: #999;
}

.sidebar-nav li a:hover {
	color: #fff;
	background: rgba(255, 255, 255, 0.2);
}

.sidebar-nav>.sidebar-brand {
	font-size: 1.3em;
	line-height: 3em;
}

#divRep {
	width: 50%;
	background-color: #ddd;
}

#divNotice {
	width: 50%;
	background-color: #ddd;
}

hr {
	margin: 0px;
}

.sidenav {
	padding-top: 5px;
	background-color: #f1f1f1;
	height: 100%;
}

footer {
	background-color: #555;
	color: white;
	padding: 15px;
}

@media screen and (max-width: 767px) {
	.sidenav {
		height: auto;
		padding: 15px;
	}
	.row.content {
		height: auto;
	}
}

#page-wrapper {
	padding-left: 250px;
}

#sidebar-wrapper {
	position: fixed;
	width: 200px;
	height: 100%;
	background: #000;
	color : #fff;
}

#page-content-wrapper {
	width: 100%;
}
</style>
</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"><img
					src="resources/logos/logo.png" style="width: 200px; height: 50px;" /></a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#"><span class="glyphicon glyphicon-log-in"></span>
							Login</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- body -->
	<div class="container-fluid text-center"></div>
	<div id="page-wrapper">
		<!-- 사이드바 -->
		<div id="sidebar-wrapper">
			<ul class="sidebar-nav">
				<li class="sidebar-brand"></li>
				<hr />
				<li class="sidebar-brand" id="goMain" onclick="goMain()"><p>메인
						화면</p></li>
				<hr />
				<li class="sidebar-brand" id="goUser" onclick="goUser()" style="background-color: white; color : black"><p>유저
						리스트</p></li>
				<hr />
				<li class="sidebar-brand" id="goBoard" onclick="goBoard()"><p>게시글
						리스트</p></li>
				<hr />
				<li class="sidebar-brand" id="goRepProc" onclick="goRepProc()"><p>신고
						처리 리스트</p></li>
				<hr />
				<li class="sidebar-brand" id="goNotice" onclick="goNotice()"><p>공지
						전송</p></li>
				<hr />
				<br />
				<br />
				<br />
				<br />
				<br />
				<br />
				<br />
				<br />
				<br />
				<br />
				<br />
				<br />
				<hr />
				<li><a href="#">최고 관리자</a></li>

			</ul>
		</div>
		<!-- /사이드바 -->

		<!-- 본문 -->
		<div id="page-content-wrapper">
			<div class="container-fluid">
				<div class="container">


					<div class="row" id="divProfile">
						<div class="col-sm-4" style="width: 120px; height: 120px;">
							<img src="resources/testphotos/photo.jpg"
								style="width: 200px; height: 200px;" />
						</div>
						<div class="col-sm-8"
							style="text-align: left; width: 200px; height: 200px;">
							<h4>
								관리자 님
								</h2>
								<h4>
									<strong>권한:</strong> 관리자
								</h4>
						</div>
						<!-- 유저 권한 -->

						<!-- 유저 정보 영역 -->
						<div class="col-sm-4"
							style="background-color: lightgrey; text-align: left">
							<span style="width: 200px; height: 200px;">

								<h4>e-mail : ${adminUserDetailInfo.mem_email }</h4>
								<h4>닉네임 : ${adminUserDetailInfo.mem_nickname }</h4>
								<h4>생년월일 : ${adminUserDetailInfo.mem_birth }</h4>
								<h4>이름 : ${adminUserDetailInfo.mem_name }</h4>
								<h4>가입날짜 : ${adminUserDetailInfo.mem_regDate }</h4>
								<h4>회원정보 : ${adminUserDetailInfo.mem_autority }</h4>
								<h4>
									회원상태 :
									<c:if test="${!adminUserDetailInfo.mem_ban}">
										<c:out value="정상"></c:out>

									</c:if>
									<c:if test="${adminUserDetailInfo.mem_ban}">
										<c:out value="탈퇴"></c:out>
										</br>
										<table class="table">
											<thead>
												<tr>
													<th colspan=2>탈퇴 정보</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<th>담당자</th>
													<th>처리 시간</th>
												</tr>
												<tr>
													<td>${adminUserBanDetailInfo.mem_nickname}</td>
													<td>${adminUserBanDetailInfo.pro_time}</td>
												</tr>
											</tbody>
										</table>
									</c:if>

								</h4>
							</span>
						</div>

						<div class="col-sm-4" style="width: 270px; height: 270px;">
							<img src="resources/testphotos/test.jpg"
								style="width: 200px; height: 200px;" />

						</div>
					</div>
				</div>
				<hr />

				<div class="container">
					<h2>Dynamic Tabs</h2>
					<ul class="nav nav-tabs">
						<li class="active"><a data-toggle="tab" href="#userBoardList">${adminUserDetailInfo.mem_nickname }의
								게시글</a></li>
						<li><a data-toggle="tab" href="#userLikeList">${adminUserDetailInfo.mem_nickname }의
								좋아요</a></li>
						<li><a data-toggle="tab" href="#userRepList">${adminUserDetailInfo.mem_nickname }의
								신고 목록</a></li>
						<li><a data-toggle="tab" href="#userCommentList">${adminUserDetailInfo.mem_nickname }의
								댓글</a></li>
						<li><a data-toggle="tab" href="#userBookmarkList">${adminUserDetailInfo.mem_nickname }의
								북마크</a></li>
					</ul>

					<div class="tab-content">

						<div id="userBoardList" class="tab-pane fade in active">
							<div style="width: 1200px; height: 500px;">
								<h3>게시글 리스트</h3>
								<table class="table" style="width: 1200px;">
									<thead>
										<tr>
											<th>글 번호</th>
											<th>작성자</th>
											<th>작성 날짜</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${adminUserBoardList}" var="board">
											<tr>
												<td>${board.board_num}</td>
												<td>${board.mem_nickname}</td>
												<td>${board.board_time}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>

						<div id="userLikeList" class="tab-pane fade">
							<div style="width: 1200px; height: 500px;">
								<h3>좋아요 리스트</h3>
								<table class="table" style="width: 1200px;">
									<thead>
										<tr>
											<th>글 번호</th>
											<th>작성자</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${adminUserLikeList}" var="like">
											<tr>
												<td>${like.board_num}</td>
												<td>${like.mem_nickname}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>

						<div id="userRepList" class="tab-pane fade">
							<div style="width: 1200px; height: 500px;">
								<h3>신고 리스트</h3>

								<table class="table" style="width: 1200px;">
									<thead>
										<tr>
											<th>신고자</th>
											<th>글 번호</th>
											<th>신고 대상</th>
											<th>신고 사유</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${adminUserRepList}" var="report">
											<tr>
												<td>${report.mem_nickname}</td>
												<td>${report.write_num}</td>
												<td>${report.mem_nickname}</td>
												<td>${report.reason}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>

						<div id="userCommentList" class="tab-pane fade">
							<div style="width: 1200px; height: 500px;">
								<h3>댓글 리스트</h3>

								<table class="table" style="width: 1200px;">
									<thead>
										<tr>
											<th>댓글 번호</th>
											<th>작성자</th>
											<th>작성 날짜</th>
											<th>작성 내용</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${adminUserCommentList}" var="comment">
											<tr>
												<td>${comment.comt_num}</td>
												<td>${comment.mem_nickname}</td>
												<td>${comment.comt_time}</td>
												<td>${comment.comt_content}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>

						<div id="userBookmarkList" class="tab-pane fade">
							<div style="width: 1200px; height: 500px;">
								<h3>북마크 리스트</h3>
								<table class="table" style="width: 1200px;">
									<thead>
										<tr>
											<th>글 번호</th>
											<th>작성자</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${adminUserBookmarkList}" var="book">
											<tr>
												<td>${book.board_num}</td>
												<td>${book.mem_nickname}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>

		<!-- body end -->


		<footer class="container-fluid text-center">
			<p>Footer Text</p>
		</footer>
</body>

<script>
function goMain() {
	history.back();
}

function goUser() {
	history.back();
}

function goBoard() {
	history.back();
}

function goRepProc() {
	history.back();
}

function goNotice() {
	history.back();
}
</script>
</html>