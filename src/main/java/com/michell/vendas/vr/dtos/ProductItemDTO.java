/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.michell.vendas.vr.dtos;

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
@NoArgsConstructor
public class ProductItemDTO extends ProductDTO{
    
    private Long productId;

    private Integer qtd;

    private Double unitPrice;
    
    public Double calculateTotalPrice() {
        if (qtd == null || unitPrice == null) {
            return 0.0; 
        }
        return qtd * unitPrice;
    }
    
}
