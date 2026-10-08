package edu.wctc.wholesale.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class WholesaleOrderDto {
    String customerName;
    LocalDate purchaseDate;
    String purchaseOrderNumber;
    String productName;
    String terms;
    LocalDate shippedDate;
    Double productCost;
}
