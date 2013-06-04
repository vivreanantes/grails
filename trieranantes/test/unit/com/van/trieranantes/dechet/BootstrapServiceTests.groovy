package com.van.trieranantes.dechet



import grails.test.mixin.*

import org.junit.*

import com.van.trieranantes.geolocalisation.Adresse

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(BootstrapService)
@Mock([CategorieUsuelle,  CategorieTraitement, Dechet, ModeCollecte, Adresse, StructureCollecte])
class BootstrapServiceTests {

	@Test
	void testCreerCategorieUsuelle(){
		service.creerCollecte()
		assert CategorieUsuelle.count == 1
	}
	
	@Test
	void testCreerCategorieTraitement(){
		service.creerCollecte()
		assert CategorieTraitement.count == 1
	}
	
	@Test
    void testCreerDechets(){
        service.creerCollecte()
		assert Dechet.count == 2
    }
}
