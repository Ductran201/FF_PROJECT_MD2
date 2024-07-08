package business.design.implement;

import business.entity.Cart;
import business.utility.IOFile;
import business.utility.InputMethod;
import run.FastFood;

import java.util.Comparator;
import java.util.List;

public class CartService {

    public static List<Cart> carts;

    static {
        carts = IOFile.readObjectFromFile(IOFile.CART_PATH);
    }


    public Cart findById(Integer id, List<Cart> list) {
//        return carts.stream().filter(c->c.getCartItemId()==id).findFirst().get();
        return list.stream().filter(c -> c.getCartItemId() == id).findFirst().orElse(null);
    }

    public void showAll() {
        if (!getListCartPerUser().isEmpty()) {
            System.out.printf("%-5S |%-20s |%-20s |%-15s |%-10s \n"
                    , "ID", "USER NAME","PRODUCT", "PRICE", "QUANTITY");
            getListCartPerUser().forEach(Cart::displayData);
        } else {
            System.err.println("No have any cart items");
        }
    }

    public void addNew() {
        Cart newCart = new Cart();
        newCart.inputData(true, getListCartPerUser());
        carts.add(newCart);
        IOFile.writeObjectToFile(carts, IOFile.CART_PATH);
        System.out.println("Add new cart successfully");
    }

    public void edit() {
        System.out.println("Enter the id of cart item to edit quantity: ");
        int id = InputMethod.getInteger();
        Cart cartItemEdit = findById(id,getListCartPerUser());
        if (cartItemEdit != null) {
            System.out.println("The previous information of this cart item: ");
            cartItemEdit.displayData();
            cartItemEdit.inputData(false, carts);
            IOFile.writeObjectToFile(carts, IOFile.CART_PATH);
        } else {
            System.err.println("No found cart with id " + id);
        }

    }

    public void delete() {
        System.out.println("Enter the id of cart item to delete");
        int id = InputMethod.getInteger();
        Cart cartItemDelete = findById(id,getListCartPerUser());
        if (cartItemDelete != null) {
            carts.remove(cartItemDelete);
            IOFile.writeObjectToFile(carts, IOFile.CART_PATH);
            System.out.println("Delete successful");

        } else {
            System.err.println("No found cart with id " + id);
        }
    }

    public void deleteAllCart() {
        System.err.println("Do you continue to delete all cart items(True:Yes/false:No)");
        if (InputMethod.getBoolean()) {
            getListCartPerUser().clear();
            IOFile.writeObjectToFile(getListCartPerUser(), IOFile.CART_PATH);
            System.out.println("Delete all items of cart successfully");
        }
    }

    public static int getNewId() {
        return carts.stream()
                .map(Cart::getCartItemId)
                .max(Comparator.naturalOrder())
                .orElse(0) + 1;
    }

    public List<Cart> getListCartPerUser() {
        return carts.stream().filter(c -> c.getUser().getUserId() == FastFood.userCurrent.getUserId()).toList();
    }

}
