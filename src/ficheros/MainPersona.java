package ficheros;

import java.util.Scanner;

public class MainPersona {

	public static void main(String[] args) {
		
		int menu=0;
		Lista l = new Lista();
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("Menú");
			System.out.println("1) Cargar ");
			System.out.println("2) Mostrar toda la lista");
			System.out.println("3) Insertar una persona");
			System.out.println("4) Eliminar una persona");
			System.out.println("5) Mostrar el número de personas en la lista");
			System.out.println("6) Buscar persona por DNI");
			System.out.println("7) Buscar persona por nombre");
			System.out.println("8) Ordenar la lista según el número de DNI");
			System.out.println("9) Guardar la lista en un fichero CSV");
			System.out.println("0) Salir");
			menu = sc.nextInt();
			switch(menu) {
			case 1: l.cargar();
					break;
			case 2:	l.listar();
					break;
			case 3: l.insertar();
					break;
			case 4: l.eliminar();
					break;
			case 5: System.out.println("La cantidad de personas en la lista son: " + l.contar());
					break;
			case 6: System.out.println("Introduzca el número de DNI sin letra de la persona a buscar:");
					int dni = sc.nextInt();
					l.buscar(dni);
					break;
			case 7: System.out.println("Introduzca el nombre sin letra de la persona a buscar:");
					String nombre = sc.nextLine();
					l.buscar(nombre);
					break;
			case 8: l.ordenar();
					break;
			case 9: l.guardar();
					break;
			case 0:	System.out.println("Gracias por usar este programa");
					break;
			default:System.out.println("Por favor, introduzca una opción correcta");
					break;
			}
		
		}while(menu != 0);
		
		sc.close();

	}

}
