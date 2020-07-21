<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="kr">
<head>
<meta charset="UTF-8">
<title>login</title>
<link href="./css/login.css" rel="stylesheet" type="text/css">

</head>
<body>

	<section class="container">
		<article class="half">
			<h1>BON PARFUM</h1>
			<div class="tabs">
				<span class="tab signin active"><a href="#signin">Sign in</a></span>
				<span class="tab signup"><a href="#signup">Sign up</a></span>
			</div>

			<div class="content">
				<div class="signin-cont cont">
					<form method="post" action="/login">
						<input type="email" name="email" id="email" class="inpt" required="required" placeholder="Your email"> 
						<label for="email">Your email</label>
						 <input type="password" name="pw" id="password" class="inpt" required="required"placeholder="Your password"> 
						<label for="password">Yourpassword</label> 
						<div class="submit-wrap">
							<input type="submit" value="Sign in" class="submit"> 
						</div>
					</form>
				</div>

				<div class="signup-cont cont">
					<form action="/reg" method="post">
						<input type="text" name="name" id="name" class="inpt" required="required" placeholder="Your name">
							 <label for="name">Your name</label> 
							 <input type="text" name="nickname" id="name" class="inpt" required="required" placeholder="Your nickname"> 
							<label for="gender">Your nickname</label> 
							<input type="email" name="email" id="email" class="inpt" required="required" placeholder="Your email"> 
							<label for="email">Your email</label> 
							<input type="password" name="pw" id="password" class="inpt" required="required" placeholder="Your password"> 
							<label for="password">Your password</label> 
							<input type="text" name="age" id="name" class="inpt" required="required" placeholder="Your age"> 
							<label for="gender">Your age</label>

						<div class="gender-wrap">
							 <button type="button" id="empty"
								style="height: 40px; width: 150px;"></button>

							<input type="radio" name="gender" value="man" checked >man
							<button type="button" id="empty"
								style="height: 40px; width: 50px;"></button>
							<input type="radio" name="gender" value="woman">woman

						</div>

						<div class="submit-wrap">
							<input type="submit" value="Sign up" class="submit"> <a
								href="#" class="more">Terms and conditions</a>
						</div>
					</form>
				</div>
			</div>
		</article>

	</section>



	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script type="text/javascript">
		$('.tabs .tab').click(function() {
			if ($(this).hasClass('signin')) {
				$('.tabs .tab').removeClass('active');
				$(this).addClass('active');
				$('.cont').hide();
				$('.signin-cont').show();
			}
			if ($(this).hasClass('signup')) {
				$('.tabs .tab').removeClass('active');
				$(this).addClass('active');
				$('.cont').hide();
				$('.signup-cont').show();
			}
		});
		$('.container .bg').mousemove(
				function(e) {
					var amountMovedX = (e.pageX * -1 / 30);
					var amountMovedY = (e.pageY * -1 / 9);
					$(this).css('background-position',
							amountMovedX + 'px ' + amountMovedY + 'px');
				});
	</script>
</body>
</html>
