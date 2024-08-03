/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.michell.vendas.vr.dtos;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author michell-bento
 */
@Getter
@Setter
@Generated
@AllArgsConstructor
@NoArgsConstructor
public class CustomersDTO {
    
    private Long code;
    
    private String customerName;
    
    private Integer purchaseLimit;
    
    private LocalDate closingDateAt;   
    
}
