import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class reto5 extends Application {
    public static void main(String[] args)throws Exception{
        launch(args);
    }

    @Override
    public void start(Stage ventana) throws Exception {
        Parent vista = FXMLLoader.load(getClass().getResource("reto5.fxml"));
        Scene scene = new Scene(vista);
        ventana.setTitle("Reto 5 - By Jhon Paz");
        ventana.setScene(scene);
        ventana.show();
    }

    
}
