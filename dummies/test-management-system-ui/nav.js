$(document).ready(function(){
    $('.toggle').click(function () {
        console.log("hi");

        $('nav ul').slideToggle();
    });
    
    $(window).resize(function () {
        if ($(window).width() > 700) {
            $('nav ul').removeAttr('style');
        }
    });

});



