package CitasClinicas;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Admin {
    public  BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
    File fileAdmin = new File(".\\src\\CitasClinicas\\db\\Admin.csv");
    HashMap<String, String> administradores;
    public Admin(){
        administradores = new HashMap<String, String>();
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
            fileAdmin.createNewFile();
        } catch (IOException e) {
        }
        try {
            Scanner sc = new Scanner(fileAdmin);
            sc.useDelimiter(",");
            while (sc.hasNextLine())
            {
                administrador= sc.nextLine().split(",");
                NewAdmin(administrador[0],administrador[1]);
            }
            sc.close();
            result = true;
        }catch (Exception e) {
            result = false;
        }
        return result;
    }

    public String NewAdmin(String usuario, String pass) {
        String result="";
        try {
            administradores.put(usuario,pass);
            result= "El administrador se ha agregado";
        }catch (Exception e){
            result ="Ocurrio un problema al crear el administrador";
        }

        return result;
    }

    public int CountAdmin(){
        return administradores.size();
    }

    public boolean ValidUser(String usuario, String pass){
        boolean resul= false;

        try {
            for (String i : administradores.keySet()) {
                if (i.equals(usuario) && administradores.get(i).equals(pass)){
                    resul = true;
                    break;
                }
            }
        }catch (Exception e){
        }

        return resul;
    }

    public  String Save(){
        String result="";
        String eol = System.getProperty("line.separator");
        try {
            Writer writer = new FileWriter(fileAdmin);
            for (Map.Entry<String, String> entry : administradores.entrySet()) {
                writer.append(entry.getKey())
                        .append(',')
                        .append(entry.getValue())
                        .append(eol);
            }
            writer.close();
            result= "Se han guardado los cambios";
        }catch (Exception e){
            result ="Ocurrio un problema al guardar los cambios";
        }

        return result;
    }
}
