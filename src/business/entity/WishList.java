package business.entity;

import business.design.implement.AddressServiceImpl;
import business.design.implement.ProductServiceImpl;
import business.design.implement.WishListService;
import business.utility.InputMethod;
import run.FastFood;

import java.io.Serializable;
import java.util.List;

public class WishList implements Serializable {
    private int idWishList;
    private User user;
    private Product product;

    public WishList() {
    }

    public WishList(int idWishList, User user, Product product) {
        this.idWishList = idWishList;
        this.user = user;
        this.product = product;
    }

    public int getIdWishList() {
        return idWishList;
    }

    public void setIdWishList(int idWishList) {
        this.idWishList = idWishList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void displayData() {
        System.out.println("--------------------------------------------------------------------");
        System.out.printf("%-5s |%-20s |%-20s |%-15s |\n"
                ,idWishList, user.getUserFullName(), product.getProductName(), product.getProductPrice());

    }

    public void inputData(List<WishList> wishList) {
        idWishList = WishListService.getNewId();
        user = FastFood.userCurrent;
        product = validateProductWishList(wishList);
    }

    public Product validateProductWishList(List<WishList> wishList) {
        while (true) {
            ProductServiceImpl productService = new ProductServiceImpl();
            System.out.println("Enter the id of product");
            int idProductInput = InputMethod.getInteger();
//check duplicate in wish list
            boolean existProduct = ProductServiceImpl.products.stream()
                    .anyMatch(p -> p.getProductId() == idProductInput);
            boolean duplicateWishList = wishList.stream()
                    .anyMatch(w -> w.getProduct().getProductId() == idProductInput);
            if (existProduct){
                if (duplicateWishList){
                    System.err.println("WishList is already exist");
                }else {
                    return productService.findById(idProductInput);
                }
            }else {
                System.err.println("Product does not exist");
            }

        }
    }


}
