$(document).ready(function(){
	    var inter; 
	    $("#button").on("click",function(){
	                var button =this;
                        $.ajax({
                                type: "get",
                                url: "startTest",
                                data:$.param({testId : window.testIndex}),
                                success: function(data, textStatus, jqXHR) {
                                      timer(button);  
                                }
                            });
                                
                        
	    });
	    
	    
	});
        
        function timer(button){
            
            var totalsec = window.totalsec;
            $(button).hide("slow");
            $(".escape-start-test").hide("slow");
            setInitTime(totalsec);
            var out;
            var h,m,s;
            inter=setInterval(function(){
            h=Math.floor(totalsec/(60*60));
            m=Math.floor((totalsec%(60*60))/60);
            s=Math.floor((totalsec%(60*60))%60);
            chsec(s);
            chminute(m);
            chhour(h);
            totalsec--;
             if(totalsec < 0)
                {
                    window.location.href="teacherDash";
                    clearInterval(inter);
                }

        },1000);
            
        }
        
	
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

