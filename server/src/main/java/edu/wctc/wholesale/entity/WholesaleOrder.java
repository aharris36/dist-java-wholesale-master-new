package edu.wctc.wholesale.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "wholesale_order")
public class WholesaleOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    @Column(name="order_id")
    int id;
    @Column(name="purchase_order_num")
    String PurchaseOrderNumber;
    @Column(name="terms")
    String terms;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    Customer customer;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    Product product;
    @Column(name="purchase_date")
    LocalDate purchaseDate;
    @Column(name="shipped_date")
    LocalDate shippedDate;


}
