
package Vista;

import Controlador.ClienteControlador;
import javax.swing.JOptionPane;
import Controlador.ProductoControlador;
import Modelo.Cliente;
import Modelo.Producto;
import javax.swing.table.DefaultTableModel;
import java.util.List;

        

/**
 *
 * @author abarr
 */
public class MantenedorProducto extends javax.swing.JFrame {

    /**
     * Creates new form MantenedorProducto
     */
    public MantenedorProducto() {
        initComponents();
        //inicializa la ventana en el centrol
        this.setLocationRelativeTo(null);
        try {
            listarProductos();
            listarProductos2();
            listarProductos3();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    //Metodo para listar todos los producto
    private void listarProductos(){
        //iniciamos variables
        String nombre_producto, tipo_producto, descripcion;
        int precio, cantidad;
        boolean disponible;
        //creamos obj del controlador
        ProductoControlador pc = new ProductoControlador();
        //creamos una copia de la tabla inicial para trabajar
        DefaultTableModel modelo = (DefaultTableModel) this.jtbl_listarProductos.getModel();
        //dejamos filas 0 inicialmente
        modelo.setRowCount(0);
        //llenamos la lista con el metodo del controlador
        List<Producto> lista = pc.buscarTodos();
        //recorremos la lista y llenamos la tabla
        for(Producto p : lista){
            nombre_producto = p.getNombre_producto();
            tipo_producto = p.getTipo_producto();
            descripcion = p.getDescripcion();
            precio = p.getPrecio();
            cantidad = p.getCantidad();
            disponible = p.isDisponible();
            
            modelo.addRow(new Object[]{nombre_producto, tipo_producto, descripcion, precio, cantidad, disponible});
        }
    }
    //metodo para listar todos los productos para modificar
    private void listarProductos2(){
        //iniciamos variables
        String nombre_producto, tipo_producto, descripcion;
        int precio, cantidad;
        boolean disponible;
        //creamos obj del controlador
        ProductoControlador pc = new ProductoControlador();
        //creamos una copia de la tabla inicial para trabajar
        DefaultTableModel modelo = (DefaultTableModel) this.jtbl_modificarProducto.getModel();
        //dejamos filas 0 inicialmente
        modelo.setRowCount(0);
        //llenamos la lista con el metodo del controlador
        List<Producto> lista = pc.buscarTodos();
        //recorremos la lista y llenamos la tabla
        for(Producto p : lista){
            nombre_producto = p.getNombre_producto();
            tipo_producto = p.getTipo_producto();
            descripcion = p.getDescripcion();
            precio = p.getPrecio();
            cantidad = p.getCantidad();
            disponible = p.isDisponible();
            
            modelo.addRow(new Object[]{nombre_producto, tipo_producto, descripcion, precio, cantidad, disponible});
        }
    }
    //metodo para listar todos los productos para modificar
    private void listarProductos3(){
        //iniciamos variables
        String nombre_producto, tipo_producto, descripcion;
        int precio, cantidad;
        boolean disponible;
        //creamos obj del controlador
        ProductoControlador pc = new ProductoControlador();
        //creamos una copia de la tabla inicial para trabajar
        DefaultTableModel modelo = (DefaultTableModel) this.jtbl_eliminarproducto.getModel();
        //dejamos filas 0 inicialmente
        modelo.setRowCount(0);
        //llenamos la lista con el metodo del controlador
        List<Producto> lista = pc.buscarTodos();
        //recorremos la lista y llenamos la tabla
        for(Producto p : lista){
            nombre_producto = p.getNombre_producto();
            tipo_producto = p.getTipo_producto();
            descripcion = p.getDescripcion();
            precio = p.getPrecio();
            cantidad = p.getCantidad();
            disponible = p.isDisponible();
            
            modelo.addRow(new Object[]{nombre_producto, tipo_producto, descripcion, precio, cantidad, disponible});
        }
    }
    //Metodo para buscar por nombre producto
    private void listarNombre(String nombre){
        //iniciamos variables
        String nombre_producto, tipo_producto, descripcion;
        int precio, cantidad;
        boolean disponible;
        //creamos obj del controlador
        ProductoControlador pc = new ProductoControlador();
        //creamos una copia de la tabla inicial para trabajar
        DefaultTableModel modelo = (DefaultTableModel) this.jtbl_listarProductos.getModel();
        //dejamos filas 0 inicialmente
        modelo.setRowCount(0);
        //llenamos la lista con el metodo del controlador
        Producto p = pc.buscarProducto(nombre);
        //llenamos la tabla
        nombre_producto = p.getNombre_producto();
        tipo_producto = p.getTipo_producto();
        descripcion = p.getDescripcion();
        precio = p.getPrecio();
        cantidad = p.getCantidad();
        disponible = p.isDisponible();
            
        modelo.addRow(new Object[]{nombre_producto, tipo_producto, descripcion, precio, cantidad, disponible});
        
    }
    //metodo para buscar por nombre producto tabla modificar
    private void listarNombre2(String nombre){
        //iniciamos variables
        String nombre_producto, tipo_producto, descripcion;
        int precio, cantidad;
        boolean disponible;
        //creamos obj del controlador
        ProductoControlador pc = new ProductoControlador();
        //creamos una copia de la tabla inicial para trabajar
        DefaultTableModel modelo = (DefaultTableModel) this.jtbl_modificarProducto.getModel();
        //dejamos filas 0 inicialmente
        modelo.setRowCount(0);
        //llenamos la lista con el metodo del controlador
        Producto p = pc.buscarProducto(nombre);
        //llenamos la tabla
        nombre_producto = p.getNombre_producto();
        tipo_producto = p.getTipo_producto();
        descripcion = p.getDescripcion();
        precio = p.getPrecio();
        cantidad = p.getCantidad();
        disponible = p.isDisponible();
            
        modelo.addRow(new Object[]{nombre_producto, tipo_producto, descripcion, precio, cantidad, disponible});
        
    }
    //metodo para buscar por nombre producto tabla eliminar
    private void listarNombre3(String nombre){
        //iniciamos variables
        String nombre_producto, tipo_producto, descripcion;
        int precio, cantidad;
        boolean disponible;
        //creamos obj del controlador
        ProductoControlador pc = new ProductoControlador();
        //creamos una copia de la tabla inicial para trabajar
        DefaultTableModel modelo = (DefaultTableModel) this.jtbl_eliminarproducto.getModel();
        //dejamos filas 0 inicialmente
        modelo.setRowCount(0);
        //llenamos la lista con el metodo del controlador
        Producto p = pc.buscarProducto(nombre);
        //llenamos la tabla
        nombre_producto = p.getNombre_producto();
        tipo_producto = p.getTipo_producto();
        descripcion = p.getDescripcion();
        precio = p.getPrecio();
        cantidad = p.getCantidad();
        disponible = p.isDisponible();
            
        modelo.addRow(new Object[]{nombre_producto, tipo_producto, descripcion, precio, cantidad, disponible});
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtpMantenedorProducto = new javax.swing.JTabbedPane();
        jpAgregarProducto = new javax.swing.JPanel();
        jlNomProduc = new javax.swing.JLabel();
        jtxtNomProduc = new javax.swing.JTextField();
        jlTipProduc = new javax.swing.JLabel();
        jcomboxTipProduc = new javax.swing.JComboBox<>();
        jlDescripProduc = new javax.swing.JLabel();
        jtxtDescripProduc = new javax.swing.JTextField();
        jlPrecioProduc = new javax.swing.JLabel();
        jtxtPrecio = new javax.swing.JTextField();
        jlCantProduc = new javax.swing.JLabel();
        jtxtCantidad = new javax.swing.JTextField();
        jlDispProduc = new javax.swing.JLabel();
        jbtnGuardar = new javax.swing.JButton();
        jbtnLimpiar = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        jpListarProducto = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtxListarNombre = new javax.swing.JTextField();
        jbtnBuscarNP = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbl_listarProductos = new javax.swing.JTable();
        jbtnSalirListar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jpModificarProducto = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jlbIdBuscarModificar = new javax.swing.JLabel();
        jtxtBuscarModificar = new javax.swing.JTextField();
        jbtn_buscarModificar = new javax.swing.JButton();
        jbtn_modificar = new javax.swing.JButton();
        jbtn_limpiar_modificar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jlbIDmodificar = new javax.swing.JLabel();
        jtxtIDmodifar = new javax.swing.JTextField();
        jlbNPmodificar = new javax.swing.JLabel();
        jtxtNPmodificar = new javax.swing.JTextField();
        jlbTPmodificar = new javax.swing.JLabel();
        jcomboxTPmodificar = new javax.swing.JComboBox<>();
        jlbDPmodificar = new javax.swing.JLabel();
        jtxtDPmodificar = new javax.swing.JTextField();
        jlbPPmodificar = new javax.swing.JLabel();
        jtxtPPmodificar1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jcbDispModificar = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jtxtCPmodificar = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtbl_modificarProducto = new javax.swing.JTable();
        jpEliminar = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbl_eliminarproducto = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jlbTPbuscar_eliminar = new javax.swing.JLabel();
        jbtnBuscar_Eliminar = new javax.swing.JButton();
        jtxt_buscarnombre = new javax.swing.JTextField();
        jbtn_eliminarProducto = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mantenedor de Productos");

        jtpMantenedorProducto.setBackground(new java.awt.Color(0, 153, 153));

        jpAgregarProducto.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)), "Agregar Producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 153, 153))); // NOI18N

        jlNomProduc.setText("Nombre Producto:");

        jtxtNomProduc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtNomProducActionPerformed(evt);
            }
        });

        jlTipProduc.setText("Tipo Producto:");

        jcomboxTipProduc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione tipo de producto...", "Accesorio", "Armazon", "Cristal", "Gafa", "Reparación", "Traspaso" }));

        jlDescripProduc.setText("Descripción:");

        jtxtDescripProduc.setText("Color, material, marca, estilo, etc.");
        jtxtDescripProduc.setCaretColor(new java.awt.Color(153, 153, 153));
        jtxtDescripProduc.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        jtxtDescripProduc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtDescripProducActionPerformed(evt);
            }
        });

        jlPrecioProduc.setText("Precio unitario ($):");

        jlCantProduc.setText("Cantidad:");

        jlDispProduc.setText("Disponibilidad:");

        jbtnGuardar.setBackground(new java.awt.Color(0, 153, 153));
        jbtnGuardar.setText("Guardar");
        jbtnGuardar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jbtnGuardarFocusGained(evt);
            }
        });
        jbtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnGuardarActionPerformed(evt);
            }
        });

        jbtnLimpiar.setBackground(new java.awt.Color(255, 255, 255));
        jbtnLimpiar.setText("Limpiar");
        jbtnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnLimpiarActionPerformed(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setText("Copyright - Alison Barraza - Francisco Castillo - Cristian Gonzalez - 2021");

        javax.swing.GroupLayout jpAgregarProductoLayout = new javax.swing.GroupLayout(jpAgregarProducto);
        jpAgregarProducto.setLayout(jpAgregarProductoLayout);
        jpAgregarProductoLayout.setHorizontalGroup(
            jpAgregarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpAgregarProductoLayout.createSequentialGroup()
                .addGroup(jpAgregarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpAgregarProductoLayout.createSequentialGroup()
                        .addGap(0, 131, Short.MAX_VALUE)
                        .addGroup(jpAgregarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jpAgregarProductoLayout.createSequentialGroup()
                                .addComponent(jlTipProduc, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcomboxTipProduc, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpAgregarProductoLayout.createSequentialGroup()
                                .addComponent(jlDescripProduc, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtxtDescripProduc, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jpAgregarProductoLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jpAgregarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jpAgregarProductoLayout.createSequentialGroup()
                                .addGroup(jpAgregarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jbtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlPrecioProduc, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpAgregarProductoLayout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(jlDispProduc, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpAgregarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtxtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBox1)
                                    .addComponent(jbtnLimpiar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jpAgregarProductoLayout.createSequentialGroup()
                                .addComponent(jlNomProduc, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtxtNomProduc, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpAgregarProductoLayout.createSequentialGroup()
                                .addComponent(jlCantProduc, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtxtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(127, 127, 127))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpAgregarProductoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(100, 100, 100))
        );
        jpAgregarProductoLayout.setVerticalGroup(
            jpAgregarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAgregarProductoLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jpAgregarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlNomProduc)
                    .addComponent(jtxtNomProduc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jpAgregarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcomboxTipProduc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlTipProduc, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jpAgregarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlDescripProduc)
                    .addComponent(jtxtDescripProduc, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpAgregarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlPrecioProduc))
                .addGap(18, 18, 18)
                .addGroup(jpAgregarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlDispProduc)
                    .addGroup(jpAgregarProductoLayout.createSequentialGroup()
                        .addGroup(jpAgregarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlCantProduc))
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBox1)))
                .addGap(76, 76, 76)
                .addGroup(jpAgregarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnGuardar)
                    .addComponent(jbtnLimpiar))
                .addGap(39, 39, 39)
                .addComponent(jLabel8))
        );

        jtpMantenedorProducto.addTab("Agregar", jpAgregarProducto);

        jpListarProducto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)), "Buscar Producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 153, 153))); // NOI18N

        jLabel1.setText("Nombre Producto:");

        jtxListarNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxListarNombreActionPerformed(evt);
            }
        });

        jbtnBuscarNP.setBackground(new java.awt.Color(153, 153, 153));
        jbtnBuscarNP.setText("Buscar");
        jbtnBuscarNP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jbtnBuscarNPFocusGained(evt);
            }
        });
        jbtnBuscarNP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBuscarNPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtxListarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtnBuscarNP, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtxListarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnBuscarNP))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setForeground(new java.awt.Color(0, 153, 153));

        jtbl_listarProductos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        jtbl_listarProductos.setForeground(new java.awt.Color(0, 204, 204));
        jtbl_listarProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nombre Producto", "Tipo Producto", "Descripción", "Precio", "Cantidad", "Disponibilidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbl_listarProductos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtbl_listarProductos);

        jbtnSalirListar.setBackground(new java.awt.Color(0, 153, 153));
        jbtnSalirListar.setText("Salir");
        jbtnSalirListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSalirListarActionPerformed(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setText("Copyright - Alison Barraza - Francisco Castillo - Cristian Gonzalez - 2021");

        javax.swing.GroupLayout jpListarProductoLayout = new javax.swing.GroupLayout(jpListarProducto);
        jpListarProducto.setLayout(jpListarProductoLayout);
        jpListarProductoLayout.setHorizontalGroup(
            jpListarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpListarProductoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpListarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpListarProductoLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(113, 113, 113))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpListarProductoLayout.createSequentialGroup()
                        .addComponent(jbtnSalirListar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(246, 246, 246))))
        );
        jpListarProductoLayout.setVerticalGroup(
            jpListarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpListarProductoLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(jbtnSalirListar)
                .addGap(48, 48, 48)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE))
        );

        jtpMantenedorProducto.addTab("Listar", jpListarProducto);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)), "Buscar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 153, 153))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(0, 153, 153));

        jlbIdBuscarModificar.setText("Nombre producto:");

        jbtn_buscarModificar.setBackground(new java.awt.Color(153, 153, 153));
        jbtn_buscarModificar.setText("Buscar");
        jbtn_buscarModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_buscarModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jlbIdBuscarModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtxtBuscarModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtn_buscarModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbIdBuscarModificar)
                    .addComponent(jtxtBuscarModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn_buscarModificar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jbtn_modificar.setBackground(new java.awt.Color(0, 153, 153));
        jbtn_modificar.setText("Modificar");
        jbtn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_modificarActionPerformed(evt);
            }
        });

        jbtn_limpiar_modificar.setBackground(new java.awt.Color(255, 255, 255));
        jbtn_limpiar_modificar.setText("Limpiar");

        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setText("Copyright - Alison Barraza - Francisco Castillo - Cristian Gonzalez - 2021");

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jlbIDmodificar.setText("ID Producto:");

        jtxtIDmodifar.setEditable(false);

        jlbNPmodificar.setText("Nombre Producto:");

        jlbTPmodificar.setText("Tipo Producto:");

        jcomboxTPmodificar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar tipo...", "Accesorio", "Armazon", "Cristal", "Gafa", "Reparación", "Traspaso" }));

        jlbDPmodificar.setText("Descripción Producto:");

        jlbPPmodificar.setText("Precio Producto ($):");

        jLabel4.setText("Disponibilidad:");

        jLabel3.setText("Cantidad:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jlbIDmodificar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxtIDmodifar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jlbPPmodificar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtxtPPmodificar1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jlbDPmodificar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtxtDPmodificar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jlbTPmodificar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcomboxTPmodificar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcbDispModificar)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jlbNPmodificar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxtNPmodificar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtxtCPmodificar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbIDmodificar)
                    .addComponent(jtxtIDmodifar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbPPmodificar)
                    .addComponent(jtxtPPmodificar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbNPmodificar)
                    .addComponent(jtxtNPmodificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jtxtCPmodificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlbTPmodificar)
                        .addComponent(jcomboxTPmodificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addComponent(jcbDispModificar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlbDPmodificar)
                    .addComponent(jtxtDPmodificar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));

        jScrollPane4.setBackground(new java.awt.Color(0, 153, 153));
        jScrollPane4.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));

        jtbl_modificarProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nombre Producto", "Tipo Producto", "Descripción", "Precio ", "Cantidad", "Disponibilidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbl_modificarProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbl_modificarProductoMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jtbl_modificarProducto);

        jScrollPane3.setViewportView(jScrollPane4);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jpModificarProductoLayout = new javax.swing.GroupLayout(jpModificarProducto);
        jpModificarProducto.setLayout(jpModificarProductoLayout);
        jpModificarProductoLayout.setHorizontalGroup(
            jpModificarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpModificarProductoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpModificarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jpModificarProductoLayout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jbtn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtn_limpiar_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102))
            .addGroup(jpModificarProductoLayout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jpModificarProductoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpModificarProductoLayout.setVerticalGroup(
            jpModificarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpModificarProductoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpModificarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtn_modificar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbtn_limpiar_modificar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtpMantenedorProducto.addTab("Modificar", jpModificarProducto);

        jScrollPane2.setBackground(new java.awt.Color(0, 153, 153));
        jScrollPane2.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));

        jtbl_eliminarproducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nombre Producto", "Tipo Producto", "Descripción", "Precio ", "Cantidad", "Disponibilidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jtbl_eliminarproducto);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)), "Buscar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 153, 153))); // NOI18N

        jlbTPbuscar_eliminar.setText("Nombre Producto:");

        jbtnBuscar_Eliminar.setBackground(new java.awt.Color(153, 153, 153));
        jbtnBuscar_Eliminar.setText("Buscar");
        jbtnBuscar_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBuscar_EliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jlbTPbuscar_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtxt_buscarnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jbtnBuscar_Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnBuscar_Eliminar)
                    .addComponent(jlbTPbuscar_eliminar)
                    .addComponent(jtxt_buscarnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jbtn_eliminarProducto.setBackground(new java.awt.Color(0, 153, 153));
        jbtn_eliminarProducto.setText("Eliminar");
        jbtn_eliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_eliminarProductoActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("Copyright - Alison Barraza - Francisco Castillo - Cristian Gonzalez - 2021");

        javax.swing.GroupLayout jpEliminarLayout = new javax.swing.GroupLayout(jpEliminar);
        jpEliminar.setLayout(jpEliminarLayout);
        jpEliminarLayout.setHorizontalGroup(
            jpEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpEliminarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(116, 116, 116))
            .addGroup(jpEliminarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpEliminarLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpEliminarLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbtn_eliminarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(244, 244, 244))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpEliminarLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jpEliminarLayout.setVerticalGroup(
            jpEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEliminarLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addComponent(jbtn_eliminarProducto)
                .addGap(92, 92, 92)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
        );

        jtpMantenedorProducto.addTab("Eliminar", jpEliminar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtpMantenedorProducto, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtpMantenedorProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnBuscarNPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBuscarNPActionPerformed
        // Buscar por nombre del producto
//        int precio, cantidad;
//        String nombre_producto, tipo_producto, descripcion;
//        Boolean disponible;
//
//        ProductoControlador cc = new ProductoControlador();
//
//        DefaultTableModel modelo = (DefaultTableModel) this.jtbl_listarProductos.getModel();
//
//        nombre_producto = this.jtxListarNombre.getText();
//        modelo.setRowCount(0);
//        
//        //revisamos criterio de busqueda y se llena la tabla con los resultados
//        if (nombre_producto.equals("")) {
//
//            List<Producto> lista = cc.buscarTodos();
//
//            for (Producto producto : lista) {
//                nombre_producto= producto.getNombre_producto();
//                tipo_producto = producto.getTipo_producto();
//                descripcion= producto.getDescripcion();
//                precio = producto.getPrecio();
//                cantidad=producto.getCantidad();
//                disponible=producto.isDisponible();
//
//                modelo.addRow(new Object[]{nombre_producto,tipo_producto,descripcion, precio, cantidad, disponible});
//                }
//            }
//        else {
//
//            //List <Producto> lista = cc.buscarProducto(nombre_producto);
//     
////            for (Producto producto : lista) {
//////               
////                nombre_producto= producto.getNombre_producto();
////                tipo_producto = producto.getTipo_producto();
////                precio = producto.getPrecio();
////                cantidad= producto.getCantidad();
////                disponible=producto.isDisponible();
////
////
////                modelo.addRow(new Object[]{nombre_producto,tipo_producto, precio, cantidad, disponible});
////               
//            }
//        }
        //
        String nombre;
        nombre = this.jtxListarNombre.getText();
        if(nombre.isEmpty()){
            listarProductos();
            JOptionPane.showMessageDialog(this, "Ingrese Nombre Producto", "Validacion", 2);
            this.jtxListarNombre.requestFocus();
            return;
        }
        System.out.println(nombre);
        listarNombre(nombre);
        
    }//GEN-LAST:event_jbtnBuscarNPActionPerformed

    private void jtxListarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxListarNombreActionPerformed
        this.jtxListarNombre.setText("");
    }//GEN-LAST:event_jtxListarNombreActionPerformed

    private void jtxtNomProducActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtNomProducActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtNomProducActionPerformed

    private void jtxtDescripProducActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtDescripProducActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtDescripProducActionPerformed

    private void jbtnGuardarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jbtnGuardarFocusGained
        this.jbtnGuardar.requestFocus();
    }//GEN-LAST:event_jbtnGuardarFocusGained

    private void jbtnBuscarNPFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jbtnBuscarNPFocusGained
        this.jbtnBuscarNP.requestFocus();
    }//GEN-LAST:event_jbtnBuscarNPFocusGained

    private void jbtnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnLimpiarActionPerformed
        this.jtxtNomProduc.setText("");
        this.jcomboxTipProduc.setSelectedItem(0);
        this.jtxtDescripProduc.setText("");
        this.jtxtPrecio.setText("");
        this.jtxtCantidad.setText("");
        this.jCheckBox1.setSelected(false);

        this.jtxtNomProduc.requestFocus();
    }//GEN-LAST:event_jbtnLimpiarActionPerformed

    private void jbtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnGuardarActionPerformed
        //Rescatar los datos ingresados
        String nombre_producto = this.jtxtNomProduc.getText();
        String tipo_producto = (String) this.jcomboxTipProduc.getSelectedItem();
        String descripcion = this.jtxtDescripProduc.getText();
        String precio_str  = this.jtxtPrecio.getText();
        String cantidad_str = this.jtxtCantidad.getText();
        Boolean disponible = this.jCheckBox1.isSelected();
        
        //Validación de que esten completos los datos
        if (nombre_producto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese Nombre del Producto", "Validacion", 2);
            this.jtxtNomProduc.requestFocus();
            return;
        }
        if (tipo_producto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Seleccione Tipo de Producto", "Validacion", 2);
            this.jcomboxTipProduc.requestFocus();
            return;
        }
        if (descripcion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese Descripción del Producto", "Validacion", 2);
            this.jtxtDescripProduc.requestFocus();
            return;
        }
        if (precio_str.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese Precio del Producto", "Validacion", 2);
            this.jtxtPrecio.requestFocus();
            return;
        }
        if (cantidad_str.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese Cantidad del Producto", "Validacion", 2);
            this.jtxtCantidad.requestFocus();
            return;
        }
       
        int precio, cantidad;
        precio = Integer.parseInt(precio_str);
        cantidad = Integer.parseInt(cantidad_str);
        
        //Guardar datos del Producto
        Producto producto= new Producto();
        producto.setNombre_producto(nombre_producto);
        producto.setTipo_producto(tipo_producto);
        producto.setDescripcion(descripcion);
        producto.setPrecio(precio);
        producto.setCantidad(cantidad);
        producto.setDisponible(disponible);
//
        ProductoControlador cc = new ProductoControlador();
        try {
            if (cc.agregarProducto(producto)) {
            JOptionPane.showMessageDialog(this, "Producto ingresado!", "Ingreso", 1);
        } else {
            JOptionPane.showMessageDialog(this, "Producto no se pudo ingresar", "Validacion", 1);
        }
        } catch (Exception e) {
        }                   
    }//GEN-LAST:event_jbtnGuardarActionPerformed

    private void jbtn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_modificarActionPerformed
             //rescatamos los datos
        String nombre_producto = this.jtxtNPmodificar.getText();
        String tipo_producto = (String) this.jcomboxTPmodificar.getSelectedItem();
        String descripcion = this.jtxtDPmodificar.getText();
        String precio_str  = this.jtxtPPmodificar1.getText();
        String cantidad_str = this.jtxtCPmodificar.getText();
        Boolean disponible = this.jcbDispModificar.isSelected();
        String id_prod = this.jtxtIDmodifar.getText();

        if (nombre_producto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese Nombre del Producto", "Validacion", 2);
            this.jtxtNPmodificar.requestFocus();
            return;
        }
        if (tipo_producto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Seleccione Tipo de Producto", "Validacion", 2);
            this.jcomboxTPmodificar.requestFocus();
            return;
        }
        if (descripcion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese Descripción del Producto", "Validacion", 2);
            this.jtxtDPmodificar.requestFocus();
            return;
        }
        if (precio_str.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese Precio del Producto", "Validacion", 2);
            this.jtxtPPmodificar1.requestFocus();
            return;
        }
        if (cantidad_str.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese Cantidad del Producto", "Validacion", 2);
            this.jtxtCPmodificar.requestFocus();
            return;
        }
        if (id_prod.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Seleccione un Producto", "Validacion", 2);
            //this.jtxtCPmodificar.requestFocus();
            return;
        }
        int precio =0, cantidad=0, id_producto;
        try {
            precio = Integer.parseInt(precio_str);
            cantidad = Integer.parseInt(cantidad_str);
            id_producto = Integer.parseInt(id_prod);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, "No ingreso numero", "Validacion", 2);
            return;
        }
                       
        //Guardamos los nuevos datos del producto
        Producto producto= new Producto();
        producto.setId_producto(id_producto);
        producto.setNombre_producto(nombre_producto);
        producto.setTipo_producto(tipo_producto);
        producto.setDescripcion(descripcion);
        producto.setPrecio(precio);
        producto.setCantidad(cantidad);
        producto.setDisponible(disponible);

        ProductoControlador cc = new ProductoControlador();

        try {
            if (cc.modificarProducto(producto)) {
            JOptionPane.showMessageDialog(this, "Producto modificado!", "Ingreso", 1);
            //actualizamos las tablas
            listarProductos();
            listarProductos2();
            listarProductos3();
        } else {
            JOptionPane.showMessageDialog(this, "Producto no se pudo modificar", "Validacion", 1);
        }
        } catch (Exception e) {
         
        } 
    }//GEN-LAST:event_jbtn_modificarActionPerformed

    private void jbtn_eliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_eliminarProductoActionPerformed
       
//        Producto producto;
//        int fila;
//        String nombre_producto;
//
//        ProductoControlador cc = new ProductoControlador();
//
//        try {
//            fila = this.jtbl_eliminarproducto.getSelectedRow();
//            nombre_producto = (String) this.jtbl_eliminarproducto.getValueAt(fila, 0);
//
//            producto = cc.buscarProducto(nombre_producto);
//
//            cc.eliminarProducto(nombre_producto);
//
//            JOptionPane.showMessageDialog(this, "Producto eliminado!", "Eliminar", 1);
//
//           // llenarTablaClientes();
//
//        } catch (Exception e) {
//            System.out.println("e.getMessage");
//        }
        //Actualizamos el atributo "disponible" a false para "eliminar" al producto seleccionado.
        Producto producto = new Producto();
        int fila;
        String nombre;
        ProductoControlador pc = new ProductoControlador();
        try {
            fila = this.jtbl_eliminarproducto.getSelectedRow();
            nombre = (String) this.jtbl_eliminarproducto.getValueAt(fila, 0);
            producto = pc.buscarProducto(nombre);
            producto.setDisponible(false);
            if (pc.modificarProducto(producto)) {
            JOptionPane.showMessageDialog(this, "Producto Eliminado(No disponible)!", "Eliminar", 1);
            //actualizamos las tablas
            listarProductos();
            listarProductos2();
            listarProductos3();
            } else {
                JOptionPane.showMessageDialog(this, "Producto no se pudo Eliminar", "Validacion", 1);
            }
            
        } catch (Exception e) {
            System.out.println("e.getMessage");
        }
        
    }//GEN-LAST:event_jbtn_eliminarProductoActionPerformed

    private void jbtn_buscarModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_buscarModificarActionPerformed
//    //Se inician las variables, controladores y la tabla
//        int  precio,cantidad;
//        String nombre_producto, tipo_producto, descripcion;
//        boolean disponible;
//
//        ProductoControlador cc = new ProductoControlador();
//
//        DefaultTableModel modelo = (DefaultTableModel) this.jtbl_modificarProducto.getModel();
//
//        nombre_producto = this.jtxtBuscarModificar.getText();
//        modelo.setRowCount(0);
//
//        //revisamos criterio de busqueda y se llena la tabla con los resultados
//        if (nombre_producto.equals("")) {
//
//            List <Producto> lista = cc.buscarTodos();
//           
//
//            for (Producto producto : lista) {
//                nombre_producto = producto.getNombre_producto();
//                tipo_producto = producto.getTipo_producto();
//                descripcion = producto.getDescripcion();
//                precio = producto.getPrecio();
//                cantidad = producto.getCantidad();
//                disponible= producto.isDisponible();
//
//                modelo.addRow(new Object[]{nombre_producto,tipo_producto,descripcion,precio,cantidad,disponible});
//            }
//        } else {
//
//            List <Producto> lista = cc.listarTodosProductosNombre();
//
//            for (Producto producto : lista){
//                
//                nombre_producto = producto.getNombre_producto();
//                tipo_producto = producto.getTipo_producto();
//                descripcion = producto.getDescripcion();
//                precio = producto.getPrecio();
//                cantidad = producto.getCantidad();
//                disponible= producto.isDisponible();
//
//                modelo.addRow(new Object[]{nombre_producto,tipo_producto,descripcion,precio,cantidad,disponible});
//                
//            }
//        }      // TODO add your handling code here:
           //
           String nombre;
            nombre = this.jtxtBuscarModificar.getText();
            if(nombre.isEmpty()){
                listarProductos2();
                JOptionPane.showMessageDialog(this, "Ingrese Nombre Producto", "Validacion", 2);
                this.jtxtBuscarModificar.requestFocus();
                return;
            }
            System.out.println(nombre);
            listarNombre2(nombre);
    }//GEN-LAST:event_jbtn_buscarModificarActionPerformed

    private void jbtnSalirListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSalirListarActionPerformed
        dispose();
    }//GEN-LAST:event_jbtnSalirListarActionPerformed

    private void jtbl_modificarProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_modificarProductoMouseClicked
        // Cuendo se clickee llenaremos los campos
        Producto producto = new Producto();
        int fila;
        String nombre, tipo;
        ProductoControlador pc = new ProductoControlador();
        try {
            fila = this.jtbl_modificarProducto.getSelectedRow();
            nombre = (String) this.jtbl_modificarProducto.getValueAt(fila, 0);
            producto = pc.buscarProducto(nombre);
            //llenamos los campos
            this.jtxtIDmodifar.setText(producto.getId_producto()+"");
            this.jtxtNPmodificar.setText(producto.getNombre_producto());
            tipo = producto.getTipo_producto();
            //preguntare que item es y repintare el combobox
            if(tipo.equalsIgnoreCase("Accesorio")){
                this.jcomboxTPmodificar.removeAllItems();
                //en el orden nuevo dejando primero el q llega de la bd
                this.jcomboxTPmodificar.addItem("Accesorio");
                this.jcomboxTPmodificar.addItem("Armazon");
                this.jcomboxTPmodificar.addItem("Cristal");
                this.jcomboxTPmodificar.addItem("Gafa");
                this.jcomboxTPmodificar.addItem("Reparación");
                this.jcomboxTPmodificar.addItem("Traspaso");
            }else if(tipo.equalsIgnoreCase("Armazon")){
                this.jcomboxTPmodificar.removeAllItems();
                //en el orden nuevo dejando primero el q llega de la bd
                this.jcomboxTPmodificar.addItem("Armazon");
                this.jcomboxTPmodificar.addItem("Cristal");
                this.jcomboxTPmodificar.addItem("Gafa");
                this.jcomboxTPmodificar.addItem("Reparación");
                this.jcomboxTPmodificar.addItem("Traspaso");
                this.jcomboxTPmodificar.addItem("Accesorio");
            }else if(tipo.equalsIgnoreCase("Cristal")){
                this.jcomboxTPmodificar.removeAllItems();
                //en el orden nuevo dejando primero el q llega de la bd
                this.jcomboxTPmodificar.addItem("Cristal");
                this.jcomboxTPmodificar.addItem("Gafa");
                this.jcomboxTPmodificar.addItem("Reparación");
                this.jcomboxTPmodificar.addItem("Traspaso");
                this.jcomboxTPmodificar.addItem("Accesorio");
                this.jcomboxTPmodificar.addItem("Armazon");
            }else if(tipo.equalsIgnoreCase("Gafa")){
                this.jcomboxTPmodificar.removeAllItems();
                //en el orden nuevo dejando primero el q llega de la bd
                this.jcomboxTPmodificar.addItem("Gafa");
                this.jcomboxTPmodificar.addItem("Reparación");
                this.jcomboxTPmodificar.addItem("Traspaso");
                this.jcomboxTPmodificar.addItem("Accesorio");
                this.jcomboxTPmodificar.addItem("Armazon");
                this.jcomboxTPmodificar.addItem("Cristal");
            }else if(tipo.equalsIgnoreCase("Reparación")){
                this.jcomboxTPmodificar.removeAllItems();
                //en el orden nuevo dejando primero el q llega de la bd
                this.jcomboxTPmodificar.addItem("Reparación");
                this.jcomboxTPmodificar.addItem("Traspaso");
                this.jcomboxTPmodificar.addItem("Accesorio");
                this.jcomboxTPmodificar.addItem("Armazon");
                this.jcomboxTPmodificar.addItem("Cristal");
                this.jcomboxTPmodificar.addItem("Gafa");
            }else if(tipo.equalsIgnoreCase("Traspaso")){
                this.jcomboxTPmodificar.removeAllItems();
                //en el orden nuevo dejando primero el q llega de la bd
                this.jcomboxTPmodificar.addItem("Traspaso");
                this.jcomboxTPmodificar.addItem("Accesorio");
                this.jcomboxTPmodificar.addItem("Armazon");
                this.jcomboxTPmodificar.addItem("Cristal");
                this.jcomboxTPmodificar.addItem("Gafa");
                this.jcomboxTPmodificar.addItem("Reparación");
            }else{
                System.out.println(tipo);
                System.out.println("no hizo nada esta wea");
            }
            //this.jcomboxTPmodificar.setSelectedIndex(WIDTH);
            this.jtxtDPmodificar.setText(producto.getDescripcion());
            this.jtxtPPmodificar1.setText(producto.getPrecio()+"");
            this.jtxtCPmodificar.setText(producto.getCantidad()+"");
            this.jcbDispModificar.setSelected(producto.isDisponible());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
                
    }//GEN-LAST:event_jtbl_modificarProductoMouseClicked

    private void jbtnBuscar_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBuscar_EliminarActionPerformed
        // TODO add your handling code here:
        String nombre;
        nombre = this.jtxt_buscarnombre.getText();
        if(nombre.isEmpty()){
            listarProductos3();
            JOptionPane.showMessageDialog(this, "Ingrese Nombre Producto", "Validacion", 2);
            this.jtxt_buscarnombre.requestFocus();
            return;
        }
        System.out.println(nombre);
        listarNombre3(nombre);
    }//GEN-LAST:event_jbtnBuscar_EliminarActionPerformed

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
            java.util.logging.Logger.getLogger(MantenedorProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MantenedorProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MantenedorProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MantenedorProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MantenedorProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton jbtnBuscarNP;
    private javax.swing.JButton jbtnBuscar_Eliminar;
    private javax.swing.JButton jbtnGuardar;
    private javax.swing.JButton jbtnLimpiar;
    private javax.swing.JButton jbtnSalirListar;
    private javax.swing.JButton jbtn_buscarModificar;
    private javax.swing.JButton jbtn_eliminarProducto;
    private javax.swing.JButton jbtn_limpiar_modificar;
    private javax.swing.JButton jbtn_modificar;
    private javax.swing.JCheckBox jcbDispModificar;
    private javax.swing.JComboBox<String> jcomboxTPmodificar;
    private javax.swing.JComboBox<String> jcomboxTipProduc;
    private javax.swing.JLabel jlCantProduc;
    private javax.swing.JLabel jlDescripProduc;
    private javax.swing.JLabel jlDispProduc;
    private javax.swing.JLabel jlNomProduc;
    private javax.swing.JLabel jlPrecioProduc;
    private javax.swing.JLabel jlTipProduc;
    private javax.swing.JLabel jlbDPmodificar;
    private javax.swing.JLabel jlbIDmodificar;
    private javax.swing.JLabel jlbIdBuscarModificar;
    private javax.swing.JLabel jlbNPmodificar;
    private javax.swing.JLabel jlbPPmodificar;
    private javax.swing.JLabel jlbTPbuscar_eliminar;
    private javax.swing.JLabel jlbTPmodificar;
    private javax.swing.JPanel jpAgregarProducto;
    private javax.swing.JPanel jpEliminar;
    private javax.swing.JPanel jpListarProducto;
    private javax.swing.JPanel jpModificarProducto;
    private javax.swing.JTable jtbl_eliminarproducto;
    private javax.swing.JTable jtbl_listarProductos;
    private javax.swing.JTable jtbl_modificarProducto;
    private javax.swing.JTabbedPane jtpMantenedorProducto;
    private javax.swing.JTextField jtxListarNombre;
    private javax.swing.JTextField jtxtBuscarModificar;
    private javax.swing.JTextField jtxtCPmodificar;
    private javax.swing.JTextField jtxtCantidad;
    private javax.swing.JTextField jtxtDPmodificar;
    private javax.swing.JTextField jtxtDescripProduc;
    private javax.swing.JTextField jtxtIDmodifar;
    private javax.swing.JTextField jtxtNPmodificar;
    private javax.swing.JTextField jtxtNomProduc;
    private javax.swing.JTextField jtxtPPmodificar1;
    private javax.swing.JTextField jtxtPrecio;
    private javax.swing.JTextField jtxt_buscarnombre;
    // End of variables declaration//GEN-END:variables
}
