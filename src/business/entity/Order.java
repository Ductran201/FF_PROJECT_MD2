package business.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Order implements Serializable {
    private int idOrder;
    private StatusOrder statusOrder;
    private Date createdDate;
    private User user;
    private List<Cart> listCart;

    public Order() {
    }

    public Order(int idOrder, StatusOrder statusOrder, Date createdDate, User user, List<Cart> listCart) {
        this.idOrder = idOrder;
        this.statusOrder = statusOrder;
        this.createdDate = createdDate;
        this.user = user;
        this.listCart = listCart;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public StatusOrder getStatusOrder() {
        return statusOrder;
    }

    public void setStatusOrder(StatusOrder statusOrder) {
        this.statusOrder = statusOrder;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Cart> getListCart() {
        return listCart;
    }

    public void setListCart(List<Cart> listCart) {
        this.listCart = listCart;
    }

    public void displayData(){
        System.out.println("----------------------------------------------------------------------------");
        System.out.printf("%-5d |%-20s |%-20s |%-15s |\n"
                , idOrder, user.getUserFullName(),statusOrder,getTotalPrice());
    }

    public void inputData(){
    }

    public int getTotalPrice(){
        int totalPrice = 0;
        for(Cart cart : listCart){
            totalPrice+= cart.getQuantity()*cart.getProduct().getProductPrice();
        }
        return totalPrice;
    }
}
