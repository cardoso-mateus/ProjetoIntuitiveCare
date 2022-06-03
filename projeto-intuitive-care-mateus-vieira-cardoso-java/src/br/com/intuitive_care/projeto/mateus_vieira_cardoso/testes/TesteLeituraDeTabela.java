package br.com.intuitive_care.projeto.mateus_vieira_cardoso.testes;

import java.io.IOException;

import br.com.intuitive_care.projeto.mateus_vieira_cardoso.modelos.TransformandoDados;

public class TesteLeituraDeTabela {

	public static void main(String[] args) throws IOException {

		TransformandoDados tf = new TransformandoDados();
		tf.descompactarAnexo1();
		tf.leitorDeTabelasTxt();
		tf.leitorDeTabelasHtml();
	}
}