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
				<li><a href="list?c=m&p=1" class="hide show">Men</a></li>
				<li><a href="list?c=w&p=1" class="hide show">Women</a></li>
				<li><a href="list?c=u&p=1" class="hide show">Unisex</a></li>
				<li><a href="list?c=s&p=1" class="hide show">Solid</a></li>
				<li><a href="list?c=r&p=1" class="hide show">Rollerball</a></li>
			</ul>
		</section>
	
	</section>
	<section class="banner">
		<div class="banner-slide">
			<img src="/../../images/banner/main-mainbn1.png" >
		</div>
		<div class="banner-slide">
			<img src="/../../images/banner/main-mainbn2.png">
		</div>
		<div class="banner-slide">
			<img src="/../../images/banner/main-mainbn3.png">
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
					<c:set var="i" value="${i+1}" />
					<tr>
						<td>${(param.p*10)-10+i }</td>
						<td class="table-img"><a href="detail?id=${list.itemnums }"><img
								width="160px" height="140px" src="../../images/${list.img }"></a></td>
						<td class="effect"><a href="detail?id=${list.itemnums}">${list.name }</a></td>
						<td>${list.brand }</td>
						<td>${list.size }</td>
						<td>${list.scent }</td>
						<fmt:formatNumber type="number" maxFractionDigits="3"
							value="${list.price }" var="price" />
						<td>${price }</td>
						<td>${list.maleLike+list.femaleLike}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<div class="pager">
         <ul>
            <c:forEach var="in" begin="1" end="${index }">
               <c:set value="${pa+1 }" var="pa" />

               <c:choose>
                  
                  <c:when test="${in eq param.p }">
                     <li><a
                        style=" font-size: 40px; color: red; margin-bottom: 20px"
                        href="list?c=${param.c }&p=${pa}"><div>${pa }</div></a></li>
                  </c:when>

                  <c:when test="${param.p+2<pa}">
                     <li><a
                        style="position: absolute; left: 0px; top: 0px; display: none"
                        href="list?c=${param.c }&p=${pa}">${pa }</a></li>
                  </c:when>
                  <c:when test="${param.p-2>pa}">
                     <li><a style="position: absolute; display: none"
                        href="list?c=${param.c }&p=${pa}">${pa }</a></li>
                  </c:when>

                  <c:otherwise>
                     <li><a href="list?c=${param.c }&p=${pa}">${pa }</a></li>
                  </c:otherwise>
               </c:choose>
            </c:forEach>
            <li style="font-size:20px;right:${param.p};">${param.p }/${index }page</li>
         </ul>
      </div>
	</section>
</main>