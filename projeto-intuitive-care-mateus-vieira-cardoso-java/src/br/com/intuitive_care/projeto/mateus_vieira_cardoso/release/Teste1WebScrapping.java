package br.com.intuitive_care.projeto.mateus_vieira_cardoso.release;

import br.com.intuitive_care.projeto.mateus_vieira_cardoso.modelos.ScrapingDados;

public class Teste1WebScrapping {

	public static void main(String[] args) throws Throwable {
		
		ScrapingDados scrap = new ScrapingDados();
		scrap.scrapingDosUrls();
		scrap.baixarAnexos();
		scrap.compactadorDeAnexos();
	}
}
