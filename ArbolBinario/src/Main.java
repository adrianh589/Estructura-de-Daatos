import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Operaciones con arboles binarios
 * @author Adrian Hoyos
 * NRC: 6295
 *
 */
public class Main {
	
	/**
	 * variable que contabiliza los nodos internos
	 */
	static int totalNodos=0;
	
	/**
	 * variable que contabiliza los nodos externos
	 */
	static int nodoExterno=0;
	
	/**
	 * variable que encuentra el valor maximo del arbol
	 */
	static int numeroMayor=0;
	
	/**
	 * varialbe que calcula el promedio de los numeros del arbol
	 */
	
	/**
	 * Array que almacena nodos 
	 */
	static ArrayList <Nodo> hojas = new ArrayList <Nodo>();
	
	/**
	 * Buffer para captura de datos
	 */
	static BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
	
	static double promedio=0;

	public static void main(String[] args) throws IOException {
	
		int creaNodos=1;
		
		Nodo raiz = new Nodo (1);
		hojas.add(raiz);
		
		String rta="";
		boolean flag = false;
		
		int savePosition = 0;
		while (rta.equals(""))
		{
			/*for (int i=0;i<creaNodos;i++)
			{
				System.out.println("ingresa el valor del nodo");
				int valor = Integer.parseInt(br.readLine());
				hojas.add(agregarNodo(valor));
			}*/
			
			
			for (int i = 0; i < creaNodos;i++)
			{
				
				System.out.println("Añade hoja izquierda al nodo con valor "+hojas.get(savePosition).getDato());
				int valor = Integer.parseInt(br.readLine());
				hojas.get(savePosition).setNodoIzquierdo(new Nodo (valor));
				hojas.add(hojas.get(savePosition).getNodoIzquierdo());
				
				System.out.println("Añade hoja derecha al nodo con valor "+hojas.get(savePosition).getDato());
				int valor2 = Integer.parseInt(br.readLine());
				hojas.get(savePosition).setNodoDerecho(new Nodo (valor));
				hojas.add(hojas.get(savePosition).getNodoDerecho());
				
				
				savePosition++;
				System.out.println(savePosition);
				
			}
			
			creaNodos*=2;
			
			System.out.println("Desea seguir añadiendo? pulse enter para continuar");
			rta=br.readLine();
		}
		
		
		//Llamamos a cuentaNodos para las 3 operaciones principales
		cuentaNodos(raiz);
		
		//Llamamos a  calculaPromedio para calcular el promedio de los numeros en el arbol
		calculaPromedio();
		
		//Indicamos al usuario las operaciones en el arbol, como lo indica el ejercicio
		System.out.println("Este arbol binario tiene "+totalNodos+" nodos internos");
		System.out.println("Este arbol binario tiene "+nodoExterno+" nodos externos");
		System.out.println("El total de nodos que tiene el arbol binario es de: "+(totalNodos+nodoExterno));
		System.out.println("El numero mayor del arbol binario es: "+numeroMayor);
		System.out.println("El promedio de los numeros del arbol binario es: "+promedio);

	}
	
	/**
	 * Este metodo cuenta el total de nodos internos, externos y calcula el valor maximo del arbol
	 * @param raiz
	 */
	public static void cuentaNodos(Nodo raiz)
	{
		//Verificacion del numero mayor del arbol
		int number=0;
		
		//Mientras haya un numero en el nodo, sustituira la variable number 
		if(raiz != null)
		{
			//En este apartado, sumamos el valor que hay en el nodo para calcular su promedio al final
			promedio+=raiz.getDato();
			number = raiz.getDato();
		}
		
		//Si la variable number es mayor que la variable numeroMayor, entonces el numero actual sera el numero mayor del arbol
		if(number>numeroMayor && raiz != null)
		{
			numeroMayor=raiz.getDato();
		}
		
		//Recorremos el orden en preorden para poder contabilizar el total de nodos
		if(raiz != null)
		{
			//Imprimimos en preorden
			System.out.println(raiz.getDato());
			//Aumentamos totalNodos, puesto que el valor no es null
			totalNodos +=1;
			cuentaNodos(raiz.getNodoIzquierdo());
			cuentaNodos(raiz.getNodoDerecho());
		}
		else
		{
			//Si hay posicion null, significa que es un nodo externo
			nodoExterno+=1;
		}
	}
	
	/**
	 * Metodo que calcula el valor promedio del arbol binario
	 */
	public static void calculaPromedio() {
		
		//El total de valores que hay en el arbol, se dividira entre el numero total de nodos internos para calcular el promedio
		double promedioArbol = promedio/totalNodos;
		
		//Finalmente sustituimos la suma total en la variable promedio del arbol
		promedio = promedioArbol;
	}
	
	/**
	 * Metodo para añadir una raiz ingresada por el usuario
	 * @param valorRaiz
	 * @return
	 */
	static Nodo agregarNodoRaiz(int valorRaiz)
	{
		return new Nodo(valorRaiz);
	}
	
	/**
	 * Metodo para añadir un nuevo nodo
	 * @param valorNodo
	 * @return
	 */
	static Nodo agregarNodo(int valorNodo)
	{
		return new Nodo (valorNodo);
	}
	
	/**
	 * Metodo que une hijos
	 * @return
	 */
	static void unirHijos(Nodo raiz, Nodo hojaIzquierda, Nodo hojaDerecha)
	{
		raiz.setNodoIzquierdo(hojaIzquierda);
		raiz.setNodoDerecho(hojaDerecha);
	}
	
}
