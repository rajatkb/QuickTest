$(document).ready(function(){
    $(".bm i").click(function(){
        $(this).toggleClass("myclass");
    });
    $("#next-five").click(showNextFiveQs);
    
});
function showNextFiveQs(){
    var question=6;
    for(var i=1; i<question;i++){
        $(".random-class").append('<div class="questions"> Q1. <span class="bm"><i class="fa fa-bookmark " id="bm"></i></span><br><input type="radio" name="option" > a) <br> <input type="radio" name="option" > b) <br> <input type="radio" name="option"> c) <br><input type="radio" name="option"> d) <button type="reset" id="clear">CLEAR</button></div>');
        $(".another-random-class").append('<div class="two columns color">1</div>');
    }
}
/*$("#clear").click(function(){
    $("input[radio]").removeAttr("checked");
});*/
$("#clear").click(function()
{
    document.getElementById("#input").checked = false;
});




