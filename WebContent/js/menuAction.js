window.addEventListener("load", function () {

    const body = document.querySelector("body");
    const subMenu = body.querySelector(".sub-menu");
    const subMenus = body.querySelectorAll(".sub-menu a");
    const mainMenu = body.querySelector(".main-menu ul");
    const mainMenus = body.querySelectorAll(".main-menu a");

    mainMenu.onmouseover = function(e){
         console.log(e.target.innerText);
        
        if(e.target.nodeName != "A")
        return;

        for(var i=0; i<mainMenus.length; i++){
            mainMenus[i].classList.remove("show");
        }
        e.target.classList.add("show");
        subMenu.classList.remove("d-none");
    };

    mainMenu.onmouseout = function(e){
        if(e.target.nodeName != "A")
        return;

        for(var i=0; i<mainMenus.length; i++){
            mainMenus[i].classList.add("show");
        }
        e.target.classList.add("show");
    };


    subMenu.onmouseover = function(e){
        e.preventDefault();
        if(e.target.nodeName != "A")
        return;

        for(var i=0; i<subMenus.length; i++){
            subMenus[i].classList.remove("show");
        }
        e.target.classList.add("show");

    };
    subMenu.onmouseout = function(e){
        if(e.target.nodeName != "A")
        return;

        for(var i=0; i<subMenus.length; i++){
            subMenus[i].classList.add("show");
        }
        e.target.classList.add("show");
    };
});