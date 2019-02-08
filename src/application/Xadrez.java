package application;

import java.util.Scanner;

import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;

public class Xadrez {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		PartidaXadrez partidaXadrez = new PartidaXadrez();

		while (true) {
			UI.criaTabuleiro(partidaXadrez.getPecas());
			System.out.println();
			System.out.print("Origem: ");
			PosicaoXadrez origem = UI.lerPosicaoXadrez(sc);
			
			System.out.print("Destino: ");
			PosicaoXadrez destino = UI.lerPosicaoXadrez(sc);
			
			PecaXadrez pecaCapturada = partidaXadrez.performarMovimentacaoPeca(origem, destino);
		}
	}
}
