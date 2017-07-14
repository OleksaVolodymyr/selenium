var map;
function initMap() {
        var uluru = {lat: 49.84, lng: 24.02};
         map = new google.maps.Map(document.getElementById('map'), {
          zoom: 4,
          center: uluru
        });
       /// addMarker(uluru,map);
    google.maps.event.addListener(map, 'rightclick', function(event) {
    alert("Latitude: " + event.latLng.lat() + " " + ", longitude: " + event.latLng.lng());
   // map.clearOverlays();
    var  marker = new google.maps.Marker({position: event.latLng, map: map});
  });
}


