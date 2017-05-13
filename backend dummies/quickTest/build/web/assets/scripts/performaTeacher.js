$(document).ready(function(){
    downloadPerforma();
    $(".get-test-review").on("click", showPerforma);
    $(".close-performa-button").on("click", closePerforma);
});
function showPerforma() {
    console.log(this);
    var performa = $($(this).parent()[0]).parent()[0];
    var testID = $(performa).attr("id");
    var testIndex = Number(testID.match(/\d/g).join(""));
    $.ajax({
        type: "post",
        url: "performa",
        data : $.param({testId:testIndex}),
        success: function(data){
            console.log(data);
            var responseJSON = JSON.parse(data);
            console.log(responseJSON);
            var students = Object.keys(responseJSON);
            for(var i=0; i<students.length; i++){
                var performaTemplate = '<div class="student row"><div class="six columns">' + students[i] + '</div><div class="six columns">' + responseJSON[students[i]] + '</div></div>';
                $(".students-list").append(performaTemplate);
                }
            var pageHeight = String(parseFloat($(window).height()));
            $(".grand-container").css("height", pageHeight * 3);
            $(".grand-container").fadeIn(500);
            $(".performa-container").fadeIn(500);
            $("html body").animate({scrollTop: 0}, "fast");    
        },
        error:function(){
            alert("error connecting to server");
        }
    });
}

function closePerforma() {
    $(".grand-container").hide(200);
    $(".performa-container").hide(200);
}

function downloadPerforma() {
    
}
