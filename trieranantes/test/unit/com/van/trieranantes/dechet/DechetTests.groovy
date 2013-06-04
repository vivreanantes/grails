package com.van.trieranantes.dechet



import grails.test.mixin.*

import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Dechet)
@Mock([CategorieUsuelle, CategorieTraitement])
class DechetTests {

	void testCreerDechet(){
		Dechet dechet = get1Dechet()
		CategorieTraitement categorieTraitement = CategorieTraitementTests.get1CategorieTraitement()
		CategorieUsuelle categorieUsuelle = CategorieUsuelleTests.get1CategorieUsuelle()
		dechet.categorieTraitement = categorieTraitement
		dechet.categorieUsuelle = categorieUsuelle
		dechet.validate()
		
		assert dechet.save()
		assert dechet.indexDechet
		assert dechet.indexDechet.description == "un dechet avec des accents eeeeeeaaa&a&&&e'(-e_ca'"
	}
	
    static Dechet get1Dechet() {
		
		Dechet dechet = new Dechet(
		   code:"code1",
		   nom:"brosse à dents",
		   description:"un déchet avec des accents éééèèèààà&à&&&é'(-è_çà'",
		   estVerifie:true,
		   estRecyclable:true,
		   image:"image"
		   )
		return dechet
    }
}
