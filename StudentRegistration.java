import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import java.sql.*;

import javax.swing.JOptionPane;

public class StudentRegistration {

    Connection conDB = DBcreate.DBCreate();
    Connection connStu = null;

    @FXML
    private AnchorPane Dynamic;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnClear;

    @FXML
    private CheckBox btnEnglish;

    @FXML
    private CheckBox btnHistory;

    @FXML
    private CheckBox btnICT;

    @FXML
    private CheckBox btnMaths;

    @FXML
    private Button btnSubmit;

    @FXML
    private TextField tfContact;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfFname;

    @FXML
    private TextField tfLname;

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
        tfFname.setText("");
        tfLname.setText("");
        tfEmail.setText("");
        tfContact.setText("");
        btnMaths.setSelected(false);
        btnICT.setSelected(false);
        btnEnglish.setSelected(false);
        btnHistory.setSelected(false);

    }

    @FXML
    void English(ActionEvent event) {

    }

    @FXML
    void History(ActionEvent event) {

    }

    @FXML
    void ICT(ActionEvent event) {

    }

    @FXML
    void Maths(ActionEvent event) {

    }

    @FXML
    void Submit(ActionEvent event) throws SQLException {
        connStu = ConStudent.connect();
       Statement stmt = connStu.createStatement();
        String StuFname = tfFname.getText();
        String StuLname = tfLname.getText();
        String StuEmail = tfEmail.getText();
        String StuContact = tfContact.getText();
        try {
            String q = "Insert into Student_details(Student_Fname, Student_Lname, Student_Email, Student_Contact) values ('"+StuFname+"' , '"+StuLname+"' , '"+StuEmail+"' , '"+StuContact+"')";
            PreparedStatement pst = connStu.prepareStatement(q);
            pst.execute();
            String q1 = "Select StudentID from Student_details Where Student_Fname = '"+StuFname+"'";
            ResultSet rSetName = ((java.sql.Statement) stmt).executeQuery(q1);
            rSetName.next();
            int StuID = rSetName.getInt("StudentID");
            System.out.println(StuID);
            if (btnMaths.isSelected() == true){
                String Mathsname = btnMaths.getText();
                String strSelectMaths = "Select CourseID from Course_details Where Course_Name = '"+Mathsname+"'";
                ResultSet rSetMaths = ((java.sql.Statement) stmt).executeQuery(strSelectMaths);
                rSetMaths.next();
                int IDMaths = rSetMaths.getInt("CourseID");
                String q2 = "Insert into Student_Course(StudentID , CourseID) values ('"+StuID+"' , '"+IDMaths+"')";
                PreparedStatement pst2 = connStu.prepareStatement(q2);
                pst2.execute();
            }
            else{
                System.out.println("Error!");
            }
            if (btnICT.isSelected() == true){
                String ICTname = btnICT.getText();
                String strSelectICT = "Select CourseID from Course_details Where Course_Name = '"+ICTname+"'";
                ResultSet rSetICT= ((java.sql.Statement) stmt).executeQuery(strSelectICT);
                rSetICT.next();
                int IDICT = rSetICT.getInt("CourseID");
                String q3 = "Insert into Student_Course(StudentID , CourseID) values ('"+StuID+"' , '"+IDICT+"')";
                PreparedStatement pst3 = connStu.prepareStatement(q3);
                pst3.execute();
            }
            else{
                System.out.println("Error!");
            }
            if (btnEnglish.isSelected() == true){
                String Englishname = btnEnglish.getText();
                String strSelectEnglish = "Select CourseID from Course_details Where Course_Name = '"+Englishname+"'";
                ResultSet rSetEnglish = ((java.sql.Statement) stmt).executeQuery(strSelectEnglish);
                rSetEnglish.next();
                int IDEnglish = rSetEnglish.getInt("CourseID");
                String q4 = "Insert into Student_Course(StudentID , CourseID) values ('"+StuID+"' , '"+IDEnglish+"')";
                PreparedStatement pst4 = connStu.prepareStatement(q4);
                pst4.execute();
            }
            else{
                System.out.println("Error!");
            }
            if (btnHistory.isSelected() == true){
                String Historyname = btnHistory.getText();
                String strSelectHistory = "Select CourseID from Course_details Where Course_Name = '"+Historyname+"'";
                ResultSet rSetHistory= ((java.sql.Statement) stmt).executeQuery(strSelectHistory);
                rSetHistory.next();
                int IDHistory = rSetHistory.getInt("CourseID");
                String q3 = "Insert into Student_Course(StudentID , CourseID) values ('"+StuID+"' , '"+IDHistory+"')";
                PreparedStatement pst3 = connStu.prepareStatement(q3);
                pst3.execute();
            }
            else{
                System.out.println("Error!");
            }
            System.out.println("Done!");
            ConCourse.connect().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(null,"successfully entered");

    }


}

