
public class Nodo {
	
		//Variables para los setters
		private int dato;
		private Nodo izq;
		private Nodo der;
	
		/**
		 * Constructor para inicializar las variables
		 * @param dato Recibe el dato o el numero ingresado
		 */
		public Nodo (int dato)
		{
			this.dato=dato;
		}
		
		//Getters para obtener el valor dependiendo de la orientacion del nodo
		public Nodo getNodoIzquierdo()
		{
			return izq;
		}
		
		public Nodo getNodoDerecho()
		{
			return der;
		}
		
		//Setters para entregar a cada nodo sus hijos
		public void setNodoIzquierdo(Nodo nodo)
		{
			izq = nodo;
		}
		
		public void setNodoDerecho(Nodo nodo)
		{
			der = nodo;
		}
		
		/**
		 * Obtencion del dato
		 * @return Retorna el numero que esta en la posicion del nodo
		 */
		public int getDato()
		{
			return dato;
		}
		
		
}
