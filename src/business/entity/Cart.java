package business.entity;

import business.design.implement.CartService;
import business.design.implement.ProductServiceImpl;
import business.utility.InputMethod;
import run.FastFood;

import java.io.Serializable;
import java.util.List;

public class Cart implements Serializable {
    private int cartItemId;
    private User user;
    private Product product;
    private int quantity;

    public Cart() {
    }

    public Cart(int cartItemId, User user, Product product, int quantity) {
        this.cartItemId = cartItemId;
        this.user = user;
        this.product = product;
        this.quantity = quantity;
    }

    public int getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(int cartItemId) {
        this.cartItemId = cartItemId;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void displayData() {
        System.out.println("----------------------------------------------------------------------------");
        System.out.printf("%-5d |%-20s |%-20s |%-15s |%-10s \n"
                , cartItemId, user.getUserFullName(),product.getProductName(), product.getProductPrice(), quantity);
    }

    public void inputData(boolean isAdd, List<Cart> cartList) {
        ProductServiceImpl productHandle = new ProductServiceImpl();

        if (isAdd) {//add
            cartItemId = CartService.getNewId();
            user = FastFood.userCurrent;
            quantity = 1;
            while (true) {
                System.out.println("Choose the id of the product you want add to cart");

                productHandle.showAll();

                int id = InputMethod.getInteger();

                Product productAdd = productHandle.findById(id);

                if (productAdd == null) {
                    System.err.println("No found the product with id " + id);
                } else if (cartList.stream().anyMatch(c -> c.getProduct().getProductId()==id)) {
                    //can not add more because duplicate
                    System.err.println("This product has already been added");
                } else if (productAdd.getStock()>0){
                    product = productHandle.findById(id);
                    break;
                }else {
                    System.err.println("This product is out of stock");
                }
            }

            System.out.println("Add " + product.getProductName() + " successfully to the cart");

        } else {// edit

            while (true) {
                System.out.println("Enter the total quantity of this product you want to order: ");
                int quantityInput = InputMethod.getInteger();

                if (quantityInput > product.getStock()) {
                    System.err.println("This product just have remain "+product.getStock()+ " quantity");
                } else {
                    quantity = quantityInput;
//                    product.setStock(product.getStock() - quantityInput);
                    System.out.println("Edit successfully!!");
                    break;
                }
            }

        }
    }

}


