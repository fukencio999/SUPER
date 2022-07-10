package Producto;

import java.util.ArrayList;

public class Carrito {
    ArrayList <Producto> carrito= new ArrayList<> ();
    
    public Carrito(){      
    }

    public ArrayList<Producto> getCarrito() {
        return carrito;
    }
      
    public int tamaño_carrito(){
        return this.carrito.size();
    }
    
    public void agregar_producto(Producto producto){          
        this.carrito.add(producto); 
        
    }
    
    public void mostrar_carrito(){
        System.out.println("SU CARRITO DE COMPRA: ");
        double total=0;
        for(int i=0;i<carrito.size();i++){
            System.out.println(carrito.get(i).getNombre()+" -- x"+(long)carrito.get(i).getCantidad()+" UNIDADES -- Total: $"+carrito.get(i).getPrecio());
            total=total+(carrito.get(i).getPrecio());
        }
        System.out.println("TOTAL A PAGAR: $"+total);
    }
       
}

