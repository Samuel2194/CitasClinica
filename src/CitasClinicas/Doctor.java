package CitasClinicas;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Doctor {
    public BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
    File fileDoct = new File(".\\src\\CitasClinicas\\db\\Doctores.csv");
    HashMap<String, String> doctores;
    public Doctor(){
        doctores = new HashMap<String, String>();
    }

    public boolean Load(){
        boolean result =false;
        File path = new File(".\\src\\CitasClinicas\\db");
        String[] doctor;
        if (!path.exists()) {
            if (path.mkdirs()) {
                System.out.println("Directorio creado");
            } else {
                System.out.println("Error al crear directorio");
            }
        }
        try {
            fileDoct.createNewFile();
        } catch (IOException e) {
        }
        try {
            Scanner sc = new Scanner(fileDoct);
            sc.useDelimiter(",");
            while (sc.hasNextLine())
            {
                doctor= sc.nextLine().split(",");
                NewDoc(doctor[0],doctor[1]);
            }
            sc.close();
            result = true;
        }catch (Exception e) {
            result = false;
        }
        return result;
    }

    public String NewDoc(String nombre, String especialidad) {
        String result="";
        try {
            doctores.put(nombre,especialidad);
            result= "El doctor se ha agregado";
        }catch (Exception e){
            result ="Ocurrio un problema al crear el doctor";
        }

        return result;
    }

    public int CountDoctores(){
        return doctores.size();
    }

    public ArrayList<String> VerEspecialidades(){
        ArrayList<String> especialidades = new ArrayList<>();

        for (String i : doctores.keySet()) {
            if (!especialidades.contains(doctores.get(i))){
                especialidades.add(doctores.get(i));
            }
        }

        return especialidades;
    }

    public ArrayList<String> VerDoctoresEspecialidad(String especialidad){
        ArrayList<String> dctoresEspecialidad = new ArrayList<>();

        for (String i : doctores.keySet()) {
            if (doctores.get(i).contains(especialidad)){
                dctoresEspecialidad.add(i);
            }
        }

        return dctoresEspecialidad;
    }
}
