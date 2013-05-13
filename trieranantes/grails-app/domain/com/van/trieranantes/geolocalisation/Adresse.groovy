package com.van.trieranantes.geolocalisation

class Adresse {

	String adresse1
	String adresse2
	String adresse3
	String adresse4
	String codePostal
	String ville
	//Latitude , Longitude
	Float lat
	Float lng
	
    static constraints = {
		
		adresse1(unique: ['codePostal','ville'])
		
		/*
		latitude nullable:true, validator: { val, obj ->
			(val>=0 && val<90)
		}
		longitude nullable:true, validator: { val, obj ->
			(val>=0 && val<360)
		}
		*/
    }
}
