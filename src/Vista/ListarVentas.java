/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ClienteControlador;
import Controlador.VentaControlador;
import Modelo.Cliente;
import Modelo.Venta;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Francisco Castillo
 * @version 30-11-2021
 * 28-11: creacion
 * 29-11: boton detalle compra todos, detalle compra cliente, detalle compra fecha
 * 30-11: metodo llenar tabla todos, iniciarla al nacer la ventana
 */
public class ListarVentas extends javax.swing.JFrame {

    /**
     * Creates new form ListarVentas
     */
    public ListarVentas() {
        initComponents();
        //inicializa la ventana en el centrol
        this.setLocationRelativeTo(null);
        try {
            llenarTablaTodos();
            llenarListaNombres();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    //inicializamos una variable estatica para ser usado en detalla venta
    public static int id_venta=0;
    
    //Metodo para llenar la tabla de todas las Ventas
    private void llenarTablaTodos(){
        //iniciamos variables
        int idventa, total, numero_operacion, rut_cliente;
        String medio_pago, tipo_documento, fechac;
        Date fecha;
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        //creamos obj del controlador
        VentaControlador vc = new VentaControlador();
        //creamos una copia de la tabla inicial para trabajar
        DefaultTableModel modelo = (DefaultTableModel) this.jtbl_Todos.getModel();
        //dejamos filas 0 inicialmente
        modelo.setRowCount(0);
        //llenamos la lista con el metodo del controlador
        List<Venta> lista = vc.listarTodos();
        //recorremos la lista y llenamos la tabla
        for(Venta v : lista){
            idventa = v.getId_venta();
            total = v.getTotal();
            fecha = v.getFecha();
            medio_pago = v.getMedio_pago();
            tipo_documento = v.getTipo_documento();
            numero_operacion = v.getNumero_operacion();
            rut_cliente = v.getRut_cliente();
            
            if(medio_pago.equals("E")){
                medio_pago = "Efectivo";
            }else if(medio_pago.equals("D")){
                medio_pago = "Debito";
            }else if(medio_pago.equals("C")){
                medio_pago = "Credito";
            }else{
                medio_pago = "Tranferencia";
            }
            
            if(tipo_documento.equals("B")){
                tipo_documento = "Boleta";
            }else{
                tipo_documento = "Factura";
            }
            fechac =   formatoFecha.format(fecha)+"";
            
            modelo.addRow(new Object[]{idventa, total, fechac, medio_pago, tipo_documento, numero_operacion, rut_cliente});
        }
    }
    
    //Metodo para llenar el jcombobox con los nombres de los clientes
    private void llenarListaNombres(){
        //iniciamos variables
        String nombre;
        //creamos obj del controlador
        ClienteControlador cc = new ClienteControlador();
        //limpiamos el combobox
        this.jcb_Clientes.removeAllItems();
        //llenamos lista de clientes
        List<Cliente> lista = cc.listarTodosClientesNombre();
        //recorremos la lista y llenamos el combobox
        for(Cliente c : lista){
            nombre = c.getNombre_cliente();
            this.jcb_Clientes.addItem(nombre);
        }
    }
    
    //Metodo para obtener el rut de un cliente
    private int obtenerRut(String nombre){
        //inicializamos variables
        int rut=0;
        //Creamos obj del controlador
        ClienteControlador cc = new ClienteControlador();
        //Creamos obj del modelo
        Cliente cliente = cc.buscarClienteNombre(nombre);
        rut = cliente.getRut();
        
        return rut;
    }
    
    //Metodo para llenar la tabla filtrado por un nombre de cliente
    private void llenarTablaCliente(int rut){
       //iniciamos variables
        int idventa, total, numero_operacion, rut_cliente;
        String medio_pago, tipo_documento, fechac;
        Date fecha;
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        //creamos obj del controlador
        VentaControlador vc = new VentaControlador();
        //creamos una copia de la tabla inicial para trabajar
        DefaultTableModel modelo = (DefaultTableModel) this.jtbl_Cliente.getModel();
        //dejamos filas 0 inicialmente
        modelo.setRowCount(0);
        //llenamos la lista con el metodo del controlador
        List<Venta> lista = vc.listarPorRut(rut);
        //validamos si la tabla no esta vacia, y si cliente tiene ventas asociadas
        if(lista.isEmpty()){
            JOptionPane.showMessageDialog(this, "Cliente No tiene Ventas Registradas ", "Validación", 2);
        }
        //recorremos la lista y llenamos la tabla
        for(Venta v : lista){
            idventa = v.getId_venta();
            total = v.getTotal();
            fecha = v.getFecha();
            medio_pago = v.getMedio_pago();
            tipo_documento = v.getTipo_documento();
            numero_operacion = v.getNumero_operacion();
            rut_cliente = v.getRut_cliente();
            
            if(medio_pago.equals("E")){
                medio_pago = "Efectivo";
            }else if(medio_pago.equals("D")){
                medio_pago = "Debito";
            }else if(medio_pago.equals("C")){
                medio_pago = "Credito";
            }else{
                medio_pago = "Tranferencia";
            }
            
            if(tipo_documento.equals("B")){
                tipo_documento = "Boleta";
            }else{
                tipo_documento = "Factura";
            }
            fechac =   formatoFecha.format(fecha)+"";
            
            modelo.addRow(new Object[]{idventa, total, fechac, medio_pago, tipo_documento, numero_operacion, rut_cliente});
        } 
    }
    
    //Metodo para llenar la tabla filtrado por fecha
    private void llenarTablaFecha(Date fechaConsulta){
       //iniciamos variables
        int idventa, total, numero_operacion, rut_cliente;
        String medio_pago, tipo_documento, fechac;
        Date fecha;
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        //creamos obj del controlador
        VentaControlador vc = new VentaControlador();
        //creamos una copia de la tabla inicial para trabajar
        DefaultTableModel modelo = (DefaultTableModel) this.jtbl_Fecha.getModel();
        //dejamos filas 0 inicialmente
        modelo.setRowCount(0);
        //llenamos la lista con el metodo del controlador
        List<Venta> lista = vc.listarPorFecha(fechaConsulta);
        //validamos si la tabla no esta vacia, hay ventas para esa fecha
        if(lista.isEmpty()){
            JOptionPane.showMessageDialog(this, "No hay Ventas registradas para esa Fecha", "Validación", 2);
        }
        //recorremos la lista y llenamos la tabla
        for(Venta v : lista){
            idventa = v.getId_venta();
            total = v.getTotal();
            fecha = v.getFecha();
            medio_pago = v.getMedio_pago();
            tipo_documento = v.getTipo_documento();
            numero_operacion = v.getNumero_operacion();
            rut_cliente = v.getRut_cliente();
            
            if(medio_pago.equals("E")){
                medio_pago = "Efectivo";
            }else if(medio_pago.equals("D")){
                medio_pago = "Debito";
            }else if(medio_pago.equals("C")){
                medio_pago = "Credito";
            }else{
                medio_pago = "Tranferencia";
            }
            
            if(tipo_documento.equals("B")){
                tipo_documento = "Boleta";
            }else{
                tipo_documento = "Factura";
            }
            fechac =   formatoFecha.format(fecha)+"";
            
            modelo.addRow(new Object[]{idventa, total, fechac, medio_pago, tipo_documento, numero_operacion, rut_cliente});
        } 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jbtn_VerDCTodos = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbl_Todos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jbtn_VerDCCliente = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbl_Cliente = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jcb_Clientes = new javax.swing.JComboBox<>();
        jbtn_ListarCliente = new javax.swing.JButton();
        jbtn_LimpiarCliente = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jbtn_VerDCFecha = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtbl_Fecha = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jtxt_Dia = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jbtn_ListarFecha = new javax.swing.JButton();
        jbtn_LimpiarFecha = new javax.swing.JButton();
        jtxt_Mes = new javax.swing.JTextField();
        jtxt_Ano = new javax.swing.JTextField();
        jbtn_Volver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LISTAR VENTAS");

        jbtn_VerDCTodos.setBackground(new java.awt.Color(0, 153, 153));
        jbtn_VerDCTodos.setText("Ver Detalle Compra");
        jbtn_VerDCTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_VerDCTodosActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));

        jtbl_Todos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        jtbl_Todos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Venta", "Total", "Fecha", "Medio De Pago", "Tipo Documento", "Número Operación", "Rut Cliente"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbl_Todos.setColumnSelectionAllowed(true);
        jtbl_Todos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtbl_Todos);
        jtbl_Todos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(236, 236, 236)
                .addComponent(jbtn_VerDCTodos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtn_VerDCTodos)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Listar Todas las Ventas", jPanel1);

        jbtn_VerDCCliente.setBackground(new java.awt.Color(0, 153, 153));
        jbtn_VerDCCliente.setText("Ver Detalle Compra");
        jbtn_VerDCCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_VerDCClienteActionPerformed(evt);
            }
        });

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));

        jtbl_Cliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        jtbl_Cliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Venta", "Total", "Fecha", "Medio De Pago", "Tipo Documento", "Número Operación", "Rut Cliente"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbl_Cliente.setColumnSelectionAllowed(true);
        jtbl_Cliente.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jtbl_Cliente);
        jtbl_Cliente.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jLabel2.setText("Seleccione Cliente:");

        jcb_Clientes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "juan", "jorge", "pedro", "pablo", "diego", "denisse", "cesar", "cristian" }));

        jbtn_ListarCliente.setBackground(new java.awt.Color(153, 153, 153));
        jbtn_ListarCliente.setText("Listar");
        jbtn_ListarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_ListarClienteActionPerformed(evt);
            }
        });

        jbtn_LimpiarCliente.setText("Limpiar");
        jbtn_LimpiarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_LimpiarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jcb_Clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(jbtn_ListarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtn_LimpiarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(228, 228, 228)
                .addComponent(jbtn_VerDCCliente)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcb_Clientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn_ListarCliente)
                    .addComponent(jbtn_LimpiarCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtn_VerDCCliente)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Listar por Cliente", jPanel2);

        jbtn_VerDCFecha.setBackground(new java.awt.Color(0, 153, 153));
        jbtn_VerDCFecha.setText("Ver Detalle Compra");
        jbtn_VerDCFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_VerDCFechaActionPerformed(evt);
            }
        });

        jScrollPane3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));

        jtbl_Fecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        jtbl_Fecha.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Venta", "Total", "Fecha", "Medio De Pago", "Tipo Documento", "Número Operación", "Rut Cliente"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbl_Fecha.setColumnSelectionAllowed(true);
        jtbl_Fecha.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jtbl_Fecha);
        jtbl_Fecha.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jLabel3.setText("Ingrese Fecha:");

        jLabel4.setText("Formato Dia/Mes/Año");

        jbtn_ListarFecha.setBackground(new java.awt.Color(153, 153, 153));
        jbtn_ListarFecha.setText("Listar");
        jbtn_ListarFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_ListarFechaActionPerformed(evt);
            }
        });

        jbtn_LimpiarFecha.setText("Limpiar");
        jbtn_LimpiarFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_LimpiarFechaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(jbtn_VerDCFecha)
                        .addGap(0, 239, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jtxt_Dia, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtxt_Mes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtxt_Ano, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtn_ListarFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtn_LimpiarFecha)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtxt_Dia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jbtn_ListarFecha)
                    .addComponent(jbtn_LimpiarFecha)
                    .addComponent(jtxt_Mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxt_Ano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtn_VerDCFecha)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Listar por Fecha", jPanel3);

        jbtn_Volver.setText("Volver al Menú");
        jbtn_Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_VolverActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("Copyright - Alison Barraza - Francisco Castillo - Cristian Gonzalez - 2021");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTabbedPane1))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(248, 248, 248)
                .addComponent(jbtn_Volver)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtn_Volver)
                .addGap(18, 18, 18)
                .addComponent(jLabel1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtn_VerDCTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_VerDCTodosActionPerformed
        int dato;
        int row;
        try {
            //seleccionamo la fila de la tabla que haya sido seleccionada, 
            //getselectedrow nos devolvera el nro de la fila, si no hay ninguna sera -1
            row = this.jtbl_Todos.getSelectedRow();
            //luego obtenemos el dato que esta en la tabla en este caso el titulo, que esta en posicion 1
            //recordar que la posicion parte desde  0 (ID)
            //esto con getValueAt(fila, columna)
            if(row >=0){
                dato = (Integer) this.jtbl_Todos.getValueAt(row, 0);
                id_venta = dato;
                new DetalleVentaGUI().setVisible(true);
            }else{
                JOptionPane.showMessageDialog(this, "Seleccione una fila de Venta ", "Validación", 2);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jbtn_VerDCTodosActionPerformed

    private void jbtn_VerDCClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_VerDCClienteActionPerformed
        int dato;
        int row;
        try {
            //seleccionamo la fila de la tabla que haya sido seleccionada, 
            //getselectedrow nos devolvera el nro de la fila, si no hay ninguna sera -1
            row = this.jtbl_Cliente.getSelectedRow();
            //luego obtenemos el dato que esta en la tabla en este caso el titulo, que esta en posicion 1
            //recordar que la posicion parte desde  0 (ID)
            //esto con getValueAt(fila, columna)
            if(row >=0){
                dato = (Integer) this.jtbl_Cliente.getValueAt(row, 0);
                id_venta = dato;
                new DetalleVentaGUI().setVisible(true);
            }else{
                JOptionPane.showMessageDialog(this, "Seleccione una fila de Venta ", "Validación", 2);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jbtn_VerDCClienteActionPerformed

    private void jbtn_VerDCFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_VerDCFechaActionPerformed
        int dato;
        int row;
        try {
            //seleccionamo la fila de la tabla que haya sido seleccionada, 
            //getselectedrow nos devolvera el nro de la fila, si no hay ninguna sera -1
            row = this.jtbl_Fecha.getSelectedRow();
            //luego obtenemos el dato que esta en la tabla en este caso el titulo, que esta en posicion 1
            //recordar que la posicion parte desde  0 (ID)
            //esto con getValueAt(fila, columna)
            if(row >=0){
                dato = (Integer) this.jtbl_Fecha.getValueAt(row, 0);
                id_venta = dato;
                new DetalleVentaGUI().setVisible(true);
            }else{
                JOptionPane.showMessageDialog(this, "Seleccione una fila de Venta ", "Validación", 2);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jbtn_VerDCFechaActionPerformed

    private void jbtn_VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_VolverActionPerformed
        dispose();
    }//GEN-LAST:event_jbtn_VolverActionPerformed

    private void jbtn_ListarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_ListarClienteActionPerformed
        //inicializamos variables
        String nombre;
        int rut;
        try {
            //obtenemos el nombre del combobox seleccionado
        nombre = (String) this.jcb_Clientes.getSelectedItem();
        //obtenemos el rut del cliente seleccionado
        rut = obtenerRut(nombre);
        //llenamos la tabla
        llenarTablaCliente(rut);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        
    }//GEN-LAST:event_jbtn_ListarClienteActionPerformed

    private void jbtn_LimpiarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_LimpiarClienteActionPerformed
        //creamos una copia de la tabla inicial para trabajar
        DefaultTableModel modelo = (DefaultTableModel) this.jtbl_Cliente.getModel();
        //dejamos filas 0 inicialmente
        modelo.setRowCount(0);
    }//GEN-LAST:event_jbtn_LimpiarClienteActionPerformed

    private void jbtn_ListarFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_ListarFechaActionPerformed
        //Rescatamos datos
        String dia, mes, ano, fechaf;
        dia = this.jtxt_Dia.getText();
        mes = this.jtxt_Mes.getText();
        ano = this.jtxt_Ano.getText();
        //vemos que no hayan datos sin llenar
        if(dia.isEmpty()){
            JOptionPane.showMessageDialog(this, "Ingrese dia", "Validacion", 2);
            this.jtxt_Dia.requestFocus();
            return;
        }
        if(mes.isEmpty()){
            JOptionPane.showMessageDialog(this, "Ingrese mes", "Validacion", 2);
            this.jtxt_Mes.requestFocus();
            return;
        }
        if(ano.isEmpty()){
            JOptionPane.showMessageDialog(this, "Ingrese año", "Validacion", 2);
            this.jtxt_Ano.requestFocus();
            return;
        }
        //armamos la fecha
        fechaf = dia+"/"+mes+"/"+ano;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha=null;
        try {
            fecha = formato.parse(fechaf);
        } catch (ParseException e) {
            System.out.println("Error de actualización de fecha " + e.getMessage());
        }
        //llenamos la tabla
        llenarTablaFecha(fecha);
    }//GEN-LAST:event_jbtn_ListarFechaActionPerformed

    private void jbtn_LimpiarFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_LimpiarFechaActionPerformed
        //creamos una copia de la tabla inicial para trabajar
        DefaultTableModel modelo = (DefaultTableModel) this.jtbl_Fecha.getModel();
        //dejamos filas 0 inicialmente
        modelo.setRowCount(0);
    }//GEN-LAST:event_jbtn_LimpiarFechaActionPerformed

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
            java.util.logging.Logger.getLogger(ListarVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListarVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListarVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListarVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListarVentas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbtn_LimpiarCliente;
    private javax.swing.JButton jbtn_LimpiarFecha;
    private javax.swing.JButton jbtn_ListarCliente;
    private javax.swing.JButton jbtn_ListarFecha;
    private javax.swing.JButton jbtn_VerDCCliente;
    private javax.swing.JButton jbtn_VerDCFecha;
    private javax.swing.JButton jbtn_VerDCTodos;
    private javax.swing.JButton jbtn_Volver;
    private javax.swing.JComboBox<String> jcb_Clientes;
    private javax.swing.JTable jtbl_Cliente;
    private javax.swing.JTable jtbl_Fecha;
    private javax.swing.JTable jtbl_Todos;
    private javax.swing.JTextField jtxt_Ano;
    private javax.swing.JTextField jtxt_Dia;
    private javax.swing.JTextField jtxt_Mes;
    // End of variables declaration//GEN-END:variables
}
