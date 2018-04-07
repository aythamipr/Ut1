package ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Lista{

	ArrayList<Persona> p = new ArrayList<Persona>();
	Scanner ss = new Scanner(System.in);
	Scanner sn = new Scanner(System.in);
	
	public void cargar() {
		String csvFile = "personas.csv";
		String linea = "";
		String csvSplitBy = ",";
		//String[] ret = null;
		BufferedReader br = null;
		try { 
			br = new BufferedReader(new FileReader(csvFile));
			while((linea = br.readLine()) != null) {
				String[] persona = linea.split(csvSplitBy);
				String nombre = persona[0];
				String apellidos = persona[1];
				int dni = Integer.parseInt(persona[2]);
				int edad = Integer.parseInt(String.valueOf(persona[3]));
				String calle = persona[4];
				int numero = Integer.parseInt(String.valueOf(persona[5]));
				int cp = Integer.parseInt(String.valueOf(persona[6]));
				String provincia = persona[7];
				p.add(new Persona(nombre, apellidos, dni, edad, calle, numero, cp, provincia));
				}
			br.close();
		}catch(FileNotFoundException e) {
			System.out.println("No se encuentra el fichero");
		}catch(IOException e) {
			System.out.println("No se puede leer el fichero");
		}
	}
	
	public void listar() {
		for(Persona s:p)
			System.out.println(s);
	}
	
	public void insertar() {
		System.out.println("Introduzca el nombre:");
		String nombre = ss.nextLine();
		System.out.println("Introduzca los apellidos:");
		String apellidos = ss.nextLine();
		System.out.println("Introduzca el DNI:");
		int dni = sn.nextInt();
		System.out.println("Introduzca la edad:");
		int edad = sn.nextInt();
		System.out.println("Introduzca el nombre de la calle:");
		String calle = ss.nextLine();
		System.out.println("Introduzca el número de la casa:");
		int numero = sn.nextInt();
		System.out.println("Introduzca el código postal:");
		int cp = sn.nextInt();
		System.out.println("Introduzca la provincia:");
		String provincia = ss.nextLine();
		p.add(new Persona(nombre, apellidos, dni, edad, calle, numero, cp, provincia));
	}
	
	public void eliminar() {
		int posicion = 0;
		int n = 0;
		System.out.println("Introduzca el dni de la persona a eliminar:");
		int dni = sn.nextInt();
		for(Persona s : p) {
			if(dni == s.getDni()) {
				posicion = n;
			}else
				n++;
		}
			p.remove(posicion);
	}
	
	public int contar() {
		return p.size();
	}
	
	public String buscar(int dni) {
		for (Persona s:p) {
			if(dni == s.getDni()) 
				System.out.println(s);
		}
		return null;
	}
	
	public void buscar (String nombre) {
		for(Persona s:p)
			if(nombre.equals(s.getNombre()))
				System.out.println(s);
	}
	
	public void ordenar() {
		Collections.sort(p);
	}
	
	public void guardar() {
		String csvFile = "pedidos.csv";
		BufferedWriter bw = null;
		String linea = "";
		
		try {
			bw = new BufferedWriter(new FileWriter(csvFile));
			bw.write("nombre,apellidos,dni,edad,calle,numero,cp,provincia" + "\n");
			for(Persona s:p) {
				linea = s.toString();
				bw.write(linea + "\n");
			}
			bw.close();
		} catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
