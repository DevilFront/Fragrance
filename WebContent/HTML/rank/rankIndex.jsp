<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="../../css/reset.css" type="text/css" rel="stylesheet">
<link href="../../css/rank/rankstyle.css" type="text/css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
<title>Rank</title>
</head>
<body>
	<header id="header">
		<h1 class="d-none">헤더</h1>

		<section class="header-menu">

			<nav class="search">
				<h1 class="d-none">검색폼</h1>
				<form action="search">
					<fieldset>
						<div>
							<legend class="d-none">검색폼</legend>

							<input type="text" name="query"> 
							<i class="fas fa-search" style="z-index: 999px;"> 
							<input type="submit" value="검색"></i>
						</div>
					</fieldset>
				</form>
			</nav>

			<nav class="logo">
				<h1>
					<img src="../../images/logo.png" />
				</h1>
			</nav>

			<nav class="member-menu">
				<h1 class="d-none">로그인메뉴</h1>
				<ul>
					<li><a href="">로그인</a></li>
					<li><a href="">회원가입</a></li>
				</ul>
			</nav>
		</section>
	</header>
	<section class="main-category">
		<h1 class="d-none">메인 메뉴</h1>
		<nav class="main-menu">
			<h1 class="d-none">메인 메뉴</h1>
			<ul>
				<li><a href="rankIndex.jsp">Rank</a></li>
				<li><a href="../celeb/celeb.html">Celeb</a></li>
				<li><a href="../rec/recomm.html">Recomm</a></li>
			</ul>
		</nav>
	</section>
	<section class="content-container">
		<div id="body">
			<main class="main">
				<section class="content-container">
					<h1 class="d-none">카테고리</h1>
					<section class="sub-menu">
						<h1 class="d-none">서브메뉴</h1>
						<ul>
							<li><a href="list?c=m">Men</a></li>
							<li><a href="list?c=w">Women</a></li>
							<li><a href="list?c=u">UNISEX</a></li>
							<li><a href="list?c=s">Solid</a></li>
							<li><a href="list?c=r">Rollerballs</a></li>
						</ul>
					</section>

					<section>
						<h1 class="d-none">종목별 카테고리</h1>
						<section class="rank-category">
							<div>Men</div>
							<ul>
								<c:forEach var="i" items="${items }" begin="0" end="0">
									<c:forEach var="i2" items="${i}" begin="0" end="2">
										<li>
											<div>
											<a href="detail?id=${i2.itemnums }">	<img src="../../images/${i2.img }"></a>
											</div>
											<div>${i2.brand }</div>
											<div>${i2.name }</div>
										</li>
									</c:forEach>
								</c:forEach>
							</ul>
						</section>
						<section class="rank-category">
							<div>Women</div>
							<ul>
								<c:forEach var="i" items="${items }" begin="1" end="1">
									<c:forEach var="i2" items="${i}" begin="0" end="2">
										<li>
											<div>
												<img src="../../images/${i2.img }">
											</div>
											<div>${i2.brand }</div>
											<div>${i2.name }</div>
										</li>
									</c:forEach>
								</c:forEach>
							</ul>
						</section>
						<section class="rank-category">
							<div>Unisex</div>
							<ul>
								<c:forEach var="i" items="${items }" begin="2" end="2">
									<c:forEach var="i2" items="${i}" begin="0" end="2">
										<li>
											<div>
												<img src="../../images/${i2.img }">
											</div>
											<div>${i2.brand }</div>
											<div>${i2.name }</div>
										</li>
									</c:forEach>
								</c:forEach>
							</ul>
						</section>
					</section>
				</section>
			</main>
		</div>
		<section>
			<a href="logo" class="on" style="opacity: 1; bottom: 15px;">위로가기</a>
		</section>
	</section>
</body>

</html>