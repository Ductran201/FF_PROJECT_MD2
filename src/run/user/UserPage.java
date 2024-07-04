package run.user;


import business.design.implement.CategoryHandleImpl;
import business.design.implement.ProductHandleImpl;
import business.design.implement.UserService;
import business.utility.IOFile;
import business.utility.InputMethod;
import run.FastFood;

public class UserPage {
    CartManagement cartManagement = new CartManagement();
    ProductHandleImpl productHandle = new ProductHandleImpl();
    CategoryHandleImpl categoryHandle = new CategoryHandleImpl();
    UserService userService = new UserService();

    public void openUserPage() {
        System.out.println("WELCOME " + FastFood.userCurrent.getUserName().toUpperCase() + " TO FAST FOOD");
        while (true) {
            System.out.println("==============USER PAGE===================");
            System.out.println("||                                      ||");
            System.out.println("||       1. OPEN MENU                   ||");
            System.out.println("||       2. OPEN MY INFORMATION         ||");
            System.out.println("||       3. OPEN ADDRESS MANAGEMENT     ||");
            System.out.println("||       4. OPEN MY WISHLIST            ||");
            System.out.println("||       5. OPEN CART                   ||");
            System.out.println("||       6. OPEN ORDER HISTORY          ||");
            System.out.println("||       7. SIGN OUT                    ||");
            System.out.println("||                                      ||");
            System.out.println("==========================================");
            System.out.print("Your choice: ");
            byte choice = InputMethod.getByte();
            switch (choice) {
                case 1:
                    openMenu();
                    break;
                case 2:
                    openInform();
                    break;
                case 3:
                    openAddress();
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

    public void openMenu() {
        while (true) {
            System.out.println("==============SHOPPING MENU================");
            System.out.println("||                                       ||");
            System.out.println("||       1. SHOW ALL CATEGORY            ||");
            System.out.println("||       2. SHOW ALL PRODUCT             ||");
            System.out.println("||       3. SEARCH CATEGORY BY NAME      ||");
            System.out.println("||       4. SEARCH PRODUCT BY NAME       ||");
            System.out.println("||       5. SEARCH PRODUCT BY CATEGORY   ||");
            System.out.println("||       6. BACK                         ||");
            System.out.println("||                                       ||");
            System.out.println("===========================================");
            System.out.print("Your choice: ");
            byte choice = InputMethod.getByte();
            switch (choice) {
                case 1:
                    categoryHandle.showAll();
                    break;
                case 2:
                    productHandle.showAll();
                    break;
                case 3:
                    categoryHandle.searchByName();
                    break;
                case 4:
                    productHandle.searchByName();
                    break;
                case 5:
                    productHandle.searchByCategory();
                    break;
                case 6:
                    return;
                default:
                    System.err.println("Wrong input, try again");
            }
        }
    }

    public void openInform() {
        while (true) {
            System.out.println("=============PERSONAL INFORMATION==============");
            System.out.println("||                                           ||");
            System.out.println("||       1. SHOW MY INFORMATION              ||");
            System.out.println("||       2. EDIT MY INFORMATION              ||");
            System.out.println("||       3. SEARCH PRODUCT BY CATEGORY       ||");
            System.out.println("||       4. BACK                             ||");
            System.out.println("||                                           ||");
            System.out.println("==============================================");
            System.out.print("Your choice: ");
            byte choice = InputMethod.getByte();
            switch (choice) {
                case 1:
                    System.out.printf("%-20s |%-20s |%-12s |\n"
                            , "EMAIL", "FULL NAME", "PHONE");
                    FastFood.userCurrent.displayDataUser();
                    break;
                case 2:
                    FastFood.userCurrent.inputData(false);
                    System.out.println("Edit information successfully!!");
                    IOFile.writeObjectToFile(UserService.users,IOFile.USER_PATH);
                    break;
                case 3:
                    break;
                case 4:
                    return;
                default:
                    System.err.println("Wrong input, try again");
            }
        }
    }

    public void openAddress(){
        while (true) {
            System.out.println("=============ADDRESS MANAGEMENT===============");
            System.out.println("||                                           ||");
            System.out.println("||       1. SHOW MY ADDRESS                  ||");
            System.out.println("||       1. SELECT ADDRESS BY ID             ||");
            System.out.println("||       2. ADD NEW ADDRESS                  ||");
            System.out.println("||       3. EDIT ADDRESS                     ||");
            System.out.println("||       4. DELETE ADDRESS                   ||");
            System.out.println("||       5. BACK                             ||");
            System.out.println("||                                           ||");
            System.out.println("==============================================");
            System.out.print("Your choice: ");
            byte choice = InputMethod.getByte();
            switch (choice) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:
                    break;
                case 4:
                    return;
                default:
                    System.err.println("Wrong input, try again");
            }
        }
    }
}
