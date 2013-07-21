package com.van.trieranantes.common

import com.van.trieranantes.dechet.CategorieUsuelle;
import com.van.trieranantes.dechet.Dechet;

class RechercheController {

	def rechercheService
	
    def resultat(String keywords) {
		List<Dechet> resultatsRechercheDechets = rechercheService.rechercherIndexDechets(keywords)
		Map<CategorieUsuelle, List> mapDechetsParCategorie = [:]
		// tri des déchets par catégorie de déchet
		resultatsRechercheDechets.each{Dechet dechet ->
			CategorieUsuelle categorieUsuelle = dechet.categorieUsuelle
			if (!mapDechetsParCategorie.containsKey(categorieUsuelle)){
				mapDechetsParCategorie.put(categorieUsuelle, [])
			}
			mapDechetsParCategorie.get(categorieUsuelle).add(dechet)
		}
		
		[keywords:keywords, mapDechetsParCategorie:mapDechetsParCategorie]
	}
}
