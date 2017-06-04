(function($){
    $(function(){
        var currentUrl = $(location).attr('href');
        var firstPosition = currentUrl.indexOf("1");
        var lastPosition = currentUrl.indexOf(":");
        var removeSlash = currentUrl.length - 1;
        var secondUrl = currentUrl.toString().slice(0, removeSlash);
        var rawness = String.raw`:2222/html/min.php`;
        var calcUrl = secondUrl.concat(rawness);
        $("#camera-screen").attr("src", calcUrl);
    });
})(jQuery);