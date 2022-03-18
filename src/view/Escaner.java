package view;


import java.util.Scanner;



/**
 * Clase que aglutina funciones para recoger información por teclado del usuario
 * Esta clase hace uso del patron singleton
 * @author juanmi_rivas_8
 *
 */
public class Escaner {

	private static Escaner control = null;
	private Scanner sc = null; 

	private Escaner(){
		this.sc = new Scanner(System.in);
	}
	
	public static Escaner newInstance() {
		if(control == null) {
			control = new Escaner();
		}
		
		return control;
	}
	/**
	 * Lee un entero por teclado entre un rango inferior y superior.
	 * 
	 * 
	 * @param inferior Rango inferior
	 * @param superior Rango superior
	 * @return Numero entero leido por teclado
	 * @throws Exception Si se leyó un numero fuera de rango, o no se introdujo un
	 *                   entero.
	 */
	public int readInt(Integer inferior, Integer superior) throws Exception {
		Integer numero = 0, aux = superior;

		// ORDENAMOS LIMITES
		if (inferior > superior) {
			superior = inferior;
			inferior = aux;
		}

		try {
			numero = readInt();
		} catch (NumberFormatException e) {
			throw e;
		}	

		if (numero < inferior) {
			throw new Exception("Numero menor que limite inferior");
		} else if (numero > superior) {
			throw new Exception("Numero mayor que limite superior");
		}

		return numero;
	}

	/**
	 * Lee un entero por teclado
	 * 
	 * 
	 * @return Devuelve el entero leido por teclado
	 * @throws NumberFormatException Se lanza esta excepcion si no se introduce
	 *                                un entero.
	 */
	public Integer readInt() throws NumberFormatException {
		Integer numero = 0;
		String cad;
		try {
			cad=sc.nextLine();
			numero = Integer.valueOf(cad);
		} catch (NumberFormatException e) {
			throw new NumberFormatException("Error - No se introdujo un entero");
		}
		return numero;
	}
	
	
	/**
	 *  Lee un entero por teclado hasta que el usuario introduce uno correctamente
	 * 
	 * @param message Cadena para orientar al usuario
	 * @return Devuelve el entero leido por teclado
	 */
	public Integer readIntBucle(String message) {
		Boolean invalido=true;
		int num=0;
		do {
			invalido=true;
			try {
				System.out.println(message);
				num=readInt();
				invalido=false;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}while(invalido);
		
		return num;
	}
	
	/**
	 * Lee un entero entre un rango por teclado hasta que el usuario introduce uno correctamente
	 * 
	 * @param message Cadena para orientar al usuario
	 * @param inf Rango inferior 
	 * @param sup Rango superior
	 * @return Entero leido por teclado
	 */
	public Integer readIntBucle(String message,Integer inf,Integer sup) {
		Boolean invalido=true;
		int num=0;
		do {
			invalido=true;
			try {
				System.out.println(message);
				num=readInt(inf,sup);
				invalido=false;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}while(invalido);
		
		return num;
	}
	
	/**
	 * Lee un double por teclado
	 * 
	 * @return double leido por teclado
	 */
	public Double readDouble() {
		Double numero = 0.0;
		String cad;
		try {
			cad=sc.nextLine();
			numero=Double.valueOf(cad);
		} catch (NumberFormatException e) {
			sc.next();
			throw new NumberFormatException("Error - No se introdujo un numero");
		}
		return numero;
	}
	
	
	/**
	 * Lee un double por teclado entre un rango inferior y superior.
	 * 
	 * @param inferior Rango inferior
	 * @param superior Rango superior
	 * @return double leido por teclado
	 * @throws Exception
	 */
	public Double readDouble(Double inferior, Double superior) throws Exception {
		Double numero = 0.0, aux = superior;

		// ORDENAMOS LIMITES
		if (inferior > superior) {
			superior = inferior;
			inferior = aux;
		}

		try {
			numero = readDouble();
		} catch (NumberFormatException e) {
			throw e;
		}

		if (numero < inferior) {
			throw new Exception("Numero menor que limite inferior");
		} else if (numero > superior) {
			throw new Exception("Numero mayor que limite superior");
		}

		return numero;
	}
	
	/**
	 *  Lee un entero por double hasta que el usuario introduce uno correctamente
	 * 
	 * @param message Cadena para orientar al usuario
	 * @return double leido por teclado
	 */
	public Double readDoubleBucle(String message) {
		Boolean invalido=true;
		Double num=0.0;
		do {
			invalido=true;
			try {
				System.out.println(message);
				num=readDouble();
				invalido=false;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}while(invalido);
		
		return num;
	}
	
	/**
	 * Lee un entero entre un rango por teclado hasta que el usuario introduce uno correctamente
	 * 
	 * @param message Cadena para orientar al usuario
	 * @param inf Rango inferior
	 * @param sup Rango superior
	 * @return double leido por teclado
	 */
	public Double readDoubleBucle(String message,Double inf,Double sup) {
		Boolean invalido=true;
		Double num=0.0;
		do {
			invalido=true;
			try {
				System.out.println(message);
				num=readDouble(inf,sup);
				invalido=false;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}while(invalido);
		
		return num;
	}
	
	public void waitForKey() {
		@SuppressWarnings("unused")
		String wait=null;
		System.out.println("--Pulse Enter para continuar--");
		wait=sc.nextLine();
		
	}

	public String readString(String mensaje) {
		System.out.println(mensaje);
		String retCad = sc.nextLine();
		
		return retCad;
	}
	
	public String readString(String mensaje,String regex)throws IllegalArgumentException {
		System.out.println(mensaje);
		String retCad = sc.nextLine();
		
		if(!retCad.matches(regex)) {
			throw new IllegalArgumentException("Formato invalido");
		}
		return retCad;
	}
	
	public String readStringBucle(String mensaje,String regex) {
		String retCad = null;
		Boolean invalido = true;
		do {
			invalido = true;
			try {
				retCad = this.readString(mensaje, regex);
				invalido=false;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}while(invalido);
		return retCad;
	}
	
	public <T extends Enum<T>> Enum<T> readEnum (String mensaje,Class<T> clase) throws IllegalArgumentException {
		
		try {
			Enum<T> a = Enum.valueOf(clase,readString(mensaje));
			return a;
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Dato no compatible");
		}
		
	}
	
	public <T extends Enum<T>> Enum<T> readEnumBucle (String mensaje,Class<T> clase){
		Boolean invalido = true;
		Enum<T> a = null;
		do {
			try {
				System.out.println("Datos compatibles: ");
				System.out.println(java.util.Arrays.asList(clase.getEnumConstants()));
				a = readEnum(mensaje,clase);
				invalido = false;
			}catch(IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}while(invalido);
		
		return a;
	}
	
	
	
}
