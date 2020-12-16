$(function () {

    $('h2').hide().slideDown();

    var $li = $('#guidelines p');

    $li.hide().each(function (index) {
        $(this).delay(2000 * index).fadeIn(1000);
    });


    $('nav ul li').click(function () {
       alert("Click on OK if you promise to follow these guidelines <3");
    });
})

$("#guidelines li").on({
    click: function (){
        $(".important p").hide().fadeIn(1500);
    }
});
