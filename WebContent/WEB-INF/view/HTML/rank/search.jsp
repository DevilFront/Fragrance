<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<main class="main">
   <section class="content-container result">

      <section class="search-result margin">
         <h1 class="search-h1 margin-bottom">"${param.query }" 에 대한 향수 검색결과 </h1>
         <c:forEach var="i" items="${item }">
               <div class="search-item-list">
                  <div class="search-img">
                     <a href="/HTML/rank/detail?id=${i.itemnums }"><img src="/images/${i.img }" width="200px" height="200px" alt=""></a>
                  </div>
                  <div class="search-innerbox">
                     <div class="search-item-title"><a href="/HTML/rank/detail?id=${i.itemnums }">
                        <span class="font-size">품명 : ${i.name }</span></a>
                     </div>
                     <div class="search-item-content"><a href="/HTML/rank/detail?id=${i.itemnums }">
                        <span class="font-size">소개 : ${i.content } </span><br> <br>
                        - 태그 : ${i.tag }<br>
                        - 가격 : ${i.price } <br>
                        - 타입 : ${i.type}</a>
                     </div>
                  </div>
               </div>
         </c:forEach>
      </section>

      <section class="search-result margin2">
      
         <h1 class="margin-bottom">"${param.query }" 에 대한 기사 검색결과</h1>
         <c:forEach var="c" items="${celeb }" >
            
               <div class="search-item-list2">
                  <div class="search-item-title2">
                  <a href="search-data">   <span class="font-size">제목 : ${c.title } </span>
                     <span ><br> 
                        작성자</span> : ${c.writerId } </a>
                  </div>
                  <div class="search-item-content2">
                  <a href="">   <span class="font-size">소개
                      : ${c.content}<br><br></span>
                        - 좋아요 : ${c.like}<br> 
                        - 조회수 : ${c.hit}<br> 
                        - 연예인 : ${c.celeb} </a></div>
               </div>
         </c:forEach>
      </section>
   </section>
      <div class="search-button"><a href="rank/list?c=${param.query }&p=1"><img src="../../../images/plus2.jpg" style="width:30px; height:30px;">&nbsp더보기</a></div>
</main>
<script src="../../../../js/Celeb/celeb.js"></script>

