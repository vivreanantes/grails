package com.van.trieranantes.recherche.dechet

import java.text.Normalizer

import com.van.trieranantes.dechet.Dechet

class RechercheService {

    List<Dechet> rechercherDechets(String motCle) {
		motCle = Normalizer.normalize(motCle, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
		List<Dechet> resultats
		List indexDechets
		def query = IndexDechet.where {
			nom ==~ "%"+motCle+"%" || 
			description ==~ "%"+motCle+"%" 
		}
		
		indexDechets = query.list()
		resultats = indexDechets*.dechet
		println resultats
		return resultats
    }
}
