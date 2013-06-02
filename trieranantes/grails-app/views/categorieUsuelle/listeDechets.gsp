<meta name="layout" content="mainTri">

<div id="searchresults">
<h1>Catégorie usuelle : <span class="keywords">${categorieUsuelle.nom}</span></h1>


<g:each var="dechet" in="${listeDechets}"> 
		<div class="result">
			<div class="picto"><r:img uri="${dechet.image}"/></div>
			<div class="item">
				<div class="intro">
						<h2><g:link controller="Dechet" action="detail" id="${dechet.id}">${dechet.nom}</g:link></h2>
				</div>
				<div class="plus">
				<ul>
					<li>${dechet.description}</li>
				</ul>
				</div>
			</div>
			<div class="picto_recyclable_${dechet.estRecyclable}"></div>
			<div class="spacer"></div>
		</div>
</g:each>
