package abc.springframework.springwebapp.domain;

public class Product {

    private String productName;
    private double price;
    private String expireDate;
    private double Tax;

    public Product(String productName, double price, String expireDate, double tax) {
        this.productName = productName;
        this.price = price;
        this.expireDate = expireDate;
        Tax = tax;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public double getTax() {
        return Tax;
    }

    public void setTax(double tax) {
        Tax = tax;
    }
}
