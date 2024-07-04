package business.entity;

public class Address {
    private int idAddress;
    private int idUser;
    private String addressName;
    private String phoneUser;
    private String nameUser;

    public Address() {
    }

    public Address(int idAddress, int idUser, String addressName, String phoneUser, String nameUser) {
        this.idAddress = idAddress;
        this.idUser = idUser;
        this.addressName = addressName;
        this.phoneUser = phoneUser;
        this.nameUser = nameUser;
    }

    public int getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(int idAddress) {
        this.idAddress = idAddress;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getPhoneUser() {
        return phoneUser;
    }

    public void setPhoneUser(String phoneUser) {
        this.phoneUser = phoneUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public void displayData(){

    }

    public void inputData(boolean isAdd){

        if(isAdd){

        }
    }

}
