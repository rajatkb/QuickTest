$(document).ready(function(){
    $(".bm i").click(function(){
        $(this).toggleClass("myclass");
    });
});

/*$("#clear").click(function(){
    $("input[radio]").removeAttr("checked");
});*/
$("#clear").click(function()
{
    document.getElementById("#input").checked = false;
});

/*var question=5;
for(var i=1;i<question;i++){
    $(".questions").append('<div class="questions">
                        
                        Q1. <span class="bm"><i class="fa fa-bookmark " id="bm"></i></span></br>
                        
                        <input type="radio" name="option" > a) <br>
                        <input type="radio" name="option" > b) <br>
                        <input type="radio" name="option"> c) <br>
                        <input type="radio" name="option"> d) 
                        <button type="reset" id="clear">CLEAR</button>
                       
                        

                    </div>');
}*/

