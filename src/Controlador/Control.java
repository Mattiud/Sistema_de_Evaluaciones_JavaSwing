package Controlador;

import Modelo.ListarPreguntas;
import Modelo.Pregunta;
import Modelo.Modelo;
import Interfaz.InterfazPrincipal;
import Interfaz.InterfazCreacion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;






public class Control implements ActionListener, ListSelectionListener {  




    private InterfazCreacion ic;

    public void setInterfazCreacion(InterfazCreacion ic) {
        this.ic = ic;
    }

    InterfazPrincipal rp;
    ListarPreguntas lp = new ListarPreguntas();

    public Control(InterfazPrincipal rp) {
        this.rp = rp;
        this.rp.BTNGUAR.addActionListener(this);
        this.rp.BTNMODI.addActionListener(this);
        this.rp.BTNELIM.addActionListener(this);
        this.rp.BTNLIMP.addActionListener(this);
        this.rp.TABLA.getSelectionModel().addListSelectionListener(this);
        this.rp.BTNvf.addActionListener(this);
        this.rp.BTNseleccionmultiple.addActionListener(this);
        this.rp.BTNCREAREX.addActionListener(this);

        // Inicialmente botones modificar y eliminar deshabilitados
        rp.BTNMODI.setEnabled(false);
        rp.BTNELIM.setEnabled(false);
    }

    // Obtiene la respuesta correcta según el radio botón seleccionado
    private int obtenerRespuestaCorrecta() throws Exception {
        if (rp.RBTNRESP1.isSelected()) return 1;
        if (rp.RBTNRESP2.isSelected()) return 2;
        if (rp.RBTNRESP3.isSelected()) return 3;
        if (rp.RBTNRESP4.isSelected()) return 4;
        throw new Exception("Debe seleccionar la respuesta correcta");
    }

    // Arma un objeto Pregunta con los datos de la interfaz
    private Pregunta obtenerPreguntaDesdeCampos() throws Exception {
        int id = Integer.parseInt(rp.TXTID.getText().trim());
        String pregunta = rp.TXTPREGUNTA.getText().trim();
        String resp1 = rp.TXTRESP1.getText().trim();
        String resp2 = rp.TXTRESP2.getText().trim();
        String resp3 = rp.TXTRESP3.getText().trim();
        String resp4 = rp.TXTRESP4.getText().trim();
        int respCorrecta = obtenerRespuestaCorrecta();
        int tiempo = Integer.parseInt(rp.TXTTIEMPO.getText().trim());
        String nivelBloom = (String)rp.CBNVL.getSelectedItem();

        return new Pregunta(id, pregunta, resp1, resp2, resp3, resp4, respCorrecta, tiempo, nivelBloom);
    }

    // Selecciona el radio botón correcto según el número recibido
    private void setRespuestaCorrectaRadio(int numeroRespuesta) {
        rp.RBTNRESP1.setSelected(numeroRespuesta == 1);
        rp.RBTNRESP2.setSelected(numeroRespuesta == 2);
        rp.RBTNRESP3.setSelected(numeroRespuesta == 3);
        rp.RBTNRESP4.setSelected(numeroRespuesta == 4);
    }

    // Limpia todos los campos y botones
    private void limpiarCampos() {
        rp.TXTID.setText("");
        rp.TXTPREGUNTA.setText("");
        rp.TXTRESP1.setText("");
        rp.TXTRESP2.setText("");
        rp.TXTRESP3.setText("");
        rp.TXTRESP4.setText("");
        rp.TXTTIEMPO.setText("");

        rp.RBTNRESP1.setSelected(false);
        rp.RBTNRESP2.setSelected(false);
        rp.RBTNRESP3.setSelected(false);
        rp.RBTNRESP4.setSelected(false);

        rp.BTNGUAR.setEnabled(true);
        rp.BTNMODI.setEnabled(false);
        rp.BTNELIM.setEnabled(false);

        rp.TABLA.clearSelection();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Modelo reg = new Modelo();

        if (e.getSource() == rp.BTNvf){

            rp.TXTRESP1.setText("Verdadero");
            rp.TXTRESP2.setText("Falso");

            rp.TXTRESP3.setEnabled(false);
            rp.TXTRESP3.setText("");
            rp.TXTRESP4.setEnabled(false);
            rp.TXTRESP4.setText("");

            rp.RBTNRESP3.setEnabled(false);
            rp.RBTNRESP4.setEnabled(false);
        }

        if (e.getSource() == rp.BTNseleccionmultiple){

            rp.TXTRESP1.setText("");
            rp.TXTRESP2.setText("");

            rp.TXTRESP3.setEnabled(true);
            rp.TXTRESP4.setEnabled(true);

            rp.RBTNRESP3.setEnabled(true);
            rp.RBTNRESP4.setEnabled(true);

        }

        if (e.getSource() == rp.BTNGUAR) {
            try {
                Pregunta p = obtenerPreguntaDesdeCampos();
                reg.RegistrarBD(p);
                lp.MostrarTabla(rp.TABLA);
                limpiarCampos();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al guardar: " + ex.getMessage());
            }
        }

        if (e.getSource() == rp.BTNMODI) {
            try {
                Pregunta p = obtenerPreguntaDesdeCampos();
                reg.ModificarBD(p);
                lp.MostrarTabla(rp.TABLA);
                limpiarCampos();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al modificar: " + ex.getMessage());
            }
        }

        if (e.getSource() == rp.BTNELIM) {
            try {
                int id = Integer.parseInt(rp.TXTID.getText().trim());
                Pregunta p = new Pregunta(id, null, null, null, null, null, 0, 0, null);
                reg.EliminarBD(p);
                lp.MostrarTabla(rp.TABLA);
                limpiarCampos();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al eliminar: " + ex.getMessage());
            }
        }

        if (e.getSource() == rp.BTNLIMP) {
            limpiarCampos();
        }


        if (e.getSource() == rp.BTNCREAREX) {
            if (ic != null) {
                ic.setVisible(true);
                ic.setLocationRelativeTo(null);
        }
}

    }

    @Override
        public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            int fila = rp.TABLA.getSelectedRow();
            if (fila >= 0) {
                TableModel modelo = rp.TABLA.getModel();

                rp.TXTID.setText(modelo.getValueAt(fila, 0).toString());
                rp.TXTPREGUNTA.setText(modelo.getValueAt(fila, 1).toString());
                rp.TXTRESP1.setText(modelo.getValueAt(fila, 2).toString());
                rp.TXTRESP2.setText(modelo.getValueAt(fila, 3).toString());
                rp.TXTRESP3.setText(modelo.getValueAt(fila, 4).toString());
                rp.TXTRESP4.setText(modelo.getValueAt(fila, 5).toString());

                int respCorrecta = Integer.parseInt(modelo.getValueAt(fila, 6).toString());
                setRespuestaCorrectaRadio(respCorrecta);

                rp.TXTTIEMPO.setText(modelo.getValueAt(fila, 7).toString());
                rp.CBNVL.setSelectedItem(modelo.getValueAt(fila, 8).toString());


                rp.BTNGUAR.setEnabled(false);
                rp.BTNMODI.setEnabled(true);
                rp.BTNELIM.setEnabled(true);
            }
        }
    }



    public static List<Pregunta> obtenerPreguntasPorIds(List<Integer> ids) {
        List<Pregunta> preguntas = new ArrayList<>();
        Conexion conexion = new Conexion();
        Connection cn = conexion.Conex();

        if (ids == null || ids.isEmpty()) {
            return preguntas;
        }

        try {
            // Creamos la parte dinámica del IN (?, ?, ?, ...)
            String placeholders = String.join(",", Collections.nCopies(ids.size(), "?"));
            String sql = "SELECT * FROM pregunta WHERE id IN (" + placeholders + ")";
            PreparedStatement ps = cn.prepareStatement(sql);

            // Asignamos cada ID a los signos de pregunta
            for (int i = 0; i < ids.size(); i++) {
                ps.setInt(i + 1, ids.get(i));
            }

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Pregunta p = new Pregunta();
                p.setId(rs.getInt("Id"));
                p.setPregunta(rs.getString("Pregunta"));
                p.setRespuesta1(rs.getString("Respuesta1"));
                p.setRespuesta2(rs.getString("Respuesta2"));
                p.setRespuesta3(rs.getString("Respuesta3"));
                p.setRespuesta4(rs.getString("Respuesta4"));
                p.setRespuestaCorrecta(rs.getInt("RespuestaCorrecta"));
                p.setTiempo(rs.getInt("Tiempo"));
                p.setNivelBloom(rs.getString("NivelBloom"));
                preguntas.add(p);
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener preguntas: " + e.getMessage());
        }

        return preguntas;
    }
}