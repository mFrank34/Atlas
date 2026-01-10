import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class CharacterSheetApp extends Application {

    @Override
    public void start(Stage stage) {
        WebView webView = new WebView();
        webView.getEngine().load(getClass().getResource("/character_sheet.html").toExternalForm());

        stage.setScene(new Scene(webView, 1200, 900));
        stage.setTitle("D&D 5e Character Sheet");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
