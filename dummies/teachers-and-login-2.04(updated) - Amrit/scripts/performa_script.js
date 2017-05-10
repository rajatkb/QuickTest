$(document).ready(function(){
    downloadPerforma();
    $(".get-review-test").on("click", showPerforma);
    $(".close-performa-button").on("click", closePerforma);
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

function closePerforma() {
    $(".grand-container").hide(200);
    $(".performa-container").hide(200);
}

function downloadPerforma() {
    var doc = new jsPDF();
    var downloadButton = {
        "#download-performa": function(element, renderer) {
            return true;
        }
    };
    $("#download-performa").on("click", function(){
        doc.fromHTML($(".performa-container").html(), 15, 15, {
            "width": 170,
            "eventHandlers": downloadButton
        });
        doc.save("performa.pdf");
    });
}
