package business.design.implement;

import business.entity.Cart;
import business.entity.Category;
import business.entity.Order;
import business.entity.StatusOrder;
import business.utility.IOFile;
import business.utility.InputMethod;
import run.FastFood;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class OrderService {
    public static List<Order> orders;

    static {
        orders = IOFile.readObjectFromFile(IOFile.ORDER_PATH);
    }

    public void showAll(){
        if (!getListOrderPerUser().isEmpty()) {
            System.out.printf("%-5S |%-20s |%-20s |%-15s | \n"
                    , "ID", "USER NAME","STATUS","Total Price");
            getListOrderPerUser().forEach(Order::displayData);
        } else {
            System.err.println("No have any order yet");
        }
    }

    public static int getNewId() {
        return orders.stream().map(Order::getIdOrder).max(Comparator.naturalOrder()).orElse(0) + 1;
    }

    public List<Order> getListOrderPerUser() {
        return orders.stream().filter(o->o.getUser().getUserId()==FastFood.userCurrent.getUserId()).toList();
    }


}
