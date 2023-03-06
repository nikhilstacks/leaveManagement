function ApplyLeaveValidation() {
	let isValid = true;
	let msg = "";
	console.log("inside validation");
	let
	message = document.getElementById('message');
	let
	uname = document.getElementsByName('fname');
	let
	mail = document.getElementsByName('mail');
	let
	phone = document.getElementsByName('phone');
	let
	reason = document.getElementsByName('rtl');
	let
	startDate = document.getElementsByName('startDate');
	let
	endDate = document.getElementsByName('endDate');
	let
	applyForLeave = document.getElementsByName('applyForLeave');

	console.log(phone.valueOf())
	if (uname.valueOf()[0].value.length < 2) {
		msg+= "Enter valid Name <br>";
		message.innerHTML = msg;
		isValid = false;
	}
	if (phone.valueOf()[0].value.length < 10) {
		msg+= "Enter valid Phone Number <br>";
		message.innerHTML = msg;
		isValid = false;
	}
	if (reason.valueOf()[0].value.length < 10) {
		msg+= "Enter valid Reason For Leave <br>";
		message.innerHTML = msg;
		isValid = false;
	}
	return isValid;
}

function validationCreateStaff() {
	let isValid = true;
	let msg = "";
	let
	message = document.getElementById('message');
	let
	uname = document.getElementsByName("uname");
	let
	psw = document.getElementsByName("psw");

	if (uname.valueOf()[0].value.length < 2) {
		msg+= "Enter valid Name <br>";
		message.innerHTML = msg;
		isValid = false;
	}
	if (psw.valueOf()[0].value.length < 8) {
		msg+= "Enter valid Password";
		message.innerHTML = msg;
		isValid = false;
	}
	return isValid;
}

function validationCreateStudent() {
	let isValid = true;
	let msg = "";
	let
	message = document.getElementById('message');
	let
	uname = document.getElementsByName("uname");
	let
	psw = document.getElementsByName("psw");

	if (uname.valueOf()[0].value.length < 2) {
		msg+= "Enter valid Name <br>";
		message.innerHTML = msg;
		isValid = false;
	}
	if (psw.valueOf()[0].value.length < 8) {
		msg+= "Enter valid Password";
		message.innerHTML = msg;
		isValid = false;
	}
	return isValid;
}