package ru.gb.family_tree.writer;

import java.io.*;

public class FileHandler implements Writable {
    public void save(Serializable serializable, String filePath) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
        oos.writeObject(serializable);
        oos.close();
    }

    public Object read(String filePath){
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            return objectInputStream.readObject();
        } catch (Exception e){
            e.printStackTrace();
            return  null;
        }
    }
}
