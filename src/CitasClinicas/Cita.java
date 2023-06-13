package CitasClinicas;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

public class Cita {
    public BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
    File fileCita = new File(".\\src\\CitasClinicas\\db\\Citas.csv");
    ArrayList<String[]> citas;
    public Cita(){
        citas = new ArrayList<>();
    }

    public boolean Load(){
        boolean result =false;
        File path = new File(".\\src\\CitasClinicas\\db");
        String[] cita;
        if (!path.exists()) {
            if (path.mkdirs()) {
                System.out.println("Directorio creado");
            } else {
                System.out.println("Error al crear directorio");
            }
        }
        try {
            fileCita.createNewFile();
        } catch (IOException e) {
        }
        try {
            Scanner sc = new Scanner(fileCita);
            sc.useDelimiter(",");
            while (sc.hasNextLine())
            {
                cita= sc.nextLine().split(",");
                NewCita(cita);
            }
            sc.close();
            result = true;
        }catch (Exception e) {
            result = false;
        }
        return result;
    }

    public String NewCita(String[] cita) {
        String result="";
        try {
            citas.add(cita);
            result= "La cita se ha agregado";
        }catch (Exception e){
            result ="Ocurrio un problema al crear la cita";
        }

        return result;
    }
}
