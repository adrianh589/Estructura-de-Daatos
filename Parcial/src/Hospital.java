import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Hospital 
{
	static int niños=0;
	static int jovenes=0;
	static int adultos=0;
	
	static int hombres=0;
	static int mujeres=0;
	
	static int posee_seguro=0;
	static int no_posee_seguro=0;
	
	public static void main(String[]args) throws IOException
	{
		Scanner sc = new Scanner (System.in);
		int respuesta;
		
		System.out.println("Bienvenido a los registros del Hospital...\nCuantos pacientes desea registrar?");
		respuesta = sc.nextInt();
		
		registrarBaseHospital(respuesta);
		
		calcularPorcentajes();
		
		calcularPorcentajesMH();
		
		pacienteSegurosPor();
		
		
		}
	
	public static void registrarBaseHospital(int n) throws IOException
	{
		
		
			SubMain paciente [] = new SubMain [20];
			Scanner sc = new Scanner(System.in);
			
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader (isr);
			
			String nombre;
			int edad;
			String sexo;
			String calle;
			String numero;
			String ciudad;
			String telefono;
			String seguro;
			boolean seguroR;
			
			
			
			
			for (int i=0; i<n; i++)
			{
				System.out.println("Introduzca los datos del paciente "+(i+1)+" (Nombre, Edad, Sexo, Calle, Numero, Ciudad, Telefono, Seguro)");
				
				System.out.println("Introduzca los nombres del paciente "+(i+1));
				nombre=br.readLine();
				
				System.out.println("Introduzca la edad del paciente "+(i+1));
				edad=Integer.parseInt(br.readLine());
				calcularEdades(edad);
				
				System.out.println("Introduzca el sexo [(m M) o (f F)] del paciente "+(i+1));
				sexo=br.readLine();
				porcentajeHombreMujeres(sexo);
				
				System.out.println("Introduzca la calle de residencia del paciente "+(i+1));
				calle=br.readLine();
				
				System.out.println("Introduzca el numero de residencia de calle del paciente "+(i+1));
				numero=br.readLine();
				
				System.out.println("Introduzca la ciudad a la que pertenece el paciente "+(i+1));
				ciudad=br.readLine();
				
				System.out.println("Introduzca el telefono del paciente "+(i+1));
				telefono=br.readLine();
				
				System.out.println("El paciente tiene seguro? S/N");
				seguro=br.readLine();
				
				if(seguro.equals("s")||seguro.equals("S")||seguro.equals("Si")||seguro.equals("si") )
				{
					System.out.println("Ha elegido una respuesta afirmativa, por tanto el paciente tiene seguro medico");
					seguroR=true;
					pacienteSeguros(seguroR);
				}
				
				else
				{
					System.out.println("Ha elegido una respuesta negativa, por tanto el paciente NO registrara seguro medico");
					seguroR=false;
					pacienteSeguros(seguroR);
				}
				
				paciente[i] = new SubMain (nombre, edad, sexo, calle, numero, ciudad, telefono, seguroR);
				System.out.println(paciente[i]);
				System.out.println("-----------------------------");
				if(i==n-1)
				{
					System.out.println("Datos del/los paciente(s)\nNombre| Edad| Sexo| Calle| Numero| Ciudad| Telefono| Seguro");
				}
			}
			
		//Desplegar la informacion
			for (int i=0; i<n; i++)
			{
				System.out.println(paciente[i].toString());
			}
		
			
	}
	
	public static void calcularEdades(int edad)
	{
		niños = 0;
		jovenes = 0;
		adultos = 0;
		
		if(edad <= 13)
		{
			niños+=1;
		}
		
		else if((edad>13)&&(edad<30))
		{
			jovenes+=1;
		}
		
		else
		{
			adultos+=1;
		}
	}
	
	public static void calcularPorcentajes()
	{
		int total=niños+jovenes+adultos;
		
		if(niños>0) {
		double porcentaje_niños=(total*100/niños);
		System.out.println("El porcentaje de los niños en el hospital es: "+porcentaje_niños);
		}
		
		if(jovenes>0) {
		double porcentaje_jovenes=(total*100/jovenes);
		System.out.println("El porcentaje de los jovenes en el hospital es: "+porcentaje_jovenes);
		}
		
		if(adultos>0) {
		double porcentaje_adultos=(total*100/adultos);
		System.out.println("El porcentaje de los adultoss en el hospital es: "+porcentaje_adultos);
		}
	}
	
	public static void porcentajeHombreMujeres(String sexo)
	{
		
		if(sexo=="m"||sexo=="M")
		{
			hombres+=1;
		}
		
		else if(sexo=="f"||sexo=="F")
		{
			mujeres +=1;
		}
	}
	
	public static void calcularPorcentajesMH()
	{
		int total=hombres+mujeres;
		
		if(hombres>0) {
		double total_hombres=(hombres*100)/total;
		System.out.println("El porcentaje de hombres en el hospital es de: "+total_hombres);
		}else
		{
			System.out.println("El porcentaje de hombres en el hospital es de: 0");
		}
				
		if(mujeres>0) {
		double total_mujeres=(mujeres*100)/total;
		System.out.println("El porcentaje de mujeress en el hospital es de: "+total_mujeres);
		}else {
			System.out.println("El porcentaje de hombres en el hospital es de: 0");
		}
	}
	
	public static void pacienteSeguros(boolean seguroR)
	{
		if(seguroR==true)
		{
			posee_seguro+=1;
		}
		
		else if(seguroR==false)
		{
			no_posee_seguro +=1;
		}
	}
	
	public static void pacienteSegurosPor()
	{
		int total=posee_seguro+no_posee_seguro;
		
		if(posee_seguro>0) {
		double si=(posee_seguro*100)/total;
		System.out.println("Los que poseen seguro en porcentaje son: "+si);
		}
		
		if(no_posee_seguro>0) {
		double no=(no_posee_seguro*100)/total;
		System.out.println("Los que NO poseen seguro en porcentaje son: "+no);
		}
	}
	
	
}
