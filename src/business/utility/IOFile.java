package business.utility;

import business.entity.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOFile {
//    constant path of list object

    public static final String USER_PATH = "src/business/data/User.txt";
    public static final String CATEGORY_PATH = "src/business/data/Category.txt";
    public static final String PRODUCT_PATH = "src/business/data/Product.txt";
    public static final String CART_PATH = "src/business/data/Cart.txt";

    public static<T> void writeObjectToFile(List<T> list, String path ){
        File file=new File(path);

        FileOutputStream fos=null;
        ObjectOutputStream oos= null;

        try {
            fos=new FileOutputStream(file);
            oos =new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static<T> List<T> readObjectFromFile(String path){
        File file=new File(path);
        FileInputStream fis=null;
        ObjectInputStream ois=null;
        List<T> list = new ArrayList<>();

        try {
            fis=new FileInputStream(file);
            ois=new ObjectInputStream(fis);
            list = (List<T>) ois.readObject();
            ois.close();
        } catch (IOException| ClassNotFoundException e) {

        }

        return list;
    }
}
