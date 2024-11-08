package es.iesoretania;
import java.sql.*;

public class sentPrepUpdateEmpleadosSalario{
    public static void main(String[] args){
        
        //Recogemos los valores de los argumentos al programa.
        String dep = args[0];
        String subida = args[1];
        
        try {
            Connection conexion = DriverManager.getConnection
            ("jdbc:mysql://localhost/practica","root", "practica");

            //construimos la orden INSERT
            String sql = "UPDATE empleados SET salario=salario + ? WHERE dept_no=?";
            PreparedStatement sentencia = conexion.prepareStatement(sql);

            sentencia.setInt(2, Integer.parseInt(dep));
            sentencia.setFloat(1, Float.parseFloat(subida));

            int filas = sentencia.executeUpdate(); 
            System.out.printf("Registros actualizados: %d%n", filas);

            sentencia.close();
            conexion.close();
        } catch (SQLException e) {
            System.out.println("ERROR: "+ e.getMessage());
        }
        


    }
}