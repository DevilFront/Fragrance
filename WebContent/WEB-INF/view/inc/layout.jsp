<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html>
<html>

<head>
    <title>Bon Parfum</title>
    <meta charset="UTF-8">
	<link href="../../css/reset.css" type="text/css" rel="stylesheet">
	<link href="<tiles:getAsString name="css"/>" type="text/css" rel="stylesheet" />
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
	<script src="/js/menuAction.js"></script>
	<script src="/js/Rank/list.js"></script>
</head>
	<!-- -----header menu------------------------------- -->
	

	<tiles:insertAttribute name="header" />
		<!-- -----top / end bt------------------------------- -->
	<tiles:insertAttribute name="topdown" />
	
	<div id="banner">
		<section class="banner-container">
			<h1 class="d-none">banner</h1>

		</section>
	</div>
	<!-- -------------main------------------------------- -->
	<div id="body">
	
		<tiles:insertAttribute name="main" />
		
	</div>
</body>
<!-- ------------footer------------------------------- -->
<tiles:insertAttribute name="footer" />

</html>