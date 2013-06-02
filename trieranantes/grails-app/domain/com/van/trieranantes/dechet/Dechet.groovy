package com.van.trieranantes.dechet

class Dechet {

    String code
	String nom
	String description
	CategorieTraitement categorieTraitement
	CategorieUsuelle categorieUsuelle
	boolean estVerifie
	boolean estRecyclable
	String image
	
	static hasMany = [conseils:Conseil]
	
    static constraints = {
		code nullable:false, unique:true
		nom nullable:false
		description nullable:true
		categorieTraitement nullable:false
		categorieUsuelle nullable:false
		image nullable:true
    }
}
