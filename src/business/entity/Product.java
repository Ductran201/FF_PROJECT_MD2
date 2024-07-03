package business.entity;

import business.design.implement.ProductHandleImpl;
import business.utility.InputMethod;

import java.io.Serializable;
import java.util.List;

public class Product implements Serializable {

    private int productId;
    private String productName;
    private int productPrice;
    private boolean productStatus;
    private Category category;
    private int stock;

    public Product() {
    }

    public Product(int productId, String productName, int productPrice, boolean productStatus, Category category, int stock) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productStatus = productStatus;
        this.category = category;
        this.stock = stock;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void displayData() {
        System.out.println("------------------------------------------------" +
                "--------------------------------------------------");
        System.out.printf("%-10s |%-15s |%-15d |%-10s |%-20s |%-15s |\n", productId, productName,
                productPrice, stock, category.getCategoryName(), productStatus ? "Stocking" : "Out of stock");

    }


    public void inputData(List<Product> products, List<Category> categories, boolean isAdd) {

        if (isAdd) {
            productId = ProductHandleImpl.getNewId();
            productStatus = true;
        }

        System.out.println("Enter the name of product");
        productName = validateProductName(products);
        System.out.println("Enter the price of product");
        productPrice = validateProductPrice();
        stock = validateStock();
        System.out.println("Enter the category of product");

        for (int i = 0; i < categories.size(); i++) {
            System.out.printf("%-5d |%-15s \n", (i + 1), categories.get(i).getCategoryName());
        }

        while (true) {
            System.out.println("Choose category by the number ");
            short number = InputMethod.getShort();

            if (number > categories.size()) {
                System.out.println("number is invalid");
//            Duc code
            }
//        else if (category == categories.get(number - 1)) {
////            nothing happened because no change the category
//        }
            else { // change category
                Category oldCategory = category;
                category = categories.get(number - 1);
                if (oldCategory != null) {//edit has old category
                    oldCategory.updateTotalProduct();
                }
                category.updateTotalProduct();
                break;

//            if (isAdd) {
//                // add product => increase the total product in category
//                category.setTotalProduct(category.getTotalProduct() + 1);
//                IOFile.writeObjectToFile(categories,IOFile.CATEGORY_PATH);
//            } else {
////                total product of old cat decrease
//                oldCategory.setTotalProduct(oldCategory.getTotalProduct() - 1);
////                total product of new cat increase
//                category.setTotalProduct(category.getTotalProduct() + 1);
//                IOFile.writeObjectToFile(categories,IOFile.CATEGORY_PATH);
//            }
            }

        }
        System.out.println("=====================================");
    }

    //VALIDATE INPUT
    private String validateProductName(List<Product> products) {

        while (true) {
            String productNameInput = InputMethod.getString();
            if (products.stream().noneMatch(t -> t.productName.equals(productNameInput))) {
                return productNameInput;
            } else {
                System.err.println("Product name is already has, please try again");
            }
        }

    }

    private int validateProductPrice() {

        while (true) {
            int productPriceInput = InputMethod.getInteger();
            if (productPriceInput >= 0) {
                return productPriceInput;
            } else {
                System.err.println("Price of product must >= 0, please try again");

            }
        }
    }

    private int validateStock() {
        while (true) {
            System.out.println("Enter the stock of product: ");
            int productStockInput = InputMethod.getInteger();
            if (productStockInput < 10) {
                System.err.println("The price of product must >= 10 !");
            } else {
                return productStockInput;
            }
        }
    }

}
