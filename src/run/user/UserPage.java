package run.user;


import business.entity.Product;
import business.design.implement.ProductHandleImpl;
import business.utility.InputMethod;

public class UserPage {
    CartManagement cartManagement = new CartManagement();
    public void openUserPage(){
        while (true){
            System.out.println("==============USER PAGE===================");
            System.out.println("||                                      ||");
            System.out.println("||       1. SHOW ALL PRODUCTS           ||");
            System.out.println("||       2. OPEN MY INFORMATION         ||");
            System.out.println("||       3. OPEN MY WISHLIST            ||");
            System.out.println("||       4. OPEN CART                   ||");
            System.out.println("||       5. OPEN ORDER HISTORY          ||");
            System.out.println("||       6. SIGN OUT                    ||");
            System.out.println("||                                      ||");
            System.out.println("==========================================");
            System.out.print("Your choice: ");
            byte choice = InputMethod.getByte();
            switch (choice) {
                case 1:
                    System.out.printf("%-10s |%-15s |%-15s |%-10s |%-20s |%-15s |\n",
                            "ID", "NAME", "PRICE", "STOCK", "CATEGORY", "STATUS");
                    ProductHandleImpl.products.forEach(Product::displayData);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    cartManagement.openCartManagement();
                    break;
                case 5:
                    break;
                case 6:
                    return;
                default:
                    System.err.println("Wrong input, try again");
            }
        }
    }
}
