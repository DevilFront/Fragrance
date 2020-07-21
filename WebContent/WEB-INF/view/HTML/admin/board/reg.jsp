<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="../../css/reset.css" type="text/css" rel="stylesheet">
    <link href="../../css/admin/prdliststyle.css" type="text/css" rel="stylesheet">
    <title>Bon Parfum 관리자 페이지</title>
</head>

<body>
 
    <!-- -------------main------------------------------- -->
<form action="reg" method="post">
	<section class="content-container">
		<div id="body">
			<main class="main">

				<section class="prdlist">
				<div class="admin">
                    <h1>< 향수 등록 ></h1>
                    <input type="button" class="button" value="메인으로" onClick="window.location='../home/index.html'"  >
					<table class="prdlist-table">

                        <div class="admin-btn">
                     

						<thead>
							<tr>
                             
                               
								<td>제품명</td>
								<td>브랜드명</td>
								<td>용량(ml)</td>
								<td>대표 향</td>
								<td>가격(원)</td>
                                <td>관리 기능</td>
							</tr>
                        </thead>
                        
						<tbody>

				
					
				
								
                            <tr>
                               
                               
                                <td><textarea name ="name" style="width:100%; height:100%; border:0;" class="content" name="content"></textarea></td>
                                <td><textarea name ="brand" style="width:100%; height:100%; border:0;" class="content" name="content"></textarea></td>
                                <td><textarea name ="size" style="width:100%; height:100%; border:0;" class="content" name="content"></textarea></td>
                                <td><textarea name ="scent" style="width:100%; height:100%; border:0;" class="content" name="content"></textarea></td>
                                <td><textarea name ="price" style="width:100%; height:100%; border:0;" class="content" name="content"></textarea></td>
                                <td><textarea style="width:100%; height:100%; border:0;" class="content" name="content"></textarea></td>
                                <!-- <td class="prd-name-img">
                                    <span class="prd-name">향수 제품명</span> 
                                    <img class="prd-img" src="../../images/Hera-Exceptional.png">
                                </td> -->
                     
                               
                             
                            </tr>
	
                        </tbody>



                        



  
                        
					</table>
					</div>
 					<div class="margin-top text-align-center">
                        <input class="btn-text btn-default" type="submit" value="등록" />
                        <a class="btn-text btn-cancel" href="prdlist">취소</a>
                    </div>
                      
                            
                                
                          
                    </section>

				</section>
			</main>
		</div>
	</section>
	</form>
</body>
 <script src="../../js/admin/admin.js"></script> 
</html>

