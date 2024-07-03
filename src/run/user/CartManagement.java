package run.user;

import business.design.implement.CartServiceImpl;
import business.utility.InputMethod;

public class CartManagement {
    CartServiceImpl cartServiceImpl = new CartServiceImpl();

    public void openCartManagement() {
        while (true) {
            System.out.println("==============CART MANAGEMENT==============");
            System.out.println("||                                       ||");
            System.out.println("||     1. SHOW ALL CART                  ||");
            System.out.println("||     2. ADD ONE PRODUCT TO CARD        ||");
            System.out.println("||     3. UPDATE QUANTITY OF CART ITEM   ||");
            System.out.println("||     4. DELETE ONE PRODUCT FROM CART   ||");
            System.out.println("||     5. DELETE ALL ITEMS FROM CART     ||");
            System.out.println("||     6. BACK                           ||");
            System.out.println("||                                       ||");
            System.out.println("===========================================");
            System.out.print("Your choice: ");
            byte choice = InputMethod.getByte();
            switch (choice) {
                case 1:
                    cartServiceImpl.showAll();
                    break;
                case 2:
                    cartServiceImpl.addNew();
                    break;
                case 3:
                    cartServiceImpl.edit();
                    break;
                case 4:
                    cartServiceImpl.delete();
                    break;
                case 5:
                    cartServiceImpl.deleteAllCart();
                    break;
                case 6:
                    return;
                default:
                    System.err.println("Wrong input");
            }
        }
    }
}
