$(document).ready(function() {
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
