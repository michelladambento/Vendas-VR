/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.michell.vendas.vr.utils;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

/**
 *
 * @author michell-bento
 */
public class PositionForm {
    
    public void openForm(JInternalFrame frame, JDesktopPane desktop){
        int widthDesktop = desktop.getWidth();
        int heightDesktop = desktop.getHeight();
        int widthFrame = frame.getWidth();
        int heightFrame = frame.getHeight();
        frame.setLocation(widthDesktop / 2 - widthFrame / 2, heightDesktop / 2 - heightFrame / 2);
        desktop.add(frame);
        frame.setVisible(true);
    }
    
}
