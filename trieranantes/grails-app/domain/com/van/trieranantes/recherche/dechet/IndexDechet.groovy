package com.van.trieranantes.recherche.dechet

import com.van.trieranantes.dechet.CategorieTraitement;
import com.van.trieranantes.dechet.CategorieUsuelle;
import com.van.trieranantes.dechet.Dechet

class IndexDechet {

	String nom
	String description
	boolean estVerifie
	boolean estRecyclable
	
	static belongsTo = [dechet:Dechet]
	
    static constraints = {
		description nullable:true
    }
	
}
