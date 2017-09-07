function makeLoginAjax()
 {
		 var email = document.getElementById("email1").value;
		 var password = document.getElementById("password1").value;
		 console.log(email);
		 var xhr = new XMLHttpRequest();
		 var url = "/LoginServlet";
		 xhr.open("POST", url, true);
		 xhr.setRequestHeader("Content-type", "application/json");
		 xhr.onreadystatechange = function () {
		 if (xhr.readyState == 4 && xhr.status == 200) {
		 //var json = JSON.parse(xhr.responseText);
		 //console.log(json.email);
		 //document.getElementById("demo").innerHTML = this.responseText;
		 alert("success");
		 alert(data);
		 window.location.href="/afterlogin";
		 //document.getElementById("myform").reset();
		 ; }
		 }; 
		 var data = JSON.stringify({"email": email, "password": password });
		 console.log(email);
		 xhr.send(data);	 
 }
 function signOut(){
	 //var email = document.getElementById("email").value;
	 //var password = document.getElementById("password").value;
	// console.log(name);
	 var xhr = new XMLHttpRequest();
	 //var email = "akhil";
	 var url = "/Signout";
	 xhr.open("POST", url, true);
	 xhr.setRequestHeader("Content-type", "application/json");
	 xhr.onreadystatechange = function () {
	 if (xhr.readyState == 4 && xhr.status == 200) {
		 alert("success");
	 //var json = JSON.parse(xhr.responseText);
	 //console.log(json.email);
	 //document.getElementById("demo").innerHTML = this.responseText;
	 //alert("success");
	 //alert(data);
	    window.location.href="/aftersignout";
	 //document.getElementById("myform").reset();
	 ; }
	 }; 
	 var data = JSON.stringify({"email": "akhil"});
	 //console.log(name);
	 xhr.send(data);
	 
	 
	 
	 
 }
 function signupcall()
 {
	 var firstnamee= document.getElementById("firstName").value;
	 var lastnamee= document.getElementById("lastName").value;
	 var emaile= document.getElementById("email").value;
     var passworde = document.getElementById("password").value;
	 console.log(emaile);
	 var xhr = new XMLHttpRequest();
	 var url = "/AuthenticationServlet";
	 xhr.open("POST", url, true);
	 xhr.setRequestHeader("Content-type", "application/json");
	 xhr.onreadystatechange = function () {
	 if (xhr.readyState == 4 && xhr.status == 200) {
	 //var json = JSON.parse(xhr.responseText);
	 //console.log(json.email);
	 //document.getElementById("demo").innerHTML = this.responseText;
	 alert("success");
	 alert(data);
	 window.location.href="/afterlogin";
	 //document.getElementById("myform").reset();
	 ; }
	 }; 
	 var data = JSON.stringify({"firstname": firstnamee,"lastname":lastnamee,"email":emaile, "password": passworde });
	 //console.log(name);
	 xhr.send(data);
	 
	 
	 
 }
 
	