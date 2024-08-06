/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.michell.vendas.vr;

import com.michell.vendas.vr.dtos.CustomerDTO;
import com.michell.vendas.vr.views.VendasMainForm;
import com.sun.tools.javac.Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author michell-bento
 */
public class VendasVR {
    
   

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        VendasMainForm form = new VendasMainForm();
        form.setVisible(true);

//        // Cria o RestTemplate
//        RestTemplate restTemplate = new RestTemplate();
//        
//          // Cria a interface gráfica
//        JFrame frame = new JFrame("My Swing App");
//        JButton button = new JButton("Fetch Data");
//        JTextArea textArea = new JTextArea(20, 40);
//        JScrollPane scrollPane = new JScrollPane(textArea);
//
//        button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Faz a requisição para a API
//                String result = restTemplate.getForObject(API_URL, String.class);
//                // Atualiza a área de texto com a resposta
//                textArea.setText(result);
//            }
//        });
//
//        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
//        frame.add(button);
//        frame.add(scrollPane);
//        
//        frame.setSize(500, 300);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);
  // Cria o RestTemplate
        

    }
}
