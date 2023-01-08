package Cine;

public class Cliente {
	private int tiempoLlegada;
	private int tiempoSalida;
	
	public Cliente(int llegada) {
		tiempoLlegada = llegada;
	}
	
	public void setTiempoSalida(int salida) {
		tiempoSalida = salida;
	}
	
	public int getTiempoLlegada() {
		return tiempoLlegada;
	}
	
	public int getTiempoTranscurrido() {
		return tiempoSalida - tiempoLlegada;
	}
}
