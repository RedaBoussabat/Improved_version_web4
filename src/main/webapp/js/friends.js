$(document).ready(function (){
    $("#addFriendButton").click(function (){
        $email = document.getElementById("email").value;
        $.post("Controller?command=Friends", {email:$email}, function (data){
            var newParagraph = $('<p />').text(data);
            $('#friendList').append(newParagraph);
        });
    });
});