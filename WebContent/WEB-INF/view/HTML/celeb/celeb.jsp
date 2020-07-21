<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <link rel="shortcut icon" href="data:image/x-icon;," type="image/x-icon">
<main id="main">
		<section class="container">
			<h1 class="d-none">Content Info</h1>

			<section class="banner">
				<h1 class="d-none">top-banner</h1>
				<img class="top-banner" src="../../images/banner/LV-banner3.png">
			</section>

			<section class="grid-container1">
				<h1 class="d-none">grid-container1</h1>
				<div class="grid-item item1">
					<span><img data-id="${c[0].titleNums}" class="img" src="../../images/celeb/${c[0].imgBanner }"></span>
				</div>

				<div class="grid-item item2">
					<span><img data-id="${c[1].titleNums}" class="img" src="../../images/celeb/${c[1].imgBanner }"></span>
				</div>

				<div class="grid-item item3">
					<span><img data-id="${c[2].titleNums}" class="img" src="../../images/celeb/${c[2].imgBanner }"></span>
				</div>

				<div class="grid-item item4">
					<span><img data-id="${c[3].titleNums}" class="img" src="../../images/celeb/${c[3].imgBanner }"></span>
				</div>

			</section>

			<!-- -------------middle banner----------------------------- -->
			<section>
				<h1 class="d-none">middle-banner</h1>
				<img class="middle-banner"
					src="../../images/banner/ChanelBleude-banner.png">
			</section>
			<!-- -------------middle banner----------------------------- -->


			<section class="grid-container2">
				<h1 class="d-none">grid-container2</h1>
				<div class="grid-item item5">
					<img data-id="${c[4].titleNums}" class="img" src="../../images/celeb/${c[4].imgBanner }">
				</div>
				<div class="grid-item item6">
					<img data-id="${c[5].titleNums}" class="img" src="../../images/celeb/${c[5].imgBanner }">
				</div>
			</section>
			<!-- ---------------grid 안의 내용 중 onload 버튼------------------------ -->
			<section class="onloadblock">
				<h1 class="d-none">onload block</h1>
				<input type="button" class="onload" value="onload">
			</section>

			<section class="grid-container3">
				<h1 class="d-none">grid-container3</h1>
				<div class="grid-item item7">
					<img data-id="${c[6].titleNums}" class="img" src="../../images/celeb/${c[6].imgBanner }">
				</div>
				<div class="grid-item item8">
					<img data-id="${c[7].titleNums}" class="img" src="../../images/celeb/${c[7].imgBanner }">
				</div>
				<div class="grid-item item9">
					<img data-id="${c[8].titleNums}" class="img" src="../../images/celeb/${c[8].imgBanner }">
				</div>
			</section>
			<!-- ---------------grid 안의 내용 중 두번째 onload 버튼------------------------ -->
			<section class="add-onloadblock">
				<h1 class="d-none">onload block</h1>
				<input type="button" class="add-onload" value="onload">
			</section>


			<!-- ----------------------------------설명--------------------------------------- -->
			<section class="description d-none">
				<h1 class="d-none">description</h1>
			</section>	
		</section>
		<script src="../../js/Celeb/celeb.js"></script>
	<script src="../../js/Celeb/utils.js"></script>
	</main>