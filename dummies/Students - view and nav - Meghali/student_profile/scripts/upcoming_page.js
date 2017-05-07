$(document).ready(function() {
    $('.toggle').click(function () {

        $('nav ul').slideToggle();
    });
    
    
    $(window).resize(function () {
        if ($(window).width() > 700) {
            $('nav ul').removeAttr('style');
        }
    });

        $('.test').each(function() {
            $(this).css('background',randomColor());
        
    });
    $('.pro').mouseover(function(){
       $('.profile').slideDown("fast");
    });
    $('.pro').mouseout(function(){
       $('.profile').slideUp("fast");
    });
    
});
var codes = ['00','33','66','99','cc','ff'];
var rand = function() {
    return Math.floor(Math.random()*6);
};
var randomColor = function() {
    var r = codes[rand()];
    var g = codes[rand()];
    var b = codes[rand()];
    return "#"+r+g+b;
};
