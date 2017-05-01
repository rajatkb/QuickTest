$(document).ready(function(){
    var state = 0;
    $("#register").click(function(){
        console.log("hello");
        if(state == 0){
            console.log("hello");
            $(this).text("Login");
            $(".login-main-container").hide(300, function(){
                $(".register-main-container").show(100);
            });
            state = 1;
        } else {
            $(this).text("Register");
            $(".register-main-container").hide(300, function(){
                $(".login-main-container").show(100);
            });
            state = 0;
        }
    });
});

