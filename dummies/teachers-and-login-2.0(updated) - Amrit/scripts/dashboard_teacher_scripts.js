$(document).ready(onLoading);

function onLoading(){    
    fixButtons();
    $("#new-test-button").click(loadNewTestForm);
    $("#update-info-button").click(updateTeachersInfo);
    $(".start-test").click(startTest);
    $("#add-qs-btn").click(function(){
        var questions = $(".question");
        var new_qs_index = questions.length+1;
        addNewQuestion(new_qs_index);
    });
    $(".escape-test-form-button").click(escapeFormWindow);
     $(".escape-start-test").click(escapeStartTest);
}
function updateTeachersInfo(){
    $(".grand-container").fadeIn(500);
    var pageHeight = String(parseFloat($(".main-container").css("height"))+150);
    $(".grand-container").css("height", pageHeight);
    $(".update-info-form").fadeIn(500);
    updateInfoFormSubmission();
}
function startTest(){
    $(".grand-container").fadeIn(500);
    var pageHeight = String(parseFloat($(".main-container").css("height"))+150);
    $(".grand-container").css("height", pageHeight);
    $(".ongoing-test-info").fadeIn(500);
}
function addNewQuestion(index){
    var newQuestionTemplate = '<div class="question" id="question'+ index + '"' + '><input class="form-item qs_title" name="newtest[qs_' + index + ']" placeholder="Enter question '+ index +'" /><div class="row"><div class="six columns"><input class="form-item" name="newtest[qs_' + index + '_choice_a]" placeholder="A" /></div><div class="six columns"><input class="form-item" name="newtest[qs_' + index + '_choice_b]" placeholder="B" /></div></div><div class="row"><div class="six columns"><input class="form-item" name="newtest[qs_' + index + '_choice_c]" placeholder="C" /></div><div class="six columns"><input class="form-item" name="newtest[qs_' + index + '_choice_d]" placeholder="D" /></div></div><div class="row"><div class="six columns"><input class="form-item" name="newtest[qs_' + index + '_answer]" placeholder="Correct choice" /></div><div class="six columns"><input class="form-item" name="newtest[qs_' + index + '_marks]" placeholder="Marks for this question" /></div></div>'
    $('#question'+String(index-1)).hide('slide', {direction: 'left'}, 300, function(){
        $('.more-qs-container').append(newQuestionTemplate);
    });
} 
function fixButtons(){
    $(".test-submitted .edit-test").css({"opacity": "0.5", "box-shadow": "none"});
    $(".test-submitted .submit-test").css({"opacity": "0.5", "box-shadow": "none"});
    $(".test-submitted .edit-test").prop("disabled", true);
    $(".test-submitted .submit-test").prop("disabled", true);
    $(".test-conducted .edit-test").css({"opacity": "0.5", "box-shadow": "none"});
    $(".test-conducted .submit-test").css({"opacity": "0.5", "box-shadow": "none"});
    $(".test-conducted .start-test").css({"opacity": "0.5", "box-shadow": "none"});
    $(".test-conducted .edit-test").prop("disabled", true);
    $(".test-conducted .submit-test").prop("disabled", true);
    $(".test-conducted .start-test").prop("disabled", true);
}
function loadNewTestForm(){
    $(".grand-container").fadeIn(500);
    $(".dummy-grand").fadeIn(500);
    var formHeight = String(parseFloat($(".new-test-form").css("height"))+50);
    $(".dummy-grand").css("height", formHeight);
    $(".grand-container").css("height", formHeight);
}
function escapeFormWindow(){
    $(".grand-container").fadeOut(50, function(){
        $(".dummy-grand").hide("fast");
    });
}
function escapeStartTest(){
    $(".grand-container").fadeOut(50, function(){
        $(".ongoing-test-info").hide("fast");
    });
}
