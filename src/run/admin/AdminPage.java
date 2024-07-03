package run.admin;

import business.utility.InputMethod;

public class AdminPage {
    CategoryManagement categoryManagement = new CategoryManagement();
    ProductManagement productManagement = new ProductManagement();
    AccountManagement accountManagement = new AccountManagement();

    public void openAdminPage() {

        while (true) {
            System.out.println("=================ADMIN PAGE=================");
            System.out.println("||                                        ||");
            System.out.println("||        1. OPEN ACCOUNT MANAGEMENT      ||");
            System.out.println("||        2. OPEN CATEGORY MANAGEMENT     ||");
            System.out.println("||        3. OPEN PRODUCT MANAGEMENT      ||");
            System.out.println("||        4. SIGN OUT                     ||");
            System.out.println("||                                        ||");
            System.out.println("============================================");
            System.out.print("Your choice: ");
            byte choice = InputMethod.getByte();
            switch (choice) {
                case 1:
                    accountManagement.openAccountManagement();
                    break;
                case 2:
                    categoryManagement.openCategoryManagement();
                    break;
                case 3:
                    productManagement.openProductManagement();
                    break;
                case 4:
                    System.out.println("ACCOUNT HAS BEEN LOGGED OUT");
                    return;
            }
        }
    }
}
