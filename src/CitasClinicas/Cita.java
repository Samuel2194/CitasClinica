package CitasClinicas;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
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

    public String AgregarDoctor(int idCita, String doctor){
        String result="";
        String[] usuarioCita, nuevoUsuarioCita = new String[5];
        try {
            usuarioCita = citas.get(idCita);
            nuevoUsuarioCita[0]=usuarioCita[0];
            nuevoUsuarioCita[1]=usuarioCita[1];
            nuevoUsuarioCita[2]=usuarioCita[2];
            nuevoUsuarioCita[3]=usuarioCita[3];
            nuevoUsuarioCita[4] = doctor;
            citas.set(idCita,nuevoUsuarioCita);
            result ="Se agrego el doctor a la cita";
        }catch (Exception e){
            result="Ocurrio un problema al agregar el doctor a la cita";
        }
        return result;
    }

    public ArrayList<String> CitasSinDoctor(){
        ArrayList<String> newUserCita = new ArrayList<>();
        String[]userCita;
        ArrayList<String> result=null;
        for (int i=0;i <citas.size();i++){
           if(citas.get(i).length==4){
               userCita=citas.get(i);
               newUserCita.add(Integer.toString(i));
               newUserCita.add(userCita[0]);
               newUserCita.add(userCita[1]);
               newUserCita.add(userCita[2]);
               newUserCita.add(userCita[3]);
               result =newUserCita;
               break;
           }
        }
        return result;
    }
}
