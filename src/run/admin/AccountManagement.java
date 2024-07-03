package run.admin;

import business.design.implement.UserService;
import business.utility.InputMethod;

public class AccountManagement {
    UserService userService = new UserService();

    public void openAccountManagement(){
        while (true){
            System.out.println("===========ACCOUNT MANAGEMENT=============");
            System.out.println("||                                      ||");
            System.out.println("||     1. SHOW ALL ACCOUNT              ||");
            System.out.println("||     2. CHANGE STATUS ACCOUNT         ||");
            System.out.println("||     3. SEARCH ACCOUNT BY NAME        ||");
            System.out.println("||     4. SORT NAME ACCOUNT FOR A-Z     ||");
            System.out.println("||     5. SHOW 5 ACCOUNT PER PAGE       ||");
            System.out.println("||     6. BACK                          ||");
            System.out.println("||                                      ||");
            System.out.println("==========================================");
            System.out.print("Your choice: ");
            byte choice = InputMethod.getByte();
            switch (choice) {
                case 1:
                    userService.showAllAccount();
                    break;
                case 2:
                    userService.changeStatus();
                    break;
                case 3:
                    userService.searchByName();
                    break;
                case 4:
                    userService.sortByName();
                    break;
                case 5:

                    break;
                case 6:
                    return;
                default:
                    System.err.println("Wrong input");
            }
        }
    }
}
