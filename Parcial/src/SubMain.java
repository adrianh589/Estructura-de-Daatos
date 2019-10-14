
public class SubMain 
{
	public String nombre;
	public int edad;
	public String sexo;
	public String calle;
	public String numero;
	public String ciudad;
	public String telefono;
	public boolean seguro;
	
	public SubMain(String nombre, int edad, String sexo, String calle, String numero, String ciudad,
			String telefono, boolean seguro)
	{
		this.nombre=nombre;
		this.edad=edad;
		this.sexo=sexo;
		this.calle=calle;
		this.numero=numero;
		this.ciudad=ciudad;
		this.telefono=telefono;
		this.seguro=seguro;
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public boolean getSeguro() {
		return seguro;
	}

	public void setSeguro(boolean seguro) {
		this.seguro = seguro;
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(getNombre());
		sb.append(", ");
		
		sb.append(getEdad());
		sb.append(", ");
		
		sb.append(getSexo());
		sb.append(", ");
		
		sb.append(getCalle());
		sb.append(", ");
		
		sb.append(getNumero());
		sb.append(", ");
		
		sb.append(getCiudad());
		sb.append(", ");
		
		sb.append(getTelefono());
		sb.append(", ");
		
		sb.append(getSeguro());
		
		return sb.toString();
	}
	
}