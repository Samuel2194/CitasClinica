package CitasClinicas;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class Doctor {
    public BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
    File fileDoct = new File(".\\src\\CitasClinicas\\db\\Doctor.csv");
    HashMap<String, String> doctores;
    public Doctor(){
        doctores = new HashMap<String, String>();
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
            fileDoct.createNewFile();
        } catch (IOException e) {
        }
        try {
            Scanner sc = new Scanner(fileDoct);
            sc.useDelimiter(",");
            while (sc.hasNextLine())
            {
                administrador= sc.nextLine().split(",");
                NewDoc(administrador[0],administrador[1]);
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
}
