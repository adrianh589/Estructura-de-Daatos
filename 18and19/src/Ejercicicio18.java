import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Ejercicicio18 {

	public static void main(String[] args) throws NumberFormatException, IOException
	{
		/**
		* Creamos los buffers para captura de datos
		*/
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		/*
		 * Creamos la cola
		 */
		LinkedList cola = new LinkedList();
		
		/*
		 * Creamos un pila
		 */
		Stack pila = new Stack();
		
		
		System.out.println("Cuanto elementos desea introducir en la cola doble?");
		
		int elements=Integer.parseInt(br.readLine());
		
		for(int i=0;i<elements;i++)
		{
			System.out.println("Ingrese el elemento "+(i+1));
			int valor = Integer.parseInt(br.readLine());
			cola.offer(valor);
			pila.push(valor);
		}
		
		System.out.println("Su cola es:");
		System.out.println(cola);
		
		String rta="y";
		while(rta.equals("y"))
		{	System.out.println("porque lado desea desencolar los elementos? izq/der");
			rta = br.readLine();
			
			if(rta.equals("izq"))
			{
				System.out.println(izquierda(cola,br));
			}
			
			else if(rta.equals("der"))
			{
				System.out.println(derecha(cola, br, pila));
			}
			
			System.out.println("Desea volver a introducir elementos? y/n");
			rta=br.readLine();
		}
		
	}
	
	static LinkedList izquierda(LinkedList cola, BufferedReader br) throws NumberFormatException, IOException
	{
		System.out.println("Ha decidido desencolar elementos por izquierda");
		
		System.out.println("Cuanto elementos desea añadir por la derecha?");
		int rta = Integer.parseInt(br.readLine());
		
		for(int i=0;i<rta;i++)
		{
			cola.remove(cola.peek());
			
			System.out.println("Añada elemento "+(i+1));
			int element=Integer.parseInt(br.readLine());
			cola.offer(element);
		}
		
		System.out.println("Su cola es: ");
		return cola;
	}
	
	static LinkedList derecha(LinkedList cola, BufferedReader br, Stack pila) throws NumberFormatException, IOException
	{
		System.out.println("Ha decidido desencolar elementos por derecha");
		System.out.println("Cuanto elementos desea añadir por la izquierda?");
		int rta = Integer.parseInt(br.readLine());
		
		/*
		 * vaceamos la cola para introducir los numeros alrevez
		 */
		while(!cola.isEmpty())
		{
			cola.poll();
		}
		
		/*
		 * llenamos la cola con los numeros alrevez
		 */
		while(!pila.isEmpty())
		{
			cola.offer(pila.peek());
			pila.pop();		
		}
		
		/*
		 * Como los numeros estan alrevez, se hace el procedimiento de el metodo izquierda
		 */
		for(int i=0;i<rta;i++)
		{
			cola.remove(cola.peek());
			
			System.out.println("Añada elemento "+(i+1));
			int element=Integer.parseInt(br.readLine());
			cola.offer(element);
		}
		
		/*
		 * Como la pila esta vacia, metemos los elementos de la cola para ponerlos alderecho
		 */
		while(!cola.isEmpty())
		{
			pila.push(cola.peek());
			cola.poll();
		}
		
		/*
		 * finalmente, metemos de nuevo en la cola los elementos de la pila, dando un resultado final
		 */
		while(!pila.empty())
		{
			cola.offer(pila.peek());
			pila.pop();
		}
		
		System.out.println("Su cola es: ");
		return cola;
	}

}
