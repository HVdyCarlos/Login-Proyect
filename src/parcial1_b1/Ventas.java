
package parcial1_b1;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Ventas {
    
    private Clientes cliente;
    private ArrayList<Productos> ListaProducto;
    private double descuento;
    private double preciobajo;
    private double precioalto;
    private double totalcondescunento;
    private double totalsindescuento;
    private double subtotalVenta;
    private String tipoDescuento;

    public Ventas(Clientes cliente, ArrayList<Productos> producto) {
        this.cliente = cliente;
        this.ListaProducto = producto;
    }

    public Ventas() {

    }

    public Clientes getCliente() {
        return this.cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Productos> getProducto() {
        return this.ListaProducto;
    }

    public void setProducto(ArrayList<Productos> producto) {
        this.ListaProducto = producto;
    }

    public double getDescuento() {
        return this.descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getPreciobajo() {
        return this.preciobajo;
    }

    public void setPreciobajo(double preciobajo) {
        this.preciobajo = preciobajo;
    }

    public double getPrecioalto() {
        return this.precioalto;
    }

    public void setPrecioalto(double precioalto) {
        this.precioalto = precioalto;
    }

    public double getTotalsindescuento() {
        return this.totalsindescuento;
    }

    public void setTotalsindescuento(double totalsindescuento) {
        this.totalsindescuento = totalsindescuento;
    }

    public double getSubtotal() {
        return this.subtotalVenta;
    }

    public void setSubtotal(double subtotal) {
        this.subtotalVenta = subtotal;
    }

    public String getTipoDescuento() {
        return tipoDescuento;
    }

    public void setTipoDescuento(String tipoDescuento) {
        this.tipoDescuento = tipoDescuento;
    }

    
    
    
    DefaultTableModel modelo = new DefaultTableModel();
    
     public void CebecerasubTotalVenta(JTable tablaSubtotal){
       String[] cabecera = new String[]{"NOMBRE PRODUCTO","SUBTOTAL"};
        modelo.setColumnIdentifiers(cabecera);
        tablaSubtotal.setModel(modelo);
     }
    
     
    public double CalcularSubtotalVenta(JTextField cantidad, JTable tablaProductos){
        this.subtotalVenta=0;
        tablaProductos.getSelectedRow();
        for(int i = 0; i < tablaProductos.getRowCount(); i++){
             
            double valorTabla = Double.parseDouble(tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 2).toString());
             
            this.subtotalVenta = valorTabla * Integer.parseInt(cantidad.getText());
        } 
        return this.subtotalVenta;
    }
    
    public void AgregarTablaVentas(JTextField cantidad, JTable tablaProductos, JTable tablaVentas, JTextField bajo, JTextField alto, JTextField descuento, JTextField total, JTextField ttdescuento,JLabel tipodes){

        if(cantidad.getText().length()==0){
            JOptionPane.showMessageDialog(null, "Por favor ingresa la Cantida a comprar");
        }
        else{
            if(tablaProductos.getSelectedRow()==-1){
                JOptionPane.showMessageDialog(null, "Por favor Selecione un producto");
            }else{
                modelo.addRow(new Object[]{tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 0),this.CalcularSubtotalVenta(cantidad, tablaProductos)});
                bajo.setText(String.valueOf(this.CalcularSubtotalBajo(tablaVentas)));
                alto.setText(String.valueOf(this.CalcularSubtotalAlto(tablaVentas)));
                descuento.setText(String.valueOf(this.CalcularDecuentoVenta()));
                total.setText(String.valueOf(this.CalcularTotalVenta(tablaVentas)));
                ttdescuento.setText(String.valueOf(this.CalcularTotalconDes()));
                tipodes.setText(this.tipoDescuento); 
                cantidad.setText("");
            }
         
        } 

    }

    
    public double CalcularTotalVenta(JTable tablaSubtotal){
        this.totalsindescuento=0;
        for(int i=0; i<tablaSubtotal.getRowCount(); i++){
            double valorTabla = Double.parseDouble(tablaSubtotal.getValueAt(i, 1).toString());
            this.totalsindescuento = this.totalsindescuento + valorTabla;
            
        }
        System.out.println("Total compra = "+this.totalsindescuento);
        return this.totalsindescuento;
    }

    public double CalcularTotalconDes(){
        this.totalcondescunento = this.totalsindescuento-this.descuento;
        return this.totalcondescunento;
    }
     public double CalcularDecuentoVenta(){
          this.descuento=0;
         this.tipoDescuento="0%";
         if(this.totalsindescuento>50000 && this.totalsindescuento <=100000){
             this.descuento = (this.totalsindescuento*0.2);
             System.out.println("Su descuento es del 20%");
             this.tipoDescuento="20%";
         }
         else{
             if(this.totalsindescuento>100000 && this.totalsindescuento <=200000){
                 this.descuento = (this.totalsindescuento*0.4);
                 System.out.println("Su descuento es del 40%");
                 this.tipoDescuento="40%";
             }
             else{
                 if(this.totalsindescuento >200000){
                     this.descuento = (this.totalsindescuento*0.5);
                 System.out.println("Su descuento es del 50%");
                 this.tipoDescuento="50%";
                 }
             }
         }
       
         return this.descuento;
    }
     
    public double CalcularSubtotalAlto(JTable tablaSubtotal){
        this.precioalto=0;
        for(int i = 0; i < tablaSubtotal.getRowCount(); i++){             
            double valorTabla = Double.parseDouble(tablaSubtotal.getValueAt(i, 1).toString());
            if(valorTabla > this.precioalto){
                this.precioalto=valorTabla;
            }
        } 
        return this.precioalto;
    }
    
     public double CalcularSubtotalBajo(JTable tablaSubtotal){
        this.preciobajo = Double.parseDouble(tablaSubtotal.getValueAt(0, 1).toString());//100 - 500
        tablaSubtotal.getSelectedRow();
        for(int i = 0; i < tablaSubtotal.getRowCount(); i++){             
            double valorTabla = Double.parseDouble(tablaSubtotal.getValueAt(i, 1).toString());
            if(valorTabla < this.preciobajo){
                this.preciobajo=valorTabla;
            }
  
        } 
        return this.preciobajo;
    }
     
      public void eliminarfilaventa(JTable tablaVenta, JTextField bajo, JTextField alto, JTextField descuento, JTextField total, JTextField ttdescuento,JLabel tipodes){
        int fila=tablaVenta.getSelectedRow();
        if(tablaVenta.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }
        else{
           modelo.removeRow(fila); 
                bajo.setText(String.valueOf(this.CalcularSubtotalBajo(tablaVenta)));
                alto.setText(String.valueOf(this.CalcularSubtotalAlto(tablaVenta)));
                descuento.setText(String.valueOf(this.CalcularDecuentoVenta()));
                total.setText(String.valueOf(this.CalcularTotalVenta(tablaVenta)));
                ttdescuento.setText(String.valueOf(this.CalcularTotalconDes()));
                tipodes.setText(this.tipoDescuento);

        }
        
    }

}
