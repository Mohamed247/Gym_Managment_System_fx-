package DataModels;

import java.io.*;
import java.util.ArrayList;

public class WriterReaderSingleton{

    private static final WriterReaderSingleton instance = new WriterReaderSingleton();

    //private constructor to avoid client applications to use constructor
    private WriterReaderSingleton(){}

    public static WriterReaderSingleton getInstance(){
        return instance;
    }

    public ArrayList<Object> readAllMembersFromFile(String filePath){
        ArrayList<Object> arrayList = new ArrayList<>();

        try{

            FileInputStream fi = new FileInputStream(filePath);
            ObjectInputStream oi = new ObjectInputStream(fi);


            while (true){
                Object object;
                try{
                    object  = oi.readObject();
                    arrayList.add(object);
                }catch(Exception e){
                    //failed to read object as reached the final line
                    break;
                }
            }
            oi.close();
            fi.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return arrayList;
    }
    public void writeObjectsToFile(String filePath, ArrayList<Object> objectArrayList){
        try {
            //clearTextFile(filePath);
            FileOutputStream fo = new FileOutputStream(filePath);
            ObjectOutputStream oo = new ObjectOutputStream(fo);

            // Write objects to file
            for (Object object: objectArrayList){
                oo.writeObject(object);
            }
            oo.close();
            fo.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void clearTextFile(String filePath){
        try{
            PrintWriter writer = new PrintWriter(filePath);
            writer.print("");
            writer.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}