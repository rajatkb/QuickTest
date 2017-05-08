$(document).ready(onLoading);

function onLoading(){    
    fixButtons();
    $("#new-test-button").click(loadNewTestForm);
    $("#update-info-button").click(updateTeachersInfo);
    $(".test-list").on('click','.start-test',startTest);
    $("#prev-qs-btn").on("click", function(event){
        var pres_qs_index = screenQuestionIndex();
        var $element = $(this);
        if($element.data("clicked")){
            event.preventDefault();
            event.stopPropagation();
        } else {
            $element.data("clicked", true);
            window.setTimeout(function(){
                $element.removeData("clicked");
                showPrevQuestion(pres_qs_index);
            }, 150);
        }
    });
    $("#next-qs-btn").on("click", function(event){
        var pres_qs_index = screenQuestionIndex();
        var $element = $(this);
        if($element.data("clicked")){
            event.preventDefault();
            event.stopPropagation();
        } else {
            $element.data("clicked", true);
            window.setTimeout(function(){
                $element.removeData("clicked");
                showNextQuestion(pres_qs_index);
            }, 150);
        }
    });
    $("#add-qs-btn").on("click", function(event){
        var questions = $(".question");
        var new_qs_index = questions.length+1;
        var screen_qs_index = screenQuestionIndex();
        var $element = $(this);
        if($element.data("clicked")){
            event.preventDefault();
            event.stopPropagation();
        } else {
            $element.data("clicked", true);
            window.setTimeout(function(){
                $element.removeData("clicked");
                addNewQuestion(screen_qs_index, new_qs_index);
            }, 150);
        }
    });
    $(".escape-test-form-button").click(escapeFormWindow);
    $(".escape-start-test").click(escapeStartTest);
    $(".test-list").on('click','button.delete-test',function(){
        console.log('clicked delete');
        $("html body").animate({scrollTop: 0}, "fast");
        forDeletingTest(this);
    });
    $("#search-ques-button").click(showSelectedQuestion);
}
function forDeletingTest(test){
    var questionToDel = $(test).parent().parent()[0];
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
function updateTeachersInfo(){
    $(".grand-container").fadeIn(500);
    var pageHeight = String(parseFloat($(".main-container").css("height"))+150);
    $(".grand-container").css("height", pageHeight);
    $(".update-info-form").fadeIn(500);
}
function startTest(){
    console.log("clicked start test");
    $("html body").animate({scrollTop: 0}, "fast");
    $(".grand-container").fadeIn(500);
    var pageHeight = String(parseFloat($(".main-container").css("height"))+150);
    $(".grand-container").css("height", pageHeight);
    $(".ongoing-test-info").fadeIn(500);
}
function addNewQuestion(screen_qs_index, index){
    var newQuestionTemplate = '<div class="question" id="question'+ index + '"' + '><input class="form-item qs_title" name="qs_' + index + '" placeholder="Enter question '+ index +'" required /><div class="row"><div class="six columns"><input class="form-item" name="qs_' + index + '_choice_1" placeholder="A" required /></div><div class="six columns"><input class="form-item" name="qs_' + index + '_choice_2" placeholder="B" required /></div></div><div class="row"><div class="six columns"><input class="form-item" name="qs_' + index + '_choice_3" placeholder="C" required /></div><div class="six columns"><input class="form-item" name="qs_' + index + '_choice_4" placeholder="D" required /></div></div><div class="row"><div class="six columns"><select class="form-item" name="answer" required><option value="" disabled selected hidden>Correct choice</option><option value="a">A</option><option value="b">B</option><option value="c">C</option><option value="d">D</option></select></div></div></div>'
    $('#question'+String(screen_qs_index)).hide('slide', {direction: 'left'}, 200, function(){
        $('.more-qs-container').append(newQuestionTemplate);
    });
} 
function showPrevQuestion(index){
    if(index>1){
        $('#question'+String(index)).hide('slide', {direction: 'right'}, 200, function(){
            $('#question'+String(index-1)).show('slide', {direction: 'left'}, 200);
        });
    }
}
function showNextQuestion(index){
    var allQues = $(".question").toArray();
    if(index+1 <= allQues.length)
        $('#question'+String(index)).hide('slide', {direction: 'left'}, 200, function(){
            $('#question'+String(index+1)).show('slide', {direction: 'right'}, 200);
        });
}
function fixButtons(){
    $(".test-conducted .start-test").css({"opacity": "0.5", "box-shadow": "none"});
    $(".test-conducted .start-test").prop("disabled", true);
}
function screenQuestionIndex(){
    var screenQuestion = [ ];
    var temp = $(".question").toArray();
    temp.forEach(function(ques){
        if($(ques).css("display")=="block" || $(ques).css("display")=="inline-block")
            screenQuestion.push(ques);
    });
    var pres_qs_id = $(screenQuestion[0]).attr("id");
    var pres_qs_index = getQsIndex(pres_qs_id);
    return pres_qs_index;
}
function getQsIndex(pres_qs_id){
     var digits = ["1", "2", "3", "4", "5", "6", "7", "8", "9"];
     for(var i=0; i<pres_qs_id.length; i++){
         if(digits.includes(pres_qs_id[i])){
            var index = Number(pres_qs_id.substring(i));
            return index;
         }
     }
}
function loadNewTestForm(){
    $(".grand-container").fadeIn(500);
    var pageHeight = String(parseFloat($(".main-container").css("height"))+150);
    $(".grand-container").css("height", pageHeight);
    $(".dummy-grand").fadeIn(500);
    var formHeight = String(parseFloat($(".new-test-form").css("height"))+50);
    $(".dummy-grand").css("height", formHeight);
    
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
function closeConfBox(){
    $(".grand-container").fadeOut(50, function(){
        $(".delete-test-conf").hide("fast");
    });
}
function deleteThisTest(questionToDel){
    var testID = $(questionToDel).attr("id");
    var testIndex = Number(testID.match(/\d/g).join(""));
    var encoded = $.param({ testId :testIndex});
    console.log(encoded);
    $.ajax({
        method:"delete",
        url:"testInteract",
        data:encoded,
        success : function(data){
            $(questionToDel).hide();
            console.log(data);
            closeConfBox();
        }
    });
    
}
function showSelectedQuestion(){
    var ques_search = Number($("#search-ques").val());
    var ques_on_screen = screenQuestionIndex();
    var netQues = $(".question").toArray();
    if(ques_search <= netQues.length && ques_search>0){
        if(ques_search < ques_on_screen){
            $('#question'+String(ques_on_screen)).hide('slide', {direction: 'right'}, 200, function(){
                $('#question'+String(ques_search)).show('slide', {direction: 'left'}, 200);
            });
        } else if(ques_search > ques_on_screen) {
            $('#question'+String(ques_on_screen)).hide('slide', {direction: 'left'}, 200, function(){
                $('#question'+String(ques_search)).show('slide', {direction: 'right'}, 200);
            });
        }
    }
}

