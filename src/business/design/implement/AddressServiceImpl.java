package business.design.implement;

import business.design.IGenericDesign;
import business.entity.Address;
import business.entity.Product;
import business.utility.IOFile;

import java.util.Comparator;
import java.util.List;

public class AddressServiceImpl implements IGenericDesign<Address,Integer> {

    public static List<Address> addressList;
    static {
        addressList = IOFile.readObjectFromFile(IOFile.ADDRESS_PATH);
    }

    @Override
    public Address findById(Integer id) {
        return addressList.stream().filter(a->a.getIdAddress()==id).findFirst().orElse(null);
    }

    @Override
    public void showAll() {
        if (addressList.isEmpty()) {
            System.err.println("No have any address");
        } else {
            System.out.printf("%-10s |%-15s |%-15s |%-10s |%-20s |%-15s |\n",
                    "ID", "NAME", "PRICE", "STOCK", "CATEGORY", "STATUS");
            addressList.forEach(a->a.displayData());
        }

    }

    @Override
    public void addNew() {

    }

    @Override
    public void edit() {

    }

    @Override
    public void delete() {

    }

    public static int getNewId() {
        return addressList.stream()
                .map(Address::getIdAddress).max(Comparator.naturalOrder())
                .orElse(0) + 1;
    }
}
