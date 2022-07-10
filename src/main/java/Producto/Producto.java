package Producto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Producto {
    private int id;
    private String nombre;
    private double precio;
    private double cantidad;
    private int id_categoria;
    private int stock;
    
    
    public Producto(){
        
    }
    
    public Producto(int id, String nombre, double precio, double cantidad, int id_categoria, int stock ) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad=cantidad;
        this.id_categoria = id_categoria;
        this.stock = stock;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    
    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    
    public double getCantidad(){
        return cantidad;
    }
    
    public void setCantidad(double cantidad){
        this.cantidad=cantidad;
    }
    
    public void setIdCategoria(int id_categoria){
        this.id_categoria=id_categoria;
    }
    
    public int getIdCategoria(){
        return id_categoria;
    }
 
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
  
    public void mostar_categorias(Connection conexion) throws SQLException{
        Statement declaracion = null;
        declaracion = conexion.createStatement();
        String sql;
        sql = "SELECT nombre, id FROM categoria";
        ResultSet consulta = declaracion.executeQuery(sql);
        while(consulta.next()){
            int id=consulta.getInt("id");
            String nombre=consulta.getString("nombre");
            System.out.println(id+") "+nombre);
        }
    }
        
    public double cantidad(double cantidad){
        return cantidad;
    }
    
    public void elegir_productos(Connection conexion, Carrito carrito) throws SQLException{
        Statement declaracion = null;
        declaracion = conexion.createStatement();
        String sql;
        Scanner leer=new Scanner(System.in);
        
        System.out.print("SELECCCIONE UNA CATEGORÍA PARA EMPEZAR CON SU COMPRA: ");
        int opc=leer.nextInt();       
        leer.nextLine();
        switch(opc){
            case 1: {   sql = "SELECT nombre, precio, id FROM producto WHERE id_categoria=1";
                        ResultSet consulta = declaracion.executeQuery(sql);                   
                        while(consulta.next()){                                                                                      
                            Producto producto=new Producto();
                            producto.setId(consulta.getInt("id"));
                            producto.setNombre(consulta.getString("nombre"));
                            producto.setPrecio(consulta.getDouble("precio"));
                            System.out.println("Producto: "+producto.getNombre()+'\n'+"Precio: $"+producto.getPrecio());
                            System.out.println("") ;  
                            System.out.println("DESEA AGREGAR EL PRODUCTO A SU CARRITO?");
                            System.out.println("s=SI");
                            String opc2=leer.nextLine();                          
                            if(opc2.equals("s")){
                                System.out.print("INDIQUE LA CANTIDAD DE ESTE ARTICULO QUE DESEA COMPRAR: ");
                                producto.setCantidad(leer.nextDouble());                               
                                producto.setPrecio(producto.getPrecio()*producto.getCantidad());                               
                                carrito.agregar_producto(producto);
                                System.out.println("PORDUCTO/S AGREGADOS AL CARRITO CON ÉXITO");  
                                
                            }
                            
                        }   
            } break;                      
                  
            case 2: {  sql = "SELECT nombre, precio, id FROM producto WHERE id_categoria=2";
                        ResultSet consulta = declaracion.executeQuery(sql);                   
                        while(consulta.next()){                                                                                      
                            Producto producto=new Producto();
                            producto.setId(consulta.getInt("id"));
                            producto.setNombre(consulta.getString("nombre"));
                            producto.setPrecio(consulta.getDouble("precio"));
                            System.out.println("Producto: "+producto.getNombre()+'\n'+"Precio: $"+producto.getPrecio());
                            System.out.println("") ;  
                            System.out.println("DESEA AGREGAR EL PRODUCTO A SU CARRITO?");
                            System.out.println("s=SI");
                            String opc2=leer.nextLine();
                            if(opc2.equals("s")){
                                System.out.print("INDIQUE LA CANTIDAD DE ESTE ARTICULO QUE DESEA COMPRAR: ");
                                producto.setCantidad(leer.nextDouble());                                                                                          
                                producto.setPrecio(producto.getPrecio()*producto.getCantidad());                               
                                carrito.agregar_producto(producto);
                                System.out.println("PORDUCTO/S AGREGADOS AL CARRITO CON ÉXITO");                               
                            }                                                    
                        }  
            } break;           
            
            case 3: {   sql = "SELECT nombre, precio, id FROM producto WHERE id_categoria=3";
                        ResultSet consulta = declaracion.executeQuery(sql);                   
                        while(consulta.next()){                                                                                      
                            Producto producto=new Producto();
                            producto.setId(consulta.getInt("id"));
                            producto.setNombre(consulta.getString("nombre"));
                            producto.setPrecio(consulta.getDouble("precio"));
                            System.out.println("Producto: "+producto.getNombre()+'\n'+"Precio: $"+producto.getPrecio());
                            System.out.println("") ;  
                            System.out.println("DESEA AGREGAR EL PRODUCTO A SU CARRITO?");
                            System.out.println("s=SI");
                            String opc2=leer.nextLine();
                            if(opc2.equals("s")){
                                System.out.print("INDIQUE LA CANTIDAD DE ESTE ARTICULO QUE DESEA COMPRAR: ");
                                producto.setCantidad(leer.nextDouble());                                                                                          
                                producto.setPrecio(producto.getPrecio()*producto.getCantidad());                               
                                carrito.agregar_producto(producto);
                                System.out.println("PORDUCTO/S AGREGADOS AL CARRITO CON ÉXITO");
                            }                                                    
                        }  
            } break;           
            
            case 4: {   sql = "SELECT nombre, precio, id FROM producto WHERE id_categoria=4";
                        ResultSet consulta = declaracion.executeQuery(sql);                   
                        while(consulta.next()){                                                                                      
                            Producto producto=new Producto();
                            producto.setId(consulta.getInt("id"));
                            producto.setNombre(consulta.getString("nombre"));
                            producto.setPrecio(consulta.getDouble("precio"));
                            System.out.println("Producto: "+producto.getNombre()+'\n'+"Precio: $"+producto.getPrecio());
                            System.out.println("") ;  
                            System.out.println("DESEA AGREGAR EL PRODUCTO A SU CARRITO?");
                            System.out.println("s=SI");
                            String opc2=leer.nextLine();
                            if(opc2.equals("s")){
                                System.out.print("INDIQUE LA CANTIDAD DE ESTE ARTICULO QUE DESEA COMPRAR: ");
                                producto.setCantidad(leer.nextDouble());                                                                                          
                                producto.setPrecio(producto.getPrecio()*producto.getCantidad());                               
                                carrito.agregar_producto(producto);
                                System.out.println("PORDUCTO/S AGREGADOS AL CARRITO CON ÉXITO");
                            }                                                    
                        }  
            } break;           
            
            case 5: {   sql = "SELECT nombre, precio, id FROM producto WHERE id_categoria=5";
                        ResultSet consulta = declaracion.executeQuery(sql);                   
                        while(consulta.next()){                                                                                      
                            Producto producto=new Producto();
                            producto.setId(consulta.getInt("id"));
                            producto.setNombre(consulta.getString("nombre"));
                            producto.setPrecio(consulta.getDouble("precio"));
                            System.out.println("Producto: "+producto.getNombre()+'\n'+"Precio: $"+producto.getPrecio());
                            System.out.println("") ;  
                            System.out.println("DESEA AGREGAR EL PRODUCTO A SU CARRITO?");
                            System.out.println("s=SI");
                            String opc2=leer.nextLine();
                            if(opc2.equals("s")){
                                System.out.print("INDIQUE LA CANTIDAD DE ESTE ARTICULO QUE DESEA COMPRAR: ");
                                producto.setCantidad(leer.nextDouble());                                                                                          
                                producto.setPrecio(producto.getPrecio()*producto.getCantidad());                               
                                carrito.agregar_producto(producto);
                                System.out.println("PORDUCTO/S AGREGADOS AL CARRITO CON ÉXITO");
                            }                                                    
                        }  
            } break;           
            
            case 6: {   sql = "SELECT nombre, precio, id FROM producto WHERE id_categoria=6";
                        ResultSet consulta = declaracion.executeQuery(sql);                   
                        while(consulta.next()){                                                                                      
                            Producto producto=new Producto();
                            producto.setId(consulta.getInt("id"));
                            producto.setNombre(consulta.getString("nombre"));
                            producto.setPrecio(consulta.getDouble("precio"));
                            System.out.println("Producto: "+producto.getNombre()+'\n'+"Precio: $"+producto.getPrecio());
                            System.out.println("") ;  
                            System.out.println("DESEA AGREGAR EL PRODUCTO A SU CARRITO?");
                            System.out.println("s=SI");
                            String opc2=leer.nextLine();
                            if(opc2.equals("s")){
                                System.out.print("INDIQUE LA CANTIDAD DE ESTE ARTICULO QUE DESEA COMPRAR: ");
                                producto.setCantidad(leer.nextDouble());                                                                                          
                                producto.setPrecio(producto.getPrecio()*producto.getCantidad());                               
                                carrito.agregar_producto(producto);
                                System.out.println("PORDUCTO/S AGREGADOS AL CARRITO CON ÉXITO");
                            }                                                    
                        }  
            } break;           
            
            case 7: {   sql = "SELECT nombre, precio, id FROM producto WHERE id_categoria=7";
                        ResultSet consulta = declaracion.executeQuery(sql);                   
                        while(consulta.next()){                                                                                      
                            Producto producto=new Producto();
                            producto.setId(consulta.getInt("id"));
                            producto.setNombre(consulta.getString("nombre"));
                            producto.setPrecio(consulta.getDouble("precio"));
                            System.out.println("Producto: "+producto.getNombre()+'\n'+"Precio: $"+producto.getPrecio());
                            System.out.println("") ;  
                            System.out.println("DESEA AGREGAR EL PRODUCTO A SU CARRITO?");
                            System.out.println("s=SI");
                            String opc2=leer.nextLine();
                            if(opc2.equals("s")){
                                System.out.print("INDIQUE LA CANTIDAD DE ESTE ARTICULO QUE DESEA COMPRAR: ");
                                producto.setCantidad(leer.nextDouble());                                                                                          
                                producto.setPrecio(producto.getPrecio()*producto.getCantidad());                               
                                carrito.agregar_producto(producto);
                                System.out.println("PORDUCTO/S AGREGADOS AL CARRITO CON ÉXITO");
                            }                                                    
                        }  
            } break;           
            
            case 8: {   sql = "SELECT nombre, precio, id FROM producto WHERE id_categoria=8";
                        ResultSet consulta = declaracion.executeQuery(sql);                   
                        while(consulta.next()){                                                                                      
                            Producto producto=new Producto();
                            producto.setId(consulta.getInt("id"));
                            producto.setNombre(consulta.getString("nombre"));
                            producto.setPrecio(consulta.getDouble("precio"));
                            System.out.println("Producto: "+producto.getNombre()+'\n'+"Precio: $"+producto.getPrecio());
                            System.out.println("") ;  
                            System.out.println("DESEA AGREGAR EL PRODUCTO A SU CARRITO?");
                            System.out.println("s=SI");
                            String opc2=leer.nextLine();
                            if(opc2.equals("s")){
                                System.out.print("INDIQUE LA CANTIDAD DE ESTE ARTICULO QUE DESEA COMPRAR: ");
                                producto.setCantidad(leer.nextDouble());                                                                                          
                                producto.setPrecio(producto.getPrecio()*producto.getCantidad());                               
                                carrito.agregar_producto(producto);
                                System.out.println("PORDUCTO/S AGREGADOS AL CARRITO CON ÉXITO");
                            }                                                    
                        }  
            } break;           
            
            case 9: {   sql = "SELECT nombre, precio, id FROM producto WHERE id_categoria=9";
                        ResultSet consulta = declaracion.executeQuery(sql);                   
                        while(consulta.next()){                                                                                      
                            Producto producto=new Producto();
                            producto.setId(consulta.getInt("id"));
                            producto.setNombre(consulta.getString("nombre"));
                            producto.setPrecio(consulta.getDouble("precio"));
                            System.out.println("Producto: "+producto.getNombre()+'\n'+"Precio: $"+producto.getPrecio());
                            System.out.println("") ;  
                            System.out.println("DESEA AGREGAR EL PRODUCTO A SU CARRITO?");
                            System.out.println("s=SI");
                            String opc2=leer.nextLine();
                            if(opc2.equals("s")){
                                System.out.print("INDIQUE LA CANTIDAD DE ESTE ARTICULO QUE DESEA COMPRAR: ");
                                producto.setCantidad(leer.nextDouble());                                                                                          
                                producto.setPrecio(producto.getPrecio()*producto.getCantidad());                               
                                carrito.agregar_producto(producto);
                                System.out.println("PORDUCTO/S AGREGADOS AL CARRITO CON ÉXITO");
                            }                                                    
                        }  
            } break; 
            
            case 10: {  sql = "SELECT nombre, precio, id FROM producto WHERE id_categoria=10";
                        ResultSet consulta = declaracion.executeQuery(sql);                   
                        while(consulta.next()){                                                                                      
                            Producto producto=new Producto();
                            producto.setId(consulta.getInt("id"));
                            producto.setNombre(consulta.getString("nombre"));
                            producto.setPrecio(consulta.getDouble("precio"));
                            System.out.println("Producto: "+producto.getNombre()+'\n'+"Precio: $"+producto.getPrecio());
                            System.out.println("") ;  
                            System.out.println("DESEA AGREGAR EL PRODUCTO A SU CARRITO?");
                            System.out.println("s=SI");
                            String opc2=leer.nextLine();
                            if(opc2.equals("s")){
                                System.out.print("INDIQUE LA CANTIDAD DE ESTE ARTICULO QUE DESEA COMPRAR: ");
                                producto.setCantidad(leer.nextDouble());                                                                                          
                                producto.setPrecio(producto.getPrecio()*producto.getCantidad());                               
                                carrito.agregar_producto(producto);
                                System.out.println("PORDUCTO/S AGREGADOS AL CARRITO CON ÉXITO");
                                }
                        }       
            }   

        }
    }
}
    

    
    
    
    
    
    
    
    
    

