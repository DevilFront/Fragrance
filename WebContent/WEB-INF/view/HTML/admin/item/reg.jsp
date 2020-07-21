<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="../../../css/admin/reset.css" type="text/css" rel="stylesheet">
    <link href="../../../css/admin/prd_detail_style.css" type="text/css" rel="stylesheet">
    <title>Bon Parfum 관리자 페이지</title>
</head>

<body>
    <script src="../../js/Celeb/utils.js"></script>

	<section class="content-container">
        
		<div id="body">
			<main class="main">
                
                <!-- -------------aside------------------------------- -->
                <aside id="aside">
                    <div class="left_area">
                        <h1> 관리자 홈 </h1>

                        <div class="left-menu">
                                  <section>
                                <h2 class="titmenu">페이지관리</h2>
                                <ul class="submenu">
                                    <li><a href="prdlist"> → 제품목록</a></li>
                                    <li><a href="../board/boardlist"> → 게시글목록</a></li>
                                </ul>	
                            </section>
                            <section> 
                                <h2 class="titmenu">회원관리</h2>
                                <ul class="submenu">
                                    <li><a href="../user/userlist"> → 회원목록</a></li>

                                </ul>
                            </section>  
                        </div>
                    </div>
                </aside>    
                <!-- ------------- aside end -------------------------- -->

                <div class="main-prdinfo">
                    <section class="prdinfo">
                        <h1>< 제품 정보 등록 ></h1>

                        <div class="rightbtn-golist">
                            <a href="prdlist"><button type="submit">목록으로</button></a>  
                        </div>
                        
						<form action="reg" method="post" enctype="multipart/form-data">
                        <div class="tablewarp">
                            <table class="table-part1">
                            
                                <tr>
                                    <td rowspan="7">
                                        <img class="prd-img" src="../../images/Hera-Exceptional.png">
                                    </td>
                                </tr>
                                <tr>
                                    <td class="info-tit"> 이미지 등록 </td>
                                    <td class="filebox info-con">
                                        
                                            <input type="file" name="file" />
                                       
                                    </td>
                                </tr>
                                <tr>
                                    <td class="info-tit">제품 번호</td>
                                    <td class="info-con"> 자동</td>
                                </tr>
                                <tr>     
                                    <td class="info-tit">제품명</td>
                                    <td class="info-con">
                                        <input value ="${n.name}" type="text" name="prd-name" id="input" required>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="info-tit">브랜드명</td>
                                    <td class="info-con">
                                        <input value ="${n.brand}" type="text" name="brand-name" id="input" required>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="info-tit">용량 (ml)</td>
                                    <td class="info-con">
                                        <input value ="${n.size}" type="text" name="ml" id="input" required>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="info-tit">가격 (원)</td>
                                    <td class="info-con">
                                        <input value ="${n.price}" type="text" name="price" id="input" required>
                                    </td>
                                </tr>
                            </table>
                            

                            <table class="table-part2">
                                <tr>
                                    <td class="info-tit">향 성분</td>
                                    <td class="info-con rightnone" colspan="3">
                                        <input value ="${n.scent}" type="text" name="scent" id="input" required>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="info-tit">향 설명</td>
                                    <td class="info-con rightnone" colspan="3">
                                        <input  value ="${n.content}" type="text" name="scentexp" id="input" required>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="info-tit">태그</td>
                                    <td class="info-con rightnone" colspan="3">
                                        <input value ="${n.tag}" type="text" name="tag" id="input" required>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="info-tit"> 향수 타입</td>
                                    <td class="info-con">
                                        <select name ="type">
                                            <option  value="스프레이 타입">&nbsp;&nbsp;&nbsp;스프레이 타입&nbsp;&nbsp;&nbsp;</option>
                                            <option  value="롤온 타입">&nbsp;&nbsp;&nbsp;롤온 타입</option>
                                            <option  value="고체 타입">&nbsp;&nbsp;&nbsp;고체 타입</option>
                                        </select>
                                    </td>
                                    <td class="info-tit">타겟 성별</td>
                                    <td class="info-con rightnone">
                                        <form>
                                            <input type="radio" value="woman" name="gender">
                                            <label for="woman">여자</label> 
                                            
                                            <input type="radio" value="man" name="gender" style="margin-left: 40px;">
                                            <label for="man">남자</label> 
                                        </form>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="info-tit">좋아요 (개수/남자)</td>
                                    <td class="info-con" style="font-style: italic">DB</td>
                                    <td class="info-tit">좋아요 (개수/여자)</td>
                                    <td class="info-con rightnone"style="font-style: italic">DB</td>
                                </tr>
                                <tr>
                                    <td class="info-tit bottomnone">조회수</td>
                                    <td class="info-con bottomnone" style="font-style: italic">DB</td>
                                    <td class="info-tit bottomnone">제품 등록일</td>
                                    <td class="info-con  bottomnone rightnone"><input type="date" id="name" name="name" required minlength="5" maxlength="8" size="15">
                                    </td>
                                </tr>
                            </table>    
                            
                        </div>

                        <div class="register-btn">
                            <a href="detail?id=${n.itemnums}"><button type="submit">등록하기</button></a>  
                        </div>
                        
                        </form>

                    </section>
                </div>

			</main>
		</div>
	</section>
</body>
</html>
