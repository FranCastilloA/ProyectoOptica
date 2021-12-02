/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ClienteControlador;
import Controlador.DetalleVentaControlador;
import Controlador.ProductoControlador;
import Controlador.VentaControlador;
import Modelo.Cliente;
import Modelo.DetalleVenta;
import Modelo.Producto;
import Modelo.Venta;
import java.awt.HeadlessException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Francisco Castillo
 * @version 02-12-2021
 */
public class GenerarVenta extends javax.swing.JFrame {

    /**
     * Creates new form GenerarVenta
     */
    public GenerarVenta() {
        initComponents();
        //inicializa la ventana en el centrol
        this.setLocationRelativeTo(null);
        try {
            llenarListaNombres();
            llenarListaProductos();
            vaciarCarrito();
            iniciarFecha();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    //creamos una variable total
    int total=0;
    
    //Metodo para llenar el jcombobox con los nombres de los clientes
    private void llenarListaNombres(){
        //iniciamos variables
        String nombre;
        //creamos obj del controlador
        ClienteControlador cc = new ClienteControlador();
        //limpiamos el combobox
        this.jcb_Cliente.removeAllItems();
        //llenamos lista de clientes
        List<Cliente> lista = cc.listarTodosClientesNombre();
        //recorremos la lista y llenamos el combobox
        for(Cliente c : lista){
            nombre = c.getNombre_cliente();
            this.jcb_Cliente.addItem(nombre);
        }
    }
    //Metodo para llenar el jcombobox con los nombres de los productos
    private void llenarListaProductos(){
        //iniciamos variables
        String nombre;
        //creamos obj del controlador
        ProductoControlador pc = new ProductoControlador();
        //limpiamos el combobox
        this.jcb_Producto.removeAllItems();
        //llenamos lista de clientes
        List<Producto> lista = pc.listarTodosProductosNombre();
        //recorremos la lista y llenamos el combobox
        for(Producto p : lista){
            nombre = p.getNombre_producto();
            this.jcb_Producto.addItem(nombre);
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
    //Metodo para llenar datos del cliente
    private void mostrarCliente(int rut){
        //creamos obj del controlador
        ClienteControlador cc = new ClienteControlador();
        //creamos obj del modelo
        Cliente cliente = cc.buscarClienteRut(rut);
        //llenamos los campos
        this.jlbl_Rut.setText(cliente.getRut()+"");
        this.jlbl_Dv.setText(cliente.getDv());
        this.jlbl_Nombre.setText(cliente.getNombre_cliente());
        this.jlbl_Apellido.setText(cliente.getApellido());
        
    }
    //Metodo para llenar precio de producto
    private void llenarPrecio(String nombre){
        //creamos obj del controlador
        ProductoControlador pc = new ProductoControlador();
        //creamos obj del modelo
        Producto producto = pc.buscarProducto(nombre);
        //llenamos los campos
        this.jlbl_PrecioUnitario.setText(producto.getPrecio()+"");
    }
    //Metodo para agregar producto al carro de compras
    private void agregarProducto(Producto prod, int cant, int subtotal){
        //iniciamos variables
        int id_producto, precio;
        String nombre_producto;
        //creamos una copia de la tabla inicial para trabajar
        //DefaultTableModel modelo = (DefaultTableModel) this.jtbl_Carrito.getModel();
        //asignamos variables
        id_producto = prod.getId_producto();
        nombre_producto = prod.getNombre_producto();
        precio = prod.getPrecio();
        //creamos una copia de la tabla inicial para trabajar
        DefaultTableModel modelo = (DefaultTableModel) this.jtbl_Carrito.getModel();
        //agregamos el producto a la tabla
        modelo.addRow(new Object[]{id_producto, nombre_producto, precio, cant, subtotal});
    }
    //Metodo para vaciar la tabla inicial
    private void vaciarCarrito(){
        //creamos una copia de la tabla inicial para trabajar
        DefaultTableModel modelo = (DefaultTableModel) this.jtbl_Carrito.getModel();
        //dejamos filas 0 inicialmente
        modelo.setRowCount(0);
    }
    //Metodo para inicializar Fecha
    private void iniciarFecha(){
        try {
            String fechastr;
            //Date fecha = null;
            //SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            fechastr = dtf.format(LocalDateTime.now());//.toString();
            System.out.println(fechastr);
            this.jlbl_Fecha.setText(fechastr);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
               
    }
    //Metodo para ingresar una Venta y luego registramos su detalle invocando el metodo ingresarDetalle
    private void generarVenta(){
        //inicializamos variables a utilizar
        int totalv, numero_operacion, rut_cliente;
        String medio_pago, tipo_documento, nro_op;
        Date fecha;
        try {
            //rescatamos los valores necesarios
            //si total no es mayor q 0, no se puede ingresar venta
            if(total>0){
                totalv = total;
            }else{
                JOptionPane.showMessageDialog(this, "No hay productos en el Carro de Compras", "Validacion", 2);
                return;
            }
            //rescatamos la fecha
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            fecha = formatoFecha.parse(this.jlbl_Fecha.getText());
            //recatamos el medio de pago
            if(this.jrb_Efectivo.isSelected()){
                medio_pago = "E";
            }else if(this.jrb_Debito.isSelected()){
                medio_pago = "D";
            }else if(this.jrb_Credito.isSelected()){
                medio_pago = "C";
            }else if(this.jrb_Transferencia.isSelected()){
                medio_pago = "T";
            }else{
                JOptionPane.showMessageDialog(this, "Seleccione Medio de Pago", "Validacion", 2);
                return;
            }
            //vemos que numero de operacion no este vacio
            nro_op = this.jtxt_NumeroOperacion.getText();
            if(nro_op.isEmpty()){
                JOptionPane.showMessageDialog(this, "Ingrese Numero de Operación, 4 digitos", "Validacion", 2);
                this.jtxt_NumeroOperacion.requestFocus();
                return;
            }
            numero_operacion = Integer.parseInt(nro_op);
            //rescatamos tipo de documento
            if(this.jrb_Boleta.isSelected()){
                tipo_documento = "B";
            }else if(this.jrb_Factura.isSelected()){
                tipo_documento = "F";
            }else{
                JOptionPane.showMessageDialog(this, "Seleccione Medio de Pago", "Validacion", 2);
                return;
            }
            //rescatamos rut de cliente
            rut_cliente =  Integer.parseInt(this.jlbl_Rut.getText());
            //Creamos el obj del modelo
            Venta venta = new Venta();
            //lo llenamos
            venta.setTotal(totalv);
            venta.setFecha(fecha);
            venta.setMedio_pago(medio_pago);
            venta.setTipo_documento(tipo_documento);
            venta.setNumero_operacion(numero_operacion);
            venta.setRut_cliente(rut_cliente);
            //creamos el obj controlador
            VentaControlador vc = new VentaControlador();
            //agregamos la venta
            if(vc.agregarVenta(venta)){
                JOptionPane.showMessageDialog(this, "Se Agregó la Venta", "Información", 1);
                //de ser exitos registramos el detalle
                ingresarDetalle();
            }else{
                JOptionPane.showMessageDialog(this, "No se Agregó la Venta", "Información", 0);
            }
            
        } catch (HeadlessException | NumberFormatException | ParseException e) {
            System.out.println(e.getMessage());
        }
    }
    //Metodo para ingresar el detalle de venta
    private void ingresarDetalle(){
        //inicializamos las variables con que vamos a trabajar
        int filas, id_venta, id_prod, cantidad;
        int nroVentas = 0;
        //obtenemos el id de la venta recien ingresada
        //creamos el obj del controlador
        VentaControlador vc = new VentaControlador();
        id_venta = vc.ultimaVenta();
        if(id_venta == 0){
           JOptionPane.showMessageDialog(this, "No se ingreso la venta o No se Rescato el ID_VENTA", "Validacion", 2);
           return;
        }
        //creamos una copia de la tabla inicial para trabajar
        DefaultTableModel modelo = (DefaultTableModel) this.jtbl_Carrito.getModel();
        //obtenemos el numero de filas del carrito
        filas =  modelo.getRowCount();
        //Creamos el obj del controlador de detalleventa
        DetalleVentaControlador dvc = new DetalleVentaControlador();
        //recorremos el carrito y regisramos las ventas
        for(int i=0; i<filas; i++ ){
            //indicamos la fila correcta
            int row = i;
            //en la 3ra columna esta cantidad
            cantidad = (Integer) this.jtbl_Carrito.getValueAt(row, 3);
            //en la  1ra columna esta el id producto
            id_prod = (Integer) this.jtbl_Carrito.getValueAt(row, 0);
            //Creamos un obj del modelo
            DetalleVenta dv = new DetalleVenta(cantidad, id_venta, id_prod);
            //Agregamos a la base de datos el detalle de venta
            if(dvc.agregarDetalleVenta(dv)){
                //incrementamos el contador de filas ingresadas
                nroVentas ++;
            }
        }
        //Enviamos otro aviso de cuantos detalles de venta se ingresaron
        if(nroVentas>0){
            JOptionPane.showMessageDialog(this, "Se Ingresaron: "+nroVentas+" Registros", "Información", 1);
        } else {
            JOptionPane.showMessageDialog(this, "No se Registraron los Productos", "Información", 0);
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

        btnGroupMedioPago = new javax.swing.ButtonGroup();
        bntGroupTipoDocumento = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jcb_Producto = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jlbl_PrecioUnitario = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtxt_Cantidad = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jlbl_SubTotal = new javax.swing.JLabel();
        jbtn_AgregarCarro = new javax.swing.JButton();
        jbtn_Calcular = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jbtn_Quitar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbl_Carrito = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jcb_Cliente = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jlbl_Rut = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jlbl_Dv = new javax.swing.JLabel();
        jlbl_Nombre = new javax.swing.JLabel();
        jlbl_Apellido = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jlbl_Total = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jrb_Efectivo = new javax.swing.JRadioButton();
        jrb_Debito = new javax.swing.JRadioButton();
        jrb_Credito = new javax.swing.JRadioButton();
        jrb_Transferencia = new javax.swing.JRadioButton();
        jLabel15 = new javax.swing.JLabel();
        jrb_Boleta = new javax.swing.JRadioButton();
        jrb_Factura = new javax.swing.JRadioButton();
        jLabel16 = new javax.swing.JLabel();
        jtxt_NumeroOperacion = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jlbl_Fecha = new javax.swing.JLabel();
        jbtn_IngresarCompra = new javax.swing.JButton();
        jbtn_CancelarCompra = new javax.swing.JButton();
        jbtn_Volver = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GENERAR VENTA");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Agregar Productos"));

        jLabel3.setText("Seleccione Producto:");

        jcb_Producto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcb_Producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_ProductoActionPerformed(evt);
            }
        });

        jLabel1.setText("Precio Unitario:");

        jLabel4.setText("$");

        jlbl_PrecioUnitario.setText("0000");

        jLabel5.setText("Cantidad:");

        jLabel6.setText("SubTotal:");

        jLabel7.setText("$");

        jlbl_SubTotal.setText("0000");

        jbtn_AgregarCarro.setText("Agregar al Carro");
        jbtn_AgregarCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_AgregarCarroActionPerformed(evt);
            }
        });

        jbtn_Calcular.setText("Calcular");
        jbtn_Calcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_CalcularActionPerformed(evt);
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
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcb_Producto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxt_Cantidad)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jlbl_PrecioUnitario))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jlbl_SubTotal)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jbtn_AgregarCarro, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtn_Calcular, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jcb_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jlbl_PrecioUnitario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtxt_Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jlbl_SubTotal))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtn_AgregarCarro)
                    .addComponent(jbtn_Calcular))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Carro de Compras"));

        jbtn_Quitar.setText("Quitar Producto");
        jbtn_Quitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_QuitarActionPerformed(evt);
            }
        });

        jtbl_Carrito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Producto", "Precio Unitario", "Cantidad", "SubTotal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbl_Carrito.setColumnSelectionAllowed(true);
        jtbl_Carrito.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jtbl_Carrito);
        jtbl_Carrito.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(jbtn_Quitar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtn_Quitar)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Ingresar Venta"));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));

        jLabel2.setText("Seleccione Cliente:");

        jcb_Cliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcb_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_ClienteActionPerformed(evt);
            }
        });

        jLabel8.setText("Rut:");

        jLabel9.setText("Nombre:");

        jLabel10.setText("Apellido:");

        jlbl_Rut.setText("00000000");

        jLabel11.setText("-");

        jlbl_Dv.setText("0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlbl_Nombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(12, 12, 12)
                                .addComponent(jlbl_Apellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jcb_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(38, 38, 38)
                                .addComponent(jlbl_Rut, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlbl_Dv)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcb_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jlbl_Rut)
                    .addComponent(jLabel11)
                    .addComponent(jlbl_Dv))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jlbl_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(jlbl_Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Formalizar Compra"));

        jLabel12.setText("Total Compra:");

        jLabel13.setText("$");

        jlbl_Total.setText("000000");

        jLabel14.setText("Medio de Pago:");

        btnGroupMedioPago.add(jrb_Efectivo);
        jrb_Efectivo.setText("Efectivo");

        btnGroupMedioPago.add(jrb_Debito);
        jrb_Debito.setText("Débito");

        btnGroupMedioPago.add(jrb_Credito);
        jrb_Credito.setText("Crédito");

        btnGroupMedioPago.add(jrb_Transferencia);
        jrb_Transferencia.setText("Transferencia");

        jLabel15.setText("Tipo de Documento:");

        bntGroupTipoDocumento.add(jrb_Boleta);
        jrb_Boleta.setText("Boleta");

        bntGroupTipoDocumento.add(jrb_Factura);
        jrb_Factura.setText("Factura");

        jLabel16.setText("Número de Operación:");

        jLabel18.setText("Fecha:");

        jlbl_Fecha.setText("xx/xx/xxxx");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlbl_Total)
                        .addGap(124, 124, 124)
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)
                        .addComponent(jlbl_Fecha))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jrb_Efectivo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jrb_Debito)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jrb_Credito)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jrb_Transferencia))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jrb_Boleta)
                        .addGap(18, 18, 18)
                        .addComponent(jrb_Factura))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(jtxt_NumeroOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jlbl_Total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18)
                    .addComponent(jlbl_Fecha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jrb_Efectivo)
                    .addComponent(jrb_Debito)
                    .addComponent(jrb_Credito)
                    .addComponent(jrb_Transferencia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jtxt_NumeroOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jrb_Boleta)
                    .addComponent(jrb_Factura))
                .addContainerGap())
        );

        jbtn_IngresarCompra.setText("Ingresar Compra");
        jbtn_IngresarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_IngresarCompraActionPerformed(evt);
            }
        });

        jbtn_CancelarCompra.setText("Cancelar Compra");
        jbtn_CancelarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_CancelarCompraActionPerformed(evt);
            }
        });

        jbtn_Volver.setText("Volver al Menú");
        jbtn_Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_VolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jbtn_IngresarCompra)
                        .addGap(18, 18, 18)
                        .addComponent(jbtn_CancelarCompra)
                        .addGap(18, 18, 18)
                        .addComponent(jbtn_Volver)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbtn_IngresarCompra)
                            .addComponent(jbtn_CancelarCompra)
                            .addComponent(jbtn_Volver))
                        .addGap(12, 12, 12)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel17.setText("Copyright - Alison Barraza - Francisco Castillo - Cristian Gonzalez - 2021");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addGap(171, 171, 171))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcb_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_ClienteActionPerformed
        // al seleccionar un cliente, se llenaran los datos
        //inicializamos variables
        String nombre;
        int rut;
        try {
            //obtenemos el nombre del combobox seleccionado
        nombre = (String) this.jcb_Cliente.getSelectedItem();
        //obtenemos el rut del cliente seleccionado
        rut = obtenerRut(nombre);
        //llenamos los datos del cliente
        mostrarCliente(rut);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jcb_ClienteActionPerformed

    private void jcb_ProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_ProductoActionPerformed
        /// al seleccionar un producto, se llenaran los datos
        //inicializamos variables
        String nombre;
        try {
            //obtenemos el nombre del combobox seleccionado
        nombre = (String) this.jcb_Producto.getSelectedItem();
        //llenamos el precio del producto
        llenarPrecio(nombre);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jcb_ProductoActionPerformed

    private void jbtn_CalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_CalcularActionPerformed
        //Rescatamos datos
        String cantidad = this.jtxt_Cantidad.getText();
        String preciounit = this.jlbl_PrecioUnitario.getText();
        //vemos que no hayan datos sin llenar
        if(cantidad.isEmpty()){
            JOptionPane.showMessageDialog(this, "Ingrese Cantidad", "Validacion", 2);
            this.jtxt_Cantidad.requestFocus();
            return;
        }
        //convertimos el dato a int y calculamos el subtotal
        try {
            int cant = Integer.parseInt(cantidad);
            int precio = Integer.parseInt(preciounit);
            this.jlbl_SubTotal.setText((cant * precio)+"");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }//GEN-LAST:event_jbtn_CalcularActionPerformed

    private void jbtn_AgregarCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_AgregarCarroActionPerformed
        //nos aseguramos de que este actualizado los valores de producto
        this.jbtn_Calcular.doClick();
        // iniciamos variables
        String cantidad, subtotal, nombre;
        int cant, subt;
        try {
            //obtenemos los datos
            cantidad = this.jtxt_Cantidad.getText();
            subtotal = this.jlbl_SubTotal.getText();
            nombre = (String) this.jcb_Producto.getSelectedItem();
            cant = Integer.parseInt(cantidad);
            subt = Integer.parseInt(subtotal);
            //creamos obj del controlador
            ProductoControlador pc = new ProductoControlador();
            //creamos obj del modelo
            Producto producto = pc.buscarProducto(nombre);
            //agregamos el producto al carrito
            agregarProducto(producto, cant, subt);
            //dato = (Integer) this.jtbl_Todos.getValueAt(row, 0);
            //lo sumamos al total
            total = total + subt;
            //actualizamos en la vista
            this.jlbl_Total.setText(total+"");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jbtn_AgregarCarroActionPerformed

    private void jbtn_QuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_QuitarActionPerformed
        int row, subt;
        try {
            //seleccionamo la fila de la tabla que haya sido seleccionada, 
            //getselectedrow nos devolvera el nro de la fila, si no hay ninguna sera -1
            row = this.jtbl_Carrito.getSelectedRow();
            //luego obtenemos el dato que esta en la tabla en este caso el titulo, que esta en posicion 1
            //recordar que la posicion parte desde  0 (ID)
            //esto con getValueAt(fila, columna)
            if(row >=0){
                //actualizamos primero el valor de total
                subt = (Integer) this.jtbl_Carrito.getValueAt(row, 4);
                total = total - subt;
                //actualizamos en la vista
                this.jlbl_Total.setText(total+"");
                //creamos una copia de la tabla inicial para trabajar
                DefaultTableModel modelo = (DefaultTableModel) this.jtbl_Carrito.getModel();
                modelo.removeRow(row);
                System.out.println(modelo.getRowCount());
            }else{
                JOptionPane.showMessageDialog(this, "No hay Producto en el carrito", "Validación", 2);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jbtn_QuitarActionPerformed

    private void jbtn_VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_VolverActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jbtn_VolverActionPerformed

    private void jbtn_CancelarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_CancelarCompraActionPerformed
        // TODO add your handling code here:
        vaciarCarrito();
        total = 0;
        this.jlbl_Total.setText(total+"");
        //creamos una copia de la tabla inicial para trabajar
        DefaultTableModel modelo = (DefaultTableModel) this.jtbl_Carrito.getModel();
        System.out.println(modelo.getRowCount());
    }//GEN-LAST:event_jbtn_CancelarCompraActionPerformed

    private void jbtn_IngresarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_IngresarCompraActionPerformed
        // usamos el metodo para generar la venta
        generarVenta();
    }//GEN-LAST:event_jbtn_IngresarCompraActionPerformed

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
            java.util.logging.Logger.getLogger(GenerarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GenerarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GenerarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GenerarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GenerarVenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bntGroupTipoDocumento;
    private javax.swing.ButtonGroup btnGroupMedioPago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbtn_AgregarCarro;
    private javax.swing.JButton jbtn_Calcular;
    private javax.swing.JButton jbtn_CancelarCompra;
    private javax.swing.JButton jbtn_IngresarCompra;
    private javax.swing.JButton jbtn_Quitar;
    private javax.swing.JButton jbtn_Volver;
    private javax.swing.JComboBox<String> jcb_Cliente;
    private javax.swing.JComboBox<String> jcb_Producto;
    private javax.swing.JLabel jlbl_Apellido;
    private javax.swing.JLabel jlbl_Dv;
    private javax.swing.JLabel jlbl_Fecha;
    private javax.swing.JLabel jlbl_Nombre;
    private javax.swing.JLabel jlbl_PrecioUnitario;
    private javax.swing.JLabel jlbl_Rut;
    private javax.swing.JLabel jlbl_SubTotal;
    private javax.swing.JLabel jlbl_Total;
    private javax.swing.JRadioButton jrb_Boleta;
    private javax.swing.JRadioButton jrb_Credito;
    private javax.swing.JRadioButton jrb_Debito;
    private javax.swing.JRadioButton jrb_Efectivo;
    private javax.swing.JRadioButton jrb_Factura;
    private javax.swing.JRadioButton jrb_Transferencia;
    private javax.swing.JTable jtbl_Carrito;
    private javax.swing.JTextField jtxt_Cantidad;
    private javax.swing.JTextField jtxt_NumeroOperacion;
    // End of variables declaration//GEN-END:variables
}
