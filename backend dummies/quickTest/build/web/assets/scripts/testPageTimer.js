$(document).ready(function(){
    index=Number($('.00').attr('id'));
    var totalsec=index;
    var inter;
    setInitTime(totalsec);
    totalsec=index;
    setInitTime(totalsec);
    var out;
    var h,m,s;
    inter=setInterval(function(){
    h=Math.floor(totalsec/(60*60));
    m=Math.floor((totalsec%(60*60))/60);
    s=Math.floor((totalsec%(60*60))%60);
    out=h.toString()+":"+m.toString()+":"+s.toString();
    chsec(s);
    chminute(m);
    chhour(h);

    totalsec--;
     if(totalsec < 0)
        {   var answers=[];
            $(".question input[type=radio]:checked").each(function(val){
            
            answers.push($(this).val());
            
        });
        var final_answer=answers.join("");
            clearInterval(inter);
            $.ajax({
                type: "post",
                url: "performa",
                data: $.param({answerScript: final_answer }),
                success: function(response){
                        alert("You are getting redirecteed TIME OVER");
                        window.location = "studentDash";

                },
                failure:function(response) {
                    alert();
                }
                });
        }

},1000);

    
   
});   

function setInitTime(totalsec)
{
    chhour(Math.floor(totalsec/(60*60)));
    chminute(Math.floor((totalsec%(60*60))/60));
    chsec(Math.floor((totalsec%(60*60))%60));
    
}


function chhour(v) // draws the hour digits
{
    
    var ts=v.toString();
    var t=document.getElementById("hour");
    
    if(ts.length==1)
        {
            t.innerHTML="0"+ts;        
        }
    else
        {t.innerHTML=ts;}
}

function chminute(v) // draws the minutes digits
{
    var ts=v.toString();
    var t=document.getElementById("minutes");
    
    if(ts.length==1)
        {
            t.innerHTML="0"+ts;        
        }
    else
        {t.innerHTML=ts;}
}

function chsec(v) // draws the seconds
{   
    var ts=v.toString();
    var t=document.getElementById("seconds");
    
    if(ts.length==1)
        {
            t.innerHTML="0"+ts;        
        }
    else
        {t.innerHTML=ts;}
}
    
    