$("document").ready(function(){
    $(".del-qs-button").click(deleteQues);
});
function deleteQues(){
    var screen_qs_index = screenQuestionIndex();
    $("#question"+screen_qs_index).hide("fast", function(){
        $("#question"+screen_qs_index).remove();
    });
    $.ajax({
        type: "POST",
        data: screen_qs_index,
        dataType: "text", 
        statusCode: {
            404: function(){
                console.log("Error: 404");
            }    
        }
    })
    .done(function(data){
        console.log(data);
    });
}