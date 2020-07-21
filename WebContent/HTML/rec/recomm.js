window.addEventListener("load", function() {
	var main = document.querySelector(".recomm-main");
	var recomm = main.querySelector(".fragrances-recomm");
	var prdDisplay = recomm.querySelector(".prd-display");
	var pre = prdDisplay.querySelector(".moveBtn-pre");
	var next = prdDisplay.querySelector(".moveBtn-next");
	var wrap = prdDisplay.querySelector(".prdinfo-wrap");
	var carousel = wrap.querySelector(".carousel");
	var tag= recomm.querySelector(".tag-box");

	var i = 1;
	var list = [ {} ];

	pre.onclick = function() {
		if (i == 1) {
			i = 3;
			carousel.style.transform = `translateX(-2320px)`;
		} else if (i == 2) {
			carousel.style.transform = `translateX(0px)`;
			i--;
		} else if (i == 3) {
			carousel.style.transform = `translateX(-1160px)`;
			i--;
		}
	};

	next.onclick = function() {
		if (i == 3) {
			i = 1;
			carousel.style.transform = `translateX(0px)`;
		} else {
			carousel.style.transform = `translateX(${-1160*i}px)`;
			i++;
		}
	};

	tag.onclick = function(e){
	    e.preventDefault();
	    if(e.target.nodeName != "A") return;
	    var link = e.target.getAttribute('href'); 
	    console.log(link);

	    var xhr = new XMLHttpRequest();
	    xhr.open('GET', link , true); // 트루면 비동기 , 펄스면 동기형
	    
	    xhr.onload = function () {
	  	  list = JSON.parse(xhr.responseText);
	        bind();
	       };
	       
	       xhr.send(null);
	};
	
	function bind(){
	  var div = wrap.querySelectorAll(".recomm-prd");
	  console.log(div);
	    for(var i in list){
	  	div[i].remove();
	    var n = list[i];
	    var template = `<div class="recomm-prd">
								<a href="/HTML/rank/detail?id=${n.itemnums }"><img
									src="../../images/${n.img }"></a> <span class="pName">${n.name }</span>
								<p class="pBrand">${n.brand }</p>
							</div>`;
	    
	    carousel.insertAdjacentHTML("afterbegin", template);
	}

	};

});