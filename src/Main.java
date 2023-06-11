import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
    static String opcion="";
    public static void main(String[] args) throws IOException {
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

        System.out.println("¿Que deseas hacer?\n 1) Alta Doctores\n 2) Alta Pacientes\n 3) Eliminar Contacto\n 4) Salir");
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
}