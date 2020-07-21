<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="../../css/reset.css" type="text/css" rel="stylesheet">
<link href="../../css/rank/rankliststyle.css" type="text/css"
	rel="stylesheet">
	
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
<title>RankList</title>
<style rel="stylesheet">
@charset "UTF-8";

@import url(https://fonts.googleapis.com/css?family=Lato:400,700);

* {
	-moz-box-sizing: border-box;
	-webkit-box-sizing: border-box;
	box-sizing: border-box;
}

body {
	font-family: 'Lato', sans-serif;
	--background-color: black;
}
</style>

</head>

<body>

	<header id="header">
		<h1 class="d-none">헤더</h1>

		<section class="header-menu">

			<nav class="search">
				<h1 class="d-none">검색폼</h1>
				<form>
					<fieldset>
						<div>
							<legend class="d-none">검색폼</legend>

							<input type="text" name="query"> <i class="fas fa-search"
								style="z-index: 999px;"> <input class="search-form"
								type="submit" value="검색"></i>
						</div>
					</fieldset>
				</form>
			</nav>

			<nav class="logo">
				<h1>
					<a href="../../index.html"><img src="../../images/logo.png" /></a>
				</h1>
			</nav>

			<nav class="member-menu">
				<h1 class="d-none">로그인메뉴</h1>
				<ul>
					<li><a href="login.html">로그인</a></li>
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
				<li><a href="../rank/index.html" class="hide show">Rank</a></li>
				<li><a href="../celeb/celeb.html" class="hide show">Celeb</a></li>
				<li><a href="../rec/recomm.html" class="hide show">Recomm</a></li>
			</ul>
		</nav>
	</section>


	<section class="content-container">
		<div id="body">
			<main class="main">
				<section class="content-container category-container">
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

				</section>
				<section class="banner">
					<div class="banner-slide">
						<img src="../../images/banner2.png" width="1240px" height="500px">
					</div>
					<div class="banner-slide">
						<img src="../../images/dior.png" width="1240px" height="500px">
					</div>
					<div class="banner-slide">
						<img src="../../images/Lancome-Miracle.png" width="1240px"
							height="500px">
					</div>
					<div class="banner-slide">
						<img src="../../images/Dior-JenniferLarwens.jpg" width="1240px"
							height="500px">
					</div>

				</section>


				<section class="list">
					<table class="list-table">
						<thead>
							<tr>
								<td>번호</td>
								<td>이미지</td>
								<td>제품명</td>
								<td>브랜드</td>
								<td>용량(ml/g)</td>
								<td>향</td>
								<td>가격</td>
								<td>좋아요</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="list" items="${list }">
								<c:set var="i" value="${i+1 }"/>
									<tr>
										<td>${i }</td>
										<td class="table-img"><img width="160px" height="140px"
											src="../../images/${list.img }"></td>
										<td><a href="detail?id=${list.itemnums}">${list.name }</a></td>
										<td>${list.brand }</td>
										<td>${list.size }</td>
										<td>${list.scent }</td>
										<fmt:formatNumber type="number" maxFractionDigits="3" value="${list.price }" var="price"/>
										<td>${price }</td>
										<td>${list.maleLike+list.femaleLike}</td>
									</tr>
							</c:forEach>
						</tbody>
					</table>

					<div class="pager">
						<ul>
							<li><a class="orange" href="">1</a></li>
							<li><a href="">2</a></li>
							<li><a href="">3</a></li>
							<li><a href="">4</a></li>
							<li><a href="">5</a></li>
						</ul>
					</div>
				</section>
			</main>
		</div>
	</section>
</body>
<script src="list.js"></script>
<script src="menuaction.js"></script>


</html>