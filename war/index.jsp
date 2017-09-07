
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script src="Login.js"></script>

<body background="images/bk4.jpg">
	<h1
		style="text-align: center; padding-top: 30px; color: cornflowerblue;">Welcome!</h1>
	<div class="Button" style="text-align: center">
		<button onclick="showSignUp()" style="color: brown;">SignUp</button>
		<button onclick="showSignIn()" style="color: brown;">SignIn</button>
	</div>
	<script>
		function showSignUp() {
			document.getElementById("signUp").style.display = "block";
			document.getElementById("signIn").style.display = "none";
		}
		function showSignIn() {
			document.getElementById("signIn").style.display = "block";
			document.getElementById("signUp").style.display = "none";
		}
	</script>



	<div id='signUp'>

		<!-- <h1>Hello SignUp!</h1> -->
		<table border="2" , align="center" style="margin-top: 35px;">
			
				<tr>
					<td>First Name:</td>
					<td><input type="text" name="firstName" id="firstName"></td>
				</tr>
				<tr>
					<td>Last Name:</td>
					<td><input type="text" name="lastName" id="lastName"></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><input type="email" name="email" id="email"></td>
				</tr>
				
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password" id="password"></td>
				</tr>

				<tr>
					<td><input type="submit" value="submit" onclick="signupcall()"></td>
				</tr>
				</td>
				</tr>
			
		</table>

	
	</div>

	<div id='signIn' style="display: none;">
		<table border="2" , align="center" style="margin-top: 35px;">

				<tr>
					<td>Email:</td>
					<td><input type="email" name="email" id="email1"></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password" id="password1"></td>
				</tr>
				<tr>
					<td><input type="submit" name="SignIn" value="login" onclick="makeLoginAjax()"></td>
				</tr>
		</table>
	
	</div>


</body>
</html>
