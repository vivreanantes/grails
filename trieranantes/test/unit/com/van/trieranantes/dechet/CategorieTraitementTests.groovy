package com.van.trieranantes.dechet



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(CategorieTraitement)
class CategorieTraitementTests {

    static CategorieTraitement get1CategorieTraitement(){
		CategorieTraitement categorie = new CategorieTraitement(
			code:"001",
			libelle:"un libellé",
			description:"une descripption"
		)
	}
}
