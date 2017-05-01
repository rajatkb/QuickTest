$(document).ready(onLoading);

function onLoading(){    
    fixButtons();
    $("#new-test-button").click(loadNewTestForm);
    $("#update-info-button").click(updateTeachersInfo);
    $(".start-test").click(startTest);
    $("#add-qs-btn").on("click", function(event){
        var questions = $(".question");
        var new_qs_index = questions.length+1;
        var $element = $(this);
        if($element.data("clicked")){
            event.preventDefault();
            event.stopPropagation();
        } else {
            $element.data("clicked", true);
            window.setTimeout(function(){
                $element.removeData("clicked");
                addNewQuestion(new_qs_index);
            }, 750);
        }
    });
    $(".escape-test-form-button").click(escapeFormWindow);
    $(".escape-start-test").click(escapeStartTest);
    $(".delete-test").click(function(){
        var questionToDel = $(this).parent().parent()[0];
        deleteTest(questionToDel);
    });
}
function updateTeachersInfo(){
    $(".grand-container").fadeIn(500);
    var pageHeight = String(parseFloat($(".main-container").css("height"))+150);
    $(".grand-container").css("height", pageHeight);
    $(".update-info-form").fadeIn(500);
}
function startTest(){
    $(".grand-container").fadeIn(500);
    var pageHeight = String(parseFloat($(".main-container").css("height"))+150);
    $(".grand-container").css("height", pageHeight);
    $(".ongoing-test-info").fadeIn(500);
}
function addNewQuestion(index){
    var newQuestionTemplate = '<div class="question" id="question'+ index + '"' + '><input class="form-item qs_title" name="newtest[qs_' + index + ']" placeholder="Enter question '+ index +'" /><div class="row"><div class="six columns"><input class="form-item" name="newtest[qs_' + index + '_choice_a]" placeholder="A" /></div><div class="six columns"><input class="form-item" name="newtest[qs_' + index + '_choice_b]" placeholder="B" /></div></div><div class="row"><div class="six columns"><input class="form-item" name="newtest[qs_' + index + '_choice_c]" placeholder="C" /></div><div class="six columns"><input class="form-item" name="newtest[qs_' + index + '_choice_d]" placeholder="D" /></div></div><div class="row"><div class="six columns"><input class="form-item" name="newtest[qs_' + index + '_answer]" placeholder="Correct choice" /></div><div class="six columns"></div></div>'
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
    $(".more-qs-container").children().remove();
    $("#question1").css("display", "block");
    $(".grand-container").fadeOut(50, function(){
        $(".dummy-grand").hide("fast");
    });
}
function escapeStartTest(){
    $(".grand-container").fadeOut(50, function(){
        $(".ongoing-test-info").hide("fast");
    });
}
function deleteTest(questionToDel){
    var pageHeight = String(parseFloat($(".main-container").css("height"))+150);
    $(".grand-container").css("height", pageHeight);
    $(".grand-container").fadeIn(500, function(){
        $(".delete-test-conf").show("fast");
    });
    $(".delete-test-yes").click(function(){
        deleteThisTest(questionToDel);
    });
    $(".delete-test-no").click(function(){
        closeConfBox();
    });
}
function closeConfBox(){
    $(".grand-container").fadeOut(50, function(){
        $(".delete-test-conf").hide("fast");
    });
}
function deleteThisTest(questionToDel){
    $(questionToDel).remove();
    closeConfBox();
}
