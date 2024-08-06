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
public class DeleteCustomerResponseDTO {
    
    private MessageDTO message;

    public DeleteCustomerResponseDTO(boolean success, String details) {
        this.message = new MessageDTO(success, details);
    }
    
}
