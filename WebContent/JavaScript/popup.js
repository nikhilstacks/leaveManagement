function ApplyLeaveValidation() {

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
	if (uname.valueOf()[0].value.length < 2
			|| phone.valueOf()[0].value.length < 10
			|| reason.valueOf()[0].value.length < 10) {
		message.innerHTML = "Enter valid details";
		return false;
	}
	return true;
}

function validationCreateStaff() {
	let
	message = document.getElementById('message');
	let
	uname = document.getElementsByName("uname");
	let
	psw = document.getElementsByName("psw");

	if (uname.valueOf()[0].value.length < 2
			|| psw.valueOf()[0].value.length < 8) {
		message.innerHTML = "Enter valid details";
		return false;
	}
}

function validationCreateStudent() {
	let
	message = document.getElementById('message');
	let
	uname = document.getElementsByName("uname");
	let
	psw = document.getElementsByName("psw");

	if (uname.valueOf()[0].value.length < 2
			|| psw.valueOf()[0].value.length < 8) {
		message.innerHTML = "Enter valid details";
		return false;
	}
}