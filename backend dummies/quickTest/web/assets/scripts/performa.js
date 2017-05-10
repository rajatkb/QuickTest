$(document).ready(function(){
    $(".get-review-test").on("click", showPerforma);
});
function showPerforma() {
    var pageHeight = String(parseFloat($(window).height()));
    $(".grand-container").css("height", pageHeight);
    $(".grand-container").fadeIn(500);
    $(".performa-container").fadeIn(500);
    $("html body").animate({scrollTop: 0}, "fast");
    $.ajax({
        type: "get",
        url: "",
        success: function(responseJSON){
            var students = Object.keys(responseJSON);
            for(var i=0; i<students.length; i++){
                var performaTemplate = '<div class="student row"><div class="six columns">' + students[i] + '</div><div class="six columns">' + responseJSON[students[i]] + '</div></div>';
                $(".students-list").append(performaTemplate);
            }
        }
    });
}


