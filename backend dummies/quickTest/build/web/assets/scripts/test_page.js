var final_answer;
$(document).ready(function(){
    var items = $('.question').length;
    
    $($('.question')[0]).css("display","block");
    
    $(".bm i").click(function(){
        $(this).toggleClass("myclass"); 
   });
    
      $('.control_prev').click(function(){
        plusDivs(-1);
    });
    $('.control_next').click(function(){
        plusDivs(1);
    });
    
      
    var index = 1;
showDivs(index);

function plusDivs(n) {
    showDivs(index += n);
}

function showDivs(n) {
    var i;
    var x = $(".question");
    if (n > x.length) {index = 1} 
    if (n < 1) {index = x.length} ;
    
    for (i = 0; i < x.length; i++) {
        x[i].style.display = "none"; 
    }
    x[index-1].style.display = "block"; 
}
    $('#search-ques-button').click(showSelectedQuestion);
    
    function showSelectedQuestion(){
        var ques_search = Number($(".search-ques").val());
        var x = $(".question");
        if((ques_search>x.length) || (ques_search<1)){return;}
        for (i = 0; i < x.length; i++) {
            x[i].style.display = "none"; 
        }
        x[ques_search-1].style.display = "block"; 
            
        }
        
    
    $("input:radio").on("click",function (e) {
        var inp=$(this);
    if (inp.is(".theone")) {
        inp.prop("checked",false).removeClass("theone");
    } else {
        $("input:radio[name='"+inp.prop("name")+"'].theone").removeClass("theone");
        inp.addClass("theone");
    }

});

    var answers=[];
    $('.submit').click(function(){
        $(".question input[type=radio]:checked").each(function(val){
            
            answers.push($(this).val());
            
        });
        var final_answer=answers.join("");
        $.ajax({
           type:"post",
            url:"performa",
            data: $.param({answerScript : final_answer}),
            success: function(dat){
                alert("You will now be redirected.");
                window.location = "studentDash";
            },
            failure: function(dat){
                alert("NO DATA SEND");
            }
        });
    })
});
    
    


