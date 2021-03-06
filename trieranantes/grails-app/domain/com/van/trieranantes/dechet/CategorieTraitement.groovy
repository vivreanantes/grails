package com.van.trieranantes.dechet

class CategorieTraitement {

	String code
	String libelle
	String description
	
	static hasMany=[modesCollecte:ModeCollecte, conseils:Conseil]
	
	static mapping = {
		description type:'text'
	}
	
    static constraints = {
		code nullable:false, unique:true
    }
}
