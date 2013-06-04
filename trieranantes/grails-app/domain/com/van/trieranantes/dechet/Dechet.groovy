package com.van.trieranantes.dechet

import java.text.Normalizer

import com.van.trieranantes.recherche.dechet.IndexDechet

class Dechet {

    String code
	String nom
	String description
	CategorieTraitement categorieTraitement
	CategorieUsuelle categorieUsuelle
	boolean estVerifie
	boolean estRecyclable
	String image
	
	IndexDechet indexDechet
	
	static hasMany = [conseils:Conseil]
	
    static constraints = {
		code nullable:false, unique:true
		nom nullable:false
		description nullable:true
		categorieTraitement nullable:false
		categorieUsuelle nullable:false
		image nullable:true
    }
	
	def beforeValidate() {
		if (indexDechet == null){
			indexDechet = new IndexDechet()
		}
		indexDechet.nom=Normalizer.normalize(nom, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
		if (description != null){indexDechet.description=Normalizer.normalize(description, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "")}
		indexDechet.estVerifie=estVerifie
		indexDechet.estRecyclable=estRecyclable
		indexDechet.dechet = this
		println indexDechet
	}
}
