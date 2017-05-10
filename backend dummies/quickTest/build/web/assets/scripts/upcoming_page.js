$(document).ready(function() {
    

    $('.test').each(function() {
        $(this).css('background',randomColor());
    });
    $('.pro').mouseover(function(){
        console.log('hello');
        $('.profile').slideDown("fast");
    });
    $('.pro').mouseout(function(){
        console.log('hello');
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
