package com.van.trieranantes.dechet



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(CategorieUsuelle)
class CategorieUsuelleTests {

    static CategorieUsuelle get1CategorieUsuelle(){
		CategorieUsuelle categorie = new CategorieUsuelle(
			code:"0002",
			nom:"nom cat",
			description:"une description",
			estSousCategorie:false
		)
	}
}
