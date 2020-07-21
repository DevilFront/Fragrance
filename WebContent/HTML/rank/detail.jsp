<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="../../css/reset.css">
    <link rel="stylesheet" href="../../css/rank/rankliststyle.css">
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

                            <input type="text" name="query">
                            <i class="fas fa-search" style="z-index: 999px;"> <input class="search-form" type="submit"
                                    value="검색"></i>
                        </div>
                    </fieldset>
                </form>
            </nav>

            <nav class="logo">
                <h1><a href="../../index.html"><img src="../../images/logo.png" /></a></h1>
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
                            <li><a name="category" class="hide show" href="../rank/list.html">Men</a></li>
                            <li><a name="category" class="hide show" href="../rank/list.html">Women</a></li>
                            <li><a name="category" class="hide show" href="../rank/list.html">UNISEX</a></li>
                            <li><a name="category" class="hide show" href="../rank/list.html">Solid</a></li>
                            <li><a name="category" class="hide show" href="../rank/list.html">Rollerballs</a></li>
                        </ul>
                    </section>


                    <section class="detail">
							<c:forEach var="l" items="${list }">
                        <div class="detail-img"><img src="../../images/${l.img }" style="width: 400px; height: 400px;" alt="">
                        </div>

						<div class="detail-info">
								<div class="brand">${l.brand }</div>
								<div class="name">${l.name }</div>
								<div class="price-like">
								<fmt:formatNumber type="number" maxFractionDigits="3" value="${l.price }" var="price"/>
									<div class="price">${l.size }ml/ ${price }원</div>
									<div class="like">
										<span><img src="images/blankheart.png"
											style="width: 40px; height: 40px;" alt=""> <span>
												<img class="img-d-none" src="images/redheart.png"
												style="width: 40px; height: 40px;" alt="">
										</span> </span> ${l.maleLike+l.femaleLike }
									</div>
								</div>
								<div class="item-info">
									<div class="font">소개</div>
									${l.content }
								</div>
								<div class="item-info">
									<div class="font">타입/향</div>
									${l.type }/${l.scent }
								</div>
								<div class="item-info">
									<div class="font">태그</div>
									${l.tag }
								</div>
							</c:forEach>
						</div>
					</section>


                    
                    
                    <section class="review-reg">
                        <h1 class="review-title">리뷰 등록소><</h1>
                        <!-- <div class="review-id"><span>devilfront</span></div> -->
                        <textarea name="" id="" cols="30" rows="10">

                        </textarea>
                        <input type="button" value="등록">
                    </section>


                    <section class="review">
                        <h1 class="review-title">실화100% 솔직 리뷰</h1>
                        <div class="comment">
                            <div class="review-id"><span>devilfront</span>
                                <span>20-06-05</span></div>
                            <div class="review-content">이거는 제가 써본 결과 잔향 및 냄새가 기가막히며 앚 적극추천드리는 바입니다 참고로 가격도 개꿀딱임 ㄹㅇㅋㅋ루삥뽕
                            </div>
                        </div>
                    </section>



                </section>

            </main>

        </div>
    </section>
</body>
<script src="js/rank/index.js"></script>
<script src="js/rank/list.js"></script>

</html>