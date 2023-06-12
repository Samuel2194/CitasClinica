package CitasClinicas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
    static Admin admin= new Admin();
    static String opcion="";
    public static void main(String[] args) throws IOException {
        admin.Load();
        if (admin.CountAdmin()==0){
            StartConfig();
        }
        System.out.println("¡Bienvenido!\n¿Deseas ingresar como administrador?\n 1) Si\n 2) No\n 3) Salir");
        opcion = scanner.readLine();
        switch(opcion.toUpperCase()) {
            case "1": {
                MenuAdmin();
                break;
            }
            case "2": {

                MenuUsuario();
                break;
            }
            case "3": {
                System.out.println("Adios");
                break;
            }
            default: {
                System.out.println("Opcion invalida");
                break;
            }
        }
    }

    public static void MenuAdmin() throws IOException {

        System.out.println("¿Que deseas hacer?\n 1) Alta Usuarios\n 2) Asignar Doctor\n 3) Salir");
        opcion = scanner.readLine();
        switch(opcion.toUpperCase()) {
            case "1": {
                MenuAdmin();
                break;
            }
            case "2": {

                MenuAdmin();
                break;
            }
            case "3": {

                MenuAdmin();
                break;
            }
            case "4": {
                System.out.println("Adios");
                break;
            }
            default: {
                System.out.println("Opcion invalida");
                MenuAdmin();
                break;
            }
        }
    }

    public static void MenuUsuario(){

    }

    public static void StartConfig() throws IOException {
        String nombre, pass, repPass;
        System.out.println("Es necesario estableces un administrador para que se pueda ejecutar el programa");
        System.out.println("Ingresa el nombre del Administrador");
        nombre = scanner.readLine();
        System.out.println("Ingresa la contrasela");
        pass = scanner.readLine();
        System.out.println("Repite la contrasela");
        repPass = scanner.readLine();
        if (pass==repPass){
            System.out.println (admin.NewAdmin(nombre, pass));
        }
    }
}