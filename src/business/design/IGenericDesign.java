package business.design;

import java.util.Scanner;

public interface IGenericDesign<T, E> {
    T findById(E id);

    void showAll();

    void addNew();

    void edit();

    void delete();


}
