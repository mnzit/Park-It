
// Or with jQuery

$(document).ready(function () {
    $('.sidenav').sidenav();
})
$("#phoneNo").on('input', function () {
    if ($(this).val().length > 10) {
        alert('Your mobile number should be of 10 digits only');
    }
});

var uniid, uni_check;
function dataSender(id, check) {
    uni_id = id;
    uni_check = check;
}
function deleteData() {
    var xmlhttp;
    var class_name;
    if (window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();
    } else {
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    if (uni_check === "staffDelete") {
        xmlhttp.open("GET", "StaffController?action=delete&staffid=" + uni_id + "&format=fragment", true);
        class_name = "staff-";
    } else if (uni_check === "memberDelete") {
        xmlhttp.open("GET", "MemberController?action=delete&memberid=" + uni_id + "&format=fragment", true);
        class_name = "member-";
    }
    xmlhttp.send(null);
    xmlhttp.onreadystatechange = function ()
    {
        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
            console.log("Deleted");
            var row = document.getElementById(class_name + uni_id);
            row.parentNode.removeChild(row);
        }
    }
}
$('.seats').change(function () {
    if ($(this).is(":checked")) {
        $(this).addClass('marked');
    } else {
        $(this).removeClass('marked');
    }
});
function call() {
    var chkArray
    var vehicleno = document.getElementById("vehicleno").value;
    /* look for all checkboes that have a parent id called 'checkboxlist' attached to it and check if it was checked */
    $(".marked").each(function () {
        chkArray = ($(this).val());
    });
    console.log(chkArray + name + vehicleno);
    var xmlhttp;
    if (window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();
    } else {
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.open("GET", "ParkingController?action=checked&checkedbox=" + chkArray + "&vehicleno=" + vehicleno + "&format=fragment", true);
    xmlhttp.send(null);
    xmlhttp.onreadystatechange = function ()
    {
        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
            $(".seats").each(function () {
                $(this).removeClass('marked');
                location.reload();
            });
        }

    }
}
function removeVehicle(i, j) {
    var xmlhttp;
    if (window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();
    } else {
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        s
    }
    xmlhttp.open("GET", "ParkingController?action=removed&location_id=" + i + "&parkid=" + j + "&format=fragment", true);
    xmlhttp.send(null);
    xmlhttp.onreadystatechange = function ()
    {
        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
            location.reload();
            alert("The vehicle is removed from parking space")
        }

    }
}

var secondsPerMinute = 60;
var minutesPerHour = 60;

function convertSecondsToHHMMSS(intSecondsToConvert) {
    var hours = convertHours(intSecondsToConvert);
    var minutes = getRemainingMinutes(intSecondsToConvert);
    minutes = (minutes == 60) ? "00" : minutes;
    var seconds = getRemainingSeconds(intSecondsToConvert);
    return hours + ":" + minutes;
}

function convertHours(intSeconds) {
    var minutes = convertMinutes(intSeconds);
    var hours = Math.floor(minutes / minutesPerHour);
    return hours;
}
function convertMinutes(intSeconds) {
    return Math.floor(intSeconds / secondsPerMinute);
}
function getRemainingSeconds(intTotalSeconds) {
    return (intTotalSeconds % secondsPerMinute);
}
function getRemainingMinutes(intSeconds) {
    var intTotalMinutes = convertMinutes(intSeconds);
    return (intTotalMinutes % minutesPerHour);
}

function HMStoSec1(T) { // h:m:s
    var A = T.split(/\D+/);
    return (A[0] * 60 + +A[1]) * 60 + +A[2]
}

function rowHandler(parked, taken) {
    var time1 = HMStoSec1(parked);
    var time2 = HMStoSec1(taken);
    var diff = time2 - time1;
    alert("The time was: " + convertSecondsToHHMMSS(diff));
    return("The time was: " + convertSecondsToHHMMSS(diff));
}

tippy('.seats', {followCursor: true});