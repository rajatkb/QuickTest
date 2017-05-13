function startTest(){
    var testToStart = $($(this).parent()[0]).parent()[0];
    var testID = $(testToStart).attr("id");
    var testIndex = Number(testID.match(/\d/g).join(""));
    window.testIndex = testIndex;
    $("#ongoing-test-title").html( $(testToStart).find('.test-title')[0].innerText);
    $("#ongoing-test-desc").html($(testToStart).find('.desc')[0].innerText);
    $("#ongoing-test-dept").html($(testToStart).find('.dept')[0].innerText);
    $("#ongoing-test-batch").html($(testToStart).find('.batchYear')[0].innerText);
    $("#ongoing-test-full-marks").html($(testToStart).find('.totalMarks')[0].innerText);
    $.ajax({
            type: "get",
            url: "testInteract",
            data:$.param({testId : testIndex}),
            success: function(data){
                window.totalsec = Number(data);
                console.log(window.totalsec);
                setInitTime(window.totalsec);
            }
        });
    $("html body").animate({scrollTop: 0}, "fast");
    $(".grand-container").fadeIn(500);
    var pageHeight = String(parseFloat($(".main-container").css("height"))+150);
    $(".grand-container").css("height", pageHeight);
    $(".ongoing-test-info").fadeIn(500);
    
}


