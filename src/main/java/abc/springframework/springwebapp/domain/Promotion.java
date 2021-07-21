package abc.springframework.springwebapp.domain;

import javax.validation.constraints.NotNull;
import org.hibernate.annotations.OnDelete;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Id;

@Entity
public class Promotion {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String promoName;

    @Column(nullable = false)
    private String start_date;

    @Column(nullable = false)
    private String end_date;

    @Column(nullable = false)
    private double promoAmount;


    @OneToMany
    @JoinColumn(name = "promotion_id")
    private Set<Product> products = new HashSet<>() ;


    public Promotion() {
    }


    public Promotion(String promoName, String start_date, String end_date, double promoAmount) {
        this.promoName = promoName;
        this.start_date = start_date;
        this.end_date = end_date;
        this.promoAmount = promoAmount;

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

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
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
                ", start_date='" + start_date + '\'' +
                ", end_date='" + end_date + '\'' +
                ", promoAmount=" + promoAmount +
                ", products=" + products +
                '}';
    }
}
