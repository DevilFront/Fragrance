<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<main class="main">

	<h1 class="d-none">카테고리</h1>
	<section class="sub-menu">
		<h1>Best Items</h1>

	</section>
	<!-- ------------------------각 1위 상품------------------------------------------ -->
	<section class="best-item">
		<h1 class="d-none">popularity menu</h1>
		<div>
			<div>
				<h2 class="d-none">men 1st item</h2>
				<section class="best-item-m">
					<img class="img-best-m" src="../images/celeb/man_best_seller.png">
					<c:forEach var="m" items="${men }" begin="0" end="0">
						<span> <img class="img img2" src="../images/${m.img }">
						</span>
						<a href="/HTML/rank/detail?id=${m.itemnums }"> <span
							class="description">
								<dl>
									<dt>&nbsp</dt>
									<dt>&nbsp</dt>
									<dt>&nbsp</dt>
									<dt>&nbsp</dt>
									<dt>${m.name }</dt>
									<dd>${m.brand }</dd>
									<dd>&nbsp</dd>
								</dl>
						</span></a>
					</c:forEach>
				</section>
			</div>
			<div>
				<h2 class="d-none">woman 1st item</h2>
				<section class="best-item-w">
					<img class="img-best-w" src="../images/celeb/woman_best_seller.png">
					<c:forEach var="w" items="${women }" begin="0" end="0">
						<span> <img class="img" src="../images/${w.img }">
						</span>
						<a href="/HTML/rank/detail?id=${w.itemnums }"> <span
							class="description">
								<dl>
									<dt>&nbsp</dt>
									<dt>&nbsp</dt>
									<dt>&nbsp</dt>
									<dt>&nbsp</dt>
									<dt>${w.name }</dt>
									<dd>${w.brand }</dd>
									<dd>&nbsp</dd>
								</dl>
						</span>
						</a>
					</c:forEach>
				</section>
			</div>
		</div>
		<div>

			<!-- request.setAttribute("men", manslist);
					request.setAttribute("women", womanlist);
					request.setAttribute("unisex", unisexlist);
					request.setAttribute("etc", etclist); -->
			<div>
				<h2 class="d-none">Unisex item</h2>
				<section class="best-item-u">
					<img class="img-best-u" src="../images/celeb/uni_best_seller.png">
					<c:forEach var="u" items="${unisex }" begin="0" end="0">
						<span> <img class="img" src="../images/${u.img }">
						</span>
						<a href="/HTML/rank/detail?id=${u.itemnums }"> <span
							class="description">
								<dl>
									<dt>&nbsp</dt>
									<dt>&nbsp</dt>
									<dt>&nbsp</dt>
									<dt>&nbsp</dt>
									<dt>${u.name }</dt>
									<dd>${u.brand }</dd>
									<dd>&nbsp</dd>
								</dl>
						</span>
						</a>
					</c:forEach>
				</section>
			</div>
			<div>
				<h2 class="d-none">etc item</h2>
				<section class="best-item-e">
					<img class="img-best-e" src="../images/celeb/etc_best_seller.png">
					<c:forEach var="e" items="${etc }" begin="0" end="0">
						<span> <img class="img" src="../images/${e.img }">
						</span>
						<a href="/HTML/rank/detail?id=${e.itemnums }"> <span
							class="description">
								<dl>
									<dt>&nbsp</dt>
									<dt>&nbsp</dt>
									<dt>&nbsp</dt>
									<dt>&nbsp</dt>
									<dt>${e.name }</dt>
									<dd>${e.brand }</dd>
									<dd>&nbsp</dd>
								</dl>
						</span>
						</a>
					</c:forEach>
				</section>
			</div>
		</div>
	</section>

	<!-- ------------------------1위 상품 동영상------------------------------------------ -->
	<section class="ad-video">
		<h1 class="d-none">ad video</h1>
		<section class="ad-video-m-section">
			<h1>Commercial video of men 1st item</h1>
			<div class="ad-video-m">
				<iframe id="main_fullvideo-id" frameborder="0" allowfullscreen="1"
					allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
					title="YouTube video player" width="100%" height="100%"
					src="https://www.youtube.com/embed/NgEfASMDrMU?autoplay=1&rel=0&controls=0&disablekb=1&showinfo=0&start=1&enablejsapi=1&origin=https%3A%2F%2Fdiatv.cjenm.com&widgetid=1">
				</iframe>
			</div>
		</section>
		<section class="ad-video-w-section">
			<h1>Commercial video of women 1st item</h1>
			<div class="ad-video-w">
				<iframe id="main_fullvideo-id" frameborder="0" allowfullscreen="1"
					allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
					title="YouTube video player" width="100%" height="100%"
					src="https://www.youtube.com/embed/fFv5smPPuZo?autoplay=1&rel=0&controls=0&disablekb=1&showinfo=0&start=1&enablejsapi=1&origin=https%3A%2F%2Fdiatv.cjenm.com&widgetid=1">
				</iframe>
			</div>
		</section>
	</section>

	<!-- ------------------------추천 상품------------------------------------------ -->
	<section class="recomm">
		<h1>Bon Parfum이 추천하는 이 달의 향수</h1>
		<div class="recomm-prdwrap">

		<c:forEach var="s" items="${summer }" >
			<div>
				<h2 class="d-none">recommend item1</h2>
				<section class="recomm-item1">
					<a href="/HTML/rank/detail?id=${s.itemnums}"> <!--디테일페이지로--> 
					<img class="itemtag1" src="../images/main-recomm1.png" alt="추천 제품 딱지">
						<span> 
							<img class="itemimg" src="../images/${s.img }" alt="추천 제품">
						</span> 
					<span class="r-description">
						<dl>
							<dt>${s.name }</dt>
							<dt>${s.brand }</dt>
						</dl>
					</span>
					</a>
				</section>
			</div>
			</c:forEach>

			<c:forEach var="c" items="${crab }" >
				<div>
					<h2 class="d-none">recommend item2</h2>
					<section class="recomm-item2">
						<a href="/HTML/rank/detail?id=${c.itemnums}"> 
						<img class="itemtag2" src="../images/main-recomm2.png" alt="추천 제품 딱지"> 
						<span>
							<img class="itemimg" src="../images/${c.img }" alt="추천 제품">
						</span> 
						<span class="r-description">
							<dl>
								<dt>${c.name }</dt>
								<dt>${c.brand }</dt>
							</dl>
						</span>
						</a>
					</section>
				</div>
			</c:forEach>
			
			<c:forEach var="d" items="${daily }" >
				<div>
					<h2 class="d-none">recommend item3</h2>
					<section class="recomm-item3">
						<a href="/HTML/rank/detail?id=${d.itemnums}">
						 <img class="itemtag3" src="../images/main-recomm3.png" alt="추천 제품 딱지"> <span>
								<img class="itemimg" src="../images/${d.img }" alt="추천 제품">
						</span> <span class="r-description">
							<dl>
								<dt>${d.name }</dt>
								<dt>${d.brand }</dt>
							</dl>
						</span>
						</a>
					</section>
				</div>
			</c:forEach>

		</div>
	</section>
</main>