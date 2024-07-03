package run.admin;

import business.design.implement.CategoryHandleImpl;
import business.utility.InputMethod;
import business.design.implement.ProductHandleImpl;


public class ProductManagement {
    ProductHandleImpl productHandleImpl = new ProductHandleImpl();

    public void openProductManagement() {
        while (true) {
            System.out.println("===========PRODUCT MANAGEMENT=============");
            System.out.println("||                                      ||");
            System.out.println("||     1. SHOW ALL CATEGORIES           ||");
            System.out.println("||     2. SHOW ALL PRODUCTS             ||");
            System.out.println("||     3. ADD NEW PRODUCT               ||");
            System.out.println("||     4. UPDATE THE PRODUCT            ||");
            System.out.println("||     5. REMOVE THE PRODUCT            ||");
            System.out.println("||     6. CHANGE STATUS PRODUCT         ||");
            System.out.println("||     7. SEARCH WITH NAME PRODUCT      ||");
            System.out.println("||     8. PRODUCT WITH RANGE PRICE      ||");
            System.out.println("||     9. BACK                          ||");
            System.out.println("||                                      ||");
            System.out.println("==========================================");
            System.out.print("Your choice: ");
            byte choice = InputMethod.getByte();
            switch (choice) {
                case 1:
                    new CategoryHandleImpl().showAll();
                    break;
                case 2:
                    productHandleImpl.showAll();
                    break;
                case 3:
                    productHandleImpl.addNew();
                    break;
                case 4:
                    productHandleImpl.edit();
                    break;
                case 5:
                    productHandleImpl.delete();
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    return;
            }
        }

    }
}
