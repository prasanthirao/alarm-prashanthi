var date =null;
var time = null;
var timer =null;
function openBox()
{
	//document.getElementById("giveTime").innerHTML ="";
document.getElementById("addingTime").style.display="block";
}
function postTime()
{
document.getElementById("addingTime").style.display ="none";
time =document.getElementById("giveTime").value;
var ul = document.getElementById("givenTime");
var li = document.createElement("li");
var lii=document.createElement("button");
// lii.className ="glyphicon glyphicon-trash";
lii.setAttribute("class","glyphicon glyphicon-trash;");
lii.setAttribute("style","margin-right:-34px; float: right;");
// lii.setAttribute("id","ids")
lii.setAttribute("id",time);
lii.setAttribute("type","delete");


// lii.setAttribute("onclick", function() { alert("blabla"); });
li.setAttribute("class", "list-group-item");
li.setAttribute("class","well");
li.appendChild(document.createTextNode(time));
ul.appendChild(lii);
ul.appendChild(li);
}
function stop()
{
clearInterval(timer);
}
document.getElementById('giveTime').onkeydown = function(event){
    var e = event || window.event;
    if(e.keyCode == 13){
       // postTime();
    	time =document.getElementById("giveTime").value;
    	checkTimeFormat(time);
    	
    }
}
function checkTimeFormat(event){
alert(event);
	var regex = new RegExp("([0-1][0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])");
	if (regex.test(event)) {
	// alert("true");
	postTime();
	} else {
	alert("please enter HH:MM:SS format only ");
	}
}
/*
 * function identify(ul){ //var
 * event=document.getElementById("givenTime").innerHTML; alert(ul); var
 * target=getEventTarget(ul);
 * //document.getElementById("display").innerHTML=target.innerHTML;
 * alert(target); }
 */
/*
 * document.getElementById("ul").onclick=function(event){ alert("fgfgfd"); }
 */
// document.getElementById("givenTime").onclick=function(event){
function startTimer(event){
	var target = getEventTarget(event);
	var targetId = event.target.id;
	if(!targetId){
	document.getElementById("display").innerHTML = target.innerHTML;
	// document.getElementsByTagName("button").onclick=function(){alert("sdf");}
	// document.getElementById(targetId);
	alert(target.innerHTML);
	// alert(targetId);
	date= new Date();
	var initialtime = target.innerHTML;
	var array =null;
	array= initialtime.split(':');
	console.log(array);
	var hours=array[0];
	var minutes=array[1];
	var seconds=array[2];
	date.setHours(hours);
	date.setMinutes(minutes);
	date.setSeconds(seconds);
	clearInterval(timer);
	timer=setInterval(function () {
	document.getElementById("display").innerHTML=date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
	date.setTime(date.getTime() + 1000);
	}, 1000);
	document.getElementById("stop").style.display = "block";
	}
	/*
	 * else { document.getElementById(targetId); alert(targetId);
	 */
		else
		{
		var deltime=targetId;

		alert(targetId);
		console.log(deltime);
		var targetId;
		console.log(deltime);
		var xhr = new XMLHttpRequest();
		var url = "/delete";
		xhr.open("POST", url, true);
		xhr.setRequestHeader("Content-type", "application/json");
		xhr.onreadystatechange = function () {
		if (xhr.readyState == 4 && xhr.status == 200) {
		// var json = JSON.parse(xhr.responseText);
		alert("success");
		// console.log(json);
		// alert(json.email);
		// console.log(json.email);
		// document.getElementById("demo").innerHTML = this.responseText;
		if(json.successmsg==="sucess")
		{
		alert("success");
		 setTimeout(function(){
	         document.getElementById("errorDisplay").innerHTML="dfghjk";
	         },3000);
		
		else{
		alert("fail");
		}
		// window.location.href="/test/success";
		// document.getElementById("myform").reset();
		; }
		}; 
		var data = JSON.stringify({"deltime":deltime});
		console.log(data);
		xhr.send(data);
		 //document.getElementById("givenTime").style.display="none"; 
		target.style.display="none";
		}
		};
		


	function getEventTarget(e) {
	e = e || window.event;
	return e.target || e.srcElement; 
	}
 
