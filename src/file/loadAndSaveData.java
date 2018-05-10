package file;

import domain.SaveData;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
     * Clase que se utiliza para cargar o guardar una imagen
     *
     *
     * @author DiegoVega, Melissa Ramirez, Melvin Astorga
     * @version 1.0
     */


public class loadAndSaveData {

    /**
     * Metodo para guardar una imagen
     *
     *
     * @author DiegoVega, Melissa Ramirez, Melvin Astorga
     * @version 1.0
     */

    
    public static void save(Serializable data, String name) throws IOException {
        File fl = new File(name);
        FileOutputStream fos = new FileOutputStream(fl, false);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(data);

    }

    /**
     * Metodo para cargar una imagen
     *
     *
     * @author DiegoVega, Melissa Ramirez, Melvin Astorga
     * @version 1.0
     */

    
    public static Object load(String name) throws IOException, ClassNotFoundException {
        SaveData data = null;
        try {
            File fl = new File(name);
            FileInputStream fis = new FileInputStream(fl);
            ObjectInputStream ois = new ObjectInputStream(fis);
            return (SaveData) ois.readObject();
        } catch (FileNotFoundException fln) {
            System.out.println("file no founded");
        }

        return data;
    }
}
