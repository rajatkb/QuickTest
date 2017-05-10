    function startTest(){
        var testToStart = $($(this).parent()[0]).parent()[0];
        var index = $(testToStart).attr("id");
        index = Number(index.match(/\d/g).join(""));
        $("#ongoing-test-title").html($("#title-test"+index).text());
        $("#ongoing-test-desc").html($("#desc-test"+index).text());
        $("#ongoing-test-dept").html($("#dept-test"+index).text());
        $("#ongoing-test-batch").html($("#batch-test"+index).text());
        $("#ongoing-test-full-marks").html($("#marks-test"+index).text());
        $("#ongoing-test-duration").html($("#duration-test"+index).text());
        $("html body").animate({scrollTop: 0}, "fast");
        $(".grand-container").fadeIn(500);
        var pageHeight = String(parseFloat($(".main-container").css("height"))+150);
        $(".grand-container").css("height", pageHeight);
        $(".ongoing-test-info").fadeIn(500);
    }