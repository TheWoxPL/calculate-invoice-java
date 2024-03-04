import java.util.ArrayList;
import java.util.List;

public class Invoice {
    private List<Product> listOfProducts = new ArrayList<Product>();

    public Invoice(List<Product> listOfProducts) {
        this.listOfProducts = listOfProducts;
    }

    public void printInvoice() {
        double vat8Netto = 0;
        double vat23Netto = 0;
        double vat8Brutto = 0;
        double vat23Brutto = 0;

        for (Product product : listOfProducts) {
            if (product.getVatRate() == 8.0) {
                vat8Brutto += product.getPrice();
                vat8Netto += product.getPrice() - (product.getVatRate() * product.getPrice() / 100.0);
            } else if (product.getVatRate() == 23.0) {
                vat23Brutto += product.getPrice();
                vat23Netto += product.getPrice() - (product.getVatRate() * product.getPrice() / 100.0);
            }
        }

        System.out.print("| Stawka VAT    | Total netto | Total brutto |\n");
        System.out.print("|---------------|-------------|--------------|\n");
        System.out.printf("| VAT 8%%        | %9.2fzł | %10.2fzł |\n", vat8Netto, vat8Brutto);
        System.out.printf("| VAT 23%%       | %9.2fzł | %10.2fzł |\n", vat23Netto, vat23Brutto);
        System.out.print("|---------------|-------------|--------------|\n");
        System.out.printf("| Suma          | %9.2fzł | %10.2fzł |\n", vat23Netto + vat8Netto, vat23Brutto + vat8Brutto);
    }
}