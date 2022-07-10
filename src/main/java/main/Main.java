package main;

import admin.Admin;
import Entidades.Cliente;
import Producto.Carrito;
import Producto.Producto;
import compra.Compra;
import conexion.Conexion;
import java.sql.SQLException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println("#####################");
        System.out.println("| SISTEMA SUPERMARK |");
	System.out.println("#####################");
  	Scanner teclado1=new Scanner(System.in);
	Conexion conexion=new Conexion();
        Carrito carrito=new Carrito();
        int opcion=1;
        String salida="";
        boolean salir=false;
        while(opcion==1) {
            System.out.println("----------------------");
            System.out.println("|  1-Iniciar sesion  |");
            System.out.println("|  2-Crear usuario   |");
            System.out.println("|  3-Administrador   |");
            System.out.println("----------------------");
            Scanner teclado2=new Scanner(System.in);
            int opcionMenuPrincipal=teclado2.nextInt();
            ////
            switch(opcionMenuPrincipal) {
            case 1:{
            	Cliente cliente=new Cliente();
            	cliente.iniciar_sesion(conexion.conectar());
            	Producto producto=new Producto();
            while(salir==false){
            	producto.mostar_categorias(conexion.conectar());
            	producto.elegir_productos(conexion.conectar(), carrito);           	
                System.out.println("");
            	System.out.println("QUIERE REALIZAR OTRA COMPRA? \n s=SI -- n=NO");
            	salida=teclado1.nextLine();
            	if(salida.equals("n")){
            		salir=true;
            		}
            	else {
            		System.out.println("Seleccione la categoria de producto");
            	}
            	}
            System.out.println("");
            carrito.mostrar_carrito();
            System.out.println("+------------------------+");
            System.out.println("|   CONFIRMAR COMPPRA?   |");
            System.out.println("|           si           |");
            System.out.println("|           no           |");
            System.out.println("+------------------------+");
            String opc;
            opc=teclado1.next();
            if(opc.equals("si")){
            	Compra compra=new Compra();
                compra.confirmar_compra(conexion.conectar(), carrito);
                System.out.println("+------------------------+");
                System.out.println("|        SU COMPRA       |");
                System.out.println("|           FUE          |");
                System.out.println("|        CONFIRMADA      |");
                System.out.println("+------------------------+");
            }
            }
            break;
            case 2:{ 
            	Cliente cliente=new Cliente();
            	cliente.registrar(conexion.conectar());               
            	break;
            }
            case 3:{
            	Admin admin=new Admin(); //se crea un objeto de tipo Admin para poder usar los metodos codificados en su clase
            	admin.bienvenido_admin(); //metodo dentro de la calse Admin que ejecuta el inicio de sesion del admin             
		break;
            }
            }
            System.out.println("######################");
            System.out.println("| Salir del sistema? |");
            System.out.println("|     0 - SI         |");
            System.out.println("|     1 - NO         |");
            System.out.println("######################");
            opcion=teclado1.nextInt();
            teclado1.nextLine();
        }
        System.out.println("+------------------------+");
        System.out.println("| GRACIAS POR SU COMPRA  |");
        System.out.println("|      EN SUPERMARK      |");
        System.out.println("|           :)           |");
        System.out.println("+------------------------+");
        }
    }
