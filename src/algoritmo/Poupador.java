package algoritmo;

import java.util.Arrays;

public class Poupador extends ProgramaPoupador {
	
	int[][] mapaPassos = new int[30][30];
	int[][] mapaValores = new int[30][30];
	
	public int acao() {
		
		System.out.println("getX - " + sensor.getPosicao().getX());
		System.out.println("getY - " + sensor.getPosicao().getY());
		
		float[] peso_campos = new float[24];
		
		float[] soma_peso = new float[4];
		
		String saida = "";
		String saida1 = "";

		int cordx = (int) sensor.getPosicao().getX();
		int cordy = (int) sensor.getPosicao().getY();
		
		System.out.println("Cordx: " + cordx);
		System.out.println("Cordy: " + cordy);
		
		mapaPassos[cordy][cordx] = mapaPassos[cordy][cordx] + 1;
		
		mapaValores[cordy][cordx] = 0;
		mapaValores[cordy - 2][cordx - 2] = sensor.getVisaoIdentificacao()[0];
		mapaValores[cordy - 2][cordx - 1] = sensor.getVisaoIdentificacao()[1];
		mapaValores[cordy - 2][cordx] = sensor.getVisaoIdentificacao()[2];
		mapaValores[cordy - 2][cordx + 1] = sensor.getVisaoIdentificacao()[3];
		mapaValores[cordy - 2][cordx + 2] = sensor.getVisaoIdentificacao()[4];
		mapaValores[cordy - 1][cordx - 2] = sensor.getVisaoIdentificacao()[5];
		mapaValores[cordy - 1][cordx - 1] = sensor.getVisaoIdentificacao()[6];
		mapaValores[cordy - 1][cordx] = sensor.getVisaoIdentificacao()[7];
		mapaValores[cordy - 1][cordx + 1] = sensor.getVisaoIdentificacao()[8];
		mapaValores[cordy - 1][cordx + 2] = sensor.getVisaoIdentificacao()[9];
		mapaValores[cordy][cordx - 2] = sensor.getVisaoIdentificacao()[10];
		mapaValores[cordy][cordx - 1] = sensor.getVisaoIdentificacao()[11];
		mapaValores[cordy][cordx + 1] = sensor.getVisaoIdentificacao()[12];
		mapaValores[cordy][cordx + 2] = sensor.getVisaoIdentificacao()[13];
		mapaValores[cordy + 1][cordx - 2] = sensor.getVisaoIdentificacao()[14];
		mapaValores[cordy + 1][cordx - 1] = sensor.getVisaoIdentificacao()[15];
		mapaValores[cordy + 1][cordx] = sensor.getVisaoIdentificacao()[16];
		mapaValores[cordy + 1][cordx + 1] = sensor.getVisaoIdentificacao()[17];
		mapaValores[cordy + 1][cordx + 2] = sensor.getVisaoIdentificacao()[18];
		mapaValores[cordy + 2][cordx - 2] = sensor.getVisaoIdentificacao()[19];
		mapaValores[cordy + 2][cordx - 1] = sensor.getVisaoIdentificacao()[20];
		mapaValores[cordy + 2][cordx] = sensor.getVisaoIdentificacao()[21];
		mapaValores[cordy + 2][cordx + 1] = sensor.getVisaoIdentificacao()[22];
		mapaValores[cordy + 2][cordx + 2] = sensor.getVisaoIdentificacao()[23];
		
		for (int l = 0; l < mapaPassos.length; l++) {
			for (int c = 0; c < mapaPassos[0].length; c++) {
				saida = saida + mapaPassos[l][c] + " "; // imprime caracter a caracter
			}
			saida = saida + "\n"; // muda de linha
		}
		System.out.println(saida);
		
		for (int l = 0; l < mapaValores.length; l++) {
			for (int c = 0; c < mapaValores[0].length; c++) {
				saida1 = saida1 + mapaValores[l][c] + " "; // imprime caracter a caracter
			}
			saida1 = saida1 + "\n"; // muda de linha
		}
		System.out.println(saida1);
		
		
//		
//		for (int l = 0; l < 30; l++) {
//			
//			for (int c = 0; c < 30; c++) {
//				if (l == cordx && c == cordy) {
//					quadradosDoCampo[l][c] = 1;
//				}
//				saida = saida + quadradosDoCampo[l][c] + ","; // imprime caracter a caracter
//			}
//			saida = saida + "\n"; // muda de linha
//		}
//		System.out.println(saida);

//		return (int) (Math.random() * 5);
		
		for(int i = 0; i < 24; i++ ) {
			// Parede
			if(sensor.getVisaoIdentificacao()[i] == -2 || 
				sensor.getVisaoIdentificacao()[i] == -1 || 
				sensor.getVisaoIdentificacao()[i] == 1) {
				peso_campos[i] = 200.0f;
			}
			// Celula vazia
			if(sensor.getVisaoIdentificacao()[i] == 0) {
				peso_campos[i] = 30.0f;
			}
			// Ladrao
			if(sensor.getVisaoIdentificacao()[i] == 200) {
				peso_campos[i] = sensor.getNumeroDeMoedas() * 50;
				
			}
			// Banco
			if(sensor.getVisaoIdentificacao()[i] == 3) {
				peso_campos[i] = 70 / (1 + sensor.getNumeroDeMoedas());
			}
			// Moeda
			if(sensor.getVisaoIdentificacao()[i] == 4) {
				peso_campos[i] = 1.0f;
			}
			// Pastilha de poder
			if(sensor.getVisaoIdentificacao()[i] == 5) {
				peso_campos[i] = 100 / (1 + sensor.getNumeroDeMoedas());
			}
			// Poupador
			if(sensor.getVisaoIdentificacao()[i] == 100) {
				peso_campos[i] = 100.0f;
			}
				
		}
		
		soma_peso[0] = peso_campos[0] + peso_campos[1] + peso_campos[2] + peso_campos[3] + peso_campos[4] + peso_campos[5] + peso_campos[6] + peso_campos[7] + peso_campos[8] + peso_campos[9];
		soma_peso[1] = peso_campos[14] + peso_campos[15] + peso_campos[16] + peso_campos[17] + peso_campos[18] + peso_campos[19] + peso_campos[20] + peso_campos[21] + peso_campos[22] + peso_campos[23];
		soma_peso[2] = peso_campos[3] + peso_campos[4] + peso_campos[8] + peso_campos[9] + peso_campos[12] + peso_campos[13] + peso_campos[17] + peso_campos[18] + peso_campos[22] + peso_campos[23];
		soma_peso[3] = peso_campos[0] + peso_campos[1] + peso_campos[5] + peso_campos[6] + peso_campos[10] + peso_campos[11] + peso_campos[14] + peso_campos[15] + peso_campos[19] + peso_campos[20];
		
		float[] soma_peso_ordenado = new float[4];
		int[] index = new int[4];
		float soma_total = 0;

		for(int i = 0; i < 4; i++) {
			soma_peso_ordenado[i] = soma_peso[i];
			soma_total = soma_total + soma_peso[i];
		}
		
		Arrays.sort(soma_peso_ordenado);
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				if(soma_peso_ordenado[i] == soma_peso[j]) {
					index[i] = j;
				}
			}
		}
		
		double a = Math.random();
		
		
		System.out.println("Aleatorio: "+ a);
		System.out.println("Soma total: " + soma_total);
		System.out.println("indice 0: " + soma_peso_ordenado[0]);
		System.out.println("indice 1: " + soma_peso_ordenado[1]);
		System.out.println("indice 2: " + soma_peso_ordenado[2]);
		System.out.println("indice 3: " + soma_peso_ordenado[3]);
		
		double soma3 = soma_peso_ordenado[3] + soma_peso_ordenado[2] + soma_peso_ordenado[1];
		double soma2 = soma_peso_ordenado[2] + soma_peso_ordenado[1];
		
	
	
		if(a > (soma3) / soma_total) {
			double soma = (soma_peso_ordenado[3] + soma_peso_ordenado[2] + soma_peso_ordenado[1]) / soma_total;
			System.out.println("Soma3: " + soma3);
			System.out.println("Direção: " + (index[3] + 1));
			return index[3] + 1;
		} 
		else if(a > (soma2) / soma_total) {
			double soma = (soma_peso_ordenado[2] + soma_peso_ordenado[1]) / soma_total;
			System.out.println("Soma2: " + soma2);
			System.out.println("Direção: " + (index[2] + 1));
			return index[2] + 1;
		}
		else if(a > soma_peso_ordenado[1] / soma_total) {
			double soma = (soma_peso_ordenado[1]) / soma_total;
			System.out.println("Soma1: " + soma);
			System.out.println("Direção: " + (index[1] + 1));
			return index[1] + 1;
		}
		else {
			double soma = (soma_peso_ordenado[0]) / soma_total;
			System.out.println("Soma0: " + soma);
			System.out.println("Direção: " + (index[0] + 1));
			return index[0] + 1;
		}
		
//		return (int) (Math.random() * 5);
		
	}

}