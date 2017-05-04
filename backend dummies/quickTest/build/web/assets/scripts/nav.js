$(document).ready(function(){
    $('.toggle').click(function () {
        $('nav ul').slideToggle();
    });
    
    
    $(window).resize(function () {
        if ($(window).width() > 700) {
            $('nav ul').removeAttr('style');
        }
    });
    
});
$(window).on("unload",function(){
    $.ajax({
        type: "get",
        url: "logout"
    })
    .done(function(){
        console.log("Logged you out!");
    });
});




