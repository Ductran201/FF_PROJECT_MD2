package run.user;


import business.design.implement.*;
import business.utility.IOFile;
import business.utility.InputMethod;
import run.FastFood;

public class UserPage {
    CartManagement cartManagement = new CartManagement();
    ProductServiceImpl productHandle = new ProductServiceImpl();
    CategoryServiceImpl categoryHandle = new CategoryServiceImpl();
    UserService userService = new UserService();
    AddressServiceImpl addressService = new AddressServiceImpl();
    WishListService wishListService = new WishListService();
    OrderService orderService = new OrderService();

    public void openUserPage() {
        System.out.println("WELCOME " + FastFood.userCurrent.getUserFullName().toUpperCase() + " TO FAST FOOD");
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
                    openWishList();
                    break;
                case 5:
                    cartManagement.openCartManagement();
                    break;
                case 6:
                    openOrderManagement();
                    break;
                case 7:
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
            System.out.println("||       3. BACK                             ||");
            System.out.println("||                                           ||");
            System.out.println("==============================================");
            System.out.print("Your choice: ");
            byte choice = InputMethod.getByte();
            switch (choice) {
                case 1:
                    System.out.printf("%-20s |%-20s |%-12s |%-15s\n"
                            , "EMAIL", "FULL NAME", "PHONE", "TOTAL ADDRESS");
                    FastFood.userCurrent.displayDataUser();
                    break;
                case 2:
                    FastFood.userCurrent.inputData(false);
                    System.out.println("Edit information successfully!!");
                    IOFile.writeObjectToFile(UserService.users, IOFile.USER_PATH);
                    break;
                case 3:
                    return;
                default:
                    System.err.println("Wrong input, try again");
            }
        }
    }

    public void openAddress() {

        while (true) {
            System.out.println("=============ADDRESS MANAGEMENT===============");
            System.out.println("||                                           ||");
            System.out.println("||       1. SHOW MY ADDRESS                  ||");
            System.out.println("||       2. SELECT ADDRESS BY ID             ||");
            System.out.println("||       3. ADD NEW ADDRESS                  ||");
            System.out.println("||       4. EDIT ADDRESS                     ||");
            System.out.println("||       5. DELETE ADDRESS                   ||");
            System.out.println("||       6. BACK                             ||");
            System.out.println("||                                           ||");
            System.out.println("==============================================");
            System.out.print("Your choice: ");
            byte choice = InputMethod.getByte();
            switch (choice) {
                case 1:
                    addressService.showAll();
                    break;
                case 2:
                    addressService.selectById();
                    break;
                case 3:
                    addressService.addNew();
                    break;
                case 4:
                    addressService.edit();
                    break;
                case 5:
                    addressService.delete();
                    break;
                case 6:
                    return;
                default:
                    System.err.println("Wrong input, try again");
            }
        }
    }

    public void openWishList() {
        while (true) {
            System.out.println("================WISH LIST =================");
            System.out.println("||                                        ||");
            System.out.println("||       1. SHOW MY WISH LIST             ||");
            System.out.println("||       2. ADD PRODUCT TO WISHLIST       ||");
            System.out.println("||       3. DELETE PRODUCT FROM WISH LIST ||");
            System.out.println("||       4. BACK                          ||");
            System.out.println("||                                        ||");
            System.out.println("===========================================");
            System.out.print("Your choice: ");
            byte choice = InputMethod.getByte();
            switch (choice) {
                case 1:
                    wishListService.showAll();
                    break;
                case 2:
                    wishListService.addNew();
                    break;
                case 3:
                    wishListService.delete();
                    break;
                case 4:
                    return;
                default:
                    System.err.println("Wrong input, try again");
            }
        }
    }

    public void openOrderManagement() {
        while (true) {
            System.out.println("================ORDER HISTORY===============");
            System.out.println("||                                        ||");
            System.out.println("||       1. SHOW ALL ORDER HISTORY        ||");
            System.out.println("||       2. BACK                          ||");
            System.out.println("||                                        ||");
            System.out.println("===========================================");
            System.out.print("Your choice: ");
            byte choice = InputMethod.getByte();
            switch (choice) {
                case 1:
                    orderService.showAll();
                    break;
                case 2:
                    return;
                default:
                    System.err.println("Wrong input, try again");
            }
        }

    }

}
