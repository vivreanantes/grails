if (typeof jQuery !== 'undefined') {
	(function($) {
		
		$('#spinner').ajaxStart(function() {
			$(this).fadeIn();
		}).ajaxStop(function() {
			$(this).fadeOut();
		});
	})(jQuery);
}

/* Init */
/*
$(document).ready(function() {

	$('#searchresults .result').mouseover(function() { jQuery(this).addClass('hover'); });	
	$('#searchresults .result').mouseout(function() { jQuery(this).removeClass('hover'); });	
	
});
*/






