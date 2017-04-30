$(document).ready(forRegistration);

function forRegistration(){
    $("#register").click(function(){
        $("#register").attr("id", "login");
        $("#login").text("Login");
        $(".login-main-container").hide(300, function(){
            $(".register-main-container").show(100);
        });
        forLogin();
    });
}
function forLogin(){
    $("#login").click(function(){
        $("#login").attr("id", "register");
        $("#register").text("Register");
        $(".register-main-container").hide(300, function(){
            $(".login-main-container").show(100);
        });
        forRegistration();
    });
}
