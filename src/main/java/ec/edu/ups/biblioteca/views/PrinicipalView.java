/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/MDIApplication.java to edit this template
 */
package ec.edu.ups.biblioteca.views;

import ec.edu.ups.biblioteca.controllers.AutorController;
import ec.edu.ups.biblioteca.controllers.LibroController;
import ec.edu.ups.biblioteca.controllers.PrestamoController;
import ec.edu.ups.biblioteca.controllers.UsuarioController;
import ec.edu.ups.biblioteca.dao.AutorDAO;
import ec.edu.ups.biblioteca.dao.AutorDAOMemoria;
import ec.edu.ups.biblioteca.dao.LibroDAO;
import ec.edu.ups.biblioteca.dao.LibroDAOMemoria;
import ec.edu.ups.biblioteca.dao.PrestamoDAO;
import ec.edu.ups.biblioteca.dao.PrestamoDAOMemoria;
import ec.edu.ups.biblioteca.dao.UsuarioDAO;
import ec.edu.ups.biblioteca.dao.UsuarioDAOMemoria;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author Miguel Maza
 */
public class PrinicipalView extends javax.swing.JFrame {
    private RegistrarLibroView registrarLibroView;
    private BuscarLibroView buscarLibroView;
    private LibroDAO libroDAO;
    private LibroController libroController;
    private AutorDAO autorDAO;
    private RegistrarAutorView registrarAutorView;
    private AutorController autorController;
    private EliminarLibroView eliminarLibroView;
    private ListarLibroView listarLibroView;
    private ActualizarLibroView actualizarLibroView;
    private BuscarAutorView buscarAutorView;
    private EliminarAutorView eliminarAutorView;
    private ActualizarAutorView actualizarAutorView;
    private ListarAutorView listarAutorView;
    private RegistrarUsuarioView registrarUsuarioView;
    private UsuarioDAO usuarioDAO;
    private UsuarioController usuarioController;
    private BuscarUsuarioView buscarUsuarioView;
    private EliminarUsuarioView eliminarUsuarioView;
    private ActualizarUsuarioView actualizarUsuarioView;
    private ListarUsuarioView listarUsuarioView;
    private CrearPrestamoView crearPrestamoView;
    private PrestamoDAO prestamoDAO;
    private PrestamoController prestamoController;
    private BuscarPrestamoView buscarPrestamoView;
    private ListarPrestamoView listarPrestamoView;
    private CrearDevolucionView crearDevolucionView;
    /**
     * Creates new form PrinicipalView
     */
    public PrinicipalView() {
        initComponents();
        setLocationRelativeTo(null);
        registrarLibroView = new RegistrarLibroView();
        buscarLibroView = new BuscarLibroView();
        libroDAO = new LibroDAOMemoria();
        autorDAO = new AutorDAOMemoria();
        registrarAutorView = new RegistrarAutorView();
        eliminarLibroView = new EliminarLibroView();
        listarLibroView= new ListarLibroView();
        actualizarLibroView = new ActualizarLibroView();
        buscarAutorView = new BuscarAutorView();
        eliminarAutorView = new EliminarAutorView();
        actualizarAutorView = new ActualizarAutorView();
        listarAutorView = new ListarAutorView();
        
        usuarioDAO = new UsuarioDAOMemoria();
        registrarUsuarioView = new RegistrarUsuarioView();
        buscarUsuarioView= new BuscarUsuarioView();
        eliminarUsuarioView = new EliminarUsuarioView();
        actualizarUsuarioView = new ActualizarUsuarioView();
        listarUsuarioView = new ListarUsuarioView();
        
        prestamoDAO= new PrestamoDAOMemoria();
        crearPrestamoView = new CrearPrestamoView();
        buscarPrestamoView = new BuscarPrestamoView();
        listarPrestamoView = new ListarPrestamoView();
        crearDevolucionView = new CrearDevolucionView();
        libroController = new LibroController(libroDAO,registrarLibroView,autorDAO,buscarLibroView, eliminarLibroView,listarLibroView,actualizarLibroView);
        autorController = new AutorController(autorDAO,registrarAutorView ,buscarAutorView,eliminarAutorView,actualizarAutorView,listarAutorView);
        usuarioController = new UsuarioController(usuarioDAO,registrarUsuarioView,buscarUsuarioView,eliminarUsuarioView,actualizarUsuarioView,listarUsuarioView);
        prestamoController = new PrestamoController(prestamoDAO,usuarioDAO,libroDAO,crearPrestamoView,buscarPrestamoView,listarPrestamoView,crearDevolucionView);
    }
    public void cambiarIdioma(Locale locale){
        ResourceBundle bundle = ResourceBundle.getBundle("ec.edu.ups.biblioteca.i18n.mensajes", locale);
        
        libroMenu.setText(bundle.getString("libroMenu"));
        autorMenu.setText(bundle.getString("autorMenu"));
        usuarioMenu.setText(bundle.getString("usuarioMenu"));
        prestamoMenu.setText(bundle.getString("prestamoMenu"));
        devolucionMenu.setText(bundle.getString("devolucionMenu"));
        idiomaMenu.setText(bundle.getString("idiomaMenu"));
        registrarLMenuItem.setText(bundle.getString("registrarMenuItem"));
        buscarLMenuItem.setText(bundle.getString("buscarMenuItem"));
        actualizarLMenuItem.setText(bundle.getString("actualizarMenuItem"));
        eliminarLMenuItem.setText(bundle.getString("eliminarMenuItem"));
        listarLMenuItem.setText(bundle.getString("listarMenuItem"));
        
        registrarAMenuI.setText(bundle.getString("registrarMenuItem"));
        buscarAMenuI.setText(bundle.getString("buscarMenuItem"));
        actualizarAMenuI.setText(bundle.getString("actualizarMenuItem"));
        eliminarAMenuI.setText(bundle.getString("eliminarMenuItem"));
        listarAMenuI.setText(bundle.getString("listarMenuItem"));
        
        registrarUMenuItem.setText(bundle.getString("registrarMenuItem"));
        buscarUMenuItem.setText(bundle.getString("buscarMenuItem"));
        actualizarUMenuItem.setText(bundle.getString("actualizarMenuItem"));
        eliminarUMenuItem.setText(bundle.getString("eliminarMenuItem"));
        listarUMenuItem.setText(bundle.getString("listarMenuItem"));
        
        registrarPMenuItem.setText(bundle.getString("registrarMenuItem"));
        buscarPMenuItem.setText(bundle.getString("buscarMenuItem"));
        listarPMenuItem.setText(bundle.getString("listarMenuItem"));
        eliminarPMenuItem.setText(bundle.getString("devolucionMenuItem"));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        libroMenu = new javax.swing.JMenu();
        registrarLMenuItem = new javax.swing.JMenuItem();
        buscarLMenuItem = new javax.swing.JMenuItem();
        actualizarLMenuItem = new javax.swing.JMenuItem();
        eliminarLMenuItem = new javax.swing.JMenuItem();
        listarLMenuItem = new javax.swing.JMenuItem();
        autorMenu = new javax.swing.JMenu();
        registrarAMenuI = new javax.swing.JMenuItem();
        buscarAMenuI = new javax.swing.JMenuItem();
        eliminarAMenuI = new javax.swing.JMenuItem();
        actualizarAMenuI = new javax.swing.JMenuItem();
        listarAMenuI = new javax.swing.JMenuItem();
        usuarioMenu = new javax.swing.JMenu();
        registrarUMenuItem = new javax.swing.JMenuItem();
        buscarUMenuItem = new javax.swing.JMenuItem();
        eliminarUMenuItem = new javax.swing.JMenuItem();
        actualizarUMenuItem = new javax.swing.JMenuItem();
        listarUMenuItem = new javax.swing.JMenuItem();
        prestamoMenu = new javax.swing.JMenu();
        registrarPMenuItem = new javax.swing.JMenuItem();
        buscarPMenuItem = new javax.swing.JMenuItem();
        listarPMenuItem = new javax.swing.JMenuItem();
        devolucionMenu = new javax.swing.JMenu();
        eliminarPMenuItem = new javax.swing.JMenuItem();
        idiomaMenu = new javax.swing.JMenu();
        idiomaEspanoMenuItem = new javax.swing.JMenuItem();
        idiomaInglesMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/biblioteca/images/tituloBiblioteca.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(desktopPane)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 663, Short.MAX_VALUE))
                .addGap(143, 143, 143))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        libroMenu.setMnemonic('f');
        libroMenu.setText("Libros");

        registrarLMenuItem.setMnemonic('o');
        registrarLMenuItem.setText("Registrar");
        registrarLMenuItem.addActionListener(this::registrarLMenuItemActionPerformed);
        libroMenu.add(registrarLMenuItem);

        buscarLMenuItem.setMnemonic('s');
        buscarLMenuItem.setText("Buscar");
        buscarLMenuItem.addActionListener(this::buscarLMenuItemActionPerformed);
        libroMenu.add(buscarLMenuItem);

        actualizarLMenuItem.setMnemonic('a');
        actualizarLMenuItem.setText("Actualizar");
        actualizarLMenuItem.addActionListener(this::actualizarLMenuItemActionPerformed);
        libroMenu.add(actualizarLMenuItem);

        eliminarLMenuItem.setMnemonic('x');
        eliminarLMenuItem.setText("Eliminar");
        eliminarLMenuItem.addActionListener(this::eliminarLMenuItemActionPerformed);
        libroMenu.add(eliminarLMenuItem);

        listarLMenuItem.setText("Listar");
        listarLMenuItem.addActionListener(this::listarLMenuItemActionPerformed);
        libroMenu.add(listarLMenuItem);

        menuBar.add(libroMenu);

        autorMenu.setMnemonic('e');
        autorMenu.setText("Autor");

        registrarAMenuI.setMnemonic('t');
        registrarAMenuI.setText("Registrar");
        registrarAMenuI.addActionListener(this::registrarAMenuIActionPerformed);
        autorMenu.add(registrarAMenuI);

        buscarAMenuI.setMnemonic('y');
        buscarAMenuI.setText("Buscar");
        buscarAMenuI.addActionListener(this::buscarAMenuIActionPerformed);
        autorMenu.add(buscarAMenuI);

        eliminarAMenuI.setMnemonic('p');
        eliminarAMenuI.setText("Eliminar");
        eliminarAMenuI.addActionListener(this::eliminarAMenuIActionPerformed);
        autorMenu.add(eliminarAMenuI);

        actualizarAMenuI.setMnemonic('d');
        actualizarAMenuI.setText("Actualizar");
        actualizarAMenuI.addActionListener(this::actualizarAMenuIActionPerformed);
        autorMenu.add(actualizarAMenuI);

        listarAMenuI.setText("Listar");
        listarAMenuI.addActionListener(this::listarAMenuIActionPerformed);
        autorMenu.add(listarAMenuI);

        menuBar.add(autorMenu);

        usuarioMenu.setMnemonic('h');
        usuarioMenu.setText("Usuario");

        registrarUMenuItem.setMnemonic('c');
        registrarUMenuItem.setText("Registrar");
        registrarUMenuItem.addActionListener(this::registrarUMenuItemActionPerformed);
        usuarioMenu.add(registrarUMenuItem);

        buscarUMenuItem.setMnemonic('a');
        buscarUMenuItem.setText("Buscar");
        buscarUMenuItem.addActionListener(this::buscarUMenuItemActionPerformed);
        usuarioMenu.add(buscarUMenuItem);

        eliminarUMenuItem.setText("Eliminar");
        eliminarUMenuItem.addActionListener(this::eliminarUMenuItemActionPerformed);
        usuarioMenu.add(eliminarUMenuItem);

        actualizarUMenuItem.setText("Actualizar");
        actualizarUMenuItem.addActionListener(this::actualizarUMenuItemActionPerformed);
        usuarioMenu.add(actualizarUMenuItem);

        listarUMenuItem.setText("Listar");
        listarUMenuItem.addActionListener(this::listarUMenuItemActionPerformed);
        usuarioMenu.add(listarUMenuItem);

        menuBar.add(usuarioMenu);

        prestamoMenu.setText("Prestamo");

        registrarPMenuItem.setText("Crear");
        registrarPMenuItem.addActionListener(this::registrarPMenuItemActionPerformed);
        prestamoMenu.add(registrarPMenuItem);

        buscarPMenuItem.setText("Buscar");
        buscarPMenuItem.addActionListener(this::buscarPMenuItemActionPerformed);
        prestamoMenu.add(buscarPMenuItem);

        listarPMenuItem.setText("Listar");
        listarPMenuItem.addActionListener(this::listarPMenuItemActionPerformed);
        prestamoMenu.add(listarPMenuItem);

        menuBar.add(prestamoMenu);

        devolucionMenu.setText("Devolucion");

        eliminarPMenuItem.setText("Devolver");
        eliminarPMenuItem.addActionListener(this::eliminarPMenuItemActionPerformed);
        devolucionMenu.add(eliminarPMenuItem);

        menuBar.add(devolucionMenu);

        idiomaMenu.setText("Idioma");

        idiomaEspanoMenuItem.setText("Español");
        idiomaEspanoMenuItem.addActionListener(this::idiomaEspanoMenuItemActionPerformed);
        idiomaMenu.add(idiomaEspanoMenuItem);

        idiomaInglesMenuItem.setText("Ingles");
        idiomaInglesMenuItem.addActionListener(this::idiomaInglesMenuItemActionPerformed);
        idiomaMenu.add(idiomaInglesMenuItem);

        menuBar.add(idiomaMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void eliminarLMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarLMenuItemActionPerformed
             if(!eliminarLibroView.isVisible()){ 
                    //libroController.cargarAutores();
                    desktopPane.remove(eliminarLibroView);
                    eliminarLibroView.setVisible(true);
                    desktopPane.add(eliminarLibroView);            
        } 
    }//GEN-LAST:event_eliminarLMenuItemActionPerformed

    private void registrarLMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarLMenuItemActionPerformed
               if(!registrarLibroView.isVisible()){ 
                    libroController.cargarAutores();
                    registrarLibroView.setVisible(true);
                   desktopPane.remove(registrarLibroView);
                    
                    desktopPane.add(registrarLibroView);            
        } 
    // TODO add your handling code here:
    }//GEN-LAST:event_registrarLMenuItemActionPerformed

    private void registrarAMenuIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarAMenuIActionPerformed
             if(!registrarAutorView.isVisible()){    
                    desktopPane.remove(registrarAutorView);
                    registrarAutorView.setVisible(true);
                    desktopPane.add(registrarAutorView);            
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_registrarAMenuIActionPerformed

    private void actualizarLMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarLMenuItemActionPerformed
                 if(!actualizarLibroView.isVisible()){  
                     libroController.cargarAutoresA();
                    desktopPane.remove(actualizarLibroView);
                    actualizarLibroView.setVisible(true);
                    desktopPane.add(actualizarLibroView);            
        } 
        // TODO add your handling code here:
    }//GEN-LAST:event_actualizarLMenuItemActionPerformed

    private void buscarLMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarLMenuItemActionPerformed
              if(!buscarLibroView.isVisible()){ 
                    //libroController.cargarAutores();
                    desktopPane.remove(buscarLibroView);
                    buscarLibroView.setVisible(true);
                    desktopPane.add(buscarLibroView);            
        } 
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarLMenuItemActionPerformed

    private void listarLMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarLMenuItemActionPerformed
                 if(!listarLibroView.isVisible()){ 
                    desktopPane.remove(listarLibroView);
                    listarLibroView.setVisible(true);
                    desktopPane.add(listarLibroView);            
        }  
        // TODO add your handling code here:
    }//GEN-LAST:event_listarLMenuItemActionPerformed

    private void buscarAMenuIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarAMenuIActionPerformed
                if(!buscarAutorView.isVisible()){    
                    desktopPane.remove(buscarAutorView);
                    buscarAutorView.setVisible(true);
                    desktopPane.add(buscarAutorView);            
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarAMenuIActionPerformed

    private void eliminarAMenuIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarAMenuIActionPerformed
            if(!eliminarAutorView.isVisible()){    
                    desktopPane.remove(eliminarAutorView);
                    eliminarAutorView.setVisible(true);
                    desktopPane.add(eliminarAutorView);            
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_eliminarAMenuIActionPerformed

    private void actualizarAMenuIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarAMenuIActionPerformed
              if(!actualizarAutorView.isVisible()){    
                    desktopPane.remove(actualizarAutorView);
                    actualizarAutorView.setVisible(true);
                    desktopPane.add(actualizarAutorView);            
        }    
        // TODO add your handling code here:
    }//GEN-LAST:event_actualizarAMenuIActionPerformed

    private void listarAMenuIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarAMenuIActionPerformed
                 if(!listarAutorView.isVisible()){    
                    desktopPane.remove(listarAutorView);
                    listarAutorView.setVisible(true);
                    desktopPane.add(listarAutorView);            
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_listarAMenuIActionPerformed

    private void registrarUMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarUMenuItemActionPerformed
                if(!registrarUsuarioView.isVisible()){    
                    desktopPane.remove(registrarUsuarioView);
                    registrarUsuarioView.setVisible(true);
                    desktopPane.add(registrarUsuarioView);            
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_registrarUMenuItemActionPerformed

    private void buscarUMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarUMenuItemActionPerformed
              if(!buscarUsuarioView.isVisible()){    
                    desktopPane.remove(buscarUsuarioView);
                    buscarUsuarioView.setVisible(true);
                    desktopPane.add(buscarUsuarioView);            
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarUMenuItemActionPerformed

    private void eliminarUMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarUMenuItemActionPerformed
             if(!eliminarUsuarioView.isVisible()){ 
                    desktopPane.remove(eliminarUsuarioView);
                    eliminarUsuarioView.setVisible(true);
                    desktopPane.add(eliminarUsuarioView);            
        }
            // TODO add your handling code here:
    }//GEN-LAST:event_eliminarUMenuItemActionPerformed

    private void actualizarUMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarUMenuItemActionPerformed
                if(!actualizarUsuarioView.isVisible()){    
                    desktopPane.remove(actualizarUsuarioView);
                    actualizarUsuarioView.setVisible(true);
                    desktopPane.add(actualizarUsuarioView);            
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_actualizarUMenuItemActionPerformed

    private void listarUMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarUMenuItemActionPerformed
             if(!listarUsuarioView.isVisible()){    
                    desktopPane.remove(listarUsuarioView);
                    listarUsuarioView.setVisible(true);
                    desktopPane.add(listarUsuarioView);            
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_listarUMenuItemActionPerformed

    private void registrarPMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarPMenuItemActionPerformed
               if(!crearPrestamoView.isVisible()){  
                    prestamoController.cargarLibros();
                    prestamoController.cargarUsuarios();
                    desktopPane.remove(crearPrestamoView);
                    crearPrestamoView.setVisible(true);
                    desktopPane.add(crearPrestamoView);            
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_registrarPMenuItemActionPerformed

    private void buscarPMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarPMenuItemActionPerformed
            if(!buscarPrestamoView.isVisible()){    
                    desktopPane.remove(buscarPrestamoView);
                    buscarPrestamoView.setVisible(true);
                    desktopPane.add(buscarPrestamoView);            
        }  
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarPMenuItemActionPerformed

    private void listarPMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarPMenuItemActionPerformed
             if(!listarPrestamoView.isVisible()){    
                    desktopPane.remove(listarPrestamoView);
                    listarPrestamoView.setVisible(true);
                    desktopPane.add(listarPrestamoView);            
        }    
        // TODO add your handling code here:
    }//GEN-LAST:event_listarPMenuItemActionPerformed

    private void eliminarPMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarPMenuItemActionPerformed
                   if(!crearDevolucionView.isVisible()){ 
                    desktopPane.remove(crearDevolucionView);
                    crearDevolucionView.setVisible(true);
                    desktopPane.add(crearDevolucionView);            
        }   
        // TODO add your handling code here:
    }//GEN-LAST:event_eliminarPMenuItemActionPerformed

    private void idiomaEspanoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idiomaEspanoMenuItemActionPerformed
                Locale locale = new Locale( "es", "EC") ;
                this.cambiarIdioma(locale);
                registrarLibroView.cambiarIdioma(locale);
                buscarLibroView.cambiarIdioma(locale);
                eliminarLibroView.cambiarIdioma(locale);
                listarLibroView.cambiarIdioma(locale);
                registrarAutorView.cambiarIdioma(locale);
                eliminarAutorView.cambiarIdioma(locale);
                actualizarAutorView.cambiarIdioma(locale);
                buscarAutorView.cambiarIdioma(locale);
                listarAutorView.cambiarIdioma(locale);
                registrarUsuarioView.cambiarIdioma(locale);
                buscarUsuarioView.cambiarIdioma(locale);
                eliminarUsuarioView.cambiarIdioma(locale);
                actualizarUsuarioView.cambiarIdioma(locale);
                listarUsuarioView.cambiarIdioma(locale);
                crearPrestamoView.cambiarIdioma(locale);
                buscarPrestamoView.cambiarIdioma(locale);
                listarPrestamoView.cambiarIdioma(locale);
                crearDevolucionView.cambiarIdioma(locale);
                // TODO add your handling code here:
    }//GEN-LAST:event_idiomaEspanoMenuItemActionPerformed

    private void idiomaInglesMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idiomaInglesMenuItemActionPerformed
               Locale locale = new Locale("en" , "US");
              this.cambiarIdioma(locale);
              registrarLibroView.cambiarIdioma(locale);
              buscarLibroView.cambiarIdioma(locale);
              actualizarLibroView.cambiarIdioma(locale);
              eliminarLibroView.cambiarIdioma(locale);
              listarLibroView.cambiarIdioma(locale);
              registrarAutorView.cambiarIdioma(locale);
              eliminarAutorView.cambiarIdioma(locale);
              actualizarAutorView.cambiarIdioma(locale);
              buscarAutorView.cambiarIdioma(locale);
              listarAutorView.cambiarIdioma(locale);
              registrarUsuarioView.cambiarIdioma(locale);
              buscarUsuarioView.cambiarIdioma(locale);
              eliminarUsuarioView.cambiarIdioma(locale);
              actualizarUsuarioView.cambiarIdioma(locale);
              listarUsuarioView.cambiarIdioma(locale);
              crearPrestamoView.cambiarIdioma(locale);
              buscarPrestamoView.cambiarIdioma(locale);
              listarPrestamoView.cambiarIdioma(locale);
              crearDevolucionView.cambiarIdioma(locale);
        // TODO add your handling code here:
    }//GEN-LAST:event_idiomaInglesMenuItemActionPerformed

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
            java.util.logging.Logger.getLogger(PrinicipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrinicipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrinicipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrinicipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrinicipalView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem actualizarAMenuI;
    private javax.swing.JMenuItem actualizarLMenuItem;
    private javax.swing.JMenuItem actualizarUMenuItem;
    private javax.swing.JMenu autorMenu;
    private javax.swing.JMenuItem buscarAMenuI;
    private javax.swing.JMenuItem buscarLMenuItem;
    private javax.swing.JMenuItem buscarPMenuItem;
    private javax.swing.JMenuItem buscarUMenuItem;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu devolucionMenu;
    private javax.swing.JMenuItem eliminarAMenuI;
    private javax.swing.JMenuItem eliminarLMenuItem;
    private javax.swing.JMenuItem eliminarPMenuItem;
    private javax.swing.JMenuItem eliminarUMenuItem;
    private javax.swing.JMenuItem idiomaEspanoMenuItem;
    private javax.swing.JMenuItem idiomaInglesMenuItem;
    private javax.swing.JMenu idiomaMenu;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JMenu libroMenu;
    private javax.swing.JMenuItem listarAMenuI;
    private javax.swing.JMenuItem listarLMenuItem;
    private javax.swing.JMenuItem listarPMenuItem;
    private javax.swing.JMenuItem listarUMenuItem;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu prestamoMenu;
    private javax.swing.JMenuItem registrarAMenuI;
    private javax.swing.JMenuItem registrarLMenuItem;
    private javax.swing.JMenuItem registrarPMenuItem;
    private javax.swing.JMenuItem registrarUMenuItem;
    private javax.swing.JMenu usuarioMenu;
    // End of variables declaration//GEN-END:variables

}
