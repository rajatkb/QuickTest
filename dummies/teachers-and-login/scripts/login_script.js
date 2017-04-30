$(document).ready(forRegistration);

function forRegistration(){
    $("#register").click(function(){
        $(".login-main-container").hide(300, function(){
            $(".register-main-container").slideDown(500);
        });
    });
}