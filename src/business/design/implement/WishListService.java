package business.design.implement;

import business.entity.Address;
import business.entity.WishList;
import business.utility.IOFile;
import business.utility.InputMethod;
import run.FastFood;

import java.util.Comparator;
import java.util.List;

public class WishListService {
    public static List<WishList> wishLists;

    static {
        wishLists = IOFile.readObjectFromFile(IOFile.WISHLIST_PATH);
    }

    public List<WishList> getWishListPerUser() {
        return wishLists.stream().filter(w -> w.getUser().getUserId() == FastFood.userCurrent.getUserId()).toList();
    }

    public void showAll() {
// Wish list of each user

        if (getWishListPerUser().isEmpty()) {
            System.err.println("No have any wish list");
        } else {
            System.out.printf("%-5s |%-20s |%-20s |%-15s |\n"
                    , "ID", "NAME USER", "NAME PRODUCT", "PRICE");
            getWishListPerUser().forEach(WishList::displayData);
        }

    }

    public void addNew() {
        WishList newWishList = new WishList();
        newWishList.inputData(getWishListPerUser());
        wishLists.add(newWishList);
        IOFile.writeObjectToFile(wishLists, IOFile.WISHLIST_PATH);
        System.out.println("Add successfully!!");
    }


    public void delete() {
        System.out.println("Enter the id of the WishList you want to delete");
        int idDelete = InputMethod.getInteger();
        if (findById(idDelete, getWishListPerUser()) != null) {
            wishLists.remove(findById(idDelete, getWishListPerUser()));
            IOFile.writeObjectToFile(wishLists, IOFile.WISHLIST_PATH);
            System.out.println("Delete successfully!!");
        } else {
            System.err.println("WishList does not exist");
        }
    }

    public WishList findById(int id, List<WishList> list) {
        return list.stream().filter(w -> w.getIdWishList() == id).findFirst().orElse(null);
    }

    public static int getNewId() {
        return wishLists.stream()
                .map(WishList::getIdWishList)
                .max(Comparator.naturalOrder())
                .orElse(0) + 1;
    }
}
