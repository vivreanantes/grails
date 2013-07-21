<meta name="layout" content="mainTri">
<div class="frontpage">
<div style="font-size: 2em;margin-bottom:0.8em"><i><b style="color:#639E1E">Mieux trier à Nantes</b></i> <span style="font-size: 0.8em;">aide les Nantais à :</span></div>

<p>
<ul style="width:80%;padding-left: 1.5em;margin:1em 0em">
<li>Savoir si un déchet est recyclable et comment il peut être valorisé</li>
<li>Connaître les emplacements des conteneurs, lieux et horaires des décheteries et distribution des sacs jaunes et bleus</li>
<li>Connaître la filière tri à Nantes : centres de tris, centres d'incinération, nouveaux déchets récupérés, et les organismes qui se proposent de donner une seconde vie à vos déchets</li>
<li>Retrouver le mode de collecte et le jour de collecte à domicile, en recherchant par rue ou à partir de votre position</li>
</ul>
</p>

<h3>Accès rapide</h3>

<g:each var="categorieUsuelle" in="${categoriesUsuelles}"> 
		<div class="categorie">		
			<g:link controller="CategorieUsuelle" action="listeDechets" id="${categorieUsuelle.id}">${categorieUsuelle.nom}</g:link>		
		</div>
</g:each>
</div>

<p style="clear:both">
<h3>Téléchargez l'application pour mobile : </h3><br>
<a style="font-size: 1.2em;text-decoration: none">> </a><a style="font-size: 1.1em;">Android</a><br/>
<a style="font-size: 1.2em;text-decoration: none">> </a><a style="font-size: 1.1em;">iPhone </a><br/>
</p>