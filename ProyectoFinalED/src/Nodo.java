
public class Nodo {//Variables para los setters
	
	private String[][] raiz;
	
	private Nodo izquierda;
	private Nodo derecha;
	private Nodo arriba;
	private Nodo abajo;
	
	/**
	 * Constructor para inicializar las variables
	 * @param inicio Recibe el dato o el numero ingresado
	 */
	public Nodo (String[][] nodo)
	{
		this.raiz=nodo;
	}

	public Nodo getIzquierda() {
		return izquierda;
	}

	public void setIzquierda(Nodo izquierda) {
		this.izquierda = izquierda;
	}

	public Nodo getDerecha() {
		return derecha;
	}

	public void setDerecha(Nodo derecha) {
		this.derecha = derecha;
	}

	public Nodo getArriba() {
		return arriba;
	}

	public void setArriba(Nodo arriba) {
		this.arriba = arriba;
	}

	public Nodo getAbajo() {
		return abajo;
	}

	public void setAbajo(Nodo abajo) {
		this.abajo = abajo;
	}

	/**
	 * Obtencion dela matriz
	 * @return Retorna la matriz que esta en la posicion del nodo
	 */
	public String [][] getMatrizNodo()
	{
		for (int i = 0; i < raiz.length; i++) {
			for (int j = 0; j < raiz.length; j++) {
				System.out.print("["+raiz[i][j]+"]");
			}
			System.out.println();
		}
		return raiz;
	}

}
