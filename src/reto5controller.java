import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class reto5controller {

    @FXML
    private TextField txt_nombre;

    @FXML
    private TextField txt_ID;

    @FXML
    private TextField txt_municipio;

    @FXML
    private TextField txt_tipo_de_cuerpo;

    @FXML
    private TextField txt_tipo_de_agua;

    @FXML
    private TextField txt_IRCA;

    @FXML
    private TextField txt_densidad_poblacional;

    @FXML
    private ListView<String> lstv_guardado;

    @FXML
    private TextArea txtA_procesado;

    @FXML
    private Button btn_guardar;

    @FXML
    private Button btn_procesar;

    static ObservableList<String> list_g = FXCollections.observableArrayList();
    static ObservableList<String> list_p = FXCollections.observableArrayList();
    static ArrayList<CuerpoDeAgua> info = new ArrayList<>();
    static ArrayList<DensidadPoblacional> info1 = new ArrayList<>();

    @FXML
    void guardar_datos(ActionEvent event) {
        String d_n = txt_nombre.getText();
        Double d_i = Double.parseDouble(txt_ID.getText());
        String d_m =txt_municipio.getText();
        String d_ca =txt_tipo_de_cuerpo.getText();
        String d_ta =txt_tipo_de_agua.getText();
        Double d_Ir =Double.parseDouble(txt_IRCA.getText());
        Integer d_dp = Integer.parseInt(txt_densidad_poblacional.getText());
        CuerpoDeAgua ca1 = new CuerpoDeAgua(); 
        DensidadPoblacional dp = new DensidadPoblacional();
        ca1.setName(d_n);
        ca1.setId(d_i);
        ca1.setMuni(d_m);
        ca1.setTdeCuerpo(d_ca);
        ca1.setTdeAgua(d_ta);
        ca1.setIrca(d_Ir);
        dp.setAfeccion(d_dp);
        info.add(ca1);
        info1.add(dp);
        list_g.add(ca1.toString());
        list_g.add(dp.toString());
        lstv_guardado.setItems(list_g);
        txt_nombre.setText("");
        txt_ID.setText("");
        txt_municipio.setText("");
        txt_tipo_de_cuerpo.setText("");
        txt_tipo_de_agua.setText("");
        txt_IRCA.setText("");
        txt_densidad_poblacional.setText("");
    }

    @FXML
    void procesar_datos(ActionEvent event) {
        String A, B, C, D;
        Integer E;
        CuerpoDeAgua cda = new CuerpoDeAgua();
                
        A = mostrarElementos(info);
        txtA_procesado.setText(A);
        B = al_is(info);
        txtA_procesado.setText(txtA_procesado.getText()+ B +"\n");
        C = nombre_alt(info);
        txtA_procesado.setText(txtA_procesado.getText()+ C +"\n");
        cda.setNivel(cda.nivel(minimo(info)));
        D = (cda.getNivel());
        txtA_procesado.setText(txtA_procesado.getText()+ D +"\n");
        E = DensidadPoblacional.afeccion(info1);
        txtA_procesado.setText(txtA_procesado.getText()+ E +"\n");
    }

    public static String mostrarElementos(ArrayList<CuerpoDeAgua> elementos){
        String me = "";
        for (int i = 0; i< elementos.size(); i++){
            
            me = me + elementos.get(i).getName()+" "+String.format("%.2f", elementos.get(i).getId())+"\n";           
            
        }  
        return me;  

    }


    public static String al_is (ArrayList<CuerpoDeAgua> elementos){
        Double cont = 0.00;
        String resultado;
        for (int i = 0; i< elementos.size(); i++){
            
            if (elementos.get(i).getIrca() >= 35.1 && elementos.get(i).getIrca() <= 100){
                cont = cont + 1;
            }
        }
        resultado = String.format("%1.2f",cont);
        return resultado;
    }


    public static String nombre_alt(ArrayList<CuerpoDeAgua> elementos){
        int cont1 = 0;
        int cont2 = 0;
        Double x = 0.00;
        String[] es = new String[elementos.size()];
        for (int i = 0; i < elementos.size(); i++){
            x = elementos.get(i).getIrca();
            if(x >= 14.1 && x <= 35){
                es[i]= elementos.get(i).getMuni();
                cont1++;
            }else if((x>=0 && x<=14) ||(x>=35.1 && x<=100)){
                cont2 ++;
            } 
        }
        String j ="";
        for(int i = 0; i<es.length; i++){
            if(es[i] != null){
                j = j+es[i]+" "; 
            }

        }
        if(cont1!=0){
            return j;
        }else{
            return "NA";
        }
    }


    public static Double minimo (ArrayList<CuerpoDeAgua> elementos){
        Double x = 100.00;
        Double a = 0.00;
        for(int i = 0; i<elementos.size(); i++){
            a=elementos.get(i).getIrca();
            if (a < x){
                x = a;
            }
        } return x; 
    }

}
