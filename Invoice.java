import java.util.ArrayList;
import java.util.List;

public class Invoice {
    private List<Product> listOfProducts = new ArrayList<Product>();

    public Invoice(List<Product> listOfProducts) {
        this.listOfProducts = listOfProducts;
    }

    public void printInvoice() {
        double vat8 = 0;
        double vat23 = 0;
        double vat8Brutto = 0;
        double vat23Brutto = 0;

        for (Product product : listOfProducts) {
            if (product.getVatRate() == 8.0) {
                vat8 += product.getVatRate() * product.getPrice() / 100.0;
                vat8Brutto += product.getPrice() - (product.getVatRate() * product.getPrice() / 100.0);
            } else if (product.getVatRate() == 23.0) {
                vat23 += product.getVatRate() * product.getPrice() / 100.0;
                vat23Brutto += product.getPrice() - (product.getVatRate() * product.getPrice() / 100.0);
            }
        }

        System.out.print("| Stawka VAT    | Total netto | Total brutto |\n");
        System.out.print("|---------------|-------------|--------------|\n");
        System.out.printf("| VAT 8%%        | %9.2fzł | %10.2fzł |\n", vat8, vat8Brutto);
        System.out.printf("| VAT 23%%       | %9.2fzł | %10.2fzł |\n", vat23, vat23Brutto);
        System.out.print("|---------------|-------------|--------------|\n");
        System.out.printf("| Suma          | %9.2fzł | %10.2fzł |\n", vat23 + vat8, vat23Brutto + vat8Brutto);
    }

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