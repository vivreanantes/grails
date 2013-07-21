package com.van.trieranantes.recherche

import java.text.Normalizer

import com.van.trieranantes.dechet.Dechet

class RechercheService {

	List<Dechet> rechercherIndexDechets(String chaineRecherche){
		// suppression des caractères spéciaux
		String chaineTravail = Normalizer.normalize(chaineRecherche?:"", Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
		
		// split de la chaine
		List<String> listeMotsCles = chaineTravail.split()
		def criteria = Dechet.createCriteria()
		def results = criteria.list {
			indexDechet {
				or {
					listeMotsCles.each {String motCle ->
						like("nom", "%"+motCle.toLowerCase()+"%")
					}
				}
			}
		}
		List resultats = Dechet.list()
		return results
	}
	

}
