package business.design.implement;

import business.utility.IOFile;
import business.utility.InputMethod;
import business.design.ICategoryDesign;
import business.entity.Category;

import java.util.*;

public class CategoryServiceImpl implements ICategoryDesign {
    public static List<Category> categories;

    static {
        categories = IOFile.readObjectFromFile(IOFile.CATEGORY_PATH);
    }

    @Override
    public Category findById(String id) {
        return categories.stream()
                .filter(t -> t.getCategoryId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void showAll() {
        if (categories.isEmpty()) {
            System.err.println("No have any categories");
        } else {
            System.out.printf("%-6s |%-15s |%-10s |%-30s |%-15s\n",
                    "ID", "CATEGORY NAME", "STATUS", "CREATE DATE","TOTAL PRODUCT");
            categories.forEach(Category::displayData);
        }
    }

    @Override
    public void addNew() {
        System.out.println("Enter the number of category you want to add:");
        byte number = InputMethod.getByte();

        for (int i = 1; i <= number; i++) {
            System.out.println("Enter the information of category " + i);
//            add to file
            Category newCategory = new Category();
            newCategory.inputData(categories,true);
            categories.add(newCategory);
            IOFile.writeObjectToFile(categories,IOFile.CATEGORY_PATH);
        }

        System.out.println("Add successfully!!");
    }

    @Override
    public void edit() {
        System.out.println("Enter the id of category want to edit: ");
        String idEdit = InputMethod.getString();
        if (findById(idEdit) != null) {
            System.out.println("The previous of this category");
            findById(idEdit).displayData();
            findById(idEdit).inputData(categories,false);
            IOFile.writeObjectToFile(categories,IOFile.CATEGORY_PATH);
            System.out.println("Edit successfully!!");
        } else {
            System.err.println("No category found");
        }
    }

    @Override
    public void delete() {
        System.out.println("Enter the id of category want to delete: ");
        String idDelete = InputMethod.getString();
        if (findById(idDelete) != null) {
//       check if it has product it can not delete
            boolean hasProduct = ProductServiceImpl.products.stream()
                    .anyMatch(t -> t.getCategory().getCategoryId().equals(idDelete));
            if (hasProduct) {
                System.err.println("Can not delete this category because it has product");
            } else {
                categories.remove(findById(idDelete));
                IOFile.writeObjectToFile(categories,IOFile.CATEGORY_PATH);
                System.out.println("Delete successfully!!");
            }
        } else {
            System.err.println("No category found");
        }
    }

    public void changeStatus() {
        System.out.println("Enter the id of the category you want to change: ");
        String idChangeStatus = InputMethod.getString();
        if (findById(idChangeStatus) != null) {
            findById(idChangeStatus).setCategoryStatus(!findById(idChangeStatus).isCategoryStatus());
            IOFile.writeObjectToFile(categories,IOFile.CATEGORY_PATH);
            System.out.println("Change status successfully!!");
        } else {
            System.err.println("No category found");
        }
    }

    public void searchByName() {
        System.out.println("Enter category name for search: ");
        String nameSearch = InputMethod.getString();

        System.out.println("Result: ");
        categories.stream()
                .filter(t -> t.getCategoryName().toLowerCase().contains(nameSearch.toLowerCase()))
                .forEach(Category::displayData);

    }

    public void sortByName() {

        if (categories.isEmpty()) {
            System.err.println("No data");
        } else {
            System.out.println("List category sort by name a-z: ");
            categories.sort((o1, o2) -> o1.getCategoryName().compareTo(o2.getCategoryName()));
            categories.forEach(Category::displayData);

        }

    }
}

