
import java.util.ArrayList;
import java.util.Scanner;


public class practica_1 {

    public static void main(String[] args) {
        
        ArrayList<String> lenguaje = new ArrayList();
        boolean flag = true, flag2 = false;
        Scanner scan;
        String elemento;
        int contador=1;
        
        System.out.println("Ingrese los elementos del lenguaje, cuando desee terminar ingrese %");
        while(flag){
        	System.out.println("Ingrese el elemento "+contador+ " del lenguaje" );
        	contador++;
            scan = new Scanner(System.in);
            elemento = scan.next();
            flag2 = false;
            if (!elemento.equals("%")) {
                
                for (String elemAux : lenguaje) {
                    if (elemento.equals(elemAux)) {
                        System.out.println("Este elemento ya se encuentra en el lenguaje");
                        flag2 = true;
                        break;
                    }
                }
                if (!flag2) {
                    lenguaje.add(elemento);
                }
            }else{
                flag = false;
            }
            if (lenguaje.isEmpty()) {
            	System.out.println("Debe ingresar al menos un elemento al lenguaje");
            	flag = true;
            }else{
            	contador++;
            }
        }
        System.out.println("Ingrese la potencia a la que desea elevar el lenguaje");
        
        do{
            flag = false;
            scan  = new Scanner(System.in);
            if (!scan.hasNextInt()) {
                System.out.println("por favor ingrese un valor entero positivo");
                flag = true;
            }else{
                int potencia = scan.nextInt();
                if (potencia<0) {
                    System.out.println("por favor ingrese un valor entero positivo");
                    flag = true;
                }else{
                    lenguaje = potencia(lenguaje,lenguaje,1,potencia);
                    System.out.println("Los elementos del lenguaje L^"+potencia+" son: {");
                    for(String xd : lenguaje){
                        System.out.println(xd);
                    }
                    System.out.println("}");
                }
            }
        }while(flag);
                
    }
    
    private static ArrayList<String> potencia(ArrayList<String> lenguaje,ArrayList<String> lenguajeAux,int contador, int potencia){
        ArrayList<String> lenguajeF = new ArrayList();
        if (potencia==0) {
            lenguajeF.add("ɛ");
            return lenguajeF;
        }else if (potencia == 1){
            return lenguaje;
        }else if (contador<potencia){
           for(String aux1 : lenguaje){
               for(String aux2 : lenguajeAux){
                   lenguajeF.add(aux1+aux2);
                   //System.out.println(aux1+aux2);
               }
           }
           return potencia(lenguaje,lenguajeF,++contador,potencia);
        }else{
            return lenguajeAux;
        }
    }
    
}
