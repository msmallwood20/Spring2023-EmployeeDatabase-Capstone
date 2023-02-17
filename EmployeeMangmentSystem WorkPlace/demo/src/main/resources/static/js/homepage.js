/*SlideShow Container JS Allows the slide to advance auto*/
var slideIndex = 0;
carousel();

function carousel() {
  var i;
  var x = document.getElementsByClassName("Slides");

  for(i = 0; i < x.length; i++)
  {
    x[i].style.display = "none";
  }
  slideIndex++;
  if (slideIndex > x.length) {slideIndex = 1} 
  x[slideIndex-1].style.display = "block";
  setTimeout(carousel, 5000); 
}