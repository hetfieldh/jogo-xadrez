package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;
import xadrez.XadrezException;

public class Xadrez {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		PartidaXadrez partidaXadrez = new PartidaXadrez();
		List<PecaXadrez> capturado = new ArrayList<>();

		while (!partidaXadrez.getCheckMate()) {
			
			try {
				UI.clearScreen();
				UI.criarPartida(partidaXadrez, capturado);
				System.out.println();
				System.out.print("Origem: ");
				PosicaoXadrez origem = UI.lerPosicaoXadrez(sc);
				
				boolean [][] movimentosPossiveis = partidaXadrez.movimentosPossiveis(origem);
				UI.clearScreen();
				UI.criaTabuleiro(partidaXadrez.getPecas(), movimentosPossiveis);
				
				System.out.println();
				System.out.print("Destino: ");
				PosicaoXadrez destino = UI.lerPosicaoXadrez(sc);
				
				PecaXadrez pecaCapturada = partidaXadrez.performarMovimentacaoPeca(origem, destino);
				
				if (pecaCapturada != null) {
					capturado.add(pecaCapturada);
				}
				
				if (partidaXadrez.getPecaPromovida() != null) {
					System.out.print("Informe a peca para promocao (B/C/T/R): ");
					String tipoPeca = sc.nextLine();
					partidaXadrez.substituirPecaPromovida(tipoPeca);
				}
			
			} catch (XadrezException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
		UI.clearScreen();
		UI.criarPartida(partidaXadrez, capturado);
	}
}
