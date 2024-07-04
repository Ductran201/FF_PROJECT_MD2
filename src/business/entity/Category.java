package business.entity;

import business.design.implement.CategoryHandleImpl;
import business.design.implement.ProductHandleImpl;
import business.utility.InputMethod;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Category implements Serializable {
    private String categoryId;
    private String categoryName;
    private boolean categoryStatus;
    private Date createDate;
    private int totalProduct;
    ;

    public Category() {
    }

    public Category(String categoryId, String categoryName, boolean categoryStatus, Date createDate, int totalProduct) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryStatus = categoryStatus;
        this.createDate = createDate;
        this.totalProduct = totalProduct;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public boolean isCategoryStatus() {
        return categoryStatus;
    }

    public void setCategoryStatus(boolean categoryStatus) {
        this.categoryStatus = categoryStatus;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getTotalProduct() {
        return totalProduct;
    }

    public void setTotalProduct(int totalProduct) {
        this.totalProduct = totalProduct;
    }

    public void displayData() {
        System.out.println("----------------------------------------------------------------------------------");
        System.out.printf("%-6s |%-15s |%-10s |%-30s |%-15d\n",
                categoryId, categoryName, categoryStatus ? "Active" : "Block", createDate, totalProduct);
    }

    public void updateTotalProduct() {
        System.out.println(ProductHandleImpl.products);
        System.out.println(CategoryHandleImpl.categories);
        int count = (int) ProductHandleImpl.products.stream()
                .filter(p -> p.getCategory().getCategoryId().equals(this.categoryId))
                .count();
        this.totalProduct = count;
    }

    public void inputData(List<Category> categories, boolean isAdd) {
        if (isAdd) {
            categoryId = validateCategoryId(categories);
            categoryStatus = true;
            totalProduct = 0;
        }
        categoryName = validateCategoryName(categories);
        createDate = new Date();
    }

//    VALIDATE INPUT

    private String validateCategoryId(List<Category> categories) {
        final String regexCategoryId = "^C.{3}$";
        while (true) {
            System.out.println("Enter the id of the category:");
            String categoryIdInput = InputMethod.getString();
            if (categoryIdInput.matches(regexCategoryId)) {
//                Match regex => check duplicate
                if (categories.stream().noneMatch(t -> t.categoryId.equals(categoryIdInput))) {
                    return categoryIdInput;
                } else {
                    System.err.println("The id " + categoryIdInput + " has already exist, please enter again.");
                }
            } else {
                System.err.println("The Id of category must have only 4 char and begin with 'C'");
            }
        }
    }

    private String validateCategoryName(List<Category> categories) {
        while (true) {
            System.out.println("Enter the name of the category:");
            String categoryNameInput = InputMethod.getString();

            if (categories.stream().noneMatch(t -> t.categoryId.equals(categoryNameInput))) {
                return categoryNameInput;
            } else {
                System.err.println("The name has already exist, please enter again.");
            }

        }
    }

}
