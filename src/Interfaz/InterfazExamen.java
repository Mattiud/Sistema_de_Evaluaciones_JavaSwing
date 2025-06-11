package Interfaz;

import Controlador.Control;
import Controlador.ControlExamen;
import Interfaz.InterfazCreacion;
import Modelo.Pregunta;
import Modelo.PreguntaExamen;
import java.util.List;
import java.util.Arrays;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfazExamen extends javax.swing.JFrame {
    
        private List<Pregunta> preguntas;
        private int indiceActual = 0;
        private List<Integer> idsSeleccionados;
        private List<Integer> respuestasAlumno;


        public InterfazExamen(List<Integer> idsSeleccionados) {
            this.idsSeleccionados = idsSeleccionados;
            this.preguntas = Control.obtenerPreguntasPorIds(idsSeleccionados);
            this.respuestasAlumno = new java.util.ArrayList<>();
            
            for (int i = 0; i < preguntas.size(); i++) {
                respuestasAlumno.add(-1); 
            }


        initComponents();
        cargarPregunta(indiceActual);
            
            
        BTNSIG.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // Guardar respuesta actual
                respuestasAlumno.set(indiceActual, obtenerRespuestaSeleccionada());

                int respuestaSeleccionada = obtenerRespuestaSeleccionada();
                respuestasAlumno.set(indiceActual, respuestaSeleccionada);

                if (indiceActual < preguntas.size() - 1) {
                    indiceActual++;
                    cargarPregunta(indiceActual);
                } else {
                    // Finaliza
                    int correctas = 0;
                    for (int i = 0; i < preguntas.size(); i++) {
                        if (preguntas.get(i).getRespuestaCorrecta() == respuestasAlumno.get(i)) {
                            correctas++; // Aquí sumas las correctas
}

                    }
                    int puntaje = (int)(((double) correctas / preguntas.size()) * 100);
                    JOptionPane.showMessageDialog(null, "Examen finalizado.\nRespuestas correctas: " + correctas + "/" + preguntas.size() + "\nPuntaje: " + puntaje + "%");
                    dispose(); // cerrar ventana
                }
            }
        });


            BTNANT.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (indiceActual > 0) {
                        indiceActual--;
                        cargarPregunta(indiceActual);
                    }
                }
            });

        }

      
        
        
        
        
        private void cargarPregunta(int indice) {
            if (preguntas != null && indice >= 0 && indice < preguntas.size()) {
                Pregunta p = preguntas.get(indice);

                // Ejemplo: si tienes componentes como estos
                TXTPREGUNTA.setText(p.getPregunta());
                TXTNUM.setText(String.valueOf(indice + 1));
                TXTRESPUESTA1.setText(p.getRespuesta1());
                TXTRESPUESTA2.setText(p.getRespuesta2());
                TXTRESPUESTA3.setText(p.getRespuesta3());
                TXTRESPUESTA4.setText(p.getRespuesta4());

                // Puedes también actualizar el progreso
                PROGRESO.setValue((indice + 1) * 100 / preguntas.size());

                // Activar/desactivar botones según corresponda
                if (indice == preguntas.size() - 1) {
                    BTNSIG.setText("FINALIZAR");
                } else {
                    BTNSIG.setText("SIGUIENTE");
                }
                               
            }
        
        // Obtener respuesta previa del alumno
        Integer respuestaAlumno = respuestasAlumno.get(indice);
            if (respuestaAlumno != null) {
                switch (respuestaAlumno) {
                    case 1 -> BTNRESPUESTA1.setSelected(true);
                    case 2 -> BTNRESPUESTA2.setSelected(true);
                    case 3 -> BTNRESPUESTA3.setSelected(true);
                    case 4 -> BTNRESPUESTA4.setSelected(true);
                }
            } else {
                BTNRESPGROUP.clearSelection(); // Asegúrate de limpiar selección si no hay respuesta
            }


        }

        private int obtenerRespuestaSeleccionada() {
            if (BTNRESPUESTA1.isSelected()) return 1;
            if (BTNRESPUESTA2.isSelected()) return 2;
            if (BTNRESPUESTA3.isSelected()) return 3;
            if (BTNRESPUESTA4.isSelected()) return 4;
            return -1;
}

        
        
        
        
    // constructor vacío para evitar uso incorrecto
    public InterfazExamen() {
        throw new UnsupportedOperationException("Usa InterfazExamen(List<Integer>)");
    }
    
        
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BTNRESPGROUP = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        BTNANT = new javax.swing.JButton();
        BTNSIG = new javax.swing.JButton();
        BTNRESPUESTA1 = new javax.swing.JRadioButton();
        BTNRESPUESTA2 = new javax.swing.JRadioButton();
        BTNRESPUESTA3 = new javax.swing.JRadioButton();
        BTNRESPUESTA4 = new javax.swing.JRadioButton();
        TXTRESPUESTA1 = new javax.swing.JTextField();
        TXTRESPUESTA2 = new javax.swing.JTextField();
        TXTRESPUESTA3 = new javax.swing.JTextField();
        TXTRESPUESTA4 = new javax.swing.JTextField();
        TXTPREGUNTA = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TXTNUM = new javax.swing.JTextField();
        PROGRESO = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("EXAMEN");
        setLocationByPlatform(true);

        jPanel1.setBackground(new java.awt.Color(236, 239, 241));

        BTNANT.setBackground(new java.awt.Color(176, 190, 197));
        BTNANT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BTNANT.setText("ANTERIOR");

        BTNSIG.setBackground(new java.awt.Color(67, 160, 71));
        BTNSIG.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BTNSIG.setText("SIGUIENTE");

        BTNRESPUESTA1.setBackground(new java.awt.Color(236, 239, 241));
        BTNRESPGROUP.add(BTNRESPUESTA1);
        BTNRESPUESTA1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BTNRESPUESTA1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BTNRESPUESTA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNRESPUESTA1ActionPerformed(evt);
            }
        });

        BTNRESPUESTA2.setBackground(new java.awt.Color(236, 239, 241));
        BTNRESPGROUP.add(BTNRESPUESTA2);
        BTNRESPUESTA2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BTNRESPUESTA2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        BTNRESPUESTA3.setBackground(new java.awt.Color(236, 239, 241));
        BTNRESPGROUP.add(BTNRESPUESTA3);
        BTNRESPUESTA3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BTNRESPUESTA3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BTNRESPUESTA3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNRESPUESTA3ActionPerformed(evt);
            }
        });

        BTNRESPUESTA4.setBackground(new java.awt.Color(236, 239, 241));
        BTNRESPGROUP.add(BTNRESPUESTA4);
        BTNRESPUESTA4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BTNRESPUESTA4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        TXTRESPUESTA1.setEditable(false);
        TXTRESPUESTA1.setBackground(new java.awt.Color(236, 239, 241));
        TXTRESPUESTA1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TXTRESPUESTA1.setBorder(null);

        TXTRESPUESTA2.setEditable(false);
        TXTRESPUESTA2.setBackground(new java.awt.Color(236, 239, 241));
        TXTRESPUESTA2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TXTRESPUESTA2.setBorder(null);
        TXTRESPUESTA2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTRESPUESTA2ActionPerformed(evt);
            }
        });

        TXTRESPUESTA3.setEditable(false);
        TXTRESPUESTA3.setBackground(new java.awt.Color(236, 239, 241));
        TXTRESPUESTA3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TXTRESPUESTA3.setBorder(null);

        TXTRESPUESTA4.setEditable(false);
        TXTRESPUESTA4.setBackground(new java.awt.Color(236, 239, 241));
        TXTRESPUESTA4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TXTRESPUESTA4.setBorder(null);

        TXTPREGUNTA.setEditable(false);
        TXTPREGUNTA.setBackground(new java.awt.Color(236, 239, 241));
        TXTPREGUNTA.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TXTPREGUNTA.setBorder(null);

        jLabel2.setBackground(new java.awt.Color(236, 239, 241));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(13, 71, 161));
        jLabel2.setText("PREGUNTA");

        TXTNUM.setEditable(false);
        TXTNUM.setBackground(new java.awt.Color(236, 239, 241));
        TXTNUM.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TXTNUM.setBorder(null);
        TXTNUM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTNUMActionPerformed(evt);
            }
        });

        PROGRESO.setBackground(new java.awt.Color(224, 224, 224));
        PROGRESO.setForeground(new java.awt.Color(33, 150, 243));
        PROGRESO.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PROGRESO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(BTNANT, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BTNSIG, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(362, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TXTNUM, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 362, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TXTPREGUNTA, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BTNRESPUESTA4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TXTRESPUESTA4, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BTNRESPUESTA3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TXTRESPUESTA3, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BTNRESPUESTA2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TXTRESPUESTA2, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BTNRESPUESTA1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TXTRESPUESTA1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PROGRESO, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TXTNUM, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(TXTPREGUNTA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BTNRESPUESTA1, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(TXTRESPUESTA1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BTNRESPUESTA2, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(TXTRESPUESTA2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BTNRESPUESTA3, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(TXTRESPUESTA3))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BTNSIG, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BTNANT, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BTNRESPUESTA4, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                            .addComponent(TXTRESPUESTA4))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TXTNUMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTNUMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTNUMActionPerformed

    private void BTNRESPUESTA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNRESPUESTA1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BTNRESPUESTA1ActionPerformed

    private void TXTRESPUESTA2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTRESPUESTA2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTRESPUESTA2ActionPerformed

    private void BTNRESPUESTA3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNRESPUESTA3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BTNRESPUESTA3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfazExamen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazExamen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazExamen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazExamen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazExamen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BTNANT;
    public javax.swing.ButtonGroup BTNRESPGROUP;
    public javax.swing.JRadioButton BTNRESPUESTA1;
    public javax.swing.JRadioButton BTNRESPUESTA2;
    public javax.swing.JRadioButton BTNRESPUESTA3;
    public javax.swing.JRadioButton BTNRESPUESTA4;
    public javax.swing.JButton BTNSIG;
    private javax.swing.JProgressBar PROGRESO;
    public javax.swing.JTextField TXTNUM;
    public javax.swing.JTextField TXTPREGUNTA;
    public javax.swing.JTextField TXTRESPUESTA1;
    public javax.swing.JTextField TXTRESPUESTA2;
    public javax.swing.JTextField TXTRESPUESTA3;
    public javax.swing.JTextField TXTRESPUESTA4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

 
}
