
package parcial1_b1;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Productos {
    
    private String nombre;
    private int cantidad;
    private double precio;
    private ArrayList<Productos> ListaProducto= new ArrayList();
    Ventas venta = new Ventas();
      

    public Productos(String nombre, int cantidad, double precio) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }
    
    public Productos() {

    }
    
    //Getter and Setter
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public ArrayList<Productos> getProductos() {
        return this.ListaProducto;
    }

    public void setProductos(ArrayList<Productos> productos) {
        this.ListaProducto = productos;
    }
    
    
    
    DefaultTableModel modelo = new DefaultTableModel();
        
     public void CebeceraProductos(JTable tablaProductos){
       String[] cabecera = new String[]{"NOMBRE","CANTIDAD DISPONIBLE","PRECIO"};
        modelo.setColumnIdentifiers(cabecera);
        tablaProductos.setModel(modelo);
    }
    
       public void AgregarProducto(JTextField nombre, JTextField cantidad, JTextField precio){
       if(nombre.getText().length()==0 && cantidad.getText().length()==0 && precio.getText().length()==0){
          JOptionPane.showMessageDialog(null, "Llene los campos del producto");
       }
       else{
       this.nombre=nombre.getText();
       this.cantidad=Integer.parseInt(cantidad.getText());
       this.precio= Double.parseDouble(precio.getText());
        modelo.addRow(new Object[]{this.nombre,this.cantidad,this.precio});
        Productos producto = new Productos(this.nombre, this.cantidad, this.precio);

        ListaProducto.add(producto);
        //System.out.println("PRODUCTO AGREGADO"); 
           
       }
       
        
    }
     
    public void LimpiarDatosProductos(JTextField nombre, JTextField cantidad, JTextField precio){
        nombre.setText("");
        cantidad.setText("");
        precio.setText("");
    }
    
    
    public void eliminarfilaProducto(JTable tablaProductos){
        int fila=tablaProductos.getSelectedRow();
        if(tablaProductos.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }
        else{
           modelo.removeRow(fila); 
        }
        
    }
    

}
