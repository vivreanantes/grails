<meta name="layout" content="mainTri">

<div id="searchresults">
<h1>Résultats de recherche</h1>
<h6>Mots recherchés : <span class="keywords">${keywords}</span></h6>


<g:each var="element" in="${mapDechetsParCategorie}">   
	<div class="categorie"><g:link controller="CategorieUsuelle" action="listeDechets" id="${element.key.id}">${element.key.nom}</g:link></div>
	<g:each var="dechet" in="${element.value}"> 
		<div class="result">
			<div class="picto"><r:img uri="${dechet.image}"/></div>
			<div class="item">
				<div class="intro">
						<h2><g:link controller="Dechet" action="detail" id="${dechet.id}">${dechet.nom}</g:link></h2>
				</div>
			</div>
			<div class="picto_recyclable_${dechet.estRecyclable}"></div>
			<div class="spacer"></div>
		</div>
	</g:each>
</g:each>

	<g:each var="dechet" in="${resultatsRechercheDechets}">
	
	</g:each>
</div>