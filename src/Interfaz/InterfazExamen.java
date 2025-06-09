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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BTNANT.setText("ANTERIOR");

        BTNSIG.setText("SIGUIENTE");

        BTNRESPGROUP.add(BTNRESPUESTA1);

        BTNRESPGROUP.add(BTNRESPUESTA2);

        BTNRESPGROUP.add(BTNRESPUESTA3);

        BTNRESPGROUP.add(BTNRESPUESTA4);

        TXTRESPUESTA1.setEditable(false);

        TXTRESPUESTA2.setEditable(false);

        TXTRESPUESTA3.setEditable(false);

        TXTRESPUESTA4.setEditable(false);

        TXTPREGUNTA.setEditable(false);

        jLabel2.setText("PREGUNTA");

        TXTNUM.setEditable(false);
        TXTNUM.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(TXTPREGUNTA, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGap(193, 193, 193)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(BTNRESPUESTA4)
                                        .addComponent(BTNRESPUESTA3)
                                        .addComponent(BTNRESPUESTA1)
                                        .addComponent(BTNRESPUESTA2))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(TXTRESPUESTA1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TXTRESPUESTA2, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TXTRESPUESTA3, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TXTRESPUESTA4, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(316, 316, 316)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TXTNUM, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 254, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PROGRESO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(BTNANT)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BTNSIG)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PROGRESO, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TXTNUM, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(TXTPREGUNTA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BTNRESPUESTA1)
                    .addComponent(TXTRESPUESTA1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TXTRESPUESTA2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(BTNRESPUESTA2)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TXTRESPUESTA3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(BTNRESPUESTA3)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TXTRESPUESTA4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(BTNRESPUESTA4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTNSIG)
                    .addComponent(BTNANT))
                .addGap(124, 124, 124))
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
