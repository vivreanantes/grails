package com.van.trieranantes.common

import com.van.trieranantes.dechet.Dechet;

class RechercheController {

	def rechercheService
	
    def resultat(String keywords) {
		// parsing de l'entrée
		List<String> listeMots = keywords.split()
		def resultatsRecherche = [:]
		def dechets = []
		println listeMots
		// TODO choix des objets où faire la recherche --> ajout des filtres		
		// faire une recherche par mot trouvé
		listeMots.each {String motCle ->
			dechets += rechercheService.rechercherDechets(motCle)
		}
		dechets.each {Dechet dechet ->
			if (!resultatsRecherche.get(dechet.categorieUsuelle)){
				resultatsRecherche.put(dechet.categorieUsuelle, [])
			}
			resultatsRecherche.get(dechet.categorieUsuelle).add(dechet)
		}
		
		[keywords:listeMots, resultatsRecherche:resultatsRecherche]
	}
}
