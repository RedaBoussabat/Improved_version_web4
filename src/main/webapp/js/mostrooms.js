$(function getMostRooms(){
  $.ajax({
    type: "GET",
    url: "Controller?command=MostRooms",
    dataType: "json",
    success: function (json){
      $(json).each(function (index, person){
        $('#mostRooms').append($('<p />').text(person.room));
        setTimeout(getMostRooms,10000);
      })
    },
    error: function (){
      alert("An error occurred while getting a most rooms");
    }
  });
});