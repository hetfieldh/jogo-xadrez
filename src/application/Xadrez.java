package application;

import xadrez.PartidaXadrez;

public class Xadrez {

	public static void main(String[] args) {
		
		PartidaXadrez partidaXadrez = new PartidaXadrez();
		UI.criaTabuleiro(partidaXadrez.getPecas());

	}

}
