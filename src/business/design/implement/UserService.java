package business.design.implement;

import business.utility.IOFile;
import business.entity.User;
import business.utility.InputMethod;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {

    public static List<User> users;

    static {
        users = IOFile.readObjectFromFile(IOFile.USER_PATH);
    }

    public User verifySignIn(String email, String password) {

        User userSignIn = findUserByEmail(email);
        if (userSignIn == null) {
            return null;
        }

        if (userSignIn.getUserPassword().equals(password)) {
            return userSignIn;
        }

        return null;

    }


    public User findUserByEmail(String email) {
        return users.stream()
                .filter(u -> u.getUserEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    public User findUserById(int id) {
        return users.stream()
                .filter(u -> u.getUserId() == id)
                .findFirst()
                .orElse(null);
    }

    public static int getNewId() {
        int max = users.stream()
                .map(User::getUserId)
                .max(Comparator.naturalOrder()).orElse(0);
        return max + 1;
    }

    public void showAllAccount() {
        System.out.printf("%-5s |%-20s |%-20s |%-12s |%-6s |%-15s |\n"
                , "ID", "EMAIL", "FULL NAME", "PHONE", "STATUS", "ROLE");
        users.forEach(User::displayData);
    }

    public void changeStatus() {
        System.out.println("Enter the id user want to change status: ");
        int id = InputMethod.getInteger();
        User user = findUserById(id);
        if (user != null) {
            user.setUserStatus(!user.isUserStatus());
            System.out.println("Change status successfully!!");
            IOFile.writeObjectToFile(users,IOFile.USER_PATH);
        } else {
            System.err.println("Id " + id + " not found ");
        }
    }

    public void searchByName() {
        System.out.println("Enter the name of user: ");
        String nameSearch = InputMethod.getString();

        List<User> usersFilter = users.stream()
                .filter(u -> u.getUserFullName().toLowerCase().contains(nameSearch.toLowerCase()))
                .toList();

        if (usersFilter.isEmpty()){
            System.err.println("No Category with name: "+ nameSearch);
        }else {
            usersFilter.forEach(User::displayData);
        }

    }

    public void sortByName() {
        System.out.println("Order name a-z: ");
        users.sort(((o1, o2) -> o1.getUserFullName().compareTo(o2.getUserFullName())));
        users.forEach(User::displayData);

    }


}
