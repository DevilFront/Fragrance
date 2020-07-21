<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="../../css/rank/rankstyle.css" type="text/css" rel="stylesheet">
<main class="main">
				<section class="content-container">
					<h1 class="d-none">카테고리</h1>
					<section class="sub-menu">
						<h1 class="d-none">서브메뉴</h1>
						<ul>
							<li><a href="list?c=m&p=1" class="hide show">Men</a></li>
							<li><a href="list?c=w&p=1" class="hide show">Women</a></li>
							<li><a href="list?c=u&p=1" class="hide show">Unisex</a></li>
							<li><a href="list?c=s&p=1" class="hide show">Solid</a></li>
							<li><a href="list?c=r&p=1" class="hide show">Rollerball</a></li>
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
											<a href="detail?id=${i2.itemnums }"><img src="../../images/${i2.img }"></a>
											</div>
											<div><a href="detail?id=${i2.itemnums }">${i2.brand }</a></div>
											<div><a href="detail?id=${i2.itemnums }">${i2.name }</a></div>
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
												<a href="detail?id=${i2.itemnums }"><img src="../../images/${i2.img }"></a>
											</div>
											<div><a href="detail?id=${i2.itemnums }">${i2.brand }</a></div>
											<div><a href="detail?id=${i2.itemnums }">${i2.name }</a></div>
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
												<a href="detail?id=${i2.itemnums }"><img src="../../images/${i2.img }"></a>
											</div>
											<div><a href="detail?id=${i2.itemnums }">${i2.brand }</a></div>
											<div><a href="detail?id=${i2.itemnums }">${i2.name }</a></div>
										</li>
									</c:forEach>
								</c:forEach>
							</ul>
						</section>
						<section class="rank-category">
							<div>Solid</div>
							<ul>
								<c:forEach var="i" items="${items }" begin="3" end="3">
									<c:forEach var="i2" items="${i}" begin="0" end="2">
										<li>
											<div>
												<a href="detail?id=${i2.itemnums }"><img src="../../images/${i2.img }"></a>
											</div>
											<div><a href="detail?id=${i2.itemnums }">${i2.brand }</a></div>
											<div><a href="detail?id=${i2.itemnums }">${i2.name }</a></div>
										</li>
									</c:forEach>
								</c:forEach>
							</ul>
						</section>
						<section class="rank-category">
							<div>Rollerball</div>
							<ul>
								<c:forEach var="i" items="${items }" begin="4" end="4">
									<c:forEach var="i2" items="${i}" begin="0" end="2">
										<li>
											<div>
												<a href="detail?id=${i2.itemnums }"><img src="../../images/${i2.img }"></a>
											</div>
											<div><a href="detail?id=${i2.itemnums }">${i2.brand }</a></div>
											<div><a href="detail?id=${i2.itemnums }">${i2.name }</a></div>
										</li>
									</c:forEach>
								</c:forEach>
							</ul>
						</section>
					</section>
				</section>
			</main>
