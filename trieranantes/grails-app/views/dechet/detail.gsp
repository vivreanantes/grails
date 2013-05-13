<meta name="layout" content="mainTri">

<!-- Template détail déchet  -->

<div id="detaildechet">	
<div class="categorie">
	<g:link controller="categorieUsuelle" action="listeDechets" id="${dechetInstance.categorieUsuelle.id}">${dechetInstance?.categorieUsuelle?.nom}</g:link>
</div>	
<div class="result">
	<div class="picto"><r:img uri="/images/content/dechets/thumb/bouteille_biere_petit2.png"/></div>
	<div class="item">
		<div class="intro">
				<h2>${dechetInstance?.nom}</h2>
				<div class="description">
					<p>${dechetInstance?.description}</p>
                    
                    <g:if test="${dechetInstance?.conseils?.size()>0}">
	                    <p><b>Conseils : </b></p>
						<ul>
		                    <g:each var="conseil" in="${dechetInstance?.conseils}">
		                    	<li>${conseil.libelle}</li>
		                    </g:each>
	                    </ul>
                    </g:if>    
				</div>				
		</div>
		<div class="plus">
		<ul>
		<g:if test="${modesCollecte.size()>0}"> 		
				<li>Modes de collecte : 
				<g:each var="modeCollecte" status="i" in="${modesCollecte}">
				    <a>${modeCollecte.libelle}</a>${ i != modesCollecte.size()-1 ? ',' : ''}
				</g:each>
				</li>		
		</g:if>
		</ul>

		</div>
	</div>
	<tri:estRecyclable isRecy="${dechetInstance?.estRecyclable}" />
	<div class="spacer" style="padding-bottom:1em"></div>
	<div class="infos"><div class="pointscollecte">Points de collecte</div>
	<!-- 
	
	<div class="pointcollecte"><r:img uri="/images/content/marker_bleu3.png"/> Conteneur à verre</div>
	<div class="pointcollecte"><r:img uri="/images/content/marker_vert.png"/> Décheterie</div>
	<div class="pointcollecte disabled"><r:img uri="/images/content/marker_orange.png"/> Autre point de collecte</div>
	-->
	
	</div>
	<!-- CONTAINER MAP -->
	<div id="map"></div>
       
    <script>
       	$(document).ready(function() {

       		vanmap=new VanMap();
       		vanmap.init();
       		vanmap.addPoint({
           		code : 'sdc_de', 
           		coord : { lat : 47.195778, lng : -1.505127 }, 
           		fulladress : 'rue de strasbourg 44200 nantes', 
           		customtext : 'Mardi au Samedi de 10h à  17h30 (sauf jours fériés)'});
       		
       		vanmap.addPoint({
           		code : 'sdc_de', 
           		coord : { lat : 47.195778, lng : -1.515127 }, 
           		fulladress : 'rue XXXX 44200 nantes', 
           		customtext : 'Mardi au Samedi de 10h à  17h30 (sauf jours fériés)'});
       		
       		vanmap.show();
           	
       	});
    </script>
    <div class="spacer"></div>
</div>
</div>