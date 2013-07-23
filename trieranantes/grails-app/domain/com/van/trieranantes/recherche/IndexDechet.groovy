package com.van.trieranantes.recherche

import com.van.trieranantes.dechet.Dechet

class IndexDechet {

	String nom
	String description
	
	static belongsTo = [dechet:Dechet]
	
    static constraints = {
    }
	
	static mapping = {
		description type:'text'
	}
}
