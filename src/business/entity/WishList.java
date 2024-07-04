package business.entity;

import java.util.List;

public class WishList {
    private int idWishList;
    private int idUser;
    private int idProduct;

    public WishList() {
    }

    public WishList(int idWishList, int idUser, int idProduct) {
        this.idWishList = idWishList;
        this.idUser = idUser;
        this.idProduct = idProduct;
    }

    public int getIdWishList() {
        return idWishList;
    }

    public void setIdWishList(int idWishList) {
        this.idWishList = idWishList;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public void displayData(){

    }

    public void inputData(List<Product> listProduct, boolean isAdd){
        if (isAdd){

        }
    }


}
