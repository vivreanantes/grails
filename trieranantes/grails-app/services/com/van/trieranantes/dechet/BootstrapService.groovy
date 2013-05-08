package com.van.trieranantes.dechet

class BootstrapService {

    def initDonneesDeveloppement() {
		log.debug ">initDonneesDeveloppement"
		creerCollecte()
		log.debug "<initDonneesDeveloppement"
    }
	
	public creerCollecte(){
		log.debug ">creerCollecte"
		
		/* CATEGORIES */
		
		CategorieUsuelle catUsuelle1 = new CategorieUsuelle(code:"catUsuelle1", nom:"Verre / Vaisselle / Pots", estSousCategorieUsuelle:false)
		catUsuelle1.save()
		
		CategorieTraitement cat1 = new CategorieTraitement(code:"cat1", libelle:"Verre", description:"du verre")
		cat1.save()
		
		
		/* DECHETS */
		
		Dechet dechet1 = new Dechet(code:"dechet1", nom:"Bouteille en verre", 
			description:"Description du déchet", categorieTraitement:cat1,
			categorieUsuelle:catUsuelle1)
		
		
		Dechet dechet2 = new Dechet(code:"dechet2", nom:"Bocal en verre",
			description:"Description du déchet", categorieTraitement:cat1,
			categorieUsuelle:catUsuelle1)
		
		dechet1.save()
		dechet2.save()
		
		log.debug "<creerCollecte"
	}
}
