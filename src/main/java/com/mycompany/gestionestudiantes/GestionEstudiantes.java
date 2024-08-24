package com.mycompany.gestionestudiantes;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class GestionEstudiantes {
     private static Collection<String> carnets = new ArrayList<>();
    private static Collection<String> nombres = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n 1. Ingresar alumno");
            System.out.println(" 2. Buscar alumno");
            System.out.println(" 3. Eliminar alumno");
            System.out.println(" 4. Mostrar todos los alumnos");
            System.out.println(" 5. Salir");
            System.out.print("Seleccione una opción: ");
			//Input y switch
            int opcion = scanner.nextInt();
            scanner.nextLine();  
            System.out.print("\n \n");
            switch (opcion) {
                case 1:
                    ingresarAlumno(scanner);
                    break;
                case 2:
                    buscarAlumno(scanner);
                    break;
                case 3:
                    eliminarAlumno(scanner);
                    break;
                case 4:
                    mostrarTodosLosAlumnos();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void ingresarAlumno(Scanner scanner) {

        System.out.print("\n Ingrese el carnet del alumno: ");
        String carnet = scanner.nextLine();
        System.out.print("\n Ingrese el nombre completo del alumno: ");
        String nombre = scanner.nextLine();
        carnets.add(carnet);
        nombres.add(nombre);
        System.out.println("\n Alumno ingresado exitosamente.");
    }

    private static void buscarAlumno(Scanner scanner) {
       
        System.out.print("\n Ingrese el carnet del alumno para buscar: ");
        String carnet = scanner.nextLine();
        int index = -1;
        int i = 0;
        
        for (String c : carnets) {
            if (c.equals(carnet)) {
                index = i;
                break;
            }
            i++;
        }
        
        if (index != -1) {
        
            System.out.println("\n Alumno encontrado: Carnet: " + carnet + ", Nombre: " + nombres.toArray()[index]);
        } else {
        
            System.out.println("\n Alumno no encontrado, no se puede mostrar.");
        }
    }

    private static void eliminarAlumno(Scanner scanner) {
        System.out.print("\n Ingrese el carnet del alumno a eliminar: ");
        String carnet = scanner.nextLine();
        int index = -1;
        
        int i = 0;
        for (String id : carnets) {
            if (id.equals(carnet)) {
                index = i;
                break;
            }
            i++;
        }
        
        if (index != -1) {
            carnets.remove(index);
            nombres.remove(index);
            System.out.println("\n Alumno eliminado exitosamente.");
        } else {
            System.out.println("\n Alumno no encontrado, no se puede eliminar.");
        }
    }

    private static void mostrarTodosLosAlumnos() {
        if (carnets.isEmpty()) {
            System.out.println("\n No hay alumnos para mostrar.");
        } else {
            System.out.println("\n Lista de alumnos:");
            int i = 0;
            for (String carnet : carnets) {
                System.out.println("\n Carnet: " + carnet + ", Nombre: " + nombres.toArray()[i]);
                i++;
            }
        }
    }

   }
