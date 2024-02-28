import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Product p1 = new Product(100.00, "Clean Code, Robert C. Martin", 8);
        Product p2 = new Product(300.00, "Applying UML and Patterns, C. Larman", 8);
        Product p3 = new Product(50.00, "Shipping", 23);

        List<Product> listOfProducts = new ArrayList<>();
        listOfProducts.add(p1);
        listOfProducts.add(p2);
        listOfProducts.add(p3);

        Invoice i = new Invoice(listOfProducts);
        i.printInvoice();

    }
}
