package business.design.implement;

import business.utility.IOFile;
import business.utility.InputMethod;
import business.design.IProductDesign;
import business.entity.Product;

import java.util.Comparator;
import java.util.List;

public class ProductServiceImpl implements IProductDesign {

    public static List<Product> products;

    static {
        products = IOFile.readObjectFromFile(IOFile.PRODUCT_PATH);
    }

    @Override
    public Product findById(Integer id) {
        return products.stream().
                filter(t -> t.getProductId() == id).
                findFirst().
                orElse(null);
    }

    @Override
    public void showAll() {
        if (products.isEmpty()) {
            System.err.println("No have any products");
        } else {
            System.out.printf("%-10s |%-15s |%-15s |%-10s |%-20s |%-15s |\n",
                    "ID", "NAME", "PRICE", "STOCK", "CATEGORY", "STATUS");
            products.forEach(Product::displayData);
        }
    }

    @Override
    public void addNew() {
        System.out.println("Enter the number of product want to add: ");
        byte number = InputMethod.getByte();

        for (int i = 1; i <= number; i++) {

            System.out.println("Enter the information of product " + i);
            Product newProduct = new Product();
            newProduct.inputData(products, CategoryServiceImpl.categories, true);
            products.add(newProduct);
            IOFile.writeObjectToFile(products, IOFile.PRODUCT_PATH);

        }
//        updateTotalFile();
        System.out.println("Add successfully!!");

    }

    @Override
    public void edit() {
        System.out.println("Enter the id of product you want to edit");
        int idEdit = InputMethod.getInteger();
        Product productEdit = findById(idEdit);
        if (productEdit != null) {
            System.out.println("The previous information of this product");
            productEdit.displayData();
            productEdit.inputData(products, CategoryServiceImpl.categories, false);
            IOFile.writeObjectToFile(products, IOFile.PRODUCT_PATH);
//            updateTotalFile();
            System.out.println("Edit successfully!!");
        } else {
            System.err.println("No product found");
        }
    }

    @Override
    public void delete() {
        System.out.println("Enter the id of product you want to delete: ");
        int idDelete = InputMethod.getInteger();
        Product productDelete = findById(idDelete);
        if (productDelete != null) {

//            delete product
            products.remove(productDelete);
//            write to file
            IOFile.writeObjectToFile(products, IOFile.PRODUCT_PATH);
//            updateTotalFile();
            System.out.println("Delete successfully!!");
        } else {
            System.err.println("No product found");
        }
    }

    public static int getNewId() {
        return products.stream()
                .map(Product::getProductId).max(Comparator.naturalOrder())
                .orElse(0) + 1;
    }

//update total product of category to file.
//    public void updateTotalFile() {
//        CategoryHandleImpl.categories.forEach(Category::updateTotalProduct);
//        IOFile.writeObjectToFile(CategoryHandleImpl.categories, IOFile.CATEGORY_PATH);
//    }

    public void changeStatus() {
        System.out.println("Enter the id of the category you want to change: ");
        int id = InputMethod.getInteger();

        if (findById(id) != null) {
            findById(id).setProductStatus(!findById(id).isProductStatus());
            IOFile.writeObjectToFile(products, IOFile.PRODUCT_PATH);
            System.out.println("Change success");
        } else {
            System.err.println("No category found");
        }
    }

    public void searchByName() {
        System.out.println("Enter category name for search: ");
        String nameSearch = InputMethod.getString();

        System.out.println("Result: ");
        products.stream()
                .filter(t -> t.getProductName().toLowerCase().contains(nameSearch.toLowerCase()))
                .forEach(Product::displayData);
    }

    public void searchByCategory() {

        CategoryServiceImpl categoryHandle = new CategoryServiceImpl();
        categoryHandle.showAll();
        System.out.println("Enter the id of category: ");
        String idCategory = InputMethod.getString();

        if (categoryHandle.findById(idCategory) == null) {
            System.err.println("No category found with this id");
        } else {
            System.out.println("List product of category " + categoryHandle.findById(idCategory).getCategoryName() + " :");
            products.stream()
                    .filter(p -> p.getCategory().getCategoryId().equals(categoryHandle.findById(idCategory).getCategoryId()))
                    .forEach(Product::displayData);
        }


    }


}

