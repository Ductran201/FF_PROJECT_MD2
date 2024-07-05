package run;

import business.entity.RoleName;
import business.utility.IOFile;
import business.utility.InputMethod;
import business.entity.User;
import business.design.implement.UserService;
import run.admin.AdminPage;
import run.user.UserPage;


public class FastFood {
    private static final AdminPage adminPage = new AdminPage();
    private static final UserPage userPage = new UserPage();
    private static final UserService userService = new UserService();

    public static User userCurrent = null;

    public static void main(String[] args) {
//
//        CategoryHandleImpl.categories.forEach(c->c.setTotalProduct(0));
//        IOFile.writeObjectToFile(CategoryHandleImpl.categories,IOFile.CATEGORY_PATH);
        userCurrent = null;
        while (true) {
            System.out.println("=============FAST FOOD WEBSITE==============");
            System.out.println("||                                        ||");
            System.out.println("||          1. SIGN IN/ ADMIN PAGE        ||");
            System.out.println("||          2. SIGN UP/USER PAGE          ||");
            System.out.println("||          3. FORGET PASSWORD/ pending   ||");
            System.out.println("||          4. EXIT WEB                   ||");
            System.out.println("||                                        ||");
            System.out.println("============================================");
            System.out.print("Your choice: ");
            byte choice = InputMethod.getByte();
            switch (choice) {
                case 1:
//                    signIn();
                    adminPage.openAdminPage();
                    break;
                case 2:
//                    signUp();
                    userPage.openUserPage();
                    break;
                case 3:
                    getPassword();
                    break;
                case 4:
                    System.out.println("Bye bye");
                    return;
                default:
                    System.out.println("wrong input, try again");
            }
        }
    }

    public static void signIn() {

        System.out.println("===============SIGN IN==================");
        System.out.println("Enter the email:");
        String emailSignIn = InputMethod.getString();
        System.out.println("Enter the password:");
        String passwordSignIn = InputMethod.getString();
//        Check account
        User userSignIn = userService.verifySignIn(emailSignIn, passwordSignIn);
        if (userSignIn != null) {
            if (userSignIn.getUserRole().equals(RoleName.ROLE_USER)) {
                if (userSignIn.isUserStatus()) {
//                Open user page
                    userCurrent = userSignIn;
                    userPage.openUserPage();
                } else {
                    System.err.println("This account has been blocked, please contact admin");
                }
            } else {
//                Open admin page
                adminPage.openAdminPage();
            }

        } else {
            System.err.println("The email or password is incorrect");
            while (true) {
                System.out.println("1. Sign in again.");
                System.out.println("2. Do not have account, sign up now");
                System.out.println("3. Back");
                System.out.print("Your choice: ");
                byte choice = InputMethod.getByte();
                switch (choice) {
                    case 1:
                        signIn();
                        break;
                    case 2:
                        signUp();
                        break;
                    case 3:
                        return;
                }
            }
        }

    }

    public static void signUp() {
        System.out.println("================SIGN UP=====================");
        User newUser = new User();
        newUser.inputData(true);
        UserService.users.add(newUser);
        IOFile.writeObjectToFile(UserService.users, IOFile.USER_PATH);
        System.out.println("Sign up successfully!!");
    }

    public static void getPassword() {
        System.out.println("Enter your email: ");
        String emailInput = InputMethod.getString();

        User user = userService.findUserByEmail(emailInput);
        if (user != null) {
            System.out.println("Your password is: " + user.getUserPassword());
        } else {
            System.err.println("No user found with this email");
        }
    }
}
