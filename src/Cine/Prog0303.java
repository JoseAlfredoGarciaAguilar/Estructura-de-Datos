package Cine;
//PROGRAMA PARA SIMULAR UN DESPACHO DE ENTRADAS DE UN CINE, UTILIZANDO UNA ESTRUCTURA DE DATOS TIPO COLA
public class Prog0303 {
	final static int duracion_proceso = 120;
	final static int max_cajeros = 10;
	final static int num_clientes = 100;
	
	public static void main(String[] args) {
		TDACola<Cliente> colaClientes = new Cola<Cliente>();
		int[] tiempoCajero = new int[max_cajeros];
		
		//CICLO PARA SIMULAR DIFERENTES NÚMEROS DE CAJEROS
		//MÁXIMO MAX_CAJEROS
		for(int cajeros=0; cajeros<max_cajeros; cajeros++) {
			//PONER EN 0 LOS TIEMPOS DE LOS CAJEROS
			for(int i=0; i<=cajeros; i++) {
				tiempoCajero[i] = 0;
				
				//PRECARGAR LA COLA CON NUM_CLIENTES Y SUS TIEMPOS DE LLEGADA
				for(int j=0; i<num_clientes; j++) {
					colaClientes.enqueue(new Cliente(15*j));
				}
			}
			
			int caja = 0;
			int tiempoTotal = 0;
			
			//PROCESAR TODOS LOS CLIENTES
			while(!colaClientes.isEmpty()) {
				Cliente cliente = colaClientes.dequeue();
				int tiempoSalida = 0;
				
				if(cliente.getTiempoLlegada()>tiempoCajero[caja]) {
					tiempoSalida = cliente.getTiempoLlegada() + duracion_proceso;
				}else {
					tiempoSalida = tiempoCajero[caja] + duracion_proceso;
				}
				
				cliente.setTiempoSalida(tiempoSalida);
				
				//ACUMULAR TIEMPOS TRANSCURRIDOS
				tiempoTotal += cliente.getTiempoTranscurrido();
				
				//ACTUALIZAR EL TIEMPO DEL CAJERO
				tiempoCajero[caja] = tiempoSalida;
				
				//ACTUALIZAR CAJA
				caja = (caja + 1) % (cajeros + 1);			
			}
			
			//MOSTRAR RESULTADOS PARA ESTE NÚMERO DE CAJEROS
			int tiempoPromedio = tiempoTotal / num_clientes;
			System.out.printf("TOTAL CAJERO: %2d\tTiempo promedio: %5d\n" +  cajeros + 1, tiempoPromedio);
		}
	}
}