public class Product {
    private double price;
    private String name;
    private double vatRate;
    
    public Product(double price, String name, double vatRate) {
        this.price = price;
        this.name = name;
        this.vatRate = vatRate;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public Double getVatRate() {
        return vatRate;
    }
}
