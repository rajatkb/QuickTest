$(document).ready(function(){
    $(".bm i").click(function(){
        $(this).toggleClass("myclass");
                
    });
    
    
    $("#next-six").click(showNextSixQs);
    
    
    
    
    $('.ques1 input').click(function(){
   
        if($(this).attr("alt") == "1")
                $('.ans1').css("background","red")
                .css("color","white");
        else
            $('.ans1').css("background","orange")
              .css("color","white");
   
  });
    
    $('.ques2 input').click(function(){
   
        if($(this).attr("alt") == "1")
                $('.ans2').css("background","red")
                .css("color","white");
        else
            $('.ans2').css("background","orange")
              .css("color","white");
   
  });
    $('.ques3 input').click(function(){
   
        if($(this).attr("alt") == "1")
                $('.ans3').css("background","red")
                .css("color","white");
        else
            $('.ans3').css("background","orange")
              .css("color","white");
   
  });
    $('#clear').click(Clear);
    

       function Clear()
        {    
       clearRadioGroup("option1");
        }

        function clearRadioGroup(GroupName)
        {
          var ele = document.getElementsByName(GroupName);
            for(var i=0;i<ele.length;i++)
            ele[i].checked = false;
        }
    
    

    function showNextSixQs(){
        var question=10;
        for(var i=4; i<question;i++){
            $(".random-class").append('<div class="questions"> Q'+i+' <span class="bm"><i class="fa fa-bookmark " id="bm"></i></span><br><input type="radio" name="option" > a) <br> <input type="radio" name="option" > b) <br> <input type="radio" name="option"> c) <br><input type="radio" name="option"> d) <button type="reset" id="clear">CLEAR</button></div>');
            $(".another-random-class").append('<div class="two columns color">'+i+'</div>');
        }
}
/*$("#clear").click(function(){
    $("input[radio]").removeAttr("checked");
});*/


    })
