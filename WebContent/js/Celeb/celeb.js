window.addEventListener("load", function(){
    var main = document.querySelector("#main");
    var container = main.querySelector(".container");
    var description = main.querySelector(".description");
    var img = main.querySelectorAll(".img");
    var like = main.querySelector(".d-like");
    var unlike = main.querySelector(".d-unlike");
    var onload = main.querySelector(".onload");
    var addonloadblock = main.querySelector(".add-onloadblock");
    var gridcontainer = main.querySelector(".grid-container3")
    var shield = new Shield("#main");
    var top =true;
   var page = 0;
   
//--------------------창열기-----------------------------------------
   container.onclick = function(e){    //메인 전체 영역 클릭
   if (!e.target.classList.contains("img")) return; //img를 제외한 나머지는 반응하지 않게
        description.classList.remove("d-none");
        console.log("start");
        shield.show();
      page =e.target.dataset.id;
    e.preventDefault();
        console.log(page);
     var xhr = new XMLHttpRequest();
        xhr.open('GET', 'celeb-data?p='+page, true); 
       xhr.onload = function () {
           var notices = JSON.parse(xhr.responseText);
           description.innerHTML=
               `<section class="d-header">
                        <h1 class="d-none">d-header</h1>
                          
                        <div class="d-title"> ${notices.title}</div>
                        <ul class="box">
                            <li>${notices.writerId} /&#160; </li>
                            <li>${notices.regDate} /&#160; </li>
                          <li>${notices.hit} views </li>
                        </ul>
                        <div class ="close">
                            <img class="out" src="../../images/celeb/close.png">
                        </div>
                    </section>
                    <section>
                        <h1 class="d-none">d-content</h1> 
                        <div class ="d-img ">
                           <img src="../../images/celeb/${notices.imgDetail}">
                        </div>
                        <div class="d-coment">
                        ${notices.content}
                        </div>
     
                    </section>
                  <section class="d-buttons">
                        <h1 class="d-none">d-buttons</h1>
                       <a href="/HTML/rank/detail?id=${notices.itemNums}"> <input type="button" class="d-button" value="상세정보"> </a>
                        <input type="button" class="d-unlike">
                        <input type="button" class="d-like d-none">
                    </section>
                   `;
        };
        xhr.send(null);

    }
//--------------------close-----------------------------------------
    description.onclick = function(e){
   console.log(e.target)
   if (e.target.classList.contains("out")){
        description.classList.add("d-none");
        console.log("close");
        shield.hide();
   }
   else if(e.target.classList.contains("d-unlike")){
        top=!top;
        if(!top){
         console.log("like1");
         document.querySelector(".d-unlike").classList.add("d-none");
         document.querySelector(".d-like").classList.remove("d-none");
         
        }
        else{
         console.log("unlike1");
         document.querySelector(".d-unlike").classList.remove("d-none");
         document.querySelector(".d-like").classList.add("d-none");
        }
}
   else if(e.target.classList.contains("d-like")){
           top=!top;
        if(!top){
         console.log("like");
         document.querySelector(".d-unlike").classList.add("d-none");
         document.querySelector(".d-like").classList.remove("d-none");
        }
        else{
         console.log("unlike");
         document.querySelector(".d-unlike").classList.remove("d-none");
         document.querySelector(".d-like").classList.add("d-none");
        }
   }
   else return;
    }

//------------ onload button-----------------------------
    onload.onclick = function(){
        onload.style.display = "none";
        gridcontainer.style.display="grid";
        addonloadblock.style.display="block";
    }




});