public class CuerpoDeAgua extends ObjetoGeografico{
    private String nivel, TdeCuerpo, TdeAgua;
    private Double irca;
    
    

    public CuerpoDeAgua(){

    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getNivel() {
        return nivel;
    }

    public void setTdeAgua(String TdeAgua){
        this.TdeAgua = TdeAgua;
    }

    public String getTdeAgua(){
        return TdeAgua;
    }

    public void setIrca(Double irca) {
        this.irca = irca;
    }

    public Double getIrca() {
        return irca;
    }
    
    public void setTdeCuerpo(String TdeCuerpo){
        this.TdeCuerpo = TdeCuerpo;

    }

    public String getTdeCuerpo(){
        return TdeCuerpo;
    }
    
    

    /////////////////////////////////////////////////////////////////////////////////////////

    public void setName(String name) {
        super.setName(name);

    }

    public String getName() {
        return super.getName();
    }


    public void setMuni(String muni) {
        super.setMuni(muni);
    }

    public String getMuni() {
        return super.getMuni();
    }


    public void setId(Double id) {
        super.setId(id);
    }

    public Double getId() {
        return super.getId();
    }

    


    public String nivel(double IRCA){
        if (IRCA >= 80.1 && IRCA <= 100){
            return "INVIABLE SANITARIAMENTE";
        }
        else if(IRCA >= 35.1 && IRCA <= 80){
            return "ALTO";
        }
        else if(IRCA >= 14.1 && IRCA <= 35){
            return "MEDIO";
        }
        else if(IRCA >= 5.1 && IRCA <= 14){
            return "BAJO";
        }
        else if(IRCA >= 0 && IRCA <= 5){
            return "SIN RIESGO";
        }
        else{
            return "ERROR";
        }
    }

    public String toString(){
        return getName()+" "+String.valueOf(getId())+" "+getMuni()+" "+TdeCuerpo+" "+TdeAgua+" "+String.valueOf(irca); 
    }

}