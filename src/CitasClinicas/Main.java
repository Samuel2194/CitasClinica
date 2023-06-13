package CitasClinicas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
    static Admin admin= new Admin();
    static  Doctor doctor = new Doctor();
    static Paciente paciente = new Paciente();
    static String opcion="";
    public static void main(String[] args) throws IOException {
        admin.Load();
        doctor.Load();
        paciente.Load();
        if (admin.CountAdmin()==0){
            StartConfig();
        }
        MenuPrincipal();
    }

    public static void MenuPrincipal() throws IOException {
        System.out.println("¡Bienvenido!\n¿Deseas ingresar como administrador?\n 1) Si\n 2) No\n 3) Salir");
        opcion = scanner.readLine();
        switch(opcion.toUpperCase()) {
            case "1": {
                if (Login()) {
                    MenuAdmin();
                }else{
                    System.out.println("Usuario invalido");
                }
                MenuPrincipal();

                break;
            }
            case "2": {
                MenuUsuario();
                MenuPrincipal();

                break;
            }
            case "3": {
                System.out.println("Adios");

                break;
            }
            default: {
                System.out.println("Opcion invalida");
                MenuPrincipal();

                break;
            }
        }
    }
    public static void MenuAdmin() throws IOException {


        System.out.println("¿Que deseas hacer?\n 1) Alta Usuarios\n 2) Asignar Doctor\n 3) Salir");
        opcion = scanner.readLine();
        switch(opcion.toUpperCase()) {
            case "1": {
                MenuManagementUsers();
                MenuAdmin();
                break;
            }
            case "2": {

                MenuAdmin();
                break;
            }
            case "3": {
                break;
            }
            default: {
                System.out.println("Opcion invalida");
                MenuAdmin();
                break;
            }
        }
    }
    public static void MenuManagementUsers() throws IOException {
        String nombre="", especialidad="", idPaciente;
        int countPacientes;
        System.out.println("¿Que tipo de usuario quieres agregar?\n 1) Doctor\n 2) Paciente\n 3) Administrador\n 4) Salir");
        opcion = scanner.readLine();
        switch(opcion.toUpperCase()) {
            case "1": {
                System.out.println("Ingresa el nombre del doctor");
                nombre = scanner.readLine();
                System.out.println("Ingresa la especialidad del doctor");
                especialidad = scanner.readLine();
                if (!nombre.equals("") && !especialidad.equals("")){
                    System.out.println(doctor.NewDoc(nombre,especialidad));
                }else{
                    System.out.println("Debes de llenar todos los campos");
                }
                MenuAdmin();
                break;
            }
            case "2": {
                System.out.println("Ingresa el nombre del paciente");
                nombre = scanner.readLine();
                countPacientes = paciente.CountPacientes()+1;
                idPaciente = nombre + String.format("%02d", countPacientes);
                System.out.println(paciente.NewPaciente(idPaciente,nombre));
                System.out.println("El codigo de identificacion del paciente es: " + idPaciente);
                MenuAdmin();
                break;
            }
            case "3": {

                MenuAdmin();
                break;
            }
            case "4": {

                MenuAdmin();
                break;
            }
            default: {
                System.out.println("Opcion invalida");
                MenuManagementUsers();
            }
        }
    }
    public static void MenuUsuario(){

    }
    public static boolean StartConfig() throws IOException {
        boolean result=false;
        String nombre, pass, repPass;
        System.out.println("Es necesario estableces un administrador para que se pueda ejecutar el programa");
        System.out.println("Ingresa el nombre del Administrador");
        nombre = scanner.readLine();
        System.out.println("Ingresa la contraseña");
        pass = scanner.readLine();
        System.out.println("Repite la contraseña");
        repPass = scanner.readLine();
        if (pass.equals(repPass)){
            System.out.println (admin.NewAdmin(nombre, pass));
        }else {
            System.out.println("Datos incorrectos");
            StartConfig();
        }

        return result;
    }
    public static boolean Login() throws IOException {
        boolean result=false;
        String nombre, pass;
        System.out.println("Ingresa el nombre del Administrador");
        nombre = scanner.readLine();
        System.out.println("Ingresa la contraseña");
        pass = scanner.readLine();
        result = admin.ValidUser(nombre, pass);

        return result;
    }
}