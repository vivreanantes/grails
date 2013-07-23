package com.van.trieranantes.dechet

import java.text.Normalizer

import com.van.trieranantes.recherche.IndexDechet

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
	
	static mapping = {
		description type:'text'
	}
	
	def beforeValidate(){
		indexDechet = new IndexDechet(dechet:this)
		indexDechet.nom = Normalizer.normalize(nom?:"", Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "")?.toLowerCase()
		indexDechet.description = Normalizer.normalize(description?:"", Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "")?.toLowerCase()
	}
}
