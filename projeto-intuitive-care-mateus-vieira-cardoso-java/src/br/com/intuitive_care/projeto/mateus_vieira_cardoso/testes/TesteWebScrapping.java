package br.com.intuitive_care.projeto.mateus_vieira_cardoso.testes;

import br.com.intuitive_care.projeto.mateus_vieira_cardoso.modelos.ScrapingDados;

public class TesteWebScrapping {

	public static void main(String[] args) throws Throwable {
		
		ScrapingDados scrap = new ScrapingDados();
		scrap.scrapingDosUrls();
	}

}
