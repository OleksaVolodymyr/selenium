$('#btn').click(function(){
  var openWeatherAPIKey="8cc5110a45a6d7e4cdcf0b687e8def4f";
  var url ="http://api.openweathermap.org/data/2.5/weather?";
  var location = $('#loc').val();
  if(location&&location!=''){
      location=location.trim();
      var result = $.getJSON(url+"q="+location+"&units=metric"+"&lang=ua"+"&appid="+openWeatherAPIKey);
      result.success(function(){
          setData(result.responseText);
      });
      result.fail(function(){
        alert(JSON.parse(result.responseText).message);
      });
  }else {
      alert("Unknown location");
    }
  
});
function setData(result){
    var parse = JSON.parse(result);
    //console.log(parse);
    $(".weather").remove();
    $('body').append("<div class='weather'></div>");
    $('.weather').append("<h3>"+parse.name+", "+ parse.sys.country+"</h3>")
        .append("<span>"+"Coord: "+" lon. "+parse.coord.lon+", lat. "+parse.coord.lat+"</span>")
        .append("<div class='pictureAndTemp'></div>");
    $('.pictureAndTemp').append("<div class='cont'>"+"<img title="+parse.weather[0].description+" src='http://openweathermap.org/img/w/"+parse.weather[0].icon+".png'>"+"<p class='maint'>"+parse.main.temp+"<sup>o</sup>"+"</p>"+"</div>")
        .append("<div class='description'>"+"<p>"+parse.weather[0].main+"</p>"+"</div>");
    $('.weather').append("<div class='mnx'></div>");
    $('.mnx').append("<div class='mn'>"+"min."+"<span>"+parse.main.temp_min+"<sup>o</sup>"+"</span>"+"</div>")
        .append("<div class='mn'>"+"max."+"<span>"+parse.main.temp_max+"<sup>o</sup>"+"</span>"+"</div>");
    $('.weather').append("<div class='details'></div>");
    $('.details').append("<div class='dmn'>"+"wind speed"+"<span>"+parse.wind.speed+" m/s"+"</span>"+"</div>")
        .append("<div class='dmn'>"+"wind deg"+"<span>"+parse.wind.deg+"</span>"+"</div>")
        .append("<div class='dmn'>"+"humidity"+"<span>"+parse.main.humidity+"%"+"</span>"+"</div>")
        .append("<div class='dmn'>"+"pressure"+"<span>"+parse.main.pressure+"hPa"+"</span>"+"</div>")
        .append("<div class='dmn'>"+"cloudiness"+"<span>"+parse.clouds.all+"%"+"</span>"+"</div>");;
    $('.weather').append("<div class='sunud'></div>");
    var sunrise = new Date(parse.sys.sunrise);
    var sunset = new Date(parse.sys.sunset);
    $('.sunud').append("<div class='dmn'>"+"sunrice"+"<span>"+sunrise.getHours()+":"+sunrise.getMinutes()+":"+sunrise.getSeconds()+"</span>"+"</div>")
        .append("<div class='dmn'>"+"sunset"+"<span>"+sunset.getHours()+":"+sunset.getMinutes()+":"+sunset.getSeconds()+"</span>"+"</div>");
    var pos={lat: parse.coord.lat, lng: parse.coord.lon};
    var map =new google.maps.Map(document.getElementById('map'), {
        zoom:4,
        center: pos
    });
    var  marker = new google.maps.Marker({position: pos , map: map});  
}

var map;
var  marker;
function initMap() {
        var uluru = {lat: 49.84, lng: 24.02};
         map = new google.maps.Map(document.getElementById('map'), {
          zoom: 4,
          center: uluru
        });
    /*google.maps.event.addListener(map, 'click', function(event) {
    var  marker = new google.maps.Marker({position: event.latLng, map: map});
    console.log(event.latLng);
    var result= $.getJSON("http://api.openweathermap.org/data/2.5/weather?lat="+event.latLng.lat()+"&lon="+event.latLng.lng()+"&appid=8cc5110a45a6d7e4cdcf0b687e8def4f");
    result.success(function(){
          setData(result.responseText);
      });
      result.fail(function(){
        alert(JSON.parse(result.responseText).message);
      });
  });*/
}
$('#map').click(function(e){
    google.maps.event.addListener(map, 'click', function(event) {
    marker = new google.maps.Marker({position: event.latLng, map: map});
    var result= $.getJSON("http://api.openweathermap.org/data/2.5/weather?lat="+event.latLng.lat()+"&lon="+event.latLng.lng()+"&units=metric&appid=8cc5110a45a6d7e4cdcf0b687e8def4f");
    result.success(function(){
          setData(result.responseText);
      });
      result.fail(function(){
        alert(JSON.parse(result.responseText).message);
      });
  });
});

