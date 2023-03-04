
package parcial1_b1;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Clientes {
    
    private String nombre;
    private String apellido;
    private String cedula;
    private String direccion;
    private String celular;
    private String email;

    public Clientes(String nombre, String apellido, String cedula, String direccion, String celular, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.direccion = direccion;
        this.celular = celular;
        this.email = email;
    }
    
    public Clientes() {

    }
    
    
    //Getter y Setter
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return this.cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCelular() {
        return this.celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
       DefaultTableModel modelo = new DefaultTableModel();
    public void CabeceraClientes(JTable tablaClientes){
        String[] cabecera = new String[]{"NOMBRE","APELLIDO","CEDULA","DIRECCION","CELULAR","EMAIL"};
        modelo.setColumnIdentifiers(cabecera);
        tablaClientes.setModel(modelo);
    }
    
    public void AgregarCliente(JTextField nombre, JTextField apellido, JTextField ced,JTextField direcc, JTextField celular,JTextField email){
       
       this.nombre=nombre.getText();
       this.apellido=apellido.getText();
       this.cedula=ced.getText();
       this.direccion=direcc.getText();
       this.celular=celular.getText();
       this.email=email.getText();
       modelo.addRow(new Object[]{this.nombre,this.apellido,this.cedula,this.direccion,this.celular,this.email});
    }

    public void LimpiarDatosClientes(JTextField nombre, JTextField apellido, JTextField ced,JTextField direcc, JTextField celular,JTextField email){
        nombre.setText("");
        apellido.setText("");
        ced.setText("");
        direcc.setText("");
        celular.setText("");
        email.setText("");
    }
    
    public void eliminarfilaCliente(JTable tablaClientes){
        int fila=tablaClientes.getSelectedRow();
        if(tablaClientes.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }
        else{
           modelo.removeRow(fila); 
        }
        
    }
    
}
