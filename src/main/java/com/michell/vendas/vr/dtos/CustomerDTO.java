/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.michell.vendas.vr.dtos;

import java.time.LocalDate;

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
public class CustomerDTO {
    
    private Long id;
    
    private String customerName;
    
    private Double purchaseLimit;
    
    private LocalDate closingDateAt;   
    
}
