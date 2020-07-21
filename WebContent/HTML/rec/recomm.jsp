<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="shortcut icon" href="data:image/x-icon;," type="image/x-icon">
<main class="recomm-main">

	<div class="mainbn-recomm">
		<h1 class="d-none">메인 컨텐츠</h1>
		<section class="left-mainbn">
			<h1 class="d-none">향수 컨셉 이미지 영역 (좌)</h1>
		</section>

		<h1 class="d-none">취향 설문 영역 (우)</h1>
		<section class="right-contents">
			<h1>
				취향 분석을 통해 <br>추천 받을 향수를 찾아보세요!
			</h1>
			<br>
			<form class="leftbt">
				<label>Q. 성별은 무엇인가요?</label><br> <a href="survey?gender=여성"><input
					type="button" value="여성"></a> <a href="survey?gender=남성"><input
					type="button" value="남성"></a>
			</form>
		</section>
	</div>


	<div class="fragrances-recomm">

		<div>
			<h1 class="d-none">향수 추천 태그명</h1>
			<nav>
				<h1>지금 인기있는 향수 TOP-12를 추천합니다!</h1>
				<ul class="tag-box">
					<li><a href="recomm-data?tag=게자리"># 게자리</a></li>
					<li><a href="recomm-data?tag=10대"># 10대</a></li>
					<li><a href="recomm-data?tag=20대"># 20대</a></li>
					<li><a href="recomm-data?tag=30대"># 30대</a></li>
					<li><a href="recomm-data?tag=40대"># 40대</a></li>
					<li><a href="recomm-data?tag=성년의날"># 성년의날</a></li>
					<li><a href="recomm-data?tag=여자향수"># 남자가좋아하는여자향수</a></li>
					<li><a href="recomm-data?tag=남자향수"># 여자가좋아하는남자향수</a></li>
					<li><a href="recomm-data?tag=여름"># 여름향수</a></li>
				</ul>
			</nav>
		</div>

		<div class="prd-display">

			<div class="recomm-prdlist-bnt">
				<div class="moveBtn-pre">
					<img src="../../images/prebt.png">
				</div>

				<div class="moveBtn-next">
					<img src="../../images/nextbt.png">
				</div>
			</div>

			<div class="prdinfo-wrap">
				<div class="carousel">
					<c:forEach var="n" items="${recommend}" varStatus="st">
						<div class="recomm-prd">
							<a href="prd-detail?id=${n.itemNums}"><img
								src="../../images/${n.img }"></a> <span class="pName">${n.name }</span>
							<p class="pBrand">${n.brand }</p>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
<script src="recomm.js"></script>
</main>

