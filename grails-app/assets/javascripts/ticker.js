/* List Ticker by Alex Fish 
// www.alexefish.com
//
// options:
//
// effect: fade/slide
// speed: milliseconds
*/

(function($){
  $.fn.list_ticker = function(options){
    
    var defaults = {
      speed: 2000,
	  effect:'fade'
    };

    var obj = this;
    var list = obj.children();
    var lastElement = list.last();

    var options = $.extend(defaults, options);
    
    return this.each(function(){
      
      var obj = $(this);
      var list = obj.children();

      list.not(':first').hide();
      
      setInterval(function (){
        
        list = obj.children();
        list.not(':first').hide();

        var first_li = list.eq(0)
        var second_li = list.eq(1)

        if (first_li.html() === lastElement.html()) {
          var link = $("#linkToDistractionTask");
          var href = link.attr('href');
          if(link.attr("target") === "_blank") {
            window.open(href);
          } else{
            window.location = href;
          }
        }
		if(options.effect == 'slide'){
			first_li.slideUp();
			second_li.slideDown(function(){
				first_li.remove().appendTo(obj);
			});
		} else if(options.effect == 'fade'){
			first_li.fadeOut(function(){
				second_li.fadeIn();
				first_li.remove().appendTo(obj);
			});
		}
      }, options.speed)
    });
  };
})(jQuery);