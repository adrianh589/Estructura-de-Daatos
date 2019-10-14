import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
/**
 * Programa que resuelve un puzzle con inteligencia artificial
 * @author Camila
 *
 */
public class Puzzle {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static Random rnd = new Random();
	static ArrayList yaElegiste = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {

		System.out.println("Ingresa el tamaño del puzzle");
		int n = Integer.parseInt(br.readLine());
		
		System.out.println("El puzzle ordenado es: ");
		String pruebamatriz[][]=puzzleOrdenado(n);
		
		System.out.println("El puzzle desordenado es: ");
		String [][]matriz=puzzleDesordenado(n);
		
		System.out.println("A continuacion se procedera a ordenar el puzzle automaticamente");
		//ubicarHueco(matriz);
		
		//Creamos la raiz, la cual sera la matriz desordenada inicial
		Nodo raiz = new Nodo (matriz);
		
		//Comprobamos que se haya insertado correctamente
		//raiz.getMatrizNodo();
		
		//Prueba para asignarle un nodo a la raiz
		
		/*String pruebaesta [][]= {{"s","i","s"},{"i","r","v"},{"e","s"," "}};
		String prueba2 [][] = {{"9","p"},{"o","k"}};
		
		raiz.setArriba(new Nodo (pruebaesta));
		
		raiz.setAbajo(new Nodo (prueba2));
		
		imprimeNodo(raiz.getArriba());
		
		System.out.println("-----------------------");
		
		imprimeNodo(raiz.getAbajo());
		*/
		
		buscaSolucion(raiz,pruebamatriz,matriz);
		

	}
	
	/**
	 * Metodo que da un puzzle por consola aleatorio
	 * @return
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public static String [][] puzzleDesordenado(int n) throws NumberFormatException, IOException
	{
			String matriz[][]=new String[n][n];
			
			
			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz.length; j++) {
					matriz[i][j]=numeroAleatorio(n);
					System.out.print("["+matriz[i][j]+"]");
				}
				System.out.println("");
			}
		
		return matriz;
	}
	
	/**
	 * Metodo que compara el puzzle desordenado, cuando sean iguales termina la ejecucion del programa
	 * @return
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public static String [][] puzzleOrdenado(int n) throws NumberFormatException, IOException
	{
		//Creamos una nueva matriz
		String matrizOrdenada[][]=new String[n][n];
		
		//Variable que llenara la matriz a partir del numero 1
		int number=1;
		for (int i = 0; i < matrizOrdenada.length; i++) {
			for (int j = 0; j < matrizOrdenada.length; j++) {
				//Si se llego a la ultima posicion del puzzle, no lo llenara puesto que es el hueco
				if(i==matrizOrdenada.length-1&&j==matrizOrdenada.length-1)
				{
					matrizOrdenada[i][j]="  ";
					System.out.print("["+matrizOrdenada[i][j]+"]");
					break;
				}
				
				//Si el numero esta comprendido entre 0 y 10, concatenara un numero cero
				if(number>0&&number<10)
				{
					matrizOrdenada[i][j]=("[0"+Integer.toString(number)+"]");
				}
				//Si es mayor a 9, no concatenara el numero cero
				else
				{
					matrizOrdenada[i][j]=("["+Integer.toString(number)+"]");
				}
				number=number+1;
				System.out.print(matrizOrdenada[i][j]);
			}
			System.out.println("");
		}
		return matrizOrdenada;
	}
	
	/**
	 * Metodo que llena la matriz con numeros aletorios sin repetir
	 * @param n Recibe el tamaño de la matriz
	 */
	public static String numeroAleatorio(int n)
	{
		//Creamos una variable random num que elegira al azar un numero entre el valor de la matriz y 0
		String randomnum=Integer.toString(rnd.nextInt(n*n));
		
		//Si el arrayList contiene el numero, volvera a elegir hasta que el numero no se repita
		while(yaElegiste.contains(randomnum))
		{
			randomnum=Integer.toString(rnd.nextInt(n*n));
		}
		
		//Añadimos dicho numero al arrayList para evitar que se repita
		yaElegiste.add(randomnum);
		
		//El numero cero ocupara el hueco del puzzle
		if(randomnum.equals("0"))
		{
			return "  ";
		}
		
		//Añadimos el numero cero al lado de los valores unitarios
		if (Integer.parseInt(randomnum)>0&&Integer.parseInt(randomnum)<10)
		{
			return "0"+randomnum;
		}
		
		//En caso de que el valor sea de doble digito, retornara ese valor
		return randomnum;
	}
	
	/**
	 * Metodo que ubica el hueco en el puzzle
	 * @param matriz Recibe el puzzle desordenado
	 * @return Retorna la posicion donde se encuentra el hueco
	 */
	public static int [] ubicarHueco(String [][]matriz)
	{
		int [] posicionHueco = new int [2];
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				if(matriz[i][j].equals("  "))
				{
					posicionHueco[0]=i;
					posicionHueco[1]=j;
				}
			}
		}
		System.out.println("El hueco esta en la posicion: "+posicionHueco[0]+","+posicionHueco[1]);
		
		return posicionHueco;
	}
	
	/**
	 * Metodo que encontrara la solucion al puzzle
	 * @param inicio
	 * @param solucion
	 * @param matrizDesordenada
	 * @throws IOException 
	 */
	public static void buscaSolucion(Nodo inicio, String[][] solucion,String [][]matrizDesordenada) throws IOException
	{
		
		
		String rta = "";
		
		int positionIJ[] = ubicarHueco(inicio.getMatrizNodo());
		int i = positionIJ[0];
		int j = positionIJ[1];
		while(rta.equals(""))
		{
			//Validacion si el hueco se encuentra en una casilla diferente de los bordes
			if((i!=0&&i!=matrizDesordenada.length-1)&&(j!=0&&j!=matrizDesordenada.length-1))
			{
				System.out.println("Mov interno");
				
				int chooseDirection = rnd.nextInt(4)+1;
				System.out.println(chooseDirection);
				switch (chooseDirection) {
				case 1:
					inicio.setDerecha(new Nodo(correrNumDer(matrizDesordenada,positionIJ)));
					imprimeNodo(inicio.getDerecha());
					break;

				case 2:
					inicio.setIzquierda(new Nodo(correrNumIzq(matrizDesordenada,positionIJ)));
					imprimeNodo(inicio.getIzquierda());
					break;
					
				case 3:
					inicio.setAbajo(new Nodo(correrNumAba(matrizDesordenada,positionIJ)));
					imprimeNodo(inicio.getAbajo());
					break;
					
				case 4:
					inicio.setArriba(new Nodo(correrNumArr(matrizDesordenada,positionIJ)));
					imprimeNodo(inicio.getArriba());
					break;
				default:
					break;
				}
			}
			
			//Validacion para esquina superior izquierda
			else if(i==0&&j==0)
			{
				System.out.println("Mov ezq sup izq");
				int chooseDirection = rnd.nextInt(2)+1;
				System.out.println(chooseDirection);
				switch (chooseDirection) 
				{
				case 1:
					inicio.setIzquierda(new Nodo(correrNumIzq(matrizDesordenada,positionIJ)));
					imprimeNodo(inicio.getIzquierda());
					break;

				case 2:
					inicio.setArriba(new Nodo(correrNumArr(matrizDesordenada,positionIJ)));
					imprimeNodo(inicio.getArriba());
					break;
				}
			}
			
			//Validacion para esquina superior derecha
			else if(i==0&&j==matrizDesordenada.length-1)
			{
				System.out.println("Mov ezq sup der");
				int chooseDirection = rnd.nextInt(2)+1;
				System.out.println(chooseDirection);
				switch (chooseDirection) 
				{
				case 1:
					inicio.setArriba(new Nodo(correrNumArr(matrizDesordenada,positionIJ)));
					imprimeNodo(inicio.getArriba());
					break;

				case 2:
					inicio.setDerecha(new Nodo(correrNumDer(matrizDesordenada,positionIJ)));
					imprimeNodo(inicio.getDerecha());
					break;
				}
			}
			
			//Validacion para la esquina inferior izquierda
			else if(i==matrizDesordenada.length-1&&j==0)
			{
				System.out.println("Mov ezq inf izq");
				int chooseDirection = rnd.nextInt(2)+1;
				switch (chooseDirection) 
				{
				case 1:
					inicio.setAbajo(new Nodo(correrNumAba(matrizDesordenada,positionIJ)));
					imprimeNodo(inicio.getAbajo());
					break;

				case 2:
					inicio.setIzquierda(new Nodo(correrNumIzq(matrizDesordenada,positionIJ)));
					imprimeNodo(inicio.getIzquierda());
					break;
				}
			}
			
			//Validacion para la esquina inferior derecha
			else if(i==0&&j==matrizDesordenada.length-1)
			{
				System.out.println("Mov ezq inf der");
				int chooseDirection = rnd.nextInt(2)+1;
				switch (chooseDirection) 
				{
				case 1:
					inicio.setAbajo(new Nodo(correrNumAba(matrizDesordenada,positionIJ)));
					imprimeNodo(inicio.getAbajo());
					break;

				case 2:
					inicio.setDerecha(new Nodo(correrNumDer(matrizDesordenada,positionIJ)));
					imprimeNodo(inicio.getDerecha());
					break;
				}
			}
			
			//Validacion para el borde superior
			else if((i==0)&&(j>0&&j<matrizDesordenada.length-1))
			{
				System.out.println("Borde superior");
				int chooseDirection = rnd.nextInt(3)+1;
				switch (chooseDirection) 
				{
				case 1:
					inicio.setArriba(new Nodo(correrNumArr(matrizDesordenada,positionIJ)));
					imprimeNodo(inicio.getArriba());
					break;

				case 2:
					inicio.setIzquierda(new Nodo(correrNumIzq(matrizDesordenada,positionIJ)));
					imprimeNodo(inicio.getIzquierda());
					break;
					
				case 3:
					inicio.setDerecha(new Nodo(correrNumDer(matrizDesordenada,positionIJ)));
					imprimeNodo(inicio.getDerecha());
					break;
				}
			}
			
			//Validacion para el borde inferior
			else if((i==matrizDesordenada.length-1)&&(j>0&&j<matrizDesordenada.length-1))
			{
				System.out.println("Borde inferior");
				int chooseDirection = rnd.nextInt(3)+1;
				System.out.println(chooseDirection);
				switch (chooseDirection) 
				{
				case 1:
					inicio.setAbajo(new Nodo(correrNumAba(matrizDesordenada,positionIJ)));
					imprimeNodo(inicio.getAbajo());
					break;

				case 2:
					inicio.setIzquierda(new Nodo(correrNumIzq(matrizDesordenada,positionIJ)));
					imprimeNodo(inicio.getIzquierda());
					break;
					
				case 3:
					inicio.setDerecha(new Nodo(correrNumDer(matrizDesordenada,positionIJ)));
					imprimeNodo(inicio.getDerecha());
					break;
				}
			}
			
			//Validacion columna izquierda
			else if((j==0)&&(i>0&&i<matrizDesordenada.length-1))
			{
				System.out.println("Columna izquierda");
				int chooseDirection = rnd.nextInt(3)+1;
				System.out.println(chooseDirection);
				switch (chooseDirection) 
				{
				case 1:
					inicio.setAbajo(new Nodo(correrNumAba(matrizDesordenada,positionIJ)));
					imprimeNodo(inicio.getAbajo());
					break;

				case 2:
					inicio.setArriba(new Nodo(correrNumArr(matrizDesordenada,positionIJ)));
					imprimeNodo(inicio.getArriba());
					break;
					
				case 3:
					inicio.setDerecha(new Nodo(correrNumIzq(matrizDesordenada,positionIJ)));
					imprimeNodo(inicio.getDerecha());
					break;
				}
			}
			
			//Validacion para la columna derecha
			else if((j==matrizDesordenada.length-1)&&(i>0&&i<matrizDesordenada.length-1))
			{
				System.out.println("Columna derecha");
				int chooseDirection = rnd.nextInt(3)+1;
				System.out.println(chooseDirection);
				switch (chooseDirection) 
				{
				case 1:
					inicio.setAbajo(new Nodo(correrNumAba(matrizDesordenada,positionIJ)));
					imprimeNodo(inicio.getAbajo());
					break;

				case 2:
					inicio.setArriba(new Nodo(correrNumArr(matrizDesordenada,positionIJ)));
					imprimeNodo(inicio.getArriba());
					break;
					
				case 3:
					inicio.setDerecha(new Nodo(correrNumDer(matrizDesordenada,positionIJ)));
					imprimeNodo(inicio.getDerecha());
					break;
				}
			}
			
			positionIJ= ubicarHueco(inicio.getMatrizNodo());
			i = positionIJ[0];
			j=positionIJ[1];
			
			System.out.println("Enter para continuar...");
			rta = br.readLine();
		}
	}
	
	public static void imprimeNodo(Nodo nodo)
	{
		nodo.getMatrizNodo();
	}
	
	/**
	 * Funcion para mover el hueco a la izquierda
	 * @param matriz
	 * @param positionIJ
	 * @return
	 */
	public static String [][] correrNumDer(String[][] matriz, int [] positionIJ)
	{
		
		for (int i = positionIJ[0]; i < matriz.length; i++) 
		{
			for (int j = positionIJ[1]; j < matriz.length; j++) 
			{
				String aux=matriz[i][j-1];
				matriz[i][j-1]=matriz[i][j];
				matriz[i][j]=aux;
				break;
			}
			break;
		}
		return matriz;
	}
	
	/**
	 * Funcion para mover el hueco a la derecha
	 * @param matriz
	 * @param positionIJ
	 * @return
	 */
	public static String [][] correrNumIzq(String[][] matriz, int [] positionIJ)
	{
		
		for (int i = positionIJ[0]; i < matriz.length; i++) 
		{
			for (int j = positionIJ[1]; j < matriz.length; j++) 
			{
				String aux=matriz[i][j+1];
				matriz[i][j+1]=matriz[i][j];
				matriz[i][j]=aux;
				break;
			}
			break;
		}
		return matriz;
	}
	
	/**
	 * Funcion para mover el hueco hacia Arriba 
	 * @param matriz
	 * @param positionIJ
	 * @return
	 */
	public static String [][] correrNumAba(String[][] matriz, int [] positionIJ)
	{
		
		for (int i = positionIJ[0]; i < matriz.length; i++) 
		{
			for (int j = positionIJ[1]; j < matriz.length; j++) 
			{
				String aux=matriz[i-1][j];
				matriz[i-1][j]=matriz[i][j];
				matriz[i][j]=aux;
				break;
			}
			break;
		}
		return matriz;
	}
	
	/**
	 * Funcion para mover el hueco hacia Abajo
	 * @param matriz
	 * @param positionIJ
	 * @return
	 */
	public static String [][] correrNumArr(String[][] matriz, int [] positionIJ)
	{
		for (int i = positionIJ[0]; i < matriz.length; i++) 
		{
			for (int j = positionIJ[1]; j < matriz.length; j++) 
			{
				String aux=matriz[i+1][j];
				matriz[i+1][j]=matriz[i][j];
				matriz[i][j]=aux;
				break;
			}
			break;
		}
		return matriz;
	}

}
