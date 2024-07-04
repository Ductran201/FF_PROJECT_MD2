package run.admin;

import business.utility.InputMethod;
import business.design.implement.CategoryHandleImpl;

public class CategoryManagement {
    CategoryHandleImpl categoryHandleImpl =new CategoryHandleImpl();
    public void openCategoryManagement() {
        while (true){
            System.out.println("============CATEGORY MANAGEMENT=============");
            System.out.println("||                                        ||");
            System.out.println("||       1. SHOW ALL CATEGORIES           ||");
            System.out.println("||       2. ADD NEW CATEGORY              ||");
            System.out.println("||       3. UPDATE THE CATEGORY           ||");
            System.out.println("||       4. DELETE THE CATEGORY           ||");
            System.out.println("||       5. CHANGE STATUS CATEGORY        ||");
            System.out.println("||       6. SEARCH NAME CATEGORY          ||");
            System.out.println("||       7. SORT CATEGORY NAME FOR A-Z    ||");
            System.out.println("||       8. pendi                         ||");
            System.out.println("||       9. BACK                          ||");
            System.out.println("||                                        ||");
            System.out.println("============================================");
            System.out.print("Your choice: ");
            byte choice = InputMethod.getByte();
            switch (choice) {
                case 1:
                    categoryHandleImpl.showAll();
                    break;
                case 2:
                    categoryHandleImpl.addNew();
                    break;
                case 3:
                    categoryHandleImpl.edit();
                    break;
                case 4:
                    categoryHandleImpl.delete();
                    break;
                case 5:
                    categoryHandleImpl.changeStatus();
                    break;
                case 6:
                    categoryHandleImpl.searchByName();
                    break;
                case 7:
                    categoryHandleImpl.sortByName();
                    break;
                case 8:
                    break;
                case 9:
                    return;
            }
        }

    }
}
