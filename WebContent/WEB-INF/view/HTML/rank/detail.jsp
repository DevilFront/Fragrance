<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<main class="main">
	<section class="content-container category-container">
		<h1 class="d-none">카테고리</h1>
		<section class="sub-menu">
			<h1 class="d-none">서브메뉴</h1>
			<ul>
				<li><a href="list?c=m&p=1">Men</a></li>
				<li><a href="list?c=w&p=1">Women</a></li>
				<li><a href="list?c=u&p=1">Unisex</a></li>
				<li><a href="list?c=s&p=1">Solid</a></li>
				<li><a href="list?c=r&p=1">Rollerball</a></li>
			</ul>
		</section>

		<section class="detail">
			<c:forEach var="l" items="${list }">
				<div class="detail-img">
					<img src="../../images/${l.img }"
						style="width: 400px; height: 400px;" alt="">
				</div>

				<div class="detail-info">
					<div class="brand">${l.brand }</div>
					<div class="name">${l.name }</div>
					<div class="price-like">
						<fmt:formatNumber type="number" maxFractionDigits="3"
							value="${l.price }" var="price" />
						<div class="price">${l.size }ml/${price }원</div>
						<div class="like">
							<span><img src="images/blankheart.png"
								style="width: 40px; height: 40px;" alt=""> <span><img
									class="img-d-none" src="../../images/celeb/like.png"
									style="width: 40px; height: 40px;" alt=""></span> </span>
							<%-- ${l.maleLike+l.femaleLike }  --%>
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
			<h1 class="review-title"></h1>
			<!-- <div class="review-id"><span>devilfront</span></div> -->
			<form action="comment" method="post">
				<textarea name="regcomment" id="" cols="30" rows="10"></textarea>
				<input type="hidden" name="id" value="${param.id }"> <input
					type="submit" value="등록">
			</form>
		</section>

		<section class="review">
			<h1 class="review-title">댓글</h1>
			<c:forEach var="c" items="${comment }">
				<div class="comment">
					<div class="review-id">
						<span>작성자 : ${c.writerName}</span> <span>작성날짜 : ${c.regDate }</span>
						<c:set var="writer" value="${c.writerName} }" />
						<c:set var="admin" value="admin" />
						<c:if test="${sessionScope.nickName == c.writerName||sessionScope.nickName == admin}">
							<a href="delete?commentid=${c.id }&id=${param.id}">삭제하기</a>
						</c:if>
					</div>
					<div class="review-content">작성내용 : ${c.content }</div>
				</div>
			</c:forEach>
		</section>

	</section>

</main>