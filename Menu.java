import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class Menu {

    @FXML
    private AnchorPane Dynamic;

    @FXML
    private Button btnCourse;

    @FXML
    private Button btnStudent;

    @FXML
    void Course(ActionEvent event) throws IOException {
        setDynamicPane(FXMLLoader.load(getClass().getResource("CourseRegistration.fxml")));

    }

    @FXML
    void Student(ActionEvent event) throws IOException {
        setDynamicPane(FXMLLoader.load(getClass().getResource("StudentRegistration.fxml")));
    }

    private void setDynamicPane(AnchorPane Dynamic){
        this.Dynamic.getChildren().clear();
        this.Dynamic.getChildren().add(Dynamic);
    }


}
