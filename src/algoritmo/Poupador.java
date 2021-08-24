package algoritmo;

import java.util.Arrays;

public class Poupador extends ProgramaPoupador {
	
	public int acao() {
		
//		System.out.println(sensor.getVisaoIdentificacao()[11]);
//		System.out.println(sensor.getPosicao());
//		System.out.println("getX - " + sensor.getPosicao().getX());
//		System.out.println("getY - " + sensor.getPosicao().getY());
		
		float[] peso_campos = new float[24];
		
		float[] soma_peso = new float[4];
		
		for(int i = 0; i < 24; i++ ) {
			
			if(sensor.getVisaoIdentificacao()[i] == -2 || 
				sensor.getVisaoIdentificacao()[i] == -1 || 
				sensor.getVisaoIdentificacao()[i] == 1 || 
				sensor.getVisaoIdentificacao()[i] == 200) {
				peso_campos[i] = 200;
			}
			
			if(sensor.getVisaoIdentificacao()[i] == 0) {
				peso_campos[i] = 50;
			}
			
			if(sensor.getVisaoIdentificacao()[i] == 3) {
				peso_campos[i] = 10;
			}
			
			if(sensor.getVisaoIdentificacao()[i] == 4) {
				peso_campos[i] = 1;
			}
			
			if(sensor.getVisaoIdentificacao()[i] == 5) {
				peso_campos[i] = 50;
			}
			
			if(sensor.getVisaoIdentificacao()[i] == 100) {
				peso_campos[i] = 50;
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
		float total = soma_peso_ordenado[0] / soma_total;
		
		System.out.println(a);
	
		if(a > soma_peso_ordenado[0] / soma_total) {
			System.out.println("Dire��o: " + (index[0] + 1));
			return index[0] + 1;
		} 
		else if(a > soma_peso_ordenado[1] / soma_total) {
			System.out.println("Dire��o: " + (index[0] + 1));
			return index[1] + 1;
		}
		else if(a > soma_peso_ordenado[2] / soma_total) {
			System.out.println("Dire��o: " + (index[0] + 1));
			return index[2] + 1;
		}
		else if(a > soma_peso_ordenado[3] / soma_total) {
			System.out.println("Dire��o: " + (index[0] + 1));
			return index[3] + 1;
		}
		
		return (int) (Math.random() * 5);
		
	}

}