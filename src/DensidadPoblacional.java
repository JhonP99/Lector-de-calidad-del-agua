import java.util.ArrayList;

public class DensidadPoblacional extends ObjetoGeografico {
    private Integer afeccion;
    
    
    public DensidadPoblacional() {
        
    }


    public Integer getAfeccion(){
        return afeccion;
    }

    public void setAfeccion(Integer afeccion){
        this.afeccion = afeccion;
    }


    public static Integer afeccion (ArrayList<DensidadPoblacional> afeccion) {
        Integer x = 0;
        for(int i = 0; i<afeccion.size(); i++){
            x = afeccion.get(i).getAfeccion();
        }        
            
        if ( x <= 10000){
            return 0;
        }else if(x > 10000 && x <= 50000){
            return 1;
        }else if(x > 50000){
            return 2;
        }else{
            return 3;
        }
        
               
    }

    public String toString(){
        return String.valueOf(afeccion);
    }
    





    
    
}
