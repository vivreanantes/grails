/* WRAPPER pour la cartographie */

/* Dependances : API Leaflet (http://leafletjs.com) */

//TODO : Optimisation viewport : charger seulement les points visibles

function VanMap() { 

	
    this.mapParams = {center: [47.21607, -1.544781], zoom: 12}; 
    this.map=null;
    this.overlayLayers=[];
    
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
    	
    	
    	/* Collecte Layer */
    	/*
    	this.collecteLayer = L.geoJson([], { 
    			
    		// PointToLayer
    		pointToLayer: function (feature, latlng) {
				return L.circleMarker(latlng, {
					radius: 8,
					fillColor: "#ff7800",
					color: "#000",
					weight: 1,
					opacity: 1,
					fillOpacity: 0.8
				});			
    		}
    	
    		});*/
    	
    }

    this.show = function() { 
    	   	
    	
    
    }
    
	/* Affiche un marqueur pour l'adresse entree 
	 * Service de geocoding Google Adresse => Latitude,Longitude 
	 * @param info {code : 'sdc_de', coord : { lat : 45.075, lng : -1.5236 }, fulladress : 'rue de strasbourg 44200 nantes', customtext : 'Mardi au Samedi de 10h à  17h30 (sauf jours fériés)'}
	 * */
    this.addPoint = function (info) {
    	  	
    	if (typeof info.code != 'undefined' && typeof info.coord != 'undefined') {

    		//LAYER EXISTS ?
    		layerId=info.code;
    		this.log('ADD POINT '+ info.coord.lat + ' ' + info.coord.lng,'debug');
    		
    		if (typeof this.overlayLayers[layerId] != 'undefined')
    		{
    			
    			this.log('UPDATE layer '+layerId,'debug');
    			
    		}
    		else {
    			
    			this.log('CREATE layer '+layerId,'debug');
    			
    		}
    		
    	}
    	else {
    		
    		this.log('Paramètre incorrect','error');
    		
    	}
    	
    	/*
    	newcoord=[coord.lng,coord.lat];
    	
    	
          	    	  // PACKING DATA
          	    	  
          	    	  geojsonFeature = {
          	    		    "type": "Feature",
          	    		    "properties": {},
          	    		    "geometry": {
          	    		        "type": "Point",
          	    		        "coordinates": newcoord
          	    		    }
          	    	  };
          	    	 
          	    	  this.collecteLayer.addData(geojsonFeature);  	
          	    	  */
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


