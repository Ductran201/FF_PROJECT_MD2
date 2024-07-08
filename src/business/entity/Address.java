package business.entity;

import business.design.implement.AddressServiceImpl;
import business.utility.InputMethod;
import run.FastFood;

import java.io.Serializable;

public class Address implements Serializable {
    private int idAddress;
    private User user;
    private String addressName;
    private String phoneReceiver;
    private String nameReceiver;

    public Address() {
    }

    public Address(int idAddress, User user, String addressName, String phoneReceiver, String nameReceiver) {
        this.idAddress = idAddress;
        this.user = user;
        this.addressName = addressName;
        this.phoneReceiver = phoneReceiver;
        this.nameReceiver = nameReceiver;
    }

    public int getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(int idAddress) {
        this.idAddress = idAddress;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getPhoneReceiver() {
        return phoneReceiver;
    }

    public void setPhoneReceiver(String phoneReceiver) {
        this.phoneReceiver = phoneReceiver;
    }

    public String getNameReceiver() {
        return nameReceiver;
    }

    public void setNameReceiver(String nameReceiver) {
        this.nameReceiver = nameReceiver;
    }

    public void displayData() {

        System.out.println("----------------------------------------" +
                "--------------------------------------------------");
        System.out.printf("%-5s |%-20s |%-20s |%-15s |%-20s |\n"
                , idAddress, user.getUserFullName(), addressName, phoneReceiver, nameReceiver);

    }

    public void inputData(boolean isAdd) {

        if (isAdd) {
            idAddress = AddressServiceImpl.getNewId();
            user = FastFood.userCurrent;
        }

        System.out.println("Enter address: ");
        addressName = InputMethod.getString();

        phoneReceiver = validatePhoneInput();

        System.out.println("Enter name receiver: ");
        nameReceiver = InputMethod.getString();
    }

    //    VALIDATE
    public String validatePhoneInput() {
        while (true) {
            String regexPhone = "^0\\d{9}$";
            System.out.println("Enter phone receiver: ");
            String phone = InputMethod.getString();
            if (phone.matches(regexPhone)) {
                return phone;
            } else {
                System.err.println("Invalid phone number");;
            }
        }
    }

}
