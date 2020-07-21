<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header id="header">
	<h1 class="d-none">헤더</h1>

	<section class="header-menu">

		<nav class="search">
			<h1 class="d-none">검색폼</h1>
			<form action = "/HTML/search" method = "get">
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
				<a href="/index"><img
					src="../../images/banner/logo-img.png" /></a>
			</h1>
		</nav>

		<nav class="member-menu">
			<h1 class="d-none">로그인메뉴</h1>
			<ul>
				<c:if test="${nickName != null }">
					<li>${sessionScope.nickName }님<br>반갑습니다!
					</li>
				</c:if>
				<c:set var="admin" value="admin" />
				<c:if test="${sessionScope.isAdmin == admin}">
					<li><a href="/admin/item/prdlist">관리자 페이지 </a></li>
				</c:if>

				<c:if test="${nickName == null }">
					<li><a href="/login">로그인</a></li>
				</c:if>
				<c:if test="${nickName != null }">
					<li><a href="/logout">로그아웃</a></li>
				</c:if>
				<li><a href="/login">회원가입</a></li>
			</ul>
		</nav>
	</section>

</header>
<section class="main-category">
	<h1 class="d-none">메인 메뉴</h1>
	<nav class="main-menu">
		<h1 class="d-none">메인 메뉴</h1>
		<ul>

			<li><a href="/HTML/rank/rankIndex" class="hide show">Rank</a></li>
			<li><a href="/HTML/celeb/celeb" class="hide show">Celeb</a></li>
			<li><a href="/HTML/rec/recomm" class="hide show">Recommed</a></li>
		</ul>
	</nav>
</section>