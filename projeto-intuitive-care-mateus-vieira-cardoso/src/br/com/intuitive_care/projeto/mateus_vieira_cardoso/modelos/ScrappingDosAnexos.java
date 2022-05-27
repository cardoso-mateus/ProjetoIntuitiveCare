package br.com.intuitive_care.projeto.mateus_vieira_cardoso.modelos;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * Classe utilizada para criação de métodos que possibilitem realizar o download
 * dos documentos indicados pelo teste e arquivar o conjunto em um mesmo arquivo
 * zip.
 * 
 * @author Mateus Vieira Cardoso
 * @version 1.0
 */
public class ScrappingDosAnexos {

	private String URL_DO_SITE = "https://www.gov.br/ans/pt-br/assuntos/consumidor/o-que-o-seu-plano-de-saude-deve-cobrir-1/o-que-e-o-rol-de-procedimentos-e-evento-em-saude";
	private String URL_ANEXO_I;
	private String URL_ANEXO_II;
	private String URL_ANEXO_III;
	private String URL_ANEXO_IV;
	private String TITULO_ANEXO_I;
	private String TITULO_ANEXO_II;
	private String TITULO_ANEXO_III;
	private String TITULO_ANEXO_IV;

	public void scrapingDosUrls() throws IOException {
		Document doc = Jsoup.connect(URL_DO_SITE).get();
		List<Element> listaDeElementos = doc.getElementsByClass("callout");

		Element anexo1NaLista = listaDeElementos.get(3);
		Element anexo2NaLista = listaDeElementos.get(5);
		Element anexo3NaLista = listaDeElementos.get(6);
		Element anexo4NaLista = listaDeElementos.get(7);

		atribuindoAosCampos(anexo1NaLista, anexo2NaLista, anexo3NaLista, anexo4NaLista);
	}

	public void baixarAnexos() throws Throwable {
		baixarAnexo1();
		baixarAnexo2();
		baixarAnexo3();
		baixarAnexo4();
	}

	public void compactadorDeAnexos() throws Throwable {
		Map<String, String> env = new HashMap<>();
		env.put("create", "true");
		Path zipfile = Paths.get("ListaDeAnexos.zip");
		try (FileSystem fs = FileSystems.newFileSystem(zipfile, env, null)) {
			compactandoAnexo1(fs);
			compactandoAnexo2(fs);
			compactandoAnexo3(fs);
			compactandoAnexo4(fs);
		}
	}

	private void atribuindoAosCampos(Element anexo1NaLista, Element anexo2NaLista, Element anexo3NaLista, Element anexo4NaLista) {
		this.URL_ANEXO_I = anexo1NaLista.select("a").attr("href");
		this.URL_ANEXO_II = anexo2NaLista.select("a").attr("href");
		this.URL_ANEXO_III = anexo3NaLista.select("a").attr("href");
		this.URL_ANEXO_IV = anexo4NaLista.select("a").attr("href");

		this.TITULO_ANEXO_I = anexo1NaLista.select("a").text().replace("(", "").replace(")", "").replace(" ", "");
		this.TITULO_ANEXO_II = anexo2NaLista.select("a").text().replace("(", "").replace(")", "").replace(" ", "");
		this.TITULO_ANEXO_III = anexo3NaLista.select("a").text().replace("(", "").replace(")", "").replace(" ", "");
		this.TITULO_ANEXO_IV = anexo4NaLista.select("a").text().replace("(", "").replace(")", "").replace(" ", "");
	}

	private void baixarAnexo4() throws IOException {
		URL url = new URL(URL_ANEXO_IV);
		InputStream in = url.openStream();
		Files.copy(in, Paths.get(TITULO_ANEXO_IV), StandardCopyOption.REPLACE_EXISTING);
		in.close();
	}

	private void baixarAnexo3() throws IOException {
		URL url = new URL(URL_ANEXO_III);
		InputStream in = url.openStream();
		Files.copy(in, Paths.get(TITULO_ANEXO_III), StandardCopyOption.REPLACE_EXISTING);
		in.close();

	}

	private void baixarAnexo2() throws IOException {
		URL url = new URL(this.URL_ANEXO_II);
		InputStream in = url.openStream();
		Files.copy(in, Paths.get(TITULO_ANEXO_II), StandardCopyOption.REPLACE_EXISTING);
		in.close();
	}

	private void baixarAnexo1() throws IOException {
		URL url = new URL(this.URL_ANEXO_I);
		InputStream in = url.openStream();
		Files.copy(in, Paths.get(TITULO_ANEXO_I), StandardCopyOption.REPLACE_EXISTING);
		in.close();
	}

	private void compactandoAnexo4(FileSystem fs) throws IOException {
		Path externalTxtFile = Paths.get(TITULO_ANEXO_IV);
		Path pathInZipfile = fs.getPath("/" + TITULO_ANEXO_IV);
		Files.copy(externalTxtFile, pathInZipfile, StandardCopyOption.REPLACE_EXISTING);
		File f = new File(TITULO_ANEXO_IV);
		f.delete();
	}

	private void compactandoAnexo3(FileSystem fs) throws IOException {
		Path externalTxtFile = Paths.get(TITULO_ANEXO_III);
		Path pathInZipfile = fs.getPath("/" + TITULO_ANEXO_III);
		Files.copy(externalTxtFile, pathInZipfile, StandardCopyOption.REPLACE_EXISTING);
		File f = new File(TITULO_ANEXO_III);
		f.delete();
	}

	private void compactandoAnexo2(FileSystem fs) throws IOException {
		Path externalTxtFile = Paths.get(TITULO_ANEXO_II);
		Path pathInZipfile = fs.getPath("/" + TITULO_ANEXO_II);
		Files.copy(externalTxtFile, pathInZipfile, StandardCopyOption.REPLACE_EXISTING);
		File f = new File(TITULO_ANEXO_II);
		f.delete();
	}

	private void compactandoAnexo1(FileSystem fs) throws IOException {
		Path externalTxtFile = Paths.get(TITULO_ANEXO_I);
		Path pathInZipfile = fs.getPath("/" + TITULO_ANEXO_I);
		Files.copy(externalTxtFile, pathInZipfile, StandardCopyOption.REPLACE_EXISTING);
		File f = new File(TITULO_ANEXO_I);
		f.delete();
	}

}
