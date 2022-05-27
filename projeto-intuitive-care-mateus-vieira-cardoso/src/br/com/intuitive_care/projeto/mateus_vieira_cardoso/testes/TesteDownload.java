package br.com.intuitive_care.projeto.mateus_vieira_cardoso.testes;

import br.com.intuitive_care.projeto.mateus_vieira_cardoso.modelos.ScrappingDosAnexos;

public class TesteDownload {

	public static void main(String[] args) throws Throwable {
		
		ScrappingDosAnexos scrap = new ScrappingDosAnexos();
		scrap.scrapingDosUrls();
		scrap.baixarAnexos();
	}

}
