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
    <link href="../../../css/admin/prd_list_style.css" type="text/css" rel="stylesheet">
    <title>Bon Parfum 관리자 페이지</title>
</head>

<body>
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
                                    <li><a href="../item/prdlist"> → 제품목록</a></li>
                                    <li><a href="../board/boardlist"> → 게시글목록</a></li>
                                </ul>
                            </section>
                            <section> 
                                <h2 class="titmenu">회원관리</h2>
                                <ul class="submenu">
                                    <li><a href="userlist"> → 회원목록</a></li>

                                </ul>
                            </section>    
                        </div>
                    </div>
                </aside>    
 
    <!-- -------------main------------------------------- -->
                <div class="main-prdlist">
                    <section class="prdlist">
                        <h1>< 회원 수정 ></h1>
                        
             
                            
<form action="edit" method="post">
					    <table class="prdlist-table">

						 <thead>
    <tr>
     
       
            
            <td>이메일</td>
            <td>비밀번호</td>
            <td>닉네임</td>
            <td>이름</td>
            <td>나이</td>
            <td>성별</td>
            <td >역할</td>
    </tr>
</thead>

<tbody>
    <tr>
 
        <td><textarea name ="mail" style="width:100%; height:100%; border:0;" class="content" >${n.mail }</textarea></td>
        <td><textarea name ="pw" style="width:100%; height:100%; border:0;" class="content" >${n.pw }</textarea></td>
        <td><textarea name ="nickName" style="width:100%; height:100%; border:0;" class="content" >${n.nickName }</textarea></td>
         <td><textarea name ="name" style="width:100%; height:100%; border:0;" class="content" >${n.name }</textarea></td>
        <td><textarea name ="age" style="width:100%; height:100%; border:0;" class="content" >${n.age }</textarea></td>
        <td><textarea name ="gender" style="width:100%; height:100%; border:0;" class="content">${n.gender }</textarea></td>
        <td><textarea name ="role" style="width:100%; height:100%; border:0;" class="content">${n.role}</textarea></td>
    </tr>

</tbody>

					    </table>
					    
					    <div class="margin-top text-align-center">
<input type="hidden" name="userNum" value="${n.userNum}" />
<input class="btn-text btn-default" type="submit" value="등록" />
<a class="btn-text btn-cancel" href="userlist">취소</a>
</div>
					</form>
				</section>
			</div>
		

			</main>

                    
                   
		</div>
	</section>
</body>
</html>