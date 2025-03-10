package frontend.proyecto;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import backend.controladores.AlternativaControlador;
import backend.controladores.CambioControlador;
import backend.controladores.ObjetivoControlador;
import backend.entidades.Alternativa;
import backend.entidades.Cambio;
import backend.entidades.Objetivo;
import backend.entidades.Proyecto;
import backend.entidades.Usuario;
import frontend.administrador.AdminAlternativaInterfaz;
import frontend.administrador.AdminCambioInterfaz;
import frontend.administrador.AdminObjetivos;
import frontend.administrador.AdminProyectoInterfaz;

/**
 *
 * @author Daniel Arias
 */
public class ProyectoDetallesInterfaz extends javax.swing.JFrame {
    private Proyecto proyecto;
    private Usuario usuario;
    private AdminAlternativaInterfaz adminAlternativaInterfaz;
    private AdminCambioInterfaz adminCambioInterfaz;
    private AdminObjetivos adminObjetivos;
    private AlternativaControlador alternativaControlador;
    private CambioControlador cambioControlador;
    private ObjetivoControlador objetivoControlador;
    private ArrayList<Alternativa> alternativas;
    private ArrayList<Cambio> cambios;
    private ArrayList<Objetivo> objetivos;

    /**
     * Creates new form ProyectoDetallesInterfaz1
     */
    public ProyectoDetallesInterfaz() {
        initComponents();
        init();
    }

    public ProyectoDetallesInterfaz(Proyecto proyecto, Usuario usuario) {
        initComponents();
        init();
        cargarDatos(proyecto);
        initControladores();
        initTabla(tablaAlternativas, 3);
        initTabla(tablaObjetivos, 2);
        initTabla(tablaCambios, 2);
        cargarTablaObjetivos();
        cargarTablaAlternativas();
        cargarTablaCambios();
        this.usuario = usuario;
        if(usuario.getAcceso() == false){
            btnCambios.setEnabled(false);
            btnObjetivos.setEnabled(false);
        }
    }

    private void init() {
        this.setLocationRelativeTo(null);
        this.setTitle("Detalles del Proyecto");
        this.setResizable(false);
    }

    private void cargarDatos(Proyecto proyecto) {
        this.proyecto = proyecto;
        this.txtDescripcion.setText(proyecto.getDescripcion());
        this.jLabel1.setText("Proyecto: " + proyecto.getNombre());
    }

    private void initControladores() {
        alternativaControlador = new AlternativaControlador();
        cambioControlador = new CambioControlador();
        objetivoControlador = new ObjetivoControlador();
    }

    private void cargarTablaAlternativas() {
        alternativas = alternativaControlador.mostrarPorProyecto(proyecto.getId());
        DefaultTableModel modelo = (DefaultTableModel) tablaAlternativas.getModel();
        modelo.setRowCount(0);
        for (Alternativa alternativa : alternativas) {
            if (alternativa.getCategoria().equals("Funcional")) {
                Object[] fila = { alternativa.getNombre(), alternativa.getDescripcion(), alternativa.getCategoria() };
                modelo.addRow(fila);
            }
        }
        tablaAlternativas.setModel(modelo);
    }

    private void cargarTablaCambios() {
        cambios = cambioControlador.mostrarPorProyecto(proyecto.getId());
        DefaultTableModel modelo = (DefaultTableModel) tablaCambios.getModel();
        modelo.setRowCount(0);
        for (Cambio cambio : cambios) {
            Object[] fila = { cambio.getNombre(), cambio.getDescripcion() };
            modelo.addRow(fila);
        }
        tablaCambios.setModel(modelo);
    }

    private void cargarTablaObjetivos() {
        objetivos = objetivoControlador.mostrarPorProyecto(proyecto.getId());
        DefaultTableModel modelo = (DefaultTableModel) tablaObjetivos.getModel();
        modelo.setRowCount(0);
        for (Objetivo objetivo : objetivos) {
            Object[] fila = { objetivo.getNombre(), objetivo.getDescripcion() };
            modelo.addRow(fila);
        }
        tablaObjetivos.setModel(modelo);
    }

    private void initTabla(JTable tabla, int columnas) {
        tabla.setRowHeight(25);

        DefaultTableCellRenderer centrar = new DefaultTableCellRenderer();
        centrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        for (int i = 0; i < columnas; i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(centrar);
        }

        tabla.getTableHeader().setFont(new java.awt.Font("Segoe UI", 1, 14)); // Cambiar letra del Header
        ((DefaultTableCellRenderer) tabla.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment(javax.swing.SwingConstants.CENTER); // Centrar Header
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaObjetivos = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaCambios = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaAlternativas = new javax.swing.JTable();
        btnAlternativas = new javax.swing.JButton();
        btnObjetivos = new javax.swing.JButton();
        btnCambios = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Proyecto:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Descripción:");

        txtDescripcion.setEditable(false);
        txtDescripcion.setColumns(20);
        txtDescripcion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setRows(5);
        txtDescripcion.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtDescripcion);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Lista de Objetivos:");

        tablaObjetivos.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "NOMBRE", "DESCRIPCIÓN"
                }) {
            boolean[] canEdit = new boolean[] {
                    false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaObjetivos);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Lista de Cambios:");

        tablaCambios.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "NOMBRE", "DESCRIPCIÓN"
                }) {
            boolean[] canEdit = new boolean[] {
                    false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane3.setViewportView(tablaCambios);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Mejores Alternativas:");

        tablaAlternativas.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "NOMBRE", "DESCRIPCIÓN", "CATEGORIA"
                }) {
            boolean[] canEdit = new boolean[] {
                    false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane4.setViewportView(tablaAlternativas);

        btnAlternativas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAlternativas.setText("Alternativas");
        btnAlternativas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlternativasActionPerformed(evt);
            }
        });

        btnObjetivos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnObjetivos.setText("Objetivos");
        btnObjetivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObjetivosActionPerformed(evt);
            }
        });

        btnCambios.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCambios.setText("Cambios");
        btnCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, 923, Short.MAX_VALUE)
                                        .addComponent(jScrollPane2)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 923,
                                                Short.MAX_VALUE)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 923,
                                                Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel6)
                                                        .addComponent(jLabel5))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                .createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(btnAlternativas)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnObjetivos)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnCambios)))
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnAlternativas)
                                        .addComponent(btnObjetivos)
                                        .addComponent(btnCambios))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnObjetivosActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnObjetivosActionPerformed
        this.dispose();
        adminObjetivos = new AdminObjetivos(proyecto, usuario);
        adminObjetivos.setVisible(true);
    }// GEN-LAST:event_btnObjetivosActionPerformed

    private void btnCambiosActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCambiosActionPerformed
        this.dispose();
        adminCambioInterfaz = new AdminCambioInterfaz(proyecto, usuario);
        adminCambioInterfaz.setVisible(true);
    }// GEN-LAST:event_btnCambiosActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {// GEN-FIRST:event_formWindowClosing
        AdminProyectoInterfaz adminUsuarioInterfaz = new AdminProyectoInterfaz(usuario);
        adminUsuarioInterfaz.setVisible(true);
    }// GEN-LAST:event_formWindowClosing

    private void btnAlternativasActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAlternativasActionPerformed
        this.dispose();
        adminAlternativaInterfaz = new AdminAlternativaInterfaz(proyecto, usuario);
        adminAlternativaInterfaz.setVisible(true);
    }// GEN-LAST:event_btnAlternativasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProyectoDetallesInterfaz.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProyectoDetallesInterfaz.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProyectoDetallesInterfaz.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProyectoDetallesInterfaz.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProyectoDetallesInterfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlternativas;
    private javax.swing.JButton btnCambios;
    private javax.swing.JButton btnObjetivos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tablaAlternativas;
    private javax.swing.JTable tablaCambios;
    private javax.swing.JTable tablaObjetivos;
    private javax.swing.JTextArea txtDescripcion;
    // End of variables declaration//GEN-END:variables
}
