package algoritmo;

public class Poupador extends ProgramaPoupador {
	
	public int acao() {
		
//		System.out.println(sensor.getVisaoIdentificacao()[11]);
//		System.out.println(sensor.getPosicao());
		
		int[] peso_passo = new int[5];
		int[] peso_campos = new int[24];
		
		int[] soma_peso = new int[4];
		
		for(int i = 0; i < 24; i++ ) {
			
			if(sensor.getVisaoIdentificacao()[i] == -2 || 
				sensor.getVisaoIdentificacao()[i] == -1 || 
				sensor.getVisaoIdentificacao()[i] == 1 || 
				sensor.getVisaoIdentificacao()[i] == 200) {
				peso_campos[i] = 100;
			}
			
			if(sensor.getVisaoIdentificacao()[i] == 0) {
				peso_campos[i] = 0;
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
		
		int[] array = new int[4];
		int maior = 0;
		
		for(int i = 0; i < 4; i++) {
			if(i == 0) {
				maior 
			}
		}
		
		
		
			
//			System.out.println(sensor.getVisaoIdentificacao()[i]);
//			System.out.println("getx - " + sensor.getPosicao().getX());
			
//			if(sensor.getVisaoIdentificacao()[i] == 4) {
//				if (i == 0 || i == 1 || i == 5 || i == 6) {
//					if(sensor.getVisaoIdentificacao()[11] == 1) {
//						return 1;
//					}
//					return 4;
//				}
//				if (i == 2 || i == 7) {
//					return 1;
//				}
//				if (i == 3 || i == 4 || i == 8 || i == 9) {
//					return 3;
//				}
//				if (i == 12 || i == 13) {
//					return 3;
//				}
//				if (i == 17 || i == 18 || i == 22 || i == 23) {
//					return 2;
//				}
//				if (i == 16 || i == 21) {
//					return 2;
//				}
//				if (i == 14 || i == 15 || i == 19 || i == 20) {
//					return 2;
//				}
//				if (i == 10 || i == 11) {
//					return 4;
//				} 
//			}
			
//		return (int) (Math.random() * 5);
	}

}