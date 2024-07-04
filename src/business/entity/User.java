package business.entity;

import business.design.implement.UserService;
import business.utility.InputMethod;

import java.io.Serializable;
import java.util.List;


public class User implements Serializable {
    private int userId;
    private String userEmail;
    private String userPassword;
    private String userFullName;
    private String userPhone;
    private boolean userStatus;
    private RoleName userRole;
    private Address UserAddress;

    public User() {
    }

    public User(int userId, String userEmail, String userPassword, String userFullName, String userPhone, boolean userStatus, RoleName userRole) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userFullName = userFullName;
        this.userPhone = userPhone;
        this.userStatus = userStatus;
        this.userRole = userRole;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userFullName;
    }

    public void setUserName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public boolean isUserStatus() {
        return userStatus;
    }

    public void setUserStatus(boolean userStatus) {
        this.userStatus = userStatus;
    }

    public RoleName getUserRole() {
        return userRole;
    }

    public void setUserRole(RoleName userRole) {
        this.userRole = userRole;
    }



    public void displayData(){
        System.out.println("-----------------------------------------------------------" +
                "-------------------------------");
        System.out.printf("%-5s |%-20s |%-20s |%-12s |%-6s |%-15s |\n"
                ,userId,userEmail,userFullName,userPhone,userStatus,userRole);
    }

    public void displayDataUser(){
        System.out.println("-----------------------------------------------------------" +
                "-------------------------------");
        System.out.printf("%-20s |%-20s |%-12s |\n"
                ,userEmail,userFullName,userPhone);
    }

    public void inputData(boolean isAdd){
        if (isAdd){
            userId= UserService.getNewId();
            userRole=RoleName.ROLE_USER;
            userStatus=true;

        }
        System.out.println("Enter your email");
        userEmail=validateUserEmail(UserService.users);
        System.out.println("Enter your password");
        userPassword= InputMethod.getString();
        System.out.println("Enter your full name");
        userFullName= InputMethod.getString();
        System.out.println("Enter your phone number");
        userPhone=validateUserPhone(UserService.users);

    }

//    VALIDATE

    public String validateUserEmail(List<User> users){
        String regexEmail="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        while (true) {
            String userEmailInput = InputMethod.getString();
            if (userEmailInput.matches(regexEmail)) {
                if (users.stream().noneMatch(t->t.getUserEmail().equals(userEmailInput))){
                    return userEmailInput;
                }else {
                    System.err.println("This email has used by other person, please try again");
                }
            } else {
                System.err.println("Wrong email format, please try again");
            }
        }
    }

    public String validateUserPhone(List<User> users){
        String regexPhone="^0\\d{9}$";
        while (true) {
            String userPhoneInput = InputMethod.getString();
            if (userPhoneInput.matches(regexPhone)) {
                if (users.stream().noneMatch(t->t.getUserPhone().equals(userPhoneInput))){
                    return userPhoneInput;
                }else {
                    System.err.println("This phone has used to sign up, please try again");
                }
            } else {
                System.err.println("Phone number must has total 10 char and begin with 0, please try again");
            }
        }
    }

}
