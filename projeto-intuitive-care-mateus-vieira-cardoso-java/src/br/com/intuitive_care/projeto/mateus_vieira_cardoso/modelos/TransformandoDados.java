package br.com.intuitive_care.projeto.mateus_vieira_cardoso.modelos;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;
import java.util.zip.ZipInputStream;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.fit.pdfdom.PDFDomTree;

/**
 * Classe com intuito de utilizar, a partir de um arquivo ZIP inserido no projeto pelo teste 1, métodos para extrair do ZIP o documento PDF descrito
 * pela solicitação do teste, copiar deste documento PDF as tabelas de todas as páginas e criar a partir dessa informação uma tabela estruturada CSV
 * e por fim arquivar essa tabela em um segundo arquivo ZIP e excluir arquivos de uso temporário.
 * 
 * @note Até o momento só foi possível realizar a extração das informação das tabelas, de três formas diferentes, um arquivo TXT com quebras de linhas
 * feitas de forma automática, um outro arquivo TXT feito em uma única linha e uma representação HTML de todo o PDF.
 * Ainda não foi possível transpor esses dados para um texto de forma estruturada para a construção da tabela CSV solicitada no teste.
 * 
 * @author Mateus Vieira Cardoso
 * @version 0.5
 */
public class TransformandoDados {

	private final static ScrapingDados scrap = new ScrapingDados();
	private static String TITULO_ANEXO_I;
	private static String TITULO_ARQUIVO_ZIP;

	/**
	 * Este método inicia os campos utilizados posteriormente, é feita uma composição com a classe modelo do teste 1 para facilitar uma possivel
	 * mudança ou inserção de qualquer informação.
	 * @throws IOException
	 */
	private static void iniciandoCampos() throws IOException {
		scrap.scrapingDosUrls();
		TITULO_ANEXO_I = scrap.getTITULO_ANEXO_I();
		TITULO_ARQUIVO_ZIP = scrap.getTITULO_ARQUIVO_ZIP();
	}

	/**
	 * Este método extrai, do arquivo ZIP gerado no teste 1, o Anexo I para em seguida serem copiados os dados das tabelas.
	 * @throws IOException
	 */
	public void descompactarAnexo1() throws IOException {
		iniciandoCampos();
		try (InputStream in = new FileInputStream(TITULO_ARQUIVO_ZIP)) {
			ZipInputStream zipfile = new ZipInputStream(in);
			zipfile.getNextEntry();
			Files.copy(zipfile, Paths.get(TITULO_ANEXO_I), StandardCopyOption.REPLACE_EXISTING);
		}
	}

	/**
	 * Este método copia, para um arquivo TXT, o texto das tabelas do documento PDF Anexo I para que seja feita a estruturação da tabela CSV.
	 * @throws IOException
	 */
	public void leitorDeTabelasTxt() throws IOException {
		PDDocument pdoc = Loader.loadPDF(new File(TITULO_ANEXO_I));
		PDFTextStripper stripper = new PDFTextStripper();
		stripper.setStartPage(3);
		String texto = stripper.getText(pdoc);
		pdoc.close();
		PrintWriter pw = new PrintWriter("testeTxt.txt", "utf-8");
		pw.print(texto);
	}
	
	/**
	 * Este método converte todo o documento PDF Anexo I em uma representação HTML para que seja copiado todo o corpo de texto das tabelas e transformado
	 * em uma tabela estruturada CSV.
	 * @throws IOException
	 */
	public void leitorDeTabelasHtml() throws IOException {
		PDDocument pdoc = Loader.loadPDF(new File(TITULO_ANEXO_I));
		Writer output = new PrintWriter("testeHtml.html", "utf-8");
		new PDFDomTree().writeText(pdoc, output);
		output.close();
	}
	
	/**
	 * Este método transforma o arquivo TXT criado pelo método leitorDeTabelasTXT em uma string única a fim de facilitar a estruturação dos dados.
	 * @throws IOException
	 */
	public void transformarTabela() throws IOException {
		Scanner scanner = new Scanner(new File("testeTxt.txt"), "utf-8");
		String line = scanner.nextLine();
		PrintStream ps = new PrintStream("testeTxtLinhaUnica.txt", "utf-8");
		while(scanner.hasNextLine()) {
			ps.print(line);
			line = scanner.nextLine();
		}
		ps.close();
		scanner.close();
	}
}