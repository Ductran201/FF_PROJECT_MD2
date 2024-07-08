package run.admin;

import business.utility.InputMethod;
import business.design.implement.CategoryServiceImpl;

public class CategoryManagement {
    CategoryServiceImpl categoryServiceImpl =new CategoryServiceImpl();
    public void openCategoryManagement() {
        while (true){
            System.out.println("============CATEGORY MANAGEMENT==========================");
            System.out.println("||                                                     ||");
            System.out.println("||       1. SHOW ALL CATEGORIES                        ||");
            System.out.println("||       2. ADD NEW CATEGORY                           ||");
            System.out.println("||       3. UPDATE THE CATEGORY                        ||");
            System.out.println("||       4. DELETE THE CATEGORY                        ||");
            System.out.println("||       5. CHANGE STATUS CATEGORY                     ||");
            System.out.println("||       6. SEARCH NAME CATEGORY                       ||");
            System.out.println("||       7. SORT CATEGORY NAME FOR A-Z                 ||");
            System.out.println("||       8. SORT CATEGORY BY TOTAL PRODUCT DESCENDING  ||");
            System.out.println("||       9. BACK                                       ||");
            System.out.println("||                                                     ||");
            System.out.println("==========================================================");
            System.out.print("Your choice: ");
            byte choice = InputMethod.getByte();
            switch (choice) {
                case 1:
                    categoryServiceImpl.showAll();
                    break;
                case 2:
                    categoryServiceImpl.addNew();
                    break;
                case 3:
//                    if change name category -> not update name cate in product
                    categoryServiceImpl.edit();
                    break;
                case 4:
                    categoryServiceImpl.delete();
                    break;
                case 5:
                    categoryServiceImpl.changeStatus();
                    break;
                case 6:
                    categoryServiceImpl.searchByName();
                    break;
                case 7:
                    categoryServiceImpl.sortByName();
                    break;
                case 8:
                    categoryServiceImpl.sortByTotalProduct();
                    break;
                case 9:
                    return;
            }
        }

    }
}
