window.addEventListener("load",function(){
    var main = document.querySelector(".main");
    var page = main.querySelector(".page");
    var age = main.querySelector(".matching-perfume-list.age");
    var season = main.querySelector(".matching-perfume-list.season");
    var scent = main.querySelector(".matching-perfume-list.scent");
    var title = main.querySelector(".survey-title");
    var tag1 = null;
    var tag2 = null;
    var tag3 = null;
    var gender = location.search.substr(location.search.indexOf("?") + 8);
    
    
    age.onclick=function(e){
        e.preventDefault();
        age.classList.add("d-none");
        season.classList.remove("d-none");
        page.classList.remove("page");
        page.classList.add("page2");
        tag1 = e.target.innerText;
        title.innerText="Q. 사용할 계절을 선택해주세요";
    };

    season.onclick=function(e){
        e.preventDefault();
        if(e.target.nodeName != "LI") return;
        season.classList.add("d-none");
        scent.classList.remove("d-none");
        page.classList.remove("page2");
        page.classList.add("page3");
        tag2 = e.target.innerText;
        title.innerText="Q. 좋아하는 느낌의 향을 골라주세요";
    };

    scent.onclick=function(e){
        e.preventDefault();
        if(e.target.nodeName != "LI") return;
        tag3 = e.target.innerText;
        location.href=`result?gender=${gender}&age=${tag1}&season=${tag2}&scent=${tag3}` 
//        console.log(tag1);
//        console.log(tag2);
//        console.log(tag3);
    };

    
});