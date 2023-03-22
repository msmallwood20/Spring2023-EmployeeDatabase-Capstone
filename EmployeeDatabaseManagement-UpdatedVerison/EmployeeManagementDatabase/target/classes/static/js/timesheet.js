function myFunction() {

  var start = document.getElementById("start").value;
  var end = document.getElementById("end").value;
  var message = document.getElementById("total_Week1_Day1");
  var totaltime = parseInt(end) - parseInt(start);
  
  message.innerHTML = totaltime;

}

{/* Hours:
9:00am-5:00pm 
OutPut: Value is Equal to -8 */}