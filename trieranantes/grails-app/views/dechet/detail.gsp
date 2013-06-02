<meta name="layout" content="mainTri">

<!-- Template détail déchet  -->

<div id="detaildechet">	
<div class="categorie">
	<g:link controller="categorieUsuelle" action="listeDechets" id="${dechetInstance.categorieUsuelle.id}">${dechetInstance?.categorieUsuelle?.nom}</g:link>
</div>	
<div class="result">
	<div class="picto"><r:img uri="/images/content/dechets/${dechetInstance.image}"/></div>
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
	
	<g:if test="${modesCollecte.size()>0}">
		<g:each var="modeCollecte" status="i" in="${modesCollecte}">
				  <button class="btn btn-block btn-primary" type="button" onclick="Javascript:vanmap.toggleType('${modeCollecte.code}');jQuery(this).toggleClass('btn-primary');">${modeCollecte.libelle}</button>
		</g:each>	
	</g:if>
	
	</div>
	<!-- CONTAINER MAP -->
	<div id="map"></div>
       
    <script>
       	$(document).ready(function() {

       		vanmap=new VanMap();
       		vanmap.init();

       		<g:if test="${structuresCollecte.size()>0}">
				//Pour chaque mode de collecte
       			<g:each var="structureCollecte" status="i" in="${structuresCollecte}">

       				//Pour chaque structure
	       			<g:each var="structure" in="${structureCollecte.structuresCollecte}">
	       			
	       			coord={ lat : ${structure.adresse.lat} ,  lng : ${structure.adresse.lng} }
	       				
	       			vanmap.addPoint({
	               		type : '${structureCollecte.modeCollecte.code}', 
	               		coord : coord, 
	               		fulladress : "${structure.adresse.adresse1} " + "${structure.adresse.codePostal} " + "${structure.adresse.ville}", 
	               		customtext : "<b>${structure.libelle}</b>"});		
	       			
					</g:each>
       			
				</g:each>	
    			
    		</g:if>
       		
       		
       		vanmap.show();	
           	
       	});
    </script>
    <div class="spacer"></div>
</div>
</div>