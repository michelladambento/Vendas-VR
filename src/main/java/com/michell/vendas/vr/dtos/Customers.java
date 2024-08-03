/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.michell.vendas.vr.dtos;

import java.time.LocalDate;

/**
 *
 * @author michell-bento
 */

public class Customers {
    
    private Long code;
    
    private String customerName;
    
    private Integer purchaseLimit;
    
    private LocalDate closingDateAt;

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getPurchaseLimit() {
        return purchaseLimit;
    }

    public void setPurchaseLimit(Integer purchaseLimit) {
        this.purchaseLimit = purchaseLimit;
    }

    public LocalDate getClosingDateAt() {
        return closingDateAt;
    }

    public void setClosingDateAt(LocalDate closingDateAt) {
        this.closingDateAt = closingDateAt;
    }
    
   
    
}
