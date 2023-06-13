package CitasClinicas;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class Paciente {
    public BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
    File filePaciente = new File(".\\src\\CitasClinicas\\db\\Pacientes.csv");
    HashMap<String, String> pacientes;
    public Paciente(){
        pacientes = new HashMap<String, String>();
    }

    public boolean Load(){
        boolean result =false;
        File path = new File(".\\src\\CitasClinicas\\db");
        String[] administrador;
        if (!path.exists()) {
            if (path.mkdirs()) {
                System.out.println("Directorio creado");
            } else {
                System.out.println("Error al crear directorio");
            }
        }
        try {
            filePaciente.createNewFile();
        } catch (IOException e) {
        }
        try {
            Scanner sc = new Scanner(filePaciente);
            sc.useDelimiter(",");
            while (sc.hasNextLine())
            {
                administrador= sc.nextLine().split(",");
                NewPaciente(administrador[0],administrador[1]);
            }
            sc.close();
            result = true;
        }catch (Exception e) {
            result = false;
        }
        return result;
    }

    public String NewPaciente(String id, String nombre) {
        String result="";
        try {
            pacientes.put(id,nombre);
            result= "El paciente se ha agregado";
        }catch (Exception e){
            result ="Ocurrio un problema al crear el paciente";
        }

        return result;
    }

    public int CountPacientes(){
        return pacientes.size();
    }
}
