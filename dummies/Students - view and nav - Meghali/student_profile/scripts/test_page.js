$(document).ready(function(){
     var divId = $(".ques").not(":hidden").prop("id");
        var index = divId.match(/\d/g);
        index = Number((index).join(""));
    var items = $('.ques').length;
        
    $(".bm i").click(function(){
        $(this).toggleClass("myclass", function(){
            addnewbm(index);
        });
        
    });
    $("#search-ques-button").click(showSelectedQuestion);
    function addnewbm(index){
        console.log(index-1);
    var newQuestionTemplate = '<div class="new-bm"><span class="bookmark" id="bookmark"><i class="fa fa-bookmark "><br>'+(index) +'</i></span></div>'
        $('.new-bm').append(newQuestionTemplate);
    };

    
    
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
       clearans("option1");
        }

        function clearRadioGroup(GroupName)
        {
          var ele = document.getElementsByName(GroupName);
            for(var i=0;i<ele.length;i++)
            ele[i].checked = false;
        }
        function clearans(GroupName)
    {
        $('#ans1').css({"background-color":"white","color":"black"});
    }
    
    

    function showNextSixQs(){
        var question=10;
        for(var i=2; i<question;i++){
            
            $(".random-class").append('<div class="questions"> Q'+i+' <span class="bm"><i class="fa fa-bookmark " id="bm"></i></span><br><input type="radio" name="option" > a) <br> <input type="radio" name="option" > b) <br> <input type="radio" name="option"> c) <br><input type="radio" name="option"> d) <button type="reset" id="clear">CLEAR</button></div>');
        
        }
}
    
    $(".control_next").on("click",function(){
        var divId = $(".ques").not(":hidden").prop("id");
        var index = divId.match(/\d/g);
        index = Number((index).join(""));
        
        if(index!=(items)){
        $('#ques'+String(index)).hide('slide', {direction: 'left'}, 100, function(){
            $('#ques'+String(index+1)).show('slide', {direction: 'right'}, 100);


        });
        }
});
    $(".control_prev").on("click",function(){
        var divId = $(".ques").not(":hidden").prop("id");
        var index = divId.match(/\d/g);
        index = Number((index).join(""));
        
        if(index!=1){
        $('#ques'+String(index)).hide('slide', {direction: 'right'}, 100, function(){
            $('#ques'+String(index-1)).show('slide', {direction: 'left'}, 100);
        


        });
        }
        
        
});
    function showSelectedQuestion(){
    var ques_search = Number($("#search-ques").val());
        console.log(ques_search);
        console.log(items);
    $('.ques').hide('slide',{direction:'left'}, 90 , function(){
        console.log(ques_search-1);
        $($('.ques')[ques_search-1]).css('display','block')

    });
    
    }
    
    
    

    
    
});
    
    

