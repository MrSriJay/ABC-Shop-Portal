package abc.springframework.springwebapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Set;

@Entity
public class Promotion {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String promoName;
    private String date;
    private double promoAmount;

    private Set<Product> products;

    public Promotion() {
    }


    public Promotion(String promoName, String date, double promoAmount, Set<Product> products) {
        this.promoName = promoName;
        this.date = date;
        this.promoAmount = promoAmount;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Promotion promotion = (Promotion) o;

        return id != null ? id.equals(promotion.id) : promotion.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Promotion{" +
                "id=" + id +
                ", promoName='" + promoName + '\'' +
                ", date='" + date + '\'' +
                ", promoAmount=" + promoAmount +
                ", products=" + products +
                '}';
    }
}
