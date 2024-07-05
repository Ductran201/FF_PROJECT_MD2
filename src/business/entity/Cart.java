package business.entity;

import business.design.implement.CartServiceImpl;
import business.design.implement.ProductServiceImpl;
import business.utility.InputMethod;

import java.io.Serializable;
import java.util.List;

public class Cart implements Serializable {
    private int cartItemId;
    private Product product;
    private int price;
    private int quantity;

    public Cart() {
    }

    public Cart(int cartItemId, Product product, int price, int quantity) {
        this.cartItemId = cartItemId;
        this.product = product;
        this.price = price;
        this.quantity = quantity;
    }

    public int getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(int cartItemId) {
        this.cartItemId = cartItemId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void displayData() {
        System.out.println("---------------------------------------------------------");
        System.out.printf("%-5d |%-20s |%-20d |%5d \n"
                , cartItemId, product.getProductName(), price, quantity);
    }

    public void inputData(boolean isAdd, List<Cart> cartList) {
        ProductServiceImpl productHandle = new ProductServiceImpl();

        if (isAdd) {//add
            cartItemId = CartServiceImpl.getNewId();
            quantity = 1;
            while (true) {
                System.out.println("Choose the id of the product you want add to cart");

                productHandle.showAll();

                int id = InputMethod.getInteger();

                if (productHandle.findById(id) == null) {
                    System.err.println("No found the product with id " + id);
                } else if (cartList.stream().anyMatch(c -> c.getProduct().equals(productHandle.findById(id)))) {
                    //can not add more because duplicate
                    System.err.println("This product has already been added");
                } else if (product.getStock()>0){
                    product = productHandle.findById(id);
                    price = productHandle.findById(id).getProductPrice();
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
                    System.err.println("Product have not enough stock to add " + quantityInput + " quantity");
                } else {
                    quantity = quantityInput;
                    product.setStock(product.getStock() - quantityInput);
                    System.out.println("Edit successfully!!");
                    break;
                }
            }

        }
    }

}


