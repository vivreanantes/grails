package com.van.trieranantes.dechet
import com.van.trieranantes.geolocalisation.Adresse


class BootstrapService {

    def initDonneesDeveloppement() {
		log.debug ">initDonneesDeveloppement"
		creerCollecte()
		log.debug "<initDonneesDeveloppement"
    }
	
	public creerCollecte() {
		log.debug ">creerCollecte"
		
		/* SOUS CATEGORIES */
		
		CategorieUsuelle sub_catUsuelle1 = new CategorieUsuelle(code:"scu_toxiquejardin", nom:"Déchets toxiques du jardinage", estSousCategorie:true)
		sub_catUsuelle1.save()
		
		CategorieUsuelle sub_catUsuelle2 = new CategorieUsuelle(code:"scu_toxiquegarage", nom:"Déchets toxiques du garage", estSousCategorie:true)
		sub_catUsuelle2.save()	
		
		/* CATEGORIES USUELLES */
		
		CategorieUsuelle catUsuelle1 = new CategorieUsuelle(code:"cu_verrevaisselle", nom:"Verre / Vaisselle / Pots", estSousCategorie:false)
		catUsuelle1.save()
		
		CategorieUsuelle catUsuelle2 = new CategorieUsuelle(code:"cu_toxique", nom:"Toxique", estSousCategorie:false)
		catUsuelle2.addToSousCategories(sub_catUsuelle1)
		catUsuelle2.addToSousCategories(sub_catUsuelle2)
		catUsuelle2.save()
		
		CategorieUsuelle catUsuelle3 = new CategorieUsuelle(code:"cu_metal", nom:"Métal", estSousCategorie:false)
		catUsuelle3.save()
		
		CategorieUsuelle catUsuelle4 = new CategorieUsuelle(code:"cu_papierscartons", nom:"Papier / Carton", estSousCategorie:false)
		catUsuelle4.save()
		
		CategorieUsuelle catUsuelle5 = new CategorieUsuelle(code:"cu_plastique", nom:"Plastique", estSousCategorie:false)
		catUsuelle5.save()
		
		CategorieUsuelle catUsuelle6 = new CategorieUsuelle(code:"cu_electronique", nom:"Electronique", estSousCategorie:false)
		catUsuelle6.save()
		
		/* STRUCTURES DE COLLECTE */
		
		Adresse addr1= new Adresse(adresse1 : "Rue Vulcain" , codePostal : '44000', ville : 'nantes', lat : 47.225681, lng : -1.504923)
		addr1.save()
		
		StructureCollecte structure1 = new StructureCollecte(code : "struct1", libelle : "", description : "", adresse : addr1)
		structure1.save()
		
		/* MODES DE COLLECTE */
		
		ModeCollecte modecollecte1=new ModeCollecte(code:"modco_contverre", libelle:"Conteneur verre", description:"Aussi appelée \"container verre\" (on parle aussi de \"colonne verre\")")
		modecollecte1.save()
		
		ModeCollecte modecollecte2=new ModeCollecte(code:"modco_decheterie", libelle:"Décheterie", description:"Les déchetteries nantaises.")
		//modecollecte2.addToStructuresCollecte(structure1)
		modecollecte2.save()
		
		/* CATEGORIES TRAITEMENT */
		
		CategorieTraitement cat1 = new CategorieTraitement(code:"cat_verre", libelle:"Verre", description:"")
		cat1.addToModesCollecte(modecollecte1)
		cat1.addToModesCollecte(modecollecte2)
		cat1.save()
		
		CategorieTraitement cat2 = new CategorieTraitement(code:"cat_papiercarton", libelle:"Papier / Cartons", description:"")
		cat2.save()
		
		CategorieTraitement cat3 = new CategorieTraitement(code:"cat_omr", libelle:"Ordures Ménagères Résiduelles (OMR)", description:"Il s’agit des déchets non  dangereux et qui ne sont pas recyclables qui rentrent facilement dans mon bac et qui ne sont pas issus d’activités spécifiques")
		cat3.save()
		
		CategorieTraitement cat4 = new CategorieTraitement(code:"cat_ddm", libelle:"Les déchets dangereux des ménages (DDM)", description:"Ces déchets, produits en petites quantités par les ménages, présentent un risque pour l’environnement et les personnes (toxiques, inflammables…) et sont essentiellement des : peintures, vernis, colles, tubes fluorescents, diluants, solvants, acides, bases, radiographies, piles, aérosols, produits d’entretien…")
		cat4.save()
		
		CategorieTraitement cat5 = new CategorieTraitement(code:"cat_d3e", libelle:"Déchets d'équipement électrique et électronique (D3E)", description:"La collecte des D3E concerne le gros et petit électroménager, le matériel audiovisuel, informatique. Elle fonctionne grâce à l'apport volontaire des habitants de Nantes Métropole et permet de recycler nos appareils usagés.")
		cat5.save()
		
		CategorieTraitement cat6 = new CategorieTraitement(code:"cat_acier", libelle:"Acier", description:"")
		cat6.save()
		
		
		/* DECHETS */
		
		Dechet dechet1 = new Dechet(code:"dechet1", nom:"Bouteille en verre", 
			description:"Description bouteille en verre", categorieTraitement:cat1,
			categorieUsuelle:catUsuelle1)		
		
		Dechet dechet2 = new Dechet(code:"dechet2", nom:"Bocal en verre",
			description:"Description bocal en verre", categorieTraitement:cat1,
			categorieUsuelle:catUsuelle1)
		
		Dechet dechet3 = new Dechet(code:"dechet3", nom:"Baril de lessive",
			description:"paquets de lessives, barils en carton", categorieUsuelle:catUsuelle4, categorieTraitement:cat2)
		
		Dechet dechet4 = new Dechet(code:"dechet4", nom:"Antigel",
			description:"", categorieUsuelle:catUsuelle2, categorieTraitement:cat4)
		
		Dechet dechet5 = new Dechet(code:"dechet5", nom:"Appareil électronique",
			description:"", categorieUsuelle:catUsuelle6, categorieTraitement:cat5)
		
		Dechet dechet5a = new Dechet(code:"dechet5a", nom:"Petit électroménager",
			description:"", categorieUsuelle:catUsuelle6, categorieTraitement:cat5)
		
		Dechet dechet6 = new Dechet(code:"dechet6", nom:"Barquette plastique",
			description:"", categorieUsuelle:catUsuelle5, categorieTraitement:cat3)
		
		Dechet dechet6a = new Dechet(code:"dechet6a", nom:"Bouteille de lait",
			description:"", categorieUsuelle:catUsuelle5, categorieTraitement:cat3)	
		
		Dechet dechet7 = new Dechet(code:"dechet7", nom:"Boîte de conserve",
			description:"", categorieUsuelle:catUsuelle3, categorieTraitement:cat6)
		
		Dechet dechet8 = new Dechet(code:"dechet8", nom:"Carton (petits ou grands)",
			description:"", categorieUsuelle:catUsuelle4, categorieTraitement:cat2)
		
		Dechet dechet9 = new Dechet(code:"dechet9", nom:"Engrais chimiques",
			description:"", categorieUsuelle:sub_catUsuelle1, categorieTraitement:cat4)
		
		
		dechet1.save()
		dechet2.save()
		dechet3.save()
		dechet4.save()
		dechet5.save()
		dechet5a.save()
		dechet6.save()
		dechet6a.save()
		dechet7.save()
		dechet8.save()
		dechet9.save()

		log.debug "<creerCollecte"
	}
}
