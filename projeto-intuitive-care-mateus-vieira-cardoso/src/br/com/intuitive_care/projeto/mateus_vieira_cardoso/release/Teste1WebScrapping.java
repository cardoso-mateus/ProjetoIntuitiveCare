package br.com.intuitive_care.projeto.mateus_vieira_cardoso.release;

import br.com.intuitive_care.projeto.mateus_vieira_cardoso.modelos.ScrappingDosAnexos;

public class Teste1WebScrapping {

	public static void main(String[] args) throws Throwable {
		
		ScrappingDosAnexos scrap = new ScrappingDosAnexos();
		scrap.scrapingDosUrls();
		scrap.baixarAnexos();
		scrap.compactadorDeAnexos();
	}

}
