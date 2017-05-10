$(document).ready(function(){
	    
	    var totalsec=60*60*3;
	    var inter;
	    var state=false;
        $.ajax({
            type: "get",
            url: "",
            success: function(data){
                totalsec = data;
            }
        });
	    setInitTime(totalsec);
	    $("#button").on("click",function(){
	        
	        if(state==true)
	            {
	                totalsec=60*60*3;
	                setInitTime(totalsec);
	                clearInterval(inter);
	                document.getElementById("button").innerHTML="Start";
	                state=false;
	            }
	        else
	            {
	                $(this).hide("slow");
                    $(".escape-start-test").hide("slow");
                    totalsec=60*60*3;
	                setInitTime(totalsec);
	                document.getElementById("button").innerHTML="Stop";
	                var out;
	                var h,m,s;
                    testInProgress = true;
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
	                            window.location.reload(1);
                                testInProgress = false;
                                clearInterval(inter);
	                        }
	
	                },1000);
	                state=true;
	            }
	        
	    });
	    
	    
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

