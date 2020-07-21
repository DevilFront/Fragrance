<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- -------------main------------------------------- -->

	<main class="main">
		<section class="result-content-container">
			<h1 class="recomm-title">당신에게 추천 드리는 세 가지 향수입니다</h1>
			<section class="recomm-tag-prdlist">
				<h1 class="d-none">목록</h1>
				<ul class="prdinfo-warp">
					<c:forEach var="n" items="${result}" varStatus="st">
						<li><a href="prd-detail.html">
								<div class="prdinfo-warp-img">
									<img src="../../images/${n.img }">
								</div>
								<div class="prdinfo-warp-text">
									<span>${n.name }</span>
									<p class="prdname">${n.brand }</p>
								</div>
						</a></li>
					</c:forEach>
				</ul>
			</section>

			<section class="select-result">
				<h1 class="select-result-title">당신이 선택한 결과입니다.</h1>
				<section class="select-result-list">
					<h1 class="d-none">선택한 목록</h1>

					<ul>
						<li><span>#성별</span> <span>${param.gender }</span></li>

						<li><span>#나이대</span> <span>${param.age }</span></li>

						<li><span>#계절</span> <span>${param.season }</span></li>

						<li><span>#향</span> <span>${param.scent }</span></li>
					</ul>

				</section>
			</section>
		</section>
	</main>
</body>

<!-- ------------footer------------------------------- -->


</html>