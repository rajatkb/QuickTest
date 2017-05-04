$(document).ready(function() {
    $('.toggle').click(function () {
        console.log("hi");

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
    $('.pro').click(function(){
       $('.profile').toggle('show');
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
