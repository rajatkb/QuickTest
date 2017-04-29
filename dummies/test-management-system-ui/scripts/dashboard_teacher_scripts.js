$(document).ready(onLoading);

function onLoading(){
    $(".test-submitted .edit-test").css({"opacity": "0.5", "box-shadow": "none"});
    $(".test-submitted .submit-test").css({"opacity": "0.5", "box-shadow": "none"});
    $(".test-submitted .edit-test").prop("disabled", true);
    $(".test-submitted .submit-test").prop("disabled", true);
    $(".test-conducted .edit-test").css({"opacity": "0.5", "box-shadow": "none"});
    $(".test-conducted .submit-test").css({"opacity": "0.5", "box-shadow": "none"});
    $(".test-conducted .edit-test").prop("disabled", true);
    $(".test-conducted .submit-test").prop("disabled", true);
    $("#new-test-button").click(function(){
        $(".grand-container").fadeIn(500);
        $(".dummy-grand").fadeIn(500);
    });
    $("#add-qs-btn").click(addNewQuestion);
}

function addNewQuestion(){
    $(".third").append('<input class="form-item" name="newtest[first_qs]" placeholder="Enter first question" /><div class="row"><div class="col-md-6 col-xs-6 col-sm-6"><input class="form-item" name="newtest[first_qs_first_choice]" placeholder="A" /></div><div class="col-md-6 col-xs-6 col-sm-6"><input class="form-item" name="newtest[first_qs_second_choice]" placeholder="B" /></div></div><div class="row"><div class="col-md-6 col-xs-6 col-sm-6"><input class="form-item" name="newtest[first_qs_third_choice]" placeholder="C" /></div><div class="col-md-6 col-xs-6 col-sm-6"><input class="form-item" name="newtest[first_qs_fourth_choice]" placeholder="D" /></div></div><div class="row"><div class="col-md-6 col-xs-6 col-sm-6"><input class="form-item" name="newtest[first_qs_correct_choice]" placeholder="Correct choice" /></div><div class="col-md-6 col-xs-6 col-sm-6"><input class="form-item" name="newtest[first_qs_marks]" placeholder="Marks for this question" /></div></div>');
} 
                       
/*



*/