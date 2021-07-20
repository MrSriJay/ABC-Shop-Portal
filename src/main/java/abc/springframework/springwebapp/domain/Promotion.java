package abc.springframework.springwebapp.domain;

import java.util.Set;

public class Promotion {

    private String promoName;
    private String date;
    private double promoAmount;

    private Set<Product> products;

    public Promotion(String promoName, String date, double promoAmount, Set<Product> products) {
        this.promoName = promoName;
        this.date = date;
        this.promoAmount = promoAmount;
        this.products = products;
    }

    public String getPromoName() {
        return promoName;
    }

    public void setPromoName(String promoName) {
        this.promoName = promoName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPromoAmount() {
        return promoAmount;
    }

    public void setPromoAmount(double promoAmount) {
        this.promoAmount = promoAmount;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
