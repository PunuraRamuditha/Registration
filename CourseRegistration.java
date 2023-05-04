import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class CourseRegistration {

    Connection conDB = DBcreate.DBCreate();
    Connection con = null;

    
    @FXML
    private AnchorPane Dynamic;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnSubmit;

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfPeriod;

    @FXML
    private TextField tfPrice;

    @FXML
    void Back(ActionEvent event) throws IOException {
        setDynamicPane(FXMLLoader.load(getClass().getResource("Menu.fxml")));

    }

    private void setDynamicPane(AnchorPane Dynamic){
        this.Dynamic.getChildren().clear();
        this.Dynamic.getChildren().add(Dynamic);
    }

    @FXML
    void Clear(ActionEvent event) {
        tfName.setText("");
        tfPeriod.setText("");
        tfPrice.setText("");

    }

    @FXML
    void Submit(ActionEvent event) {
        con = ConCourse.connect();
        String Name = tfName.getText();
        String Period = tfPeriod.getText();
        String Price = tfPrice.getText();
        
        tfName.setText("");
        tfPeriod.setText("");
        tfPrice.setText("");
        try {
            String q = "Insert into Course_details(Course_Name, Course_Period, Course_Price) values ('"+Name+"'  , '"+Period+"',  '"+Price+"')";
            PreparedStatement pst = con.prepareStatement(q);
            pst.execute();
            System.out.println("Done!");
            ConCourse.connect().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(null,"successfully entered");

    }

    }


