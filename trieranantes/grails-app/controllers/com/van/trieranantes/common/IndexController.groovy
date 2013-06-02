package com.van.trieranantes.common

import com.van.trieranantes.dechet.CategorieUsuelle;

class IndexController {

    def index() { 
		
		List<CategorieUsuelle> categoriesUsuelles = CategorieUsuelle.findAllWhere(estSousCategorie: false)
		[categoriesUsuelles: categoriesUsuelles]
		
	}
}
