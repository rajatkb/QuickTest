$(document).ready(function(){
    index=Number($('.00').attr('id'));
    
    var totalsec=index;
    var inter;
    var state=false;
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
                        {
                            clearInterval(inter);
                            $.ajax({
                                type: "POST",
                                url: "Default.aspx/GetResponse",
                                data: $.param({answerScript: final_answer}),
                                success: function(response){
                                   if (response.d == true) {
                                        alert("You will now be redirected.");
                                        window.location = "//www.aspsnippets.com/";
                                    }
                                },
                                failure:function(response) {
                                    alert(response.d);
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
    
    