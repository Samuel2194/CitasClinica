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
        String[] paciente;
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
                paciente= sc.nextLine().split(",");
                NewPaciente(paciente[0],paciente[1]);
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

    public boolean ValidPaciente(String idPaciente){
        boolean resul= false;

        try {
            for (String i : pacientes.keySet()) {
                if (i.equals(idPaciente)){
                    resul = true;
                    break;
                }
            }
        }catch (Exception e){
        }

        return resul;
    }

    public  String NombrePaciente(String idPaciente) {
        String paciente="";
        try {
            for (String i : pacientes.keySet()) {
                if (i.equals(idPaciente)){
                    paciente = pacientes.get(i);
                    break;
                }
            }
        }catch (Exception e){
        }

        return paciente;
    }
}
