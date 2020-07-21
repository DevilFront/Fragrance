<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/home/reset.css" type="text/css" rel="stylesheet">
<link href="css/home/style.css" type="text/css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
<link rel="shortcut icon" href="data:image/x-icon;," type="image/x-icon">
<title>Fragrance</title>
</head>

<body>
	<!-- -----header menu------------------------------- -->
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
					<a href="/index"><img src="images/logo-img.png" /></a>
				</h1>
			</nav>

			<nav class="member-menu">
				<h1 class="d-none">로그인메뉴</h1>
				<ul>
					<li><a href="/login">로그인</a></li>
					<li><a href="">회원가입</a></li>
				</ul>
			</nav>
		</section>

		<section class="main-category">
			<h1 class="d-none">메인 메뉴</h1>
			<nav class="main-menu">
				<h1 class="d-none">메인 메뉴</h1>
				<ul>

					<li><a href="/HTML/rank/rankIndex.jsp">Rank</a></li>
					<li><a href="/HTML/celeb/celeb.html">Celeb</a></li>
					<li><a href="/HTMl/rec/recomm.html">Recomm.</a></li>
				</ul>
			</nav>
		</section>
	</header>
	<!-- --------main banner------------------------------- -->
	<div id="banner">
		<section class="banner-container">
			<h1 class="d-none">banner</h1>

		</section>
	</div>

	<!-- -------------main------------------------------- -->
	<div id="body">
		<main class="main">
			<h1 class="d-none">카테고리</h1>
			<section class="sub-menu">
				<h1 class="d-none">서브메뉴</h1>
				<ul>
					<li><a href="">Men</a></li>
					<li><a href="">Women</a></li>
					<li><a href="">Unisex</a></li>
					<li><a href="">Solid</a></li>
					<li><a href="">Rollerballs</a></li>
				</ul>
			</section>
			<!-- ------------------------각 1위 상품------------------------------------------ -->
			<section class="best-item">
				<h1 class="d-none">popularity menu</h1>
				<div>
					<div>
						<h2 class="d-none">men 1st item</h2>
						<section class="best-item-m">
							<img class="img-best-m"
								src="images/celeb/man_best_seller.png"> <span>
								<img class="img" src="images/1399453561328.jpg">
							</span> <span class="description d-none">
								<dl>
									<dt>&nbsp</dt>
									<dt>&nbsp</dt>
									<dt>&nbsp</dt>
									<dt>&nbsp</dt>
									<dt>EAU FRAÎCHE</dt>
									<dd>VERSACE</dd>
									<dd>giving life to a surprisingly</dd>
								</dl>
							</span>
						</section>
					</div>
					<div>
						<h2 class="d-none">men 1st item</h2>
						<section class="best-item-w">
							<img class="img-best-w"
								src="images/celeb/woman_best_seller.png"> <span>
								<img class="img" src="images/celeb/dior.png">
							</span> <span class="description d-none">
								<dl>
									<dt>&nbsp</dt>
									<dt>&nbsp</dt>
									<dt>&nbsp</dt>
									<dt>&nbsp</dt>
									<dt>Miss Dior</dt>
									<dd>Christian Dior</dd>
									<dd>What would you do for love?</dd>
								</dl>

							</span>
						</section>
					</div>
				</div>
				<div>
					<div>
						<h2 class="d-none">Unisex item</h2>
						<section class="best-item-u">
							<img class="img-best-u"
								src="images/celeb/uni_best_seller.png"> <span>
								<img class="img"
								src="images/celeb/dior.png">
							</span> <span class="description d-none">
								<ul>
									<li>상품명: 에끌라 드 아르페쥬 EDP</li>
									<li>브랜드: 랑방</li>
									<li>설명: 오랜 시간 동안 사랑을 받아오고 있는 대표 향수</li>
								</ul>
							</span>
						</section>
					</div>
					<div>
						<h2 class="d-none">etc item</h2>
						<section class="best-item-e">
							<img class="img-best-e"
								src="images/celeb/etc_best_seller.png"> <span>
								<img class="img"
								src="https://cdn.aritaum.com/UPLOAD/UPLOAD_IMAGE/C020/201904/IMG1556YsE612697039.jpg?quality=80">
							</span> <span class="description d-none">
								<ul>
									<li>상품명: 에끌라 드 아르페쥬 EDP</li>
									<li>브랜드: 랑방</li>
									<li>설명: 오랜 시간 동안 사랑을 받아오고 있는 대표 향수</li>
								</ul>
							</span>
						</section>
					</div>
				</div>
			</section>

			<!-- ------------------------1위 상품 동영상------------------------------------------ -->
			<section class="ad-video">
				<h1 class="d-none">ad video</h1>
				<section>
					<h1>Commercial video of men 1st item</h1>
					<div class="ad-video-m">
						<iframe id="main_fullvideo-id" frameborder="0" allowfullscreen="1"
							allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
							title="YouTube video player" width="100%" height="100%"
							src="https://www.youtube.com/embed/Ocjdar1yqW8?autoplay=1&rel=0&controls=0&disablekb=1&showinfo=0&start=1&enablejsapi=1&origin=https%3A%2F%2Fdiatv.cjenm.com&widgetid=1">
						</iframe>
					</div>
				</section>
				<section>
					<h1>Commercial video of women 1st item</h1>
					<div class="ad-video-w">
						<iframe id="main_fullvideo-id" frameborder="0" allowfullscreen="1"
							allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
							title="YouTube video player" width="100%" height="100%"
							src="https://www.youtube.com/embed/h4s0llOpKrU?autoplay=1&rel=0&controls=0&disablekb=1&showinfo=0&start=1&enablejsapi=1&origin=https%3A%2F%2Fdiatv.cjenm.com&widgetid=1">
						</iframe>
					</div>
				</section>
			</section>

			<!-- ------------------------추천 상품------------------------------------------ -->
			<section class="recomm">
				<h1>Bon Parfum이 추천하는 이 달의 향수</h1>
				<div class="recomm-prdwrap">

					<div>
						<h2 class="d-none">recommend item1</h2>
						<section class="recomm-item1">
							<a href=""> <!--디테일페이지로--> <img class="itemtag1"
								src="images/main-recomm1.png" alt="추천 제품 딱지"> <span>
									<img class="itemimg" src="images/1399020113282.jpg"
									alt="추천 제품">
							</span> <span class="r-description d-none">
									<dl>
										<dt>제품명제품명제품명</dt>
										<dt>브랜드명</dt>
									</dl>
							</span>
							</a>
						</section>
					</div>

					<div>
						<h2 class="d-none">recommend item2</h2>
						<section class="recomm-item2">
							<a href=""> <img class="itemtag2"
								src="images/main-recomm2.png" alt="추천 제품 딱지"> <span>
									<img class="itemimg" src="images/1399020524001.jpg"
									alt="추천 제품">
							</span> <span class="r-description d-none">
									<dl>
										<dt>제품명제품명</dt>
										<dt>브랜드명</dt>
									</dl>
							</span>
							</a>
						</section>
					</div>

					<div>
						<h2 class="d-none">recommend item3</h2>
						<section class="recomm-item3">
							<a href=""> <img class="itemtag3"
								src="images/main-recomm3.png" alt="추천 제품 딱지"> <span>
									<img class="itemimg" src="images/1399023242691.jpg"
									alt="추천 제품">
							</span> <span class="r-description d-none">
									<dl>
										<dt>제품명제품명제품명</dt>
										<dt>브랜드명</dt>
									</dl>
							</span>
							</a>
						</section>
					</div>

				</div>
			</section>
		</main>
	</div>
</body>
<!-- ------------footer------------------------------- -->
<footer id="footer">
	<div class="footer-container">Copyright 2020. Group5. All rights
		reserved.</div>
</footer>

</html>