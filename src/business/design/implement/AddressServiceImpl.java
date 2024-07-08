package business.design.implement;

import business.design.IGenericDesign;
import business.entity.Address;
import business.entity.Product;
import business.utility.IOFile;
import business.utility.InputMethod;
import run.FastFood;

import java.util.Comparator;
import java.util.List;

public class AddressServiceImpl implements IGenericDesign<Address, Integer> {

    public static List<Address> addressList;

    static {
        addressList = IOFile.readObjectFromFile(IOFile.ADDRESS_PATH);
    }

    @Override
    public Address findById(Integer id) {
        return addressList.stream().filter(a -> a.getIdAddress() == id).findFirst().orElse(null);
    }

    @Override
    public void showAll() {
//        check list address match id user empty or not

        List<Address> addressListPerUser= addressList.stream()
                .filter(a->a.getUser().getUserId()==FastFood.userCurrent.getUserId())
                .toList();

        if (addressListPerUser.isEmpty()) {
            System.err.println("No have any address");
        } else {
            System.out.printf("%-5s |%-20s |%-20s |%-15s |%-20s |\n"
                    ,"ID","USER","ADDRESS","PHONE RECEIVER","RECEIVER NAME");
            addressListPerUser.forEach(Address::displayData);
        }

    }

    @Override
    public void addNew() {
        System.out.println("ADDING NEW ADDRESS");
        Address newAddress = new Address();
        newAddress.inputData(true);
        addressList.add(newAddress);
        IOFile.writeObjectToFile(addressList, IOFile.ADDRESS_PATH);
        System.out.println("Add successfully!!");
    }

    @Override
    public void edit() {
        System.out.println("Enter the id of address you want to edit: ");
        int idEdit = InputMethod.getInteger();
        if (findById(idEdit) != null) {
            System.out.println("The previous of this address: ");
            findById(idEdit).displayData();
            findById(idEdit).inputData(false);
            IOFile.writeObjectToFile(addressList, IOFile.ADDRESS_PATH);
            System.out.println("Edit successfully!!");
        } else {
            System.err.println("No address found");
        }
    }

    @Override
    public void delete() {
        System.out.println("Enter the id of address want to delete: ");
        int idDelete = InputMethod.getInteger();
        if (findById(idDelete) != null) {
            addressList.remove(findById(idDelete));
            IOFile.writeObjectToFile(addressList, IOFile.ADDRESS_PATH);
            System.out.println("Delete successfully!!");
        } else {
            System.err.println("No address found");
        }
    }

    public void selectById(){
        System.out.println("Enter the id of address you want to show: ");
        int idSelect = InputMethod.getInteger();
        if (findById(idSelect) != null) {
            findById(idSelect).displayData();
        }else {
            System.err.println("No address found");
        }
    }

    public static int getNewId() {
        return addressList.stream()
                .map(Address::getIdAddress).max(Comparator.naturalOrder())
                .orElse(0) + 1;
    }
}
