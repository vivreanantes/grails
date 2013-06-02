/* WRAPPER pour la cartographie */

/* Dependances : API Leaflet (http://leafletjs.com) */

//TODO : Optimisation viewport : charger seulement les points visibles

function VanMap() { 

	
    this.mapParams = {center: [47.21607, -1.544781], zoom: 11}; 
    this.map=null;
    this.overlayLayers=[];
    this.overlayLayersHidden=[];
    
    this.init = function() { 

    	//INIT MAX BOUNDS (Nantes et agglo)
    	bounds = new L.LatLngBounds([47, -1.8], [47.4, -1.3]);
    	this.mapParams.maxBounds=bounds

		// initialize the map on the "map" div with a given center and zoom
		this.map = L.map('map', this.mapParams);
    	
    	//Base Tile Layer
    	osmUrl='http://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png';
    	osmAttrib='Map data © openstreetmap';
    	osmLayer = new L.TileLayer(osmUrl,{minZoom:8,maxZoom:18,attribution:osmAttrib});  	
    	osmLayer.addTo(this.map);
		
    }

    this.show = function() { 
    	 
    	for (var layerid in this.overlayLayers) {
    	    
    		this.log('ADD LAYER TO MAP '+ layerid,'debug');
        	this.map.addLayer(this.overlayLayers[layerid]);
    		
    	}
    
    }
    
	/* Ajout d'un point sur la carte
	 * @param info {type : 'sdc_de', coord : { lat : 45.075, lng : -1.5236 }, fulladress : 'rue de strasbourg 44200 nantes', customtext : 'Mardi au Samedi de 10h à  17h30 (sauf jours fériés)'}
	 * */
    this.addPoint = function (info) {
    	  	
    	if (typeof info.type != 'undefined' && typeof info.coord != 'undefined') {

    		//LAYER EXISTS ?
    		layerId=info.type;
    		this.log('ADD POINT '+ info.coord.lat + ' ' + info.coord.lng,'debug');
    		
    		if (typeof this.overlayLayers[layerId] == 'undefined')
    		{			  	
    			
    			this.log('CREATE layer '+layerId,'debug');
    			
    			myobj=this;
    			
    			// Layer
    			this.overlayLayers[layerId] = L.geoJson([], { 
    	    			
    	    		// PointToLayer
    	    		pointToLayer:  myobj.pointToLayer,
    	    		// onEachFeature
    	    		onEachFeature: myobj.onEachFeature
    	    		
    	    		});
    							
    		}
    		
    		//ADD POINT
    		if (typeof info.customtext != 'undefined' && info.customtext != '')
    			popuptext=info.customtext + "<br/>" + info.fulladress ;
    		else 
    			popuptext=info.fulladress;
    		
    		newcoord=[info.coord.lng , info.coord.lat];
			geojsonFeature = {
   	    		    "type": "Feature",
   	    		    "properties": { type : info.type , popupContent: popuptext },
   	    		    "geometry": {
   	    		        "type": "Point",
   	    		        "coordinates": newcoord
   	    		    }
			};
   	    	 
			this.overlayLayers[layerId].addData(geojsonFeature);  	
    		
    	}
    	else {
    		
    		this.log('Paramètre incorrect','error');
    		
    	}
    	
    }
    
    this.toggleType = function (type) {
    	
    	if (typeof this.overlayLayers[type] != 'undefined')
		{	
    		this.log('HIDE LAYER '+ type,'debug');
    		this.overlayLayersHidden[type]=this.overlayLayers[type];
    		this.map.removeLayer(this.overlayLayers[type]);
    		delete this.overlayLayers[type];
		}
    	else if (typeof this.overlayLayersHidden[type] != 'undefined') {
    		
    		this.log('SHOW LAYER '+ type,'debug');
    		this.overlayLayers[type]=this.overlayLayersHidden[type];
    		this.map.addLayer(this.overlayLayers[type]);
    		delete this.overlayLayersHidden[type];
    	}
    	
    }
    
    
    this.log = function (obj,level) {
    	
    	if (console) {
    		
    		switch (level) {
    		 case 'debug':
    			 console.debug(obj);
    		 break;
    		 case 'info':
    			 console.info(obj);
    		 break;
    		 case 'warn':
    			 console.warn(obj);
    		 break;
    		 case 'error':
    			 console.error(obj);
    		 break;
    		 default: 
    		 break;
    		}
    		
    	}
    	
    }
    
    this.pointToLayer = function (feature, latlng) {
			
    	
			// Creates a red marker with the coffee icon
			customMarker = L.AwesomeMarkers.icon({
			  icon: myobj.mapAwesomeIcon(feature.properties.type), 
			  color: myobj.mapAwesomeColor(feature.properties.type),
			  iconColor: 'white'
			});	
			
			finalMarker= L.marker(latlng, {icon: customMarker});
			
			return finalMarker;
			
    }
    
    this.onEachFeature = function (feature, layer) {
    	
        // does this feature have a property named popupContent?
        if (feature.properties && feature.properties.popupContent) {
            layer.bindPopup(feature.properties.popupContent);
        }
    }
    
    this.mapAwesomeIcon = function (type) {
 	
    	awesomeIcon='flag';
    	   	
    	switch (type) {
		 case 'sdc_de':
			 awesomeIcon='flag';
		 break; 
		 case 'modco_contverre':
			 awesomeIcon='glass';
		 default: 
		 break;
		}	
    	
    	myobj.log('ICON '+awesomeIcon,'debug');
    	
    	return awesomeIcon;
    	
    }
    
    this.mapAwesomeColor = function (type) {
        
    	awesomeColor='blue';
    	
    	switch (type) {
		 case 'sdc_de':
			 awesomeColor='blue';
		 break;
		 case 'sdc_ec':
			 awesomeColor='blue';
		 break;
		 case 'modco_contverre':
			 awesomeColor='green';
		 break;
		 default: 
		 break;
		}
    	
    	return awesomeColor;
    	
    }
    

} 


/* Geocoding */
function geocode_test(adress) {
	
	geocoder = new google.maps.Geocoder();    
	geocoder.geocode({'address': adress}, function(results, status,context) {
	  	      if (status == google.maps.GeocoderStatus.OK) {
	  	       
	  	    	  coord=[results[0].geometry.location.lat(),results[0].geometry.location.lng()];      	    	  	    	  
	  	    	  
	  	                       
	  	      } else {
	  	        //alert('Geocode was not successful for the following reason: ' + status);     	    	  
	  	      }
	  	      
	});

}


