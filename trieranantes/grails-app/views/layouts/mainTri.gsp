<!doctype html>
<!--[if lt IE 7 ]> <html lang="fr" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="fr" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="fr" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="fr" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title><g:layoutTitle default="TriANantes"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon">
		<link rel="apple-touch-icon" href="${resource(dir: 'images', file: 'apple-touch-icon.png')}">
		<link rel="apple-touch-icon" sizes="114x114" href="${resource(dir: 'images', file: 'apple-touch-icon-retina.png')}">
		
		<!--
		<link rel="stylesheet" href="${resource(dir: 'css/blueprint', file: 'screen.css')}" type="text/css">
		<link rel="stylesheet" href="${resource(dir: 'css/blueprint', file: 'print.css')}" type="text/css" media="print">
		-->
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'maintri.css')}" type="text/css">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'menu_assets/styles.css')}" type="text/css">
		
		<g:javascript src="application.js" />
		<g:javascript src="map/map.js" />
		
		<g:javascript library="jquery" plugin="jquery"/>
		
		<!--  TWITTER BOOTSTRAP -->
		
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'bootstrap.css')}" type="text/css">
		<link href="//netdna.bootstrapcdn.com/font-awesome/3.1.1/css/font-awesome.css" rel="stylesheet">
		
		<!--  LEAFLET MAP -->
		
		<link rel="stylesheet" href="http://cdn.leafletjs.com/leaflet-0.5.1/leaflet.css" />
		<!--[if lte IE 8]>
    	<link rel="stylesheet" href="http://cdn.leafletjs.com/leaflet-0.5.1/leaflet.ie.css" />
		<![endif]-->
		<script src="http://cdn.leafletjs.com/leaflet-0.5.1/leaflet.js"></script>
		
		<!--  LEAFLET PLUGINS -->
		
		<link rel="stylesheet" href="${resource(dir: 'js', file: 'map/leaflet-plugins/awesome-marker/leaflet.awesome-markers.css')}" type="text/css">
		<g:javascript src="map/leaflet-plugins/awesome-marker/leaflet.awesome-markers.js" />
		
		
		<!--  GOOGLE MAP API V3 pour le webservice de geolocalisation -->
		
		<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>	
		
		<g:layoutHead/>
		<r:layoutResources />
		
		<g:javascript src="bootstrap.min.js" />
		
	</head>
	<body class="projet">
	
	<div id="header" class="container">
		<div class="row">
	    	<div class="span12">
	    		<g:render template="/layouts/header"/>
				<g:render template="/layouts/menus" />
			</div>
	    </div>
    </div>
    
    <div class="container" id="content">
    	<div class="row">
			<div id="leftcolon" class="span4">
				<g:render template="/layouts/recherches"/>
        	</div>    	
        	<div id="main" class="span8">
        		<div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"/></div>		
				<g:layoutBody/>
        	</div>
        </div>
        <div class="row">
        	<div id="footer" class="span12">
				<g:render template="/layouts/footer" />	
        	</div>
    	</div>
	</div>
    
    <!-- 
		<div id="header" class="row container">
			<div class="span-24">
				
        	</div>
        </div>
		
		-->
	</body>
</html>